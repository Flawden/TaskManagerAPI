package com.flawden.TaskManagerAPI.controller;

import com.flawden.TaskManagerAPI.dto.Comment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface CommentController {

    ResponseEntity<List<Comment>> getAllComments(@RequestParam(value = "page", required = false) Long page);

    ResponseEntity<Comment> getCommentById(@RequestParam Long id);

    ResponseEntity<Comment> addComment(@RequestBody Comment comment);

    ResponseEntity<Comment> updateComment(@RequestBody Comment comment);

    ResponseEntity<Comment> deleteComment(@RequestParam Long id);

    ResponseEntity<Comment> getCommentByTaskId(@RequestParam Long id);

    ResponseEntity<Comment> getCommentByUserId(@RequestParam Long id);

}
