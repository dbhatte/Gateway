package com.devendra.gateway.service;

import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.web.client.RestTemplate;

import com.devendra.gateway.model.Post;

/**
 * Created by devendra on 26/01/2017.
 */
public class PostService {

    private static final Logger logger = LoggerFactory.getLogger(PostService.class);

    public static final String HTTP_JSONPLACEHOLDER_TYPICODE_COM_POSTS_USER_ID = "http://jsonplaceholder.typicode.com/posts?userId=";

    @Autowired
    private RestTemplate restTemplate;


    @Cacheable("posts")
    public Post[] getPostDetailsForUser(Integer id) {
        ResponseEntity<Post[]> responseEntity = restTemplate.getForEntity(HTTP_JSONPLACEHOLDER_TYPICODE_COM_POSTS_USER_ID + id,
                Post[].class);
        Post[] posts = responseEntity.getBody();

        return posts;
    }


    @Async
    public Future<Post[]> getPostDetailsForUserAsync(Integer id) {
        ResponseEntity<Post[]> responseEntity = restTemplate.getForEntity(HTTP_JSONPLACEHOLDER_TYPICODE_COM_POSTS_USER_ID + id,
                Post[].class);
        Post[] posts = responseEntity.getBody();
        return new AsyncResult<>(posts);
    }
}
