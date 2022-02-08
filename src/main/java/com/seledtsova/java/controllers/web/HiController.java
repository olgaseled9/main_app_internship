package com.seledtsova.java.controllers.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HiController {

    @GetMapping("/")
    public String sayHi() {
        return "start_page";
    }

}

