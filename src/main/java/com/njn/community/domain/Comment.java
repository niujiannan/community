package com.njn.community.domain;

import lombok.Data;

@Data
public class Comment {

    private Long id;
    private Long parentId;
    private Integer type;
    private Integer commentator;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer likeCount;
    private String content;

}
