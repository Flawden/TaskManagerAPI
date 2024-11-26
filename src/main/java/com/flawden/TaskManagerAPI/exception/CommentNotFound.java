package com.flawden.TaskManagerAPI.exception;

public class CommentNotFound extends RuntimeException {

    public CommentNotFound() {
    }

    public CommentNotFound(String message) {
        super(message);
    }
}
