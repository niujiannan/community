package com.njn.community.mapper;

import com.njn.community.domain.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionMapper {

    @Insert("insert into question(title, desciption, gmt_create, gmt_modified, creator, comment_count, view_count, like_count, tag)" +
            "values(#{title}, #{desciption}, #{gmtCreate}, #{gmtModified}, #{creator}, #{commentCount}, #{viewCount}, #{likeCount}, #{tag})")
    Integer insertQuestion(Question question);

    @Select("select * from question")
    List<Question> selectAll();
}
