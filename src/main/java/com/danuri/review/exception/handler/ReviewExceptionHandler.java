package com.danuri.review.exception.handler;

import com.danuri.review.exception.ReplyDuplicationException;
import com.danuri.review.exception.ReviewDuplicationException;
import com.danuri.review.exception.ReviewNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ReviewExceptionHandler {

    @ExceptionHandler(ReviewDuplicationException.class)
    public ResponseEntity<String> reviewDuplicationException(ReviewDuplicationException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ReviewNotFoundException.class)
    public ResponseEntity<String> reviewNotFoundException(ReviewNotFoundException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ReplyDuplicationException.class)
    public ResponseEntity<String> replyDuplicationException(ReplyDuplicationException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
