package com.popcorn.advice;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
@Slf4j
public class GlobalAPIExceptionHandler {
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ProblemDetail> handleException(Exception exception, WebRequest webRequest) {
        log.error("GlobalAPIExceptionHandler::handleException message= {}", exception.getMessage());
        exception.printStackTrace();
        ProblemDetail problemDetail = new ProblemDetailImpl();
        problemDetail.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        problemDetail.setDetail(exception.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .contentType(MediaType.APPLICATION_JSON)
                .body(problemDetail);
    }

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<ProblemDetail> handleRuntimeException(Exception exception, WebRequest webRequest) {
        log.error("GlobalAPIExceptionHandler::handleRuntimeException message= {}", exception.getMessage());
        exception.printStackTrace();
        ProblemDetail problemDetail = new ProblemDetailImpl();
        problemDetail.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        problemDetail.setDetail(exception.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .contentType(MediaType.APPLICATION_JSON)
                .body(problemDetail);
    }

    @Getter
    @Setter
    protected static class ProblemDetailImpl extends ProblemDetail {
        private String message;
    }
}
