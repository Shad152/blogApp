package com.shad.SpringStarter.SpringApp.controllers;

import com.shad.SpringStarter.SpringApp.dto.BlogDTO;
import com.shad.SpringStarter.SpringApp.entities.BlogEntity;
import com.shad.SpringStarter.SpringApp.services.BlogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BlogController {
    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }



    @GetMapping(path ="/blogs")
    public List<BlogDTO> getAllBlogs(){
        return blogService.findAllBlogs();
    }
    @GetMapping(path="/blogs/{blogId}")
    public BlogDTO getBlogWithId(@PathVariable Long blogId){
        return blogService.findBlogById(blogId);
    }
    @PostMapping("/blogs")
    public BlogDTO createBlog(@RequestBody BlogDTO blog){
       return blogService.createBlog(blog);
    }

}
