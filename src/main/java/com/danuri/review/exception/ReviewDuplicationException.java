package com.danuri.review.exception;

public class ReviewDuplicationException extends RuntimeException{
    public ReviewDuplicationException(String msg){
        super(msg);
    }
}
