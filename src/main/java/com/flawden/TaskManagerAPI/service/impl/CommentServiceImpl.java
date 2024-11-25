package com.flawden.TaskManagerAPI.service.impl;

import com.flawden.TaskManagerAPI.dto.Comment;
import com.flawden.TaskManagerAPI.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    @Override
    public List<Comment> getAllComments() {
        return List.of();
    }

    @Override
    public List<Comment> getCommentsWithPagination(Long page) {
        return List.of();
    }

    @Override
    public Comment getCommentById(Long id) {
        return null;
    }

    @Override
    public Comment addComment(Comment comment) {
        return null;
    }

    @Override
    public Comment updateComment(Comment comment) {
        return null;
    }

    @Override
    public Comment deleteComment(Long id) {
        return null;
    }

    @Override
    public Comment getCommentByTaskId(Long id) {
        return null;
    }

    @Override
    public Comment getCommentByUserId(Long id) {
        return null;
    }
}
