package com.flawden.TaskManagerAPI.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flawden.TaskManagerAPI.controller.impl.CommentControllerImpl;
import com.flawden.TaskManagerAPI.dto.Comment;
import com.flawden.TaskManagerAPI.service.CommentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class CommentControllerImplTest {

    @Mock
    private CommentService commentService;

    @InjectMocks
    private CommentControllerImpl commentController;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        objectMapper = new ObjectMapper();
    }

    @Test
    void testGetAllCommentsWithoutPagination() {
        List<Comment> comments = Arrays.asList(
                new Comment(1L, "Comment 1", 1L, 1L),
                new Comment(2L, "Comment 2", 2L, 2L)
        );
        when(commentService.getAllComments()).thenReturn(comments);
        ResponseEntity<List<Comment>> response = commentController.getAllComments(null, null);
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals(2, response.getBody().size());
        verify(commentService, times(1)).getAllComments();
    }

    @Test
    void testGetAllCommentsWithPagination() {
        List<Comment> paginatedComments = Arrays.asList(
                new Comment(1L, "Paginated Comment 1", 1L, 1L)
        );
        when(commentService.getCommentsWithPagination(0, 1)).thenReturn(paginatedComments);
        ResponseEntity<List<Comment>> response = commentController.getAllComments(0, 1);
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals(1, response.getBody().size());
        verify(commentService, times(1)).getCommentsWithPagination(0, 1);
    }

    @Test
    void testGetCommentById() {
        Comment comment = new Comment(1L, "Test Comment", 1L, 1L);
        when(commentService.getCommentById(1L)).thenReturn(comment);
        ResponseEntity<Comment> response = commentController.getCommentById(1L);
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals("Test Comment", response.getBody().getText());
        verify(commentService, times(1)).getCommentById(1L);
    }

    @Test
    void testAddComment() {
        Comment comment = new Comment(null, "New Comment", 1L, 1L);
        Comment savedComment = new Comment(1L, "New Comment", 1L, 1L);
        when(commentService.addComment(comment)).thenReturn(savedComment);
        ResponseEntity<Comment> response = commentController.addComment(comment);
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals(1L, response.getBody().getId());
        verify(commentService, times(1)).addComment(comment);
    }

    @Test
    void testUpdateComment() {
        Comment comment = new Comment(1L, "Updated Comment", 1L, 1L);
        doNothing().when(commentService).updateComment(comment, 1L);
        ResponseEntity<HttpStatus> response = commentController.updateComment(comment, 1L);
        assertEquals(200, response.getStatusCodeValue());
        verify(commentService, times(1)).updateComment(comment, 1L);
    }

    @Test
    void testDeleteComment() {
        doNothing().when(commentService).deleteComment(1L);
        ResponseEntity<HttpStatus> response = commentController.deleteComment(1L);
        assertEquals(200, response.getStatusCodeValue());
        verify(commentService, times(1)).deleteComment(1L);
    }

    @Test
    void testGetCommentByTaskId() {
        Comment comment = new Comment(1L, "Task Comment", 1L, 1L);
        when(commentService.getCommentByTaskId(1L)).thenReturn(comment);
        ResponseEntity<Comment> response = commentController.getCommentByTaskId(1L);
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals("Task Comment", response.getBody().getText());
        verify(commentService, times(1)).getCommentByTaskId(1L);
    }

    @Test
    void testGetCommentByUserId() {
        Comment comment = new Comment(1L, "User Comment", 1L, 1L);
        when(commentService.getCommentByUserId(1L)).thenReturn(comment);
        ResponseEntity<Comment> response = commentController.getCommentByUserId(1L);
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals("User Comment", response.getBody().getText());
        verify(commentService, times(1)).getCommentByUserId(1L);
    }
}
