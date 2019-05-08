package com.codeup.blog.models;

import javax.persistence.*;
import java.awt.*;

@Entity // designates this class as a "bean" (used for any class that has its own table)
@Table(name="posts")
public class Post {
    @Id @GeneratedValue
    private long id;

    @Column(nullable = false, length = 100, unique = true)
    private String title;

    @Column(nullable = false, columnDefinition = "text")
    private String body;

    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
//    @JoinColumn(name="user_id") // will also work
    private User author;

//    @OneToOne
//    private User owner;

    public Post() {} // for the C on the CRUD

    public Post(String title, String body, User author) { // for the U on the CRUD
        this.title = title;
        this.body = body;
        this.author = author;
    }

    public Post(long id, String title, String body, User author) { // for the R on the CRUD
        this.id = id;
        this.title = title;
        this.body = body;
        this.author = author;
    }

    public Post(long id) { // for the D on the CRUD
        this.id = id;
    }

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }



}
