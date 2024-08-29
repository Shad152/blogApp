package com.shad.SpringStarter.SpringApp.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class BlogDTO {
    private Long id;
    @NotBlank(message = "Title can not be blank")
    @Size(min=1,max=50,message = "Title Minimum Length=1 & Maximum Length=50")
    private String title;
    private String category;
    @NotBlank(message = "Body can not be blank")
    @Size(min = 30, max=3000,message = "Blog body Min Len=30 & Max Len=3000")
    private String body;
    @NotBlank(message = "Author name can not be Blank")
    private String author;
    @PastOrPresent(message = "Enter Current or Past Date")
    private LocalDateTime dateOfCreation=LocalDateTime.now();
    @PastOrPresent(message = "Enter Current or Past Date")
    private LocalDateTime dateOfLastUpdate=LocalDateTime.now();

}
