package com.alkemy.blog.Repository;

import com.alkemy.blog.entity.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends CrudRepository<Post, Integer> {
    List<Post> findOrderByDateDesc();
    Optional<Post> findById(int id);
    Post save(Post post);
    void deleteById(int id);
}
