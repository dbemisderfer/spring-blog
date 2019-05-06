package com.codeup.blog;

import javax.persistence.*;
import java.awt.*;

@Entity
@Table(name="spring_blogs")
public class Post {
    @Id @GeneratedValue
    private long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false)
    private String body;

    @Column(name="author_email")
    private String authorEmail;

//    private String text;
//
////    @Column(nullable = false)
//    private TextArea footer;

    public Post() {}
//
//    public Post(String title, String body, TextArea footer) {
//        this.title = title;
//        this.body = body;
//        this.footer = footer;
//    }
//
    public Post(long id, String title, String body) {
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

    public String getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
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
