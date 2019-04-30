package com.springMvc.test.controller;

import com.springMvc.test.api.ResObj;
import com.springMvc.test.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2019/4/28.
 */
@Controller
public class LoginController {
    @ResponseBody
    @RequestMapping(value = "login")
    public Object pojo(User user){
       /* System.out.println("user_name:"+user.getName());
        System.out.println("user_name:"+user.getClassNo().getCalssName());*/
        return new ResObj("200","成功",user);
    }

}
