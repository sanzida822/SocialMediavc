package org.example.socialmediamvc.controller;

import org.example.socialmediamvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import jakarta.validation.Validator;


import java.util.Locale;

@Controller
public class AController {

    @Autowired
    private Validator validator;
    @GetMapping("/check-validator")
    @ResponseBody
    public String checkValidatorType() {
        return "Validator class: " + validator.getClass().getName();
    }

//    @Autowired
//    private MessageSource messageSource;
//
//    public String testMessage(Locale locale) {
//        String message = messageSource.getMessage("error.username.required", null, locale);
//        System.out.println(message);  // This prints the actual message, e.g. "Username is required."
//        return message;
//    }

    @ModelAttribute
    public void commonData(Model model) {
        model.addAttribute("header", "Social Media View");
        model.addAttribute("footer", "Social Media View");
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(Model model) {
        ModelAndView mv=new ModelAndView();
        mv.addObject("msg","You are logged in");
        model.addAttribute("username", "admin");
        mv.setViewName("login");
        return mv;
    }

    @RequestMapping(path="/processForm", method = RequestMethod.POST)
    public  String handleForm(@RequestParam("name") String name, @RequestParam("password") String password) {System.out.println(name);
    ModelAndView mv=new ModelAndView();
    mv.addObject("name",name);
        return "processForm";
    }

    public String handleForm1(@ModelAttribute User user, Model model) {
        System.out.println(user);
        return "processForm";
    }

}
