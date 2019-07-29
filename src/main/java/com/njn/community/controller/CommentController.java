package com.njn.community.controller;

import com.njn.community.domain.Comment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CommentController {

    @ResponseBody
    @PostMapping("/comment")
    public Object comment(@RequestBody Comment comment){
        comment.setGmtCreate(System.currentTimeMillis());
        comment.setGmtModified(comment.getGmtCreate());
        return null;
    }

}
