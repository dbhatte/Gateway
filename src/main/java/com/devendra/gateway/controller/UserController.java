package com.devendra.gateway.controller;

import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devendra.gateway.model.Post;
import com.devendra.gateway.model.User;
import com.devendra.gateway.service.PostService;
import com.devendra.gateway.service.UserService;

/**
 * Created by devendra on 26/01/2017.
 */
@RestController
public class UserController {

    public static final String MERGED_URL = "/merged";

    public static final String GET_USER_URL = "/user";

    public static final String GET_USER_POST_URL = "/user/post";

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;


    @RequestMapping(GET_USER_URL)
    public Future<User> user(@RequestParam(value = "id") Integer id) {
        return userService.getUserDetailsAync(id);
    }


    @RequestMapping(GET_USER_POST_URL)
    public Future<Post[]> post(@RequestParam(value = "id") Integer id) {
        return postService.getPostDetailsForUserAsync(id);
    }


    @RequestMapping(MERGED_URL)
    public Future<User> merged(@RequestParam(value = "id") Integer id) {
        return userService.getUserWithPosts(id);
    }

}
