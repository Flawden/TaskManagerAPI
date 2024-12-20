package com.flawden.TaskManagerAPI.repository;

import com.flawden.TaskManagerAPI.model.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

    Optional<CommentEntity> findCommentEntityByAuthorId(Long authorId);
    Optional<CommentEntity> findCommentEntitiesByTaskId(Long taskId);

}
