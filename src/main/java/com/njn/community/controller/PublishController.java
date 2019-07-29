package com.njn.community.controller;

import com.njn.community.domain.Question;
import com.njn.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class PublishController {

    @Autowired
    private QuestionService questionService;



    @GetMapping("/pulish")
    public String publish() {
        return "publish";
    }

    @PostMapping("/publish/{userId}")
    public String publish(@PathVariable("userId") String userId, Question question, Model model, HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if(cookies != null) {
            for(Cookie cookie : cookies) {
                if(cookie.getName().equals("token")) {
                    question.setCreator(Integer.parseInt(userId));
                    Integer integer = questionService.insertQuestion(question);
                    if(integer != null) {
                        return "redirect:/";
                    }
                }
            }
        }

        model.addAttribute("error", "用户未登录");
        return "redirect:/login";
    }

}
