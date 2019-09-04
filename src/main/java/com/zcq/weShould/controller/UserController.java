package com.zcq.weShould.controller;

import com.zcq.weShould.entity.User;
import com.zcq.weShould.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/hello")
    public String home() {

        return "Hello World!";
    }

    /**
     * 保存一个用户信息
     * @param model
     * @return
     */
    @RequestMapping("/save")
    public String save(Model model) {

        User user = new User();
        user.setUserName("李四");
        user.setPassword("123456789");
        userService.save(user);
        model.addAttribute("msg", "添加数据成功");
        return "result";
    }

    @RequestMapping("/delete")
    public String delete(Model model) {
        userService.delete(1);
        model.addAttribute("msg", "删除数据成功");
        return "result";
    }

    @GetMapping("/all")
    public List<User> getAll() {
        return userService.getAll();
    }
}
