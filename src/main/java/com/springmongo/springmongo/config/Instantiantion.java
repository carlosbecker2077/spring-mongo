package com.springmongo.springmongo.config;

import com.springmongo.springmongo.domain.Post;
import com.springmongo.springmongo.domain.User;
import com.springmongo.springmongo.dto.AuthorDTO;
import com.springmongo.springmongo.dto.CommentDTO;
import com.springmongo.springmongo.repository.PostRepository;
import com.springmongo.springmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class Instantiantion implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        CommentDTO c1 = new CommentDTO("Boa viagem mano!", Instant.now(), new AuthorDTO(alex));
        CommentDTO c2 = new CommentDTO("Aproveite!", Instant.now(), new AuthorDTO(bob));
        CommentDTO c3 = new CommentDTO("Tenha um ótimo dia", Instant.now(), new AuthorDTO(alex));

        Post p1 = new Post(null, Instant.now(), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
        Post p2 = new Post(null, Instant.now(), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));

        postRepository.saveAll(Arrays.asList(p1, p2));

        maria.getPosts().addAll(Arrays.asList(p1, p2));

        p1.getComments().addAll(Arrays.asList(c1, c2));

        p2.getComments().addAll(Arrays.asList(c3));

        userRepository.save(maria);
        postRepository.save(p1);
        postRepository.save(p2);
    }
}
