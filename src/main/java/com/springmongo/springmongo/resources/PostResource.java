package com.springmongo.springmongo.resources;

import com.springmongo.springmongo.domain.Post;
import com.springmongo.springmongo.resources.util.URL;
import com.springmongo.springmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    PostService postService;

    @GetMapping(value = "/{id}")
    @ResponseBody
    public Post findById(@PathVariable String id) {
        return this.postService.findById(id);
    }

    @GetMapping(value = "/titlesearch")
    @ResponseBody
    public List<Post> findByTitle(
            @RequestParam(value = "title", defaultValue = "") String title
    ) {
        title = URL.decodeParam(title);
        return this.postService.findByTitle(title);
    }

    @GetMapping(value = "/fullsearch")
    @ResponseBody
    public List<Post> fullSearch(
            @RequestParam(value = "text", defaultValue = "") String text,
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate
    ) {
        text = URL.decodeParam(text);
        LocalDate min = URL.convertDate(minDate);
        LocalDate max = URL.convertDate(maxDate);
        return this.postService.fullSearch(text, min, max);
    }
}
