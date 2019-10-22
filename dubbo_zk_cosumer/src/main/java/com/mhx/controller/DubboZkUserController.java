package com.mhx.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.mhx.entity.DubboZkUser;
import com.mhx.service.DubboZkService;
import com.mhx.serviceImpl.DubboZkServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class DubboZkUserController {


    private String prefix = "user/";

    @Autowired
    private DubboZkService dubboZkServiceImpl;



    @Reference

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-dubbo.xml");
        context.start();
        DubboZkService dubboZkService = (DubboZkService) context.getBean("dubboZkService");
        List<DubboZkUser> list = dubboZkService.selectBySelective();
        System.err.println("name:"+list.get(0).getName());
    }
    /**
     *
     * @param modelMap
     *        spring框架自动创建modelmap实例，并作为controller方法的参数
     *        传入，用户无需自己创建对象
     *        modelMap对象主要用于把controller参数方法处理的数据传到页面上
     *        在controller方法中把页面需要的数据放到modelMap对象中即可
     *        它的作用类似于request对象的setAttribute方法
     * @return
     */
    @RequestMapping(value="/getAllUser")
    public String getAllUser(ModelMap modelMap,DubboZkUser userModel){
        List<DubboZkUser> list = dubboZkServiceImpl.selectBySelective();

        modelMap.put("userModelList", list);
        return prefix + "user_list";
    }

    @RequestMapping(value="/getUserDetailForm")
    public String getUserDetailForm(ModelMap modelMap, Integer id){
        if (id != null){
            modelMap.put("userModel", dubboZkServiceImpl.selectByPrimaryKey(id));
        }
        return prefix + "user_detail";
    }


    @RequestMapping(value="/addUser")
    public String addUser(DubboZkUser userModel){
        dubboZkServiceImpl.insert(userModel);
        return "redirect:getAllUser";
    }

    @RequestMapping(value="/deleteUser")
    @ResponseBody
    public boolean deleteUser(@RequestParam(value = "ids[]") Integer[] ids){
        for (int i = 0;i < ids.length;i++){
            dubboZkServiceImpl.deleteByPrimaryKey(ids[i]);
        }
        return true;
    }

}
