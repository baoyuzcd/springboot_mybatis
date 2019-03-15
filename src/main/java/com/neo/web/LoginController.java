package com.neo.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 启动页
 */
@Controller
public class LoginController {



    @RequestMapping("/403")
    public String e403(){
        return "login/403";
    }



   @RequestMapping("/")
    public String index(){
       return "redirect:/home";
   }


   @RequestMapping("/home")
    public String login(){
        return "login/home";
   }




}
