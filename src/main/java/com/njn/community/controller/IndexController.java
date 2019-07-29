package com.njn.community.controller;

import com.njn.community.domain.Question;
import com.njn.community.dto.PageingDto;
import com.njn.community.dto.QuestionDto;
import com.njn.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String hell(@RequestParam(name = "page", defaultValue = "1") Integer page,
                       @RequestParam(name = "size", defaultValue = "5") Integer size,
                       Model model) {
        PageingDto pageingDto = new PageingDto();
        pageingDto.pageingCount(page, size, questionService.dataCount());
        List<QuestionDto> questionList = questionService.selectAll(pageingDto.getStart(), size);
        pageingDto.setQuestionList(questionList);
        model.addAttribute("pageingDto", pageingDto);
        return "index";
    }

}
