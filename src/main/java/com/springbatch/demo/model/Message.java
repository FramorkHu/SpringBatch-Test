package com.springbatch.demo.model;

/**
 * Created by huyan on 2016/4/12.
 */
public class Message {

    private long id;
    private User user;
    private String content;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
