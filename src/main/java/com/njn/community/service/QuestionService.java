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

    public List<QuestionDto> selectAll(Integer start, Integer size) {
        List<QuestionDto> questionDtoList = new ArrayList<>();
        List<Question> questionList = questionMapper.selectAll(start, size);
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

    public List<Question> selectQuestionProfile(Long id) {
        List<Question> questions = new ArrayList<>();
        questions = questionMapper.selectQuestionProfile(id);
        return questions;
    }

    public QuestionDto getIdQuestion(Long questionId) {
        Question question = questionMapper.getIdQuestion(questionId);
        QuestionDto questionDto = new QuestionDto();
       if(question != null) {
           BeanUtils.copyProperties(question, questionDto);
           questionDto.setUser(userMapper.selectAll(question.getCreator()));
       }
        return questionDto;
    }

    public Integer dataCount(){
        return questionMapper.dataCount();
    };

    public void updateviewCount(Long questionId) {
        Integer viewCount = questionMapper.getViewCount(questionId);
        viewCount++;
        questionMapper.updateviewCount(questionId, viewCount);
    }
}
