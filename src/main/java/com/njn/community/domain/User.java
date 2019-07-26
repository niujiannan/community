package com.njn.community.domain;

import lombok.Data;

@Data
public class User {

    private Long id;


    private String accountId;

    private String name;

    private String password;

    private String token;

    private Long gmtCreate;

    private Long gmtModified;

    private String avatarUrl;

}
