package com.shsxt.controller;

import com.shsxt.po.User;
import com.shsxt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletRequest;

/**
 * Created by jick on 2019/3/8.
 */
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService  userService;
    @RequestMapping("queryUserById")
    @ResponseBody
    public User queryUserById(Integer id) throws Exception {
        return    userService.queryById(id);

    }


    //添加操作
    @RequestMapping("insert")
    @ResponseBody
    public  String   insert(User user) throws Exception {
         userService.insert(user);
         return   "successful";
    }

    //删除操作
    @RequestMapping("delete")
    public    String    delete(Integer id, ServletRequest session) throws Exception {
        userService.delete(id);
        session.setAttribute("result","操作成功");
        return   "index";
    }

 //修改操作
    @RequestMapping("update")
    public   String    update(User user,ServletRequest  session) throws Exception {
        userService.update(user);
        session.setAttribute("result","操作成功");
        return  "index";

    }


}
