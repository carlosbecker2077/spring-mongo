package com.springmongo.springmongo.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

public class CommentDTO implements Serializable {
    private String text;
    private Instant date;
    private AuthorDTO author;

    public CommentDTO(String text, Instant date, AuthorDTO author) {
        this.text = text;
        this.date = date;
        this.author = author;
    }

    public CommentDTO(){}

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
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
        CommentDTO comment = (CommentDTO) o;
        return Objects.equals(text, comment.text) && Objects.equals(date, comment.date) && Objects.equals(author, comment.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, date, author);
    }

    @Override
    public String toString() {
        return "CommentDTO{" +
                "text='" + text + '\'' +
                ", date=" + date +
                ", author=" + author +
                '}';
    }
}
