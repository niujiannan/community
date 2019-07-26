package com.njn.community.dto;

import com.njn.community.domain.User;
import lombok.Data;

@Data
public class QuestionDto {

    private Long id;

    private String title;

    private String desciption;

    private Long gmtCreate;

    private Long gmtModified;

    private Integer creator;

    private Integer commentCount;

    private Integer viewCount;

    private Integer likeCount;

    private String tag;

    private User user;

}
