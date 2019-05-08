package com.codeup.blog.controllers;

import com.codeup.blog.models.Post;
import com.codeup.blog.repositories.PostRepository;
import com.codeup.blog.repositories.UserRepository;
import com.codeup.blog.services.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;
    private EmailService emailService;

    public PostController(PostRepository posts, UserRepository users, EmailService emailService) {
        this.postDao = posts;
        this.userDao = users;
        this.emailService = emailService;
    }


//    @GetMapping("/posts")
////    @ResponseBody
//    public String getPosts(Model viewModel) {
////        Post post1 = new Post();
////        post1.setTitle("First Blog Post");
////        post1.setBody("This is the first post in my new blog.");
////        postDao.save(post1);
////        Post post2 = new Post();
////        post2.setTitle("Second Blog Post");
////        post2.setBody("This is the second post in my new blog");
////        postDao.save(post2);
//        viewModel.addAttribute("posts", postDao.findAll());
//
////            List<Post> posts = IteratorUtils.toList(postDao.findAll().iterator());
//////            List<Post> posts = postDao.findByTitle("First Blog Post");
////            for (Post post : posts) {
////                System.out.println(post.getId());
////                System.out.println(post.getTitle());
////                System.out.println(post.getBody());
////            }
////            return "success";
//            return "posts/index";
//        }
    @GetMapping("/posts")
    public String showPosts(Model model) {
//        init(); //be sure to go to web link to populate table
//        List<Post> posts = IteratorUtils.toList(postDao.findAll().iterator());
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("posts/{id}")
    public String showPost(@PathVariable long id, Model model) {
//        Post post = postDao.findOne(id);
        model.addAttribute("post", postDao.findOne(id));
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String showCreationForm(Model model) {
        model.addAttribute("users", userDao.findAll());
        model.addAttribute("post", new Post()); // matches th:object in view html file
        return "posts/create";
    }

//    @GetMapping("/posts/create")
//    public String showCreationForm(Model model) {
//        model.addAttribute("users", userDao.findAll());
//        return "posts/create";
//    }

    @PostMapping("/posts/create")
    public String createNewPost(@ModelAttribute Post postToSaved) { //matches data type sent in GetMapping
//        post.setAuthor(userDao.findOne(1L));
        Post savedPost = postDao.save(postToSaved);
        emailService.prepareAndSend(savedPost, "Post has been created.", "The post has been created successfully and you can find it with the ID of " + savedPost.getId());
        return "redirect:/posts/" + savedPost.getId();
    }

//    @PostMapping("/posts/create")
//    @ResponseBody
//    public String createNewPost(@RequestParam String title, @RequestParam String body, @RequestParam User user) {
//        Post newPost = new Post();
//        newPost.setTitle(title);
//        newPost.setBody(body);
////        newPost.setAuthor(userDao.findOne(1L));
//        newPost.setAuthor(user);
//        postDao.save(newPost);
//        return "New post created.";
//    }

    @GetMapping("/posts/{id}/edit")
    public String editForm(@PathVariable long id, Model model) {
        Post post = postDao.findOne(id);
        model.addAttribute("post", post);
        return "posts/edit";
    }


    @PostMapping("/posts/{id}/edit")
    public String editPost(@ModelAttribute Post postToBeEdited) {
        postDao.save(postToBeEdited);
        return "redirect:/posts/" + postToBeEdited.getId();
    }

//    @PostMapping("/posts/{id}/edit")
////    @ResponseBody
//    public String editPost(@RequestParam String title, @RequestParam String body, @RequestParam String id) {
//        Post post = postDao.findOne(Long.valueOf(id));
//        post.setTitle(title);
//        post.setBody(body);
//        postDao.save(post);
////        return "Successfully modified post";
//        return "redirect:/posts";
//    }



    @GetMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable long id, Model model) {
        model.addAttribute("post", postDao.findOne(id));
//        postDao.deleteById(id);
        return "posts/delete";
    }

    @PostMapping("/posts/{id}/delete")
//    @ResponseBody
    public String deletePost(@RequestParam String id) {
        postDao.deleteById(Long.valueOf(id));
//        return "Post successfully deleted.";
        return "redirect:/posts";
    }



    @GetMapping("/posts/navbar")
    public String showNavbar() {
        return "fragments/nav-in-progress";
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

    private void init() {
        Post post1 = new Post();
        post1.setTitle("First Blog Post");
        post1.setBody("This is the first post in my new blog.");
        postDao.save(post1);
        Post post2 = new Post();
        post2.setTitle("Second Blog Post");
        post2.setBody("This is the second post in my new blog");
        postDao.save(post2);
    }
}
