package com.danuri.review.exception;

public class ReviewNotFoundException extends RuntimeException {
    public ReviewNotFoundException(String msg){
        super(msg);
    }
}
