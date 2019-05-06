package com.codeup.blog;

import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.w3c.dom.Text;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
//    @Autowired
//    private EmailService emailService;
//
//    public PostController(EmailService emailService) {
//        this.emailService = emailService;
//    }

    private final PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

    @GetMapping("/posts")
//    @ResponseBody
    public String getPosts(Model model) {
        Post post1 = new Post();
        post1.setTitle("First Blog Post");
        post1.setBody("This is the first post in my new blog.");
        postDao.save(post1);
        Post post2 = new Post();
        post2.setTitle("Second Blog Post");
        post2.setBody("This is the second post in my new blog");
        postDao.save(post2);
        model.addAttribute("posts", postDao.findAll());

//            List<Post> posts = IteratorUtils.toList(postDao.findAll().iterator());
////            List<Post> posts = postDao.findByTitle("First Blog Post");
//            for (Post post : posts) {
//                System.out.println(post.getId());
//                System.out.println(post.getTitle());
//                System.out.println(post.getBody());
//            }
//            return "success";
            return "posts/index";
        }


//    @GetMapping("/posts")
//    @ResponseBody
//    public String showPosts() {
//        return "Posts index page.";
//    }

//    @GetMapping("/posts")
//    public String showPosts(Model viewModel) {
////        TextArea text = new TextArea("Hello, this is text for my footer.");
////        Post post1 = new Post("Random Post 1", "This is my first random post change.", "Testing.");
////        Post post2 = new Post("Random Post 2", "This is my second random post.", "Tester.");
////        Post post3 = new Post("Random Post 3", "This is my third random post change.", "Testy.");
////        Post post4 = new Post("Random Post 4", "This is my fourth random post.", "Tests.");
////        List<Post> posts = new ArrayList<>();
////        posts.add(post1);
////        posts.add(post2);
////        posts.add(post3);
////        posts.add(post4);
//        List<Post> posts = new ArrayList();
//        Post post1 = new Post();
//        post1.setTitle("First Title");
//        post1.setBody("This is the first text body.");
//        post1.setId(4L);
//        posts.add(post1);
//        Post post2 = new Post();
//        post2.setTitle("Second Title");
//        post2.setBody("This is the second text body.");
//        post2.setId(44L);
//        posts.add(post2);
//        viewModel.addAttribute("posts", posts);
//        return "posts/index";
//    }

//    @GetMapping("/posts/{id}")
//    @ResponseBody
//    public String showIndividualPost(@PathVariable long id) {
//        return "View post of id number: " + id;
//    }

//    @GetMapping("/posts/{id}")
//    public String showIndividualPost(@PathVariable long id, Model viewModel) {
////        Post post1 = new Post("Post 1", "Hello, my name is Dwight.");
////        viewModel.addAttribute("id", id);
////        viewModel.addAttribute("post", post1);
//        Post post1 = new Post();
////        post1.setId(id);
////        post1.setTitle("Title for post #" + post1.getId());
//        post1.setBody("This is the text body.");
//        viewModel.addAttribute("post", post1);
//        return "posts/show";
//    }

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

//    @PostMapping("/posts/email")
//    @ResponseBody
//    public String emailPost(EmailService emailService) {
//        Post post1 = new Post();
//        post1.setAuthorEmail("dwight.bemisderfer@gmail.com");
//        post1.setTitle("Title for Post");
//        post1.setBody("This is the text body.");
//        emailService = new EmailService();
//        emailService.prepareAndSend(post1);
//        return "success";
//    }
}
