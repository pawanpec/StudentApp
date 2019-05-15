package com.lp.school.api.controller;


import com.lp.school.api.jwt.config.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {



    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @GetMapping("/google-login")
    public String getLoginPage(Model model) {
        model.addAttribute("url", "http://ec2-13-234-50-124.ap-south-1.compute.amazonaws.com:7070/oauth2/authorization/google");

        return "google-login";
    }

}
