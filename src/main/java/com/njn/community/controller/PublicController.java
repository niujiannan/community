package com.njn.community.controller;

import com.njn.community.dto.QuestionDto;
import com.njn.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PublicController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/public/{questionId}")
    public String publicQuestion(@PathVariable("questionId") Long questionId, Model model){
        QuestionDto questionDto = questionService.getIdQuestion(questionId);
        model.addAttribute("questionDto" ,questionDto);
        return "public";
    }

}
