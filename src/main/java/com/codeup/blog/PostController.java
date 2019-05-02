package com.codeup.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

//    @GetMapping("/posts")
//    @ResponseBody
//    public String showPosts() {
//        return "Posts index page.";
//    }

    @GetMapping("/posts")
    public String showPosts(Model viewModel) {
        Post post1 = new Post("Random Post 1", "This is my first random post.");
        Post post2 = new Post("Random Post 2", "This is my second random post.");
        Post post3 = new Post("Random Post 3", "This is my third random post.");
        Post post4 = new Post("Random Post 4", "This is my fourth random post.");
        List<Post> posts = new ArrayList<>();
        posts.add(post1);
        posts.add(post2);
        posts.add(post3);
        posts.add(post4);
        viewModel.addAttribute("posts", posts);
        return "posts/index";
    }

//    @GetMapping("/posts/{id}")
//    @ResponseBody
//    public String showIndividualPost(@PathVariable long id) {
//        return "View post of id number: " + id;
//    }

    @GetMapping("/posts/{id}")
    public String showIndividualPost(@PathVariable long id, Model viewModel) {
        Post post1 = new Post("Post 1", "Hello, my name is Dwight.");
        viewModel.addAttribute("id", id);
        viewModel.addAttribute("post", post1);
        return "posts/show";
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
