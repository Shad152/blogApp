package com.shad.SpringStarter.SpringApp.dto;

import java.time.LocalDateTime;

public class BlogDTO {
    private Long id;
    private String title;
    private String category;
    private String body;
    private String author;
    private LocalDateTime dateOfCreation;
    private LocalDateTime dateOfLastUpdate;

    public BlogDTO() {
    }

    public BlogDTO(Long id, String title, String category, String body, String author, LocalDateTime dateOfCreation, LocalDateTime dateOfLastUpdate) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.body = body;
        this.author = author;
        this.dateOfCreation = dateOfCreation;
        this.dateOfLastUpdate = dateOfLastUpdate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDateOfCreation(LocalDateTime dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public void setDateOfLastUpdate(LocalDateTime dateOfLastUpdate) {
        this.dateOfLastUpdate = dateOfLastUpdate;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getBody() {
        return body;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDateTime getDateOfCreation() {
        return dateOfCreation;
    }

    public LocalDateTime getDateOfLastUpdate() {
        return dateOfLastUpdate;
    }


}
