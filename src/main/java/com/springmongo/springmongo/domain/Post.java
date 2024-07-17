package com.springmongo.springmongo.domain;

import com.springmongo.springmongo.dto.AuthorDTO;
import com.springmongo.springmongo.dto.UserDTO;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Document
public class Post implements Serializable {
    @Id
    private String id;
    private Instant createdAt;
    private String title;
    private String body;
    private AuthorDTO author;

    public Post(String id, Instant createdAt, String title, String body, AuthorDTO author) {
        this.id = id;
        this.createdAt = createdAt;
        this.title = title;
        this.body = body;
        this.author = author;
    }

    public Post (){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id='" + id + '\'' +
                ", createdAt=" + createdAt +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
