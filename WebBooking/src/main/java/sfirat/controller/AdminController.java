package sfirat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sfirat.service.UserService;

@Controller
public class AdminController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/user_base", method = RequestMethod.GET)
    public String userBase(ModelMap model) {
        model.addAttribute("message", "Product");
        model.addAttribute("userlist", userService.userList());
        return "user_base";
    }

    @RequestMapping(value = "/delete/{userId}", method = RequestMethod.GET)
    public String deleteUser(ModelMap model, @PathVariable("userId") Integer userId) {
        userService.deleteUser(userId);
        return "redirect:/user_base";
    }
}
