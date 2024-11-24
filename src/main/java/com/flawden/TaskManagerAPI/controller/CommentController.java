package com.flawden.TaskManagerAPI.controller;

import com.flawden.TaskManagerAPI.dto.Comment;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CommentController {

    ResponseEntity<List<Comment>> getAllComments();

    ResponseEntity<List<Comment>> getCommentsWithPagination(int page);

    ResponseEntity<Comment> getCommentById(Long id);

    ResponseEntity<Comment> addComment(Comment comment);

    ResponseEntity<Comment> updateComment(Comment comment);

    ResponseEntity<Comment> deleteComment(Long id);

    ResponseEntity<Comment> getCommentByTaskId(Long id);

    ResponseEntity<Comment> getCommentByUserId(Long id);

}
