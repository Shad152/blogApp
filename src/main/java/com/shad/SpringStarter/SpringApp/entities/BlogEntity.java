package com.shad.SpringStarter.SpringApp.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="blogs")
public class BlogEntity {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String title;
    private String category;
    private String body;
    private String author;
    private LocalDateTime dateOfCreation;
    private LocalDateTime dateOfLastUpdate;
}
