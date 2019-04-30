package com.springMvc.test.controller;

import com.springMvc.test.api.ResObj;
import com.springMvc.test.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2019/3/27.
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping(value = "/requestParam",method = RequestMethod.GET)
    public String requestParam(@RequestParam(value = "id") String  id,@RequestParam(value="name") String name){
        System.out.println(id+":"+name);
        return "success";
    }


    @RequestMapping(value = "/requestHeader",method = RequestMethod.GET)
    public String requestHeader(@RequestHeader(value="Accept-Language") String al){
        System.out.println("requestHeader:"+al);
        return "success";
    }

    @RequestMapping(value = "/cookieValue")
    public String cookieValue(@CookieValue(value="JSESSIONID") String jsessionid){
        System.out.println("JSESSIONID:"+jsessionid);
        return "success";
    }

    @RequestMapping(value = "/pathVariable/{number}",method = RequestMethod.GET)
    public String pathVariable(@PathVariable(value = "number") String  number){
        System.out.println("number:"+number);
        return "success";
    }
    @ResponseBody
    @RequestMapping(value = "/pojo")
    public Object pojo(User user){
        System.out.println("user_name:"+user.getName());
        System.out.println("user_name:"+user.getClassNo().getCalssName());
        return new ResObj("200","成功",user);
    }

}
