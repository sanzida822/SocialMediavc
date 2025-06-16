package org.example.socialmediamvc.controller;

import org.example.socialmediamvc.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AController {
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
