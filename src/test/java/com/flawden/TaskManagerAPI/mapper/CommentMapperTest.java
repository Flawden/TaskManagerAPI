package com.flawden.TaskManagerAPI.mapper;

import com.flawden.TaskManagerAPI.dto.Comment;
import com.flawden.TaskManagerAPI.model.CommentEntity;
import com.flawden.TaskManagerAPI.model.TaskEntity;
import com.flawden.TaskManagerAPI.model.UserEntity;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.assertj.core.api.Assertions.assertThat;

public class CommentMapperTest {

    private final CommentMapper mapper = Mappers.getMapper(CommentMapper.class);

    @Test
    void shouldMapCommentEntityToComment() {
        UserEntity user = new UserEntity();
        user.setId(1L);
        TaskEntity task = new TaskEntity();
        task.setId(2L);
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setId(3L);
        commentEntity.setText("Test comment");
        commentEntity.setAuthor(user);
        commentEntity.setTask(task);
        Comment comment = mapper.mapCommentEntityToComment(commentEntity);
        assertThat(comment.getId()).isEqualTo(3L);
        assertThat(comment.getText()).isEqualTo("Test comment");
        assertThat(comment.getAuthor()).isEqualTo(1L);
        assertThat(comment.getTask()).isEqualTo(2L);
    }

    @Test
    void shouldMapCommentToCommentEntity() {
        Comment comment = new Comment(3L, "Test comment", 1L, 2L);
        CommentEntity commentEntity = mapper.mapCommentToCommentEntity(comment);
        assertThat(commentEntity.getId()).isEqualTo(3L);
        assertThat(commentEntity.getText()).isEqualTo("Test comment");
        assertThat(commentEntity.getAuthor().getId()).isEqualTo(1L);
        assertThat(commentEntity.getTask().getId()).isEqualTo(2L);
    }

    @Test
    void shouldHandleNullFieldsInCommentToCommentEntity() {
        Comment comment = new Comment(null, "Test comment", null, null);
        CommentEntity commentEntity = mapper.mapCommentToCommentEntity(comment);
        assertThat(commentEntity.getId()).isNull();
        assertThat(commentEntity.getText()).isEqualTo("Test comment");
        assertThat(commentEntity.getAuthor()).isNull();
        assertThat(commentEntity.getTask()).isNull();
    }
}
