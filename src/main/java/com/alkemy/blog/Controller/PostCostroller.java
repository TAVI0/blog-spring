package com.alkemy.blog.Controller;

import com.alkemy.blog.Service.PostService;
import com.alkemy.blog.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class PostCostroller {

    @Autowired
    private final PostService postService;


    public PostCostroller(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("get/posts")
    public String listPost(Model model){
        model.addAttribute("list",postService.findOrderByDateDesc());
        return "home";
    }
    @GetMapping("get/post/{id}")
    public String getPost(@PathVariable("id") int id, Model model){

        Optional<Post> possiblePost = postService.findById(id);
        if(possiblePost.isPresent()){
            Post post = possiblePost.get();
            model.addAttribute("post",post);
            return "details";
        }else {
            return "postNoFind";
        }
    }

    @GetMapping("post/posts/{id}")
    public String showSave(Model model){
        model.addAttribute("post",new Post());
        return "formCreation";
    }

    @PostMapping("post/posts")
    public String save(Post post){
        postService.save(post);
        return "home";
    }

    @GetMapping("patch/posts/{id}")
    public String showEdit(@PathVariable("id") int id, Model model){
        model.addAttribute("post",postService.findById(id));
        return "formPatch";
    }
    @PatchMapping("patch/post")
    public String edit(Post post){
        postService.save(post);
        return "home";
    }

    @DeleteMapping("delete/post/{id}")
    public String delete(@PathVariable("id") int id, Model model){
        postService.deleteById(id);
        return "home";
    }


    }
