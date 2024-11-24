package com.flawden.TaskManagerAPI.repository;

import com.flawden.TaskManagerAPI.model.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
}
