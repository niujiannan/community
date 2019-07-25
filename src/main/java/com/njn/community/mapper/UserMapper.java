package com.njn.community.mapper;

import com.njn.community.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Insert("insert into users(account_id, name, token, gmt_create, gmt_modified) values(#{accountId}, #{name}, #{token}, #{gmtCreate}, #{gmtModified})")
    void setUser(User user);

    @Select("select id, account_id, name, token, gmt_create, gmt_modified, password from users where name = #{name}")
    User getByUser(String name);
}
