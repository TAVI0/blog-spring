package com.alkemy.blog.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data

@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String title;
    String content;
    String imageURL;
    String category;
    String date;
}
