package com.cs425.fsap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    @GetMapping("/")
    public String displayHomePage(){
        return "/home/index";
    }


}
