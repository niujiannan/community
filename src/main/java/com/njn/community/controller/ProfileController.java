package com.njn.community.controller;

import com.njn.community.domain.Question;
import com.njn.community.domain.User;
import com.njn.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ProfileController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/profile/{action}/{userId}")
    public String profile(@PathVariable("action") String action,@PathVariable("userId") String userId, Model model, HttpServletRequest request) {
        System.out.println(userId);
        if("questions".equals(action)) {
            User user = (User)request.getSession().getAttribute("user");
            List<Question> profileQuestions = questionService.selectQuestionProfile(Long.parseLong(userId));
            model.addAttribute("section", "questions");
            model.addAttribute("sectionName", "我的问题");
            model.addAttribute("profileQuestions",profileQuestions);
        }else if("repies".equals(action)){
            model.addAttribute("section", "repies");
            model.addAttribute("sectionName", "最新回复");
        }
        return "profile";
    }

}
