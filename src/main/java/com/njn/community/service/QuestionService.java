package com.njn.community.service;

import com.njn.community.domain.Question;
import com.njn.community.domain.User;
import com.njn.community.dto.QuestionDto;
import com.njn.community.mapper.QuestionMapper;
import com.njn.community.mapper.UserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;

    public Integer insertQuestion(Question question) {

        question.setGmtCreate(System.currentTimeMillis());
        question.setGmtModified(System.currentTimeMillis());


        return questionMapper.insertQuestion(question);
    }

    public List<QuestionDto> selectAll() {
        List<QuestionDto> questionDtoList = new ArrayList<>();
        List<Question> questionList = questionMapper.selectAll();
        if(questionList != null) {
            for(Question question : questionList) {
                User user = userMapper.selectAll(question.getCreator());
                QuestionDto questionDto = new QuestionDto();
                BeanUtils.copyProperties(question, questionDto);
                questionDto.setUser(user);
                questionDtoList.add(questionDto);
            }
        }

        return questionDtoList;
    }
}
