package com.springmongo.springmongo.resources;

import com.springmongo.springmongo.domain.Post;
import com.springmongo.springmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    PostService postService;

    @GetMapping(value = "/{id}")
    @ResponseBody
    public Post findById(@PathVariable String id) {
        Post post = this.postService.findById(id);
        return post;
    }
}
