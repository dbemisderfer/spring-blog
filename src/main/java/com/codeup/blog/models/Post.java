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

//    private String text;
//
////    @Column(nullable = false)
//    private TextArea footer;

    public Post() {} // for the C on the CRUD
//
//    public Post(String title, String body, TextArea footer) {
//        this.title = title;
//        this.body = body;
//        this.footer = footer;
//    }
//
    public Post(long id, String title, String body) { // for the R, U on the CRUD
        this.id = id;
        this.title = title;
        this.body = body;
    }
//
//    public Post(String title, String body, String text) {
//        this.title = title;
//        this.body = body;
//        this.text = text;
//    }
//
    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }
//
//    public Post(String title, String body, String text, TextArea footer) {
//        this.title = title;
//        this.body = body;
//        this.text = text;
//        this.footer = footer;
//    }

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


//    public TextArea getFooter() {
//        return footer;
//    }
//
//    public void setFooter(TextArea footer) {
//        this.footer = footer;
//    }
//
//    public String getText() {
//        return text;
//    }
//
//    public void setText(String text) {
//        this.text = text;
//    }



}
