package com.flawden.TaskManagerAPI.controller.impl;

import com.flawden.TaskManagerAPI.controller.CommentController;
import com.flawden.TaskManagerAPI.dto.Comment;
import com.flawden.TaskManagerAPI.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comments")
@RequiredArgsConstructor
public class CommentControllerImpl implements CommentController {

    private final CommentService commentService;

    @GetMapping
    @Override
    public ResponseEntity<List<Comment>> getAllComments(Long page) {
        if (page == null) {
            return ResponseEntity.ok(commentService.getAllComments());
        } else {
            return ResponseEntity.ok(commentService.getCommentsWithPagination(page));
        }
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<Comment> getCommentById(Long id) {
        return ResponseEntity.ok(commentService.getCommentById(id));
    }

    @PostMapping
    @Override
    public ResponseEntity<Comment> addComment(Comment comment) {
        return ResponseEntity.ok(commentService.addComment(comment));
    }

    @PatchMapping
    @Override
    public ResponseEntity<Comment> updateComment(Comment comment) {
        return ResponseEntity.ok(commentService.updateComment(comment));
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Comment> deleteComment(Long id) {
        return ResponseEntity.ok(commentService.deleteComment(id));
    }

    @GetMapping("/task/{id}")
    @Override
    public ResponseEntity<Comment> getCommentByTaskId(Long id) {
        return ResponseEntity.ok(commentService.getCommentByTaskId(id));
    }

    @GetMapping("/user/{id}")
    @Override
    public ResponseEntity<Comment> getCommentByUserId(Long id) {
        return ResponseEntity.ok(commentService.getCommentByUserId(id));
    }
}
