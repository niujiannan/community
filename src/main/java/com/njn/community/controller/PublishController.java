package com.njn.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PublishController {
    @GetMapping("/pulish")
    public String publish() {
        return "publish";
    }
}
