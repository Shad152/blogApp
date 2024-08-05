package com.shad.SpringStarter.SpringApp.services;

import com.shad.SpringStarter.SpringApp.dto.BlogDTO;
import com.shad.SpringStarter.SpringApp.entities.BlogEntity;
import com.shad.SpringStarter.SpringApp.repositories.BlogRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BlogService {
    private final BlogRepository blogRepository;
    private final ModelMapper modelMapper;

    public BlogService(BlogRepository blogRepository, ModelMapper modelMapper) {
        this.blogRepository = blogRepository;
        this.modelMapper = modelMapper;
    }

    public List<BlogDTO> findAllBlogs() {
        List<BlogEntity> blogEntities =blogRepository.findAll();
        return blogEntities
                .stream()
                .map(blogEntity -> modelMapper.map(blogEntity,BlogDTO.class))
                .collect(Collectors.toList());
    }

    public BlogDTO findBlogById(Long blogId) {
        BlogEntity blogEntity = blogRepository.findById(blogId).orElse(null);
        BlogDTO toBlogDto= modelMapper.map(blogEntity,BlogDTO.class);
        return toBlogDto;

    }

    public BlogDTO createBlog(BlogDTO blog) {
        BlogEntity blogEntity = modelMapper.map(blog,BlogEntity.class);
        BlogEntity toSaveBlogEntity=   blogRepository.save(blogEntity);
        return modelMapper.map(toSaveBlogEntity,BlogDTO.class);
    }
}
