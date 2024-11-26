package com.flawden.TaskManagerAPI.controller;

import com.flawden.TaskManagerAPI.dto.Comment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface CommentController {

    ResponseEntity<List<Comment>> getAllComments(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "limit", required = false) Integer limit);

    ResponseEntity<Comment> getCommentById(@PathVariable Long id);

    ResponseEntity<Comment> addComment(@RequestBody Comment comment);

    ResponseEntity<HttpStatus> updateComment(@RequestBody Comment comment, Long authorId);

    ResponseEntity<HttpStatus> deleteComment(@PathVariable Long id);

    ResponseEntity<Comment> getCommentByTaskId(@PathVariable Long id);

    ResponseEntity<Comment> getCommentByUserId(@PathVariable Long id);

}
