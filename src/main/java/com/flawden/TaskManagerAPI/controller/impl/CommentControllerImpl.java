package com.flawden.TaskManagerAPI.controller.impl;

import com.flawden.TaskManagerAPI.controller.CommentController;
import com.flawden.TaskManagerAPI.dto.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comments")
@RequiredArgsConstructor
public class CommentControllerImpl implements CommentController {

    @GetMapping
    @Override
    public ResponseEntity<List<Comment>> getAllComments(Long page) {
        return null;
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<Comment> getCommentById(Long id) {
        return null;
    }

    @PostMapping
    @Override
    public ResponseEntity<Comment> addComment(Comment comment) {
        return null;
    }

    @PatchMapping
    @Override
    public ResponseEntity<Comment> updateComment(Comment comment) {
        return null;
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Comment> deleteComment(Long id) {
        return null;
    }

    @GetMapping("/task/{id}")
    @Override
    public ResponseEntity<Comment> getCommentByTaskId(Long id) {
        return null;
    }

    @GetMapping("/user/{id}")
    @Override
    public ResponseEntity<Comment> getCommentByUserId(Long id) {
        return null;
    }
}
