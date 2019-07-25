package com.njn.community.service;


import com.njn.community.domain.User;
import com.njn.community.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorizeService {
    @Autowired
    private UserMapper userMapper;

    public User getByUser(User user) {
        User byUser = userMapper.getByUser(user.getName());
        if(byUser != null) {
            if(byUser.getPassword().equals(user.getPassword())) {
                return byUser;
            }
        }
        return null;
    }

}
