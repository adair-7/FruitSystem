package com.zt.controller;

import com.sun.tools.corba.se.idl.constExpr.Or;
import com.zt.entity.*;
import com.zt.service.UserService;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2018/1/20.
 */
@Controller
@RequestMapping("User")
public class UserController {
    @Autowired
    private UserService userService;

    /*
    * ResponseBody
    * */
    //返回登录校验
    @RequestMapping("/loginCheck")
    @ResponseBody
    public Map<String,Object> getLoginCheck(String name, String pwd){
        Map<String,Object> map=new HashMap<String,Object>();
        int loginCode=userService.getLoginCode(name,pwd);
        map.put("flag",true);
        map.put("msg","success");
        map.put("code",loginCode);
        if (loginCode==1){
            map.put("data",userService.getUserByName(name));
        }
        return map;
    }

    //注册检查
    @RequestMapping("/registCheck")
    @ResponseBody
    public  Map<String,Object> registCheck(String name,String pwd,String phone,String mail,String qq){
        Map<String,Object> map=new HashMap<String, Object>();
        User user=userService.getUserByName(name);
        if (user!=null){    //检查用户存在
            map.put("code",2);
            map.put("flag",false);
            map.put("msg","userExisted");
        }else  if (user==null){     //检查用户不存在
            User user1=new User();
            user1.setUserName(name);
            user1.setUserPwd(pwd);
            user1.setPhone(phone);
            user1.setMail(mail);
            user1.setQq(qq);
            int code=userService.addUser(user1);
            if (code==1){
                map.put("flag",true);
                map.put("msg","success");
                map.put("code",code);
            }else {
                map.put("flag",false);
                map.put("msg","failed");
                map.put("code",code);
            }
        }

        return map;
    }
    //添加订单
    @RequestMapping("/addOrder")
    @ResponseBody
    public Map<String,Object> getOrder(String userName,String fruitName,int fruitNum ,HttpServletRequest request){
        Map<String,Object> map =new HashMap<String,Object>();
        //计算订单价格
        float orderPrice=fruitNum * userService.getFruitPrice(fruitName);
        //账号余额
        float account=userService.getWalletAccount(userName);
        //获取产品库存
        int stock=userService.getStockByName(fruitName);
        if (orderPrice>account){    //余额不足
            map.put("code",2);
            map.put("msg","account not enough");
            map.put("flag",false);
        }else if (fruitNum>stock){  //产品库存不足
            map.put("code",3);
            map.put("msg","stock not enough");
            map.put("flag",false);
        }else {
            //更新库存
            stock=stock-fruitNum;
            FruitStock fruitStock=new FruitStock();
            fruitStock.setFruitName(fruitName);
            fruitStock.setStockAccount(stock);
            int code=userService.upStockByName(fruitStock);
            //更新账户余额
            account=account-orderPrice;
            Wallet wallet=new Wallet();
            wallet.setUserName(userName);
            wallet.setAmount(account);
            int code1=userService.upWalletAccount(wallet);
            //更新订单
            int userId=userService.getUserId(userName);
            int fruitId=userService.getFruitId(fruitName);
            Order order=new Order();
            order.setUserId(userId);
            order.setFruitId(fruitId);
            order.setUserName(userName);
            order.setFruitName(fruitName);
            order.setFruitNum(fruitNum);
            order.setOrderPrice(orderPrice);
            int code2=userService.addOrder(order);
            if (code1>0 && code2>0 && code>0){
                map.put("code",1);
                map.put("msg","success");
                map.put("flag",true);
            }else {
                map.put("msg","failed");
                map.put("flag",false);
            }
        }

        return map;
    }

    //获取用户信息
    @RequestMapping("getUserInfo")
    @ResponseBody
    public Map<String,Object> getUserInfo(String userName){
        Map<String,Object> map=new HashMap<String, Object>();
        User user=new User();
        user=userService.getUserByName(userName);
        map.put("msg","success");
        map.put("flag",true);
        map.put("data",user);
        return map;
    }
    //用户信息修改
    @RequestMapping("/upUser")
    @ResponseBody
    public Map<String,Object> upUser(String userName,String phone,String mail,String qq,String address){
        Map<String,Object> map=new HashMap<String, Object>();
        User user=new User();
        user.setUserName(userName);
        user.setPhone(phone);
        user.setMail(mail);
        user.setQq(qq);
        user.setAddress(address);
        int code=userService.upUserByName(user);
        if (code==1){
            map.put("code",code);
            map.put("msg","success");
            map.put("flag",true);
        }else {
            map.put("code",code);
            map.put("msg","failed");
            map.put("flag",false);
        }
        return map;
    }
    //获取钱包信息
    @RequestMapping("getWalletInfo")
    @ResponseBody
    public Map<String,Object> getWalletInfo(String userName){
        Map<String,Object> map=new HashMap<String, Object>();
        Wallet wallet=new Wallet();
        wallet=userService.getWalletByName(userName);
        map.put("msg","success");
        map.put("flag",true);
        map.put("data",wallet);
        return map;
    }
    //钱包充值
    @RequestMapping("/upWallet")
    @ResponseBody
    public Map<String,Object> upWallet(String userName,float amount){
        Map<String,Object> map=new HashMap<String, Object>();
        float upAmount=userService.getWalletAccount(userName)+amount;
        Wallet wallet=new Wallet();
        wallet.setUserName(userName);
        wallet.setAmount(upAmount);
        int code=userService.upWalletAccount(wallet);
        if (code==1){
            map.put("code",code);
            map.put("msg","success");
            map.put("flag",true);
        }else {
            map.put("code",code);
            map.put("msg","failed");
            map.put("flag",false);
        }
        return map;
    }

