package org.TraveLency.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class MainController {

//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public ModelAndView mainPage(HttpServletRequest request) {
//        ModelAndView modelAndView = new ModelAndView();
//        HttpSession session = request.getSession(true);
//        if(session.getAttribute("userPrincipal") != null) {
//            modelAndView.addObject("userPrincipal", session.getAttribute("userPrincipal"));
//        }
//        modelAndView.setViewName("main");
//        return modelAndView;
//    }

}
