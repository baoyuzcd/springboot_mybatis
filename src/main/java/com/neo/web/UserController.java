package com.neo.web;

import com.neo.entity.User;
import com.neo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import java.util.List;

@Controller
public class UserController {

    @Resource
    UserService userService;


    @RequestMapping("/user")
    public String list(Model model){
        List<User> users = userService.getUserList();
        model.addAttribute("users",users);
        return "user/list";
    }


    @RequestMapping("/toAdd")
    public String toAdd() {
        return "user/userAdd";
    }

    @RequestMapping("/add")
    public String add(User user) {
        userService.save(user);
        return "redirect:user";
    }

    @RequestMapping("/toEdit")
    public String toEdit(Model model, String id) {
        User user=userService.findUserById(id);
        model.addAttribute("user", user);
        return "user/userEdit";
    }


    @RequestMapping("/edit")
    public String edit(User user) {
        userService.edit(user);
        return "redirect:user";
    }


    @RequestMapping("/delete")
    public String delete(String id) {
        userService.delete(id);
        return "redirect:user";
    }
}
