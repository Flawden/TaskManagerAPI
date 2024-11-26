package com.flawden.TaskManagerAPI.service.impl;

import com.flawden.TaskManagerAPI.dto.Comment;
import com.flawden.TaskManagerAPI.exception.CommentNotFoundException;
import com.flawden.TaskManagerAPI.mapper.CommentMapper;
import com.flawden.TaskManagerAPI.model.CommentEntity;
import com.flawden.TaskManagerAPI.repository.CommentRepository;
import com.flawden.TaskManagerAPI.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll().stream()
                .map(this::mapCommentEntityToComment)
                .collect(Collectors.toList());
    }

    @Override
    public List<Comment> getCommentsWithPagination(Integer page, Integer limit) {
        Pageable pageable = PageRequest.of(page, limit);
        return commentRepository.findAll(pageable)
                .stream()
                .map(this::mapCommentEntityToComment)
                .collect(Collectors.toList());
    }

    private Comment mapCommentEntityToComment(CommentEntity commentEntity) {
        return commentMapper.mapCommentEntityToComment(commentEntity);
    }

    @Override
    public Comment getCommentById(Long id) {
        return commentMapper.mapCommentEntityToComment(commentRepository.findById(id).orElseThrow(CommentNotFoundException::new));
    }

    @Override
    public Comment addComment(Comment comment) {
        return commentMapper.mapCommentEntityToComment(commentRepository.save(commentMapper.mapCommentToCommentEntity(comment)));
    }

    @Override
    public void updateComment(Comment comment, Long authorId) {
        CommentEntity updatableComment = commentRepository.findCommentEntityByAuthorId(authorId).orElseThrow(CommentNotFoundException::new);
        updatableComment.setAuthor(updatableComment.getAuthor());
        updatableComment.setText(updatableComment.getText());
        commentRepository.save(updatableComment);
    }

    @Override
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public Comment getCommentByTaskId(Long id) {
        return commentMapper.mapCommentEntityToComment(commentRepository.findCommentEntitiesByTaskId(id).orElseThrow(CommentNotFoundException::new));
    }

    @Override
    public Comment getCommentByUserId(Long id) {
        return commentMapper.mapCommentEntityToComment(commentRepository.findCommentEntityByAuthorId(id).orElseThrow(CommentNotFoundException::new));
    }
}
