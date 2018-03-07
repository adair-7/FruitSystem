package com.zt.controller;

import com.alibaba.fastjson.JSONObject;
import com.zt.entity.Admin;
import com.zt.entity.FruitCategory;
import com.zt.entity.Pagination;
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
            String sqlPath=null;
            //文件保存在本地的路径
            String localPath="G:\\FruitSystem\\src\\main\\webapp\\assets\\images\\";
            //文件名
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
            //把图片的相对路径保存至数据库
            sqlPath="../assets/images/"+filename;
            System.out.println(sqlPath);

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
            Pagination pagination=new Pagination(pageIndex,pageSize,adminService.getTotalRows(name));
            map.put("page",pagination);
            List<FruitCategory> fruitCategories=adminService.getFruitByPage(name,pagination.getBeginRow(),pageSize);
            map.put("data",fruitCategories);
            map.put("flag",true);
        }
        return map;
    }

    @RequestMapping("/{id}/productUp")
    public ModelAndView productUp(@PathVariable int id){
        ModelAndView modelAndView=new ModelAndView("productUp");
        FruitCategory fruitCategory=adminService.getFruitById(id);
        modelAndView.addObject("fruit",fruitCategory);
        return  modelAndView;
    }
}
