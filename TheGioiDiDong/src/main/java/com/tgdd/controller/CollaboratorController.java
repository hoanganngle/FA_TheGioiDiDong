package com.tgdd.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tgdd.service.CollaboratorService;

public class CollaboratorController {
	@Autowired
    private CollaboratorService collaboratorService;

    @GetMapping("/login")
    public ModelAndView getLoginForm() {
        return new ModelAndView("login");
    }

    @PostMapping("/login")
    public ModelAndView checkLogin(HttpServletRequest req) {
        ModelAndView mav = new ModelAndView();
        String url = "login";
        String collabName = req.getParameter("txtUsername");
        String password = req.getParameter("txtPassword");

        if(collaboratorService.checkLogin(collabName, password) != null) {
            url = "addProduct";
        } else {
            mav.addObject("Result", "Wrong username or password");
        }
        mav.setViewName(url);
        return mav;
    }

    @GetMapping("/logout")
    public ModelAndView logout() {
        return new ModelAndView("index");
    }
}
