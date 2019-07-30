package com.njn.community.mapper;

import com.njn.community.domain.Question;
import com.njn.community.dto.QuestionDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface QuestionMapper {

    @Insert("insert into question(title, desciption, gmt_create, gmt_modified, creator, tag)" +
            "values(#{title}, #{desciption}, #{gmtCreate}, #{gmtModified}, #{creator},  #{tag})")
    Integer insertQuestion(Question question);

    @Select("select * from question order by gmt_create desc limit #{start}, #{size}")
    List<Question> selectAll(@Param("start") Integer start, @Param("size") Integer size);

    @Select("select * from question where creator = #{id}")
    List<Question> selectQuestionProfile(Long id);

    @Select("select * from question where id = #{questionId}")
    Question getIdQuestion(Long questionId);

    @Select("select count(1) from question")
    Integer dataCount();

    @Update("update question set view_count = #{num} where id = #{questionId}")
    void updateviewCount(Long questionId, Integer num);

    @Select("select view_count from question where id = #{questionId}")
    Integer getViewCount(Long questionId);
}
