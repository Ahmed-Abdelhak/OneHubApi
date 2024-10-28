package com.onehub.api.v1.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public interface BadRequestExceptionHandler {

  @ExceptionHandler(IllegalArgumentException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  default ResponseEntity<ErrorDto> handleIllegalArgumentException(IllegalArgumentException e) {
    return ResponseEntity.badRequest()
        .body(
            ErrorDto.builder().code(HttpStatus.BAD_REQUEST.name()).message(e.getMessage()).build());
  }
}
