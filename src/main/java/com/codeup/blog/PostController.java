package com.codeup.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String showPosts() {
        return "Posts index page.";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String showIndividualPost(@PathVariable long id) {
        return "View post of id number: " + id;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String showCreationForm() {
        return "View the form for creating a post.";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createNewPost() {
        return "Create a new post.";
    }
}
