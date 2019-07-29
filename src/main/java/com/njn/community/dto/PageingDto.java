package com.njn.community.dto;

import lombok.Data;

import java.util.List;

@Data
public class PageingDto {

    private List<QuestionDto> questionList;
    private Integer page;
    private Integer pageCount;
    private Integer start;
    public void pageingCount(Integer page, Integer size, Integer count) {
        start = (page - 1) * size;
        pageCount = count / size;
        if(count % size != 0) {
            pageCount++;
        }
    }
}
