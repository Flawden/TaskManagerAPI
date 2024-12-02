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

/**
 * Реализация сервиса для работы с комментариями.
 * <p>
 * Этот сервис предоставляет методы для получения всех комментариев, добавления, обновления и удаления комментариев,
 * а также для получения комментариев по идентификатору задачи или пользователя.
 * </p>
 */
@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    /**
     * Получить все комментарии.
     * <p>
     * Этот метод возвращает все комментарии, извлекая их из репозитория и преобразуя в объекты типа {@link Comment}.
     * </p>
     *
     * @return список всех комментариев.
     */
    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll().stream()
                .map(this::mapCommentEntityToComment)
                .collect(Collectors.toList());
    }

    /**
     * Получить комментарии с пагинацией.
     * <p>
     * Этот метод возвращает комментарии с учетом пагинации, используя параметры страницы и лимита.
     * </p>
     *
     * @param page  номер страницы (от 0).
     * @param limit количество комментариев на странице.
     * @return список комментариев на текущей странице.
     */
    @Override
    public List<Comment> getCommentsWithPagination(Integer page, Integer limit) {
        Pageable pageable = PageRequest.of(page, limit);
        return commentRepository.findAll(pageable)
                .stream()
                .map(this::mapCommentEntityToComment)
                .collect(Collectors.toList());
    }

    /**
     * Преобразует {@link CommentEntity} в {@link Comment}.
     *
     * @param commentEntity сущность комментария.
     * @return объект комментария {@link Comment}.
     */
    private Comment mapCommentEntityToComment(CommentEntity commentEntity) {
        return commentMapper.mapCommentEntityToComment(commentEntity);
    }

    /**
     * Получить комментарий по идентификатору.
     * <p>
     * Этот метод ищет комментарий по его идентификатору и возвращает его, если он существует. В противном случае
     * выбрасывается исключение {@link CommentNotFoundException}.
     * </p>
     *
     * @param id идентификатор комментария.
     * @return комментарий {@link Comment}.
     * @throws CommentNotFoundException если комментарий не найден.
     */
    @Override
    public Comment getCommentById(Long id) {
        return commentMapper.mapCommentEntityToComment(commentRepository.findById(id).orElseThrow(CommentNotFoundException::new));
    }

    /**
     * Добавить новый комментарий.
     * <p>
     * Этот метод сохраняет новый комментарий в базе данных.
     * </p>
     *
     * @param comment объект комментария для добавления.
     * @return добавленный комментарий {@link Comment}.
     */
    @Override
    public Comment addComment(Comment comment) {
        return commentMapper.mapCommentEntityToComment(commentRepository.save(commentMapper.mapCommentToCommentEntity(comment)));
    }

    /**
     * Обновить существующий комментарий.
     * <p>
     * Этот метод обновляет комментарий с заданным автором. Если комментарий не найден, выбрасывается исключение
     * {@link CommentNotFoundException}.
     * </p>
     *
     * @param comment  объект комментария с обновленными данными.
     * @param authorId идентификатор автора комментария.
     * @throws CommentNotFoundException если комментарий не найден.
     */
    @Override
    public void updateComment(Comment comment, Long authorId) {
        CommentEntity updatableComment = commentRepository.findCommentEntityByAuthorId(authorId).orElseThrow(CommentNotFoundException::new);
        updatableComment.setAuthor(updatableComment.getAuthor());
        updatableComment.setText(updatableComment.getText());
        commentRepository.save(updatableComment);
    }

    /**
     * Удалить комментарий по идентификатору.
     * <p>
     * Этот метод удаляет комментарий с указанным идентификатором.
     * </p>
     *
     * @param id идентификатор комментария.
     */
    @Override
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

    /**
     * Получить комментарий по идентификатору задачи.
     * <p>
     * Этот метод возвращает комментарий, привязанный к задаче с указанным идентификатором.
     * </p>
     *
     * @param id идентификатор задачи.
     * @return комментарий {@link Comment}.
     * @throws CommentNotFoundException если комментарий не найден.
     */
    @Override
    public Comment getCommentByTaskId(Long id) {
        return commentMapper.mapCommentEntityToComment(commentRepository.findCommentEntitiesByTaskId(id).orElseThrow(CommentNotFoundException::new));
    }

    /**
     * Получить комментарий по идентификатору пользователя.
     * <p>
     * Этот метод возвращает комментарий, созданный пользователем с указанным идентификатором.
     * </p>
     *
     * @param id идентификатор пользователя.
     * @return комментарий {@link Comment}.
     * @throws CommentNotFoundException если комментарий не найден.
     */
    @Override
    public Comment getCommentByUserId(Long id) {
        return commentMapper.mapCommentEntityToComment(commentRepository.findCommentEntityByAuthorId(id).orElseThrow(CommentNotFoundException::new));
    }
}
