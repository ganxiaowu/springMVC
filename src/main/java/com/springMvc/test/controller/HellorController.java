package com.springMvc.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2019/3/25.
 */
@Controller
public class HellorController {
    @RequestMapping("/helloWorld")
    public String hello(){
        System.out.println("success");
        return "success";
    }

    @RequestMapping(value = "/ant/*/success",method = RequestMethod.GET)
    public String ant(String  id){
        System.out.println(id);
        return "success";
    }

}
