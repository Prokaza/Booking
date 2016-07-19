package sfirat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import sfirat.entity.User;
import sfirat.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

@Controller
public class AccountController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/personal_account", method = RequestMethod.GET)
    public ModelAndView personalAccount(Principal principal) {

        ModelAndView model = new ModelAndView();
        if (principal != null){
            User user = userService.findUserByEmail(principal.getName());
            model.addObject("user", user);
        }
        model.setViewName("personal_account");
        return model;
    }

    @RequestMapping(value = "/personal_account/save/{userid}", method = RequestMethod.POST)
    public ModelAndView editPersonalAccount(User user, @PathVariable("userid") Integer userid) {
        ModelAndView model = new ModelAndView();

        userService.updateUser(user);
        model.setViewName("redirect:/personal_account");
        return model;
//    public String editPersonalAccount(@ModelAttribute("user") User user, BindingResult result) {
//
//        userService.updateUser(user);
//        return "redirect:/personal_account";
    }

    @Secured("USER, ADMIN, MANAGER")
    @RequestMapping(value = "/personal_account/delete/{userId}")
    public String deleteAccount(@PathVariable("userId") Integer userId, HttpServletRequest request, HttpServletResponse response) {
        userService.deleteUser(userId);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        SecurityContextHolder.getContext().setAuthentication(null);
        return "redirect:index";
    }

    @RequestMapping(value = "/cancel", method = RequestMethod.GET)
    public String cancel(ModelMap model) {
        model.addAttribute("message", "Contact");
        return "index";
    }

}
