package com.lp.school.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import io.swagger.annotations.Api;

@Api(tags = {"health-check"})
@Controller
public class HealthCheckController {

    @GetMapping("/health-check")
    public String getHealthCheckPage(Model model) {
        return "health-check";
    }
}
