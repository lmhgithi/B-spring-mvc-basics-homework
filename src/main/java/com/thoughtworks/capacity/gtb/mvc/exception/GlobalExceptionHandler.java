package com.thoughtworks.capacity.gtb.mvc.exception;

import com.thoughtworks.capacity.gtb.mvc.exception.domain.ErrorResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResult> exceptionHandler(MethodArgumentNotValidException e) {
        String message = e.getBindingResult().getFieldError().getDefaultMessage();
        ErrorResult errorResult = new ErrorResult(message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
    }

    @ExceptionHandler(UserNameAlreadyExistsException.class)
    public ResponseEntity<ErrorResult> notExistsHandler(UserNameAlreadyExistsException e) {
        ErrorResult errorResult = new ErrorResult("用户名已存在");
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResult);
    }

    @ExceptionHandler(UserNameOrPassWordInvalidException.class)
    public ResponseEntity<ErrorResult> invalidHandler(UserNameOrPassWordInvalidException e) {
        ErrorResult errorResult = new ErrorResult("用户名或密码错误");
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(errorResult);
    }
}
