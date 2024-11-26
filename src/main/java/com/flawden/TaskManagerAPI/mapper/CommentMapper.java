package com.flawden.TaskManagerAPI.mapper;

import com.flawden.TaskManagerAPI.dto.Comment;
import com.flawden.TaskManagerAPI.model.CommentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    Comment mapCommentEntityToComment(CommentEntity commentEntity);

    CommentEntity mapCommentToCommentEntity(Comment comment);

}
