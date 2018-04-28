package com.zt.controller;

import com.alibaba.fastjson.JSONObject;
import com.zt.entity.*;
import com.zt.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by admin on 2018/1/15.
 */
@Controller
@RequestMapping("Admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    /*
    * Response ModelAndView
    * */
    //登录
    @RequestMapping("/goLogin")
    public String goLogin(){
        return "login";
    }

    //主页
    @RequestMapping("/goIndex")
    public ModelAndView goIndex(HttpSession session){
        ModelAndView modelAndView=new ModelAndView("index");
        Admin admin= (Admin) session.getAttribute("adminSession");
        modelAndView.addObject("admin",admin);
        return modelAndView;
    }
    //退出登录
    @RequestMapping("/goOut")
    public ModelAndView goOut(HttpSession session){
        ModelAndView modelAndView=new ModelAndView("login");
        session.removeAttribute("adminSession");
        return modelAndView;
    }

    //产品更新
    @RequestMapping("/{id}/productUp")
    public ModelAndView productUp(@PathVariable int id){
        ModelAndView modelAndView=new ModelAndView("productUp");
        FruitCategory fruitCategory=adminService.getFruitById(id);
        modelAndView.addObject("fruit",fruitCategory);
        return  modelAndView;
    }

    //用户查看
    @RequestMapping("/{id}/userUp")
    public ModelAndView userUp(@PathVariable int id){
        ModelAndView modelAndView=new ModelAndView("userUp");
        User user=adminService.getUserById(id);
        modelAndView.addObject("user",user);
        return modelAndView;
    }

    //库存更新
    @RequestMapping("/{id}/stockUp")
    public ModelAndView stockUp(@PathVariable int id){
        ModelAndView modelAndView=new ModelAndView("stockUp");
        FruitStock fruitStock=adminService.getStockById(id);
        modelAndView.addObject("stock",fruitStock);
        return modelAndView;
    }

    //钱包查看
    @RequestMapping("/{id}/walletUp")
    public ModelAndView walletUp(@PathVariable int id){
        ModelAndView modelAndView=new ModelAndView("walletUp");
        Wallet wallet=adminService.getWalletById(id);
        modelAndView.addObject("wallet",wallet);
        return modelAndView;
    }

    /*
    * ResponseBody
    * */
    //返回登录校验
    @RequestMapping("/loginCheck")
    @ResponseBody
    public Map<String,Object> getLoginCheck(String name, String pwd, HttpServletRequest request){
        Map<String,Object> map=new HashMap<String, Object>();
        int loginCode=adminService.getLoginCheck(name,pwd,request);
        map.put("flag",true);
        map.put("msg","success");
        map.put("code",loginCode);
        return  map;
    }
    //添加商品
    @RequestMapping("/addProduct")
    @ResponseBody
    public Map map(String fruitName, String unitPrice, String introduction,MultipartFile file, HttpServletRequest request) throws IOException, ServletException {
        Map<String,Object> map=new HashMap<String, Object>();
        FruitCategory fruitCategory= adminService.getFruitByName(fruitName);

        if (fruitCategory!=null) {  //水果种类已存在
            map.put("code",2);
            map.put("flag", false);
            map.put("msg", "fruitExisted");
        }else if (fruitCategory==null){ //水果种类不存在
            //上传图片
            //文件保存在数据库的路径
            String sqlPath="upload/"+getFileName(file);

            FruitCategory fruitCategory1=new FruitCategory();
            fruitCategory1.setFruitName(fruitName);
            fruitCategory1.setUnitPrice(Float.parseFloat(unitPrice));
            fruitCategory1.setIntroduction(introduction);
            fruitCategory1.setIconUrl(sqlPath);
            int code=adminService.addProduct(fruitCategory1);
            if (code==1) {
                map.put("code", code);
                map.put("msg", "success");
                map.put("flag", true);
            }else {
                map.put("code", code);
                map.put("msg", "failed");
                map.put("flag", false);
            }
        }

        return  map;
    }
    //商品查询显示
    @RequestMapping("/quaryFruit")
    @ResponseBody
    public Map<String,Object> quaryFruit(int pageIndex, int pageSize,String name,HttpServletRequest request){
        Map<String,Object> map=new HashMap<String, Object>();
        if ("".equals(name)){
            Pagination pagination=new Pagination(pageIndex,pageSize,adminService.getAllfruitCount());
            map.put("page",pagination);
            List<FruitCategory> fruitCategories=adminService.getAllFruitByPage(pagination.getBeginRow(),pageSize);
            map.put("data",fruitCategories);
            map.put("flag",true);
        }else {
            Pagination pagination=new Pagination(pageIndex,pageSize,adminService.getFruitRows(name));
            map.put("page",pagination);
            List<FruitCategory> fruitCategories=adminService.getFruitByPage(name,pagination.getBeginRow(),pageSize);
            map.put("data",fruitCategories);
            map.put("flag",true);
        }
        return map;
    }

    //产品更新
    @RequestMapping("/productUp")
    @ResponseBody
    public Map<String,Object> productUp(String fruitName,String introduction,String unitPrice,MultipartFile file,HttpServletRequest request) throws IOException {
        Map<String,Object> map=new HashMap<String, Object>();
        String sqlPath="upload/"+getFileName(file);
        FruitCategory fruitCategory=new FruitCategory();
        fruitCategory.setFruitName(fruitName);
        fruitCategory.setUnitPrice(Float.parseFloat(unitPrice));
        fruitCategory.setIntroduction(introduction);
        fruitCategory.setIconUrl(sqlPath);
        int code=adminService.updateFruit(fruitCategory);
        if (code>0){
            map.put("code",code);
            map.put("msg","success");
            map.put("flag",true);
        }else {
            map.put("code", code);
            map.put("msg", "failed");
            map.put("flag", false);
        }
        return map;
    }

    //产品删除
    @RequestMapping("/productDel")
    @ResponseBody
    public Map<String,Object> productDel(int fruitId,HttpServletRequest request){
        Map<String,Object> map=new HashMap<String, Object>();
        int code=adminService.delFruit(fruitId);
        if (code==1){
            map.put("code",code);
            map.put("msg","success");
            map.put("flag",true);
        }
        else {
            map.put("code",code);
            map.put("msg","fail");
            map.put("flag",false);
        }
        return map;
    }

    //用户查询
    @RequestMapping("/quaryUser")
    @ResponseBody
    public Map<String,Object> quaryUser(int pageIndex,int pageSize,String name,HttpServletRequest request ){
        Map<String,Object> map=new HashMap<String, Object>();
        if ("".equals(name)){
            Pagination pagination=new Pagination(pageIndex,pageSize,adminService.getUserCount());
            map.put("page",pagination);
            List<User> users=adminService.getAllUserByPage(pagination.getBeginRow(),pageSize);
            map.put("data",users);
            map.put("flag",true);
        }else {
            Pagination pagination=new Pagination(pageIndex,pageSize,adminService.getUserRows(name));
            map.put("page",pagination);
            List<User> users=adminService.getUserByPage(name,pagination.getBeginRow(),pageSize);
            map.put("data",users);
            map.put("flag",true);
        }
        return map;
    }

    //钱包查询
    @RequestMapping("/quaryWallet")
    @ResponseBody
    public Map<String,Object> quaryWallet(int pageIndex,int pageSize,String name,HttpServletRequest request){
        Map<String,Object> map=new HashMap<String, Object>();
        if ("".equals(name)){
            Pagination pagination=new Pagination(pageIndex,pageSize,adminService.getWalletCount());
            map.put("page",pagination);
            List<Wallet> wallets=adminService.getAllWalletByPage(pagination.getBeginRow(),pageSize);
            map.put("data",wallets);
            map.put("flag",true);
        }else {
            Pagination pagination=new Pagination(pageIndex,pageSize,adminService.getWalletRows(name));
            map.put("page",pagination);
            List<Wallet> wallets=adminService.getWalletByPage(name,pagination.getBeginRow(),pageSize);
            map.put("data",wallets);
            map.put("flag",true);

        }
        return map;
    }

    //库存查询
    @RequestMapping("/quaryStock")
    @ResponseBody
    public Map<String,Object> quaryStock(int pageIndex,int pageSize,String name,HttpServletRequest request){
        Map<String,Object> map=new HashMap<String, Object>();
        if ("".equals(name)){
            Pagination pagination=new Pagination(pageIndex,pageSize,adminService.getStockCount());
            map.put("page",pagination);
            List<FruitStock> fruitStocks=adminService.getAllStockByPage(pagination.getBeginRow(),pageSize);
            map.put("data",fruitStocks);
            map.put("flag",true);
        }else {
            Pagination pagination=new Pagination(pageIndex,pageSize,adminService.getStockRows(name));
            map.put("page",pagination);
            List<FruitStock> fruitStocks=adminService.getStockByPage(name,pagination.getBeginRow(),pageSize);
            map.put("data",fruitStocks);
            map.put("flag",true);

        }
        return map;
    }

    //库存更新
    @RequestMapping("/stockUp")
    @ResponseBody
    public Map<String,Object> stockUp(int fruitId,int stockTop,int stockAccount,HttpServletRequest request){
        Map<String,Object>map=new HashMap<String, Object>();
        FruitStock fruitStock=new FruitStock();
        fruitStock.setFruitId(fruitId);
        fruitStock.setStockTop(stockTop);
        fruitStock.setStockAccount(stockAccount);
        int code=adminService.updataStock(fruitStock);
        if (code>0){
            map.put("code",code);
            map.put("msg","success");
            map.put("flag",true);
        }else {
            map.put("code", code);
            map.put("msg", "failed");
            map.put("flag", false);
        }
        return map;
    }

    //订单查询
    @RequestMapping("/quaryOrder")
    @ResponseBody
    public Map<String,Object> queryOrder(int pageIndex,int pageSize,String name,HttpServletRequest request ){
        Map<String,Object> map=new HashMap<String, Object>();
        if ("".equals(name)){
            Pagination pagination=new Pagination(pageIndex,pageSize,adminService.getOrderCount());
            map.put("page",pagination);
            List<Order> orders=adminService.getAllOrderByPage(pagination.getBeginRow(),pageSize);
            map.put("data",orders);
            map.put("flag",true);
        }else {
            Pagination pagination=new Pagination(pageIndex,pageSize,adminService.getOrderRows(name));
            map.put("page",pagination);
            List<Order> orders=adminService.getOrderByPage(name,pagination.getBeginRow(),pageSize);
            map.put("data",orders);
            map.put("flag",true);
        }
        return map;
    }

    //订单删除
    @RequestMapping("/orderDel")
    @ResponseBody
    public Map<String,Object> orderDel(int orderId,HttpServletRequest request){
        Map<String,Object> map=new HashMap<String, Object>();
        int code=adminService.delOrder(orderId);
        if (code==1){
            map.put("code",code);
            map.put("msg","success");
            map.put("flag",true);
        }
        else {
            map.put("code",code);
            map.put("msg","fail");
            map.put("flag",false);
        }
        return map;
    }


    /*
    * method
    * 图片存放服务器并返回文件名
    * */
    public String getFileName(MultipartFile file) throws IOException {
        //文件保存在本地的路径
        //文件名
        String localPath = "G:\\upload\\";
        String filename=null;
        if (!file.isEmpty()){
            //生成uuid作为文件名称
            String uuid= UUID.randomUUID().toString().replaceAll("-","");
            //获得文件类型（可以判断如果不是图片，禁止上传）
            String contentType=file.getContentType();
            //获得文件后缀名
            String suffixName=contentType.substring(contentType.indexOf("/")+1);
            //得到文件名
            filename=uuid+"."+suffixName;
            //System.out.println(filename);
            //创建并保存文件
            file.transferTo(new File(localPath+filename));
        }
        return filename;
    }
}
