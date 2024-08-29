package com.shad.SpringStarter.SpringApp.services;

import com.shad.SpringStarter.SpringApp.dto.BlogDTO;
import com.shad.SpringStarter.SpringApp.entities.BlogEntity;
import com.shad.SpringStarter.SpringApp.exceptions.ResourceNotFoundException;
import com.shad.SpringStarter.SpringApp.repositories.BlogRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
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
       return blogRepository.findById(blogId).map(blogEntity -> modelMapper.map(blogEntity,BlogDTO.class))
               .orElseThrow(()->new ResourceNotFoundException("Blog does not exist with Id: "+blogId));

    }

    public BlogDTO createBlog(BlogDTO blogDTO) {
        BlogEntity blogEntity = modelMapper.map(blogDTO,BlogEntity.class);
        BlogEntity toSaveBlogEntity = blogRepository.save(blogEntity);
        return modelMapper.map(toSaveBlogEntity,BlogDTO.class);
    }

    public BlogDTO updateBlogById(Long blogId, BlogDTO blogDTO) {
        isBlogExistById(blogId);
        BlogEntity blogEntity = modelMapper.map(blogDTO,BlogEntity.class);
        BlogEntity savedBlogEntity = blogRepository.save(blogEntity);
        return modelMapper.map(savedBlogEntity,BlogDTO.class);

    }

    public BlogDTO updateBlogPartiallyById(Long blogId, Map<String, Object> blogUpdates) {
        isBlogExistById(blogId);
        BlogEntity EntityToBeUpdated= blogRepository.findById(blogId).get();
        blogUpdates.forEach(
                (field, updatedValue) ->{
                 Field fieldToBeUpdated= ReflectionUtils.findField(BlogEntity.class,field);
                 fieldToBeUpdated.setAccessible(true);
                 if(fieldToBeUpdated.getName().equals("dateOfLastUpdate")){
                     ReflectionUtils.setField(fieldToBeUpdated,EntityToBeUpdated, LocalDateTime.parse((String)updatedValue));
                 }
                 else {
                     ReflectionUtils.setField(fieldToBeUpdated,EntityToBeUpdated,updatedValue);
                 }
                }
        );
        return modelMapper.map(blogRepository.save(EntityToBeUpdated),BlogDTO.class);
    }
    private boolean isBlogExistById(Long blogId){
        Optional<BlogEntity> blogEntity=blogRepository.findById(blogId);
        if(blogEntity.isPresent()){
            return true;
        }
        throw new ResourceNotFoundException("Blog does not exist with this Id:"+blogId);
    }
}
