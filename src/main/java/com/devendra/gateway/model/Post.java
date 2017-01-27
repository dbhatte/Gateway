package com.devendra.gateway.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by devendra on 26/01/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Post {

    private Integer userId;

    private Integer id;

    private String title;

    private String body;


    public Integer getUserId() {
        return userId;
    }


    public void setUserId(Integer userId) {
        this.userId = userId;
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public String getBody() {
        return body;
    }


    public void setBody(String body) {
        this.body = body;
    }


    @Override
    public String toString() {
        return "Post{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
