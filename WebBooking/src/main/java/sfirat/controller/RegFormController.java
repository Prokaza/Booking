package sfirat.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sfirat.component.FormValidator;
import sfirat.entity.User;
import sfirat.entity.enumeration.Role;
import sfirat.entity.enumeration.State;
import sfirat.service.SpringMailSender;
import sfirat.service.UserService;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Controller
public class RegFormController {

    @Autowired
    SpringMailSender mailSender;
    @Autowired
    private FormValidator formValidator;
    @Autowired
    public UserService userService;


    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model){
        model.addAttribute("user", new User());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String processReg(@ModelAttribute("user") User user,BindingResult result, ModelMap model) {

          formValidator.validate(user, result);
        if (result.hasErrors()){
            return "registration";
        } else {
            String password = user.getPassword();
            user.setPassword(getCriptPassword(password));
            user.setState(State.ACTIVE);
            user.setRole(Role.USER);
            userService.saveUser(user);

            mailSender.sendMail(user.getEmail(), user.getFirstname() + " " + user.getLastname(),
                    user.getEmail(), password, " Sfirat");

            model.addAttribute("message", "message.registrationSuccess" );
            return "index";
        }
    }

    public String getCriptPassword(String pass){
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        if (messageDigest != null) {
            messageDigest.update(pass.getBytes(),0, pass.length());
        }
        String hashedPass = new BigInteger(1,messageDigest.digest()).toString(16);
        if (hashedPass.length() < 32){
            hashedPass = "0" + hashedPass;}
        return hashedPass;
    }
}
