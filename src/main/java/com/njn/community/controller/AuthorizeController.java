package com.njn.community.controller;

import com.njn.community.domain.User;
import com.njn.community.service.AuthorizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AuthorizeController {

    @Autowired
    private AuthorizeService authorizeService;

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @PostMapping("/login")
    public String login(User user, HttpServletResponse response, HttpServletRequest request) {
        User byUser = authorizeService.getByUser(user);
        if(byUser != null) {
            // 登录成功
            response.addCookie(new Cookie("token", byUser.getToken()));
            request.getSession().setAttribute("user", byUser);
            return "redirect:/";
        }

        return "login";
    }
}
