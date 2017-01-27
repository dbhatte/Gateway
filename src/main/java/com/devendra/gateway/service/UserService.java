package com.devendra.gateway.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.web.client.RestTemplate;

import com.devendra.gateway.model.Post;
import com.devendra.gateway.model.User;

/**
 * Created by devendra on 26/01/2017.
 */
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public static final String HTTP_JSONPLACEHOLDER_TYPICODE_COM_USERS = "http://jsonplaceholder.typicode.com/users/";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private PostService postService;


    @Cacheable("user")
    public User getUserDetails(Integer id) {
        User user = restTemplate.getForObject(HTTP_JSONPLACEHOLDER_TYPICODE_COM_USERS + id, User.class);
        return user;
    }


    @Async
    public Future<User> getUserDetailsAync(Integer id) {
        User user = restTemplate.getForObject(HTTP_JSONPLACEHOLDER_TYPICODE_COM_USERS + id, User.class);
        return new AsyncResult<>(user);
    }


    @Async
    public Future<User> getUserWithPosts(Integer id) {
        CompletableFuture<User> userFuture = CompletableFuture.supplyAsync(() -> getUserDetails(id));
        CompletableFuture<Post[]> postsFuture = CompletableFuture.supplyAsync(() -> postService.getPostDetailsForUser(id));

        userFuture.thenCombine(postsFuture, (user, posts) -> combine(user, posts));
        return userFuture;
    }


    private User combine(User user, Post[] posts) {
        user.setPosts(posts);
        return user;
    }
}
