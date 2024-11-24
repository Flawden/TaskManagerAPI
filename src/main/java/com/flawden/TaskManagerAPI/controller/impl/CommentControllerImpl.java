package com.flawden.TaskManagerAPI.controller.impl;

import com.flawden.TaskManagerAPI.controller.CommentController;
import com.flawden.TaskManagerAPI.dto.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comments")
@RequiredArgsConstructor
public class CommentControllerImpl implements CommentController {

    @Override
    public ResponseEntity<List<Comment>> getAllComments() {
        return null;
    }

    @Override
    public ResponseEntity<List<Comment>> getCommentsWithPagination(int page) {
        return null;
    }

    @Override
    public ResponseEntity<Comment> getCommentById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Comment> addComment(Comment commentEntity) {
        return null;
    }

    @Override
    public ResponseEntity<Comment> updateComment(Comment commentEntity) {
        return null;
    }

    @Override
    public ResponseEntity<Comment> deleteComment(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Comment> getCommentByTaskId(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Comment> getCommentByUserId(Long id) {
        return null;
    }
}
