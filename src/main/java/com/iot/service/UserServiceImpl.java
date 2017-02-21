package com.iot.service;

import com.iot.dao.UserMapper;
import com.iot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xiuge on 2017/2/20.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(int userId){
        User user=userMapper.selectByPrimaryKey(userId);
        return  user;
    }
}
