package com.danuri.review.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Duplicate Review")
public class ReviewDuplicationException extends RuntimeException{
    public ReviewDuplicationException(String msg){
        super(msg);
    }
}
