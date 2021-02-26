package com.alkemy.blog.Service;

import com.alkemy.blog.Repository.PostRepository;
import com.alkemy.blog.entity.Post;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private final PostRepository postRepository;
    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    public List<Post> findAll(){
        return this.postRepository.findAll();
    }
    //public List<Post> findOrderByDateDesc(){return this.postRepository.findOrderByDateDesc();}
    public Optional<Post> findById(int id){
        return this.postRepository.findById(id);
    }
    public Post save(Post post){
        return this.postRepository.save(post);
    }
    public void deleteById(int id){
        this.postRepository.deleteById(id);
    }
}