    //获取所有水果
    @RequestMapping("/getAllFruit")
    @ResponseBody
    public Map<String,Object> getAllFruit(){
        Map<String,Object> map=new HashMap<String, Object>();
        List<FruitCategory> fruitCategories=userService.getAllFruit();
        map.put("data",fruitCategories);
        map.put("msg","success");
        map.put("flag",true);
        return map;
    }
    //获取所有订单
    @RequestMapping("/getAllOrder")
    @ResponseBody
    public Map<String,Object> getAllOrder(String userName){
        Map<String,Object> map=new HashMap<String, Object>();
        List<Order> orders=userService.getAllOrder(userName);
        map.put("data",orders);
        map.put("msg","success");
        map.put("flag",true);
        return map;
    }

    //获取推荐
    @RequestMapping("/getRecommendItem")
    @ResponseBody
    public Map<String,Object> getRecommendItem(int userId) throws Exception {
        Map<String,Object> map=new HashMap<String, Object>();
        List<FruitCategory> fruitCategories=new ArrayList<FruitCategory>();
        List<Integer> itemIds=new ArrayList<Integer>();
        int dataSize=4;//推荐数量
        List<RecommendedItem> recommendedItems= getRecommendItem(getRecommendFile(),userId,dataSize);
        for (int i=0;i<recommendedItems.size();i++){
            fruitCategories.add(userService.getFruitById((int) recommendedItems.get(i).getItemID()));
//            itemIds.add((int) recommendedItems.get(i).getItemID());
        }
        if (fruitCategories.size()<1){
            for (int i=0;i<dataSize;i++){
                fruitCategories.add(userService.getFruitById(userService.getTopFruit(4).get(i).getFruitId()));
            }
            map.put("msg", "rankRecommend");
            map.put("flag", true);
            map.put("data", fruitCategories);

        }else {
            map.put("msg", "autoRecommend");
            map.put("flag", true);
            map.put("data", fruitCategories);
        }
        return map;
    }

    //生成推荐文件
    public File getRecommendFile()throws Exception{
        File file=new File("G:\\upload\\recommend.csv");
        try{
            if (!file.exists()){
                file.createNewFile();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        int userCount=userService.getUserCount();
        List<Recommend> userAsc=userService.getUserByAsc();
        FileWriter fileWriter=new FileWriter("G:\\upload\\recommend.csv");
        for (int i=0;i<userCount;i++){
            int userId= userAsc.get(i).getUserId();
            List<Recommend> fruitAsc=userService.getFruitByAsc(userId);
            int fruitCount=fruitAsc.size();
            for (int j=0;j<fruitCount;j++){
                int fruitId=fruitAsc.get(j).getFruitId();
                int orderCount=userService.getOrderCount(userId,fruitId);
                String str=userId+","+fruitId+","+orderCount+"\r\n";
                fileWriter.write(str);
            }
            fileWriter.write("\r\n");
        }
        fileWriter.flush();
        fileWriter.close();

        return file;

    }


    //获取推荐结果项
    public List<RecommendedItem> getRecommendItem( File file,int userId,int num ) throws  Exception{
        DataModel model = new FileDataModel(file);
        // Build the same recommender for testing that we did last time:
        RecommenderBuilder recommenderBuilder = new RecommenderBuilder() {
            @Override
            public Recommender buildRecommender(DataModel model) throws TasteException {
                ItemSimilarity similarity = new PearsonCorrelationSimilarity(model);
                return new GenericItemBasedRecommender(model, similarity);
            }
        };
        //获取推荐结果
        List<RecommendedItem> recommendations = recommenderBuilder.buildRecommender(model).recommend(userId, num);
        return  recommendations;
    }

}
