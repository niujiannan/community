package com.njn.community.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Question implements Serializable {

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

}
