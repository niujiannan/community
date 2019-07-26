package com.njn.community.controller;

import com.njn.community.domain.Question;
import com.njn.community.dto.QuestionDto;
import com.njn.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String hell(Model model) {
        List<QuestionDto> questionList = questionService.selectAll();
        model.addAttribute("questionList", questionList);
        return "index";
    }

}
