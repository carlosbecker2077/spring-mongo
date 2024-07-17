package com.springmongo.springmongo.repository;

import com.springmongo.springmongo.domain.Post;
import com.springmongo.springmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
