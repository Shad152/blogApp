package com.shad.SpringStarter.SpringApp.controllers;

import com.shad.SpringStarter.SpringApp.dto.BlogDTO;
import com.shad.SpringStarter.SpringApp.exceptions.ResourceNotFoundException;
import com.shad.SpringStarter.SpringApp.services.BlogService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/blogs")
public class BlogController {
    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }



    @GetMapping
    public ResponseEntity<List<BlogDTO>> getAllBlogs(){
        List<BlogDTO> blogs = blogService.findAllBlogs();
        if(blogs.isEmpty()){
            throw new ResourceNotFoundException("Blogs Table is Empty");
        }
        else
        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }
    @GetMapping(path="/{blogId}")
    public ResponseEntity<BlogDTO> getBlogWithId(@PathVariable Long blogId){
        BlogDTO blogDTO = blogService.findBlogById(blogId);
        return ResponseEntity.ok(blogDTO);
    }
    @PostMapping
    public ResponseEntity<BlogDTO> createBlog(@Valid @RequestBody BlogDTO blogDTO){
       BlogDTO blogDTO1 = blogService.createBlog(blogDTO);
       return new ResponseEntity<>(blogDTO1,HttpStatus.OK);
    }
    @PutMapping (path = "/{blogId}")
    public ResponseEntity<BlogDTO> updateBlog(@PathVariable Long blogId, @Valid @RequestBody BlogDTO blogDTO){
        BlogDTO blogDTO1 = blogService.updateBlogById(blogId,blogDTO);
        return new ResponseEntity<>(blogDTO1,HttpStatus.OK);

    }
    @PatchMapping(path = "/{blogId}")
    public ResponseEntity<BlogDTO> partialBlogUpdateById(@PathVariable Long blogId, @RequestBody Map<String, Object> blogUpdates){
        BlogDTO blogDTO = blogService.updateBlogPartiallyById(blogId, blogUpdates);
        return new ResponseEntity<>(blogDTO,HttpStatus.OK);

    }
}
