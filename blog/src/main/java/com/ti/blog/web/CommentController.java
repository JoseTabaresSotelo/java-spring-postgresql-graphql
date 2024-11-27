package com.ti.blog.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ti.blog.entity.Comment;
import com.ti.blog.service.CommentService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@AllArgsConstructor
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService commentService;

    @GetMapping("/{id}")
    public ResponseEntity<Comment> getComment(@PathVariable Long id) {
        return new ResponseEntity<>(commentService.getComment(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Comment>> getComments() {
        return new ResponseEntity<>(commentService.getComments(), HttpStatus.OK);
    }

    @PostMapping("/user/{userId}/post/{postId}")
    public ResponseEntity<Comment> postMethodName(@Valid @RequestBody Comment comment, @PathVariable Long userId,
            @PathVariable Long postId) {
        return new ResponseEntity<>(commentService.saveComment(comment, userId, postId), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
