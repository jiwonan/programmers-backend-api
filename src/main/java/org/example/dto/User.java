package org.example.dto;

public class User {
    String user_id;
    String username;
    String post_count;

    public String getUser_id() {
        return this.user_id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPost_count() {
        return this.post_count;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPost_count(String post_count) {
        this.post_count = post_count;
    }
}
