package com.ti.blog.exception;

public class UserNotEnrolledException extends RuntimeException {

    public UserNotEnrolledException(Long userId, Long courseId) {
        super("The student with id: '" + userId + "' is not enrolled in the course with id: '" + courseId);
    }

}