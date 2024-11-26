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
    public ResponseEntity<List<Comment>> getAllComments(Integer page, Integer size) {
        if (page == null) {
            return ResponseEntity.ok(commentService.getAllComments());
        } else {
            return ResponseEntity.ok(commentService.getCommentsWithPagination(page, size));
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

    @PatchMapping("{id}")
    @Override
    public ResponseEntity<Comment> updateComment(Comment comment, Long authorId) {
        return ResponseEntity.ok(commentService.updateComment(comment, authorId));
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity deleteComment(Long id) {
        commentService.deleteComment(id);
        return ResponseEntity.ok().build();
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
