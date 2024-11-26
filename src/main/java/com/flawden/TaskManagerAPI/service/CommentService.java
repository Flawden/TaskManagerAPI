package com.flawden.TaskManagerAPI.service;

import com.flawden.TaskManagerAPI.dto.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> getAllComments();

    List<Comment> getCommentsWithPagination(Integer page, Integer limit);

    Comment getCommentById(Long id);

    Comment addComment(Comment comment);

    void updateComment(Comment comment, Long authorId);

    void deleteComment(Long id);

    Comment getCommentByTaskId(Long id);

    Comment getCommentByUserId(Long id);

}
