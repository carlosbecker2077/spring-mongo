package com.springmongo.springmongo.services;

import com.springmongo.springmongo.domain.Post;
import com.springmongo.springmongo.repository.PostRepository;
import com.springmongo.springmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Post findById(String id) {
        Optional<Post> post = postRepository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException(id));
    }

    public List<Post> findByTitle(String title) {
        return this.postRepository.findByTitleContaining(title);
    }
}
