package com.iot.controller;

import com.iot.common.Response;
import com.iot.model.User;
import com.iot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiuge on 2017/2/20.
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{userId}",method = RequestMethod.GET)
    public Response<User> sayHello(@PathVariable int userId) {
        Response<User>response=new Response<User>();
        User user=userService.getUserById(userId);
        response.setResult(user);
        return response;
    }
}
