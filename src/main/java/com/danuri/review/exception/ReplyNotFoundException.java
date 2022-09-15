package com.danuri.review.exception;

public class ReplyNotFoundException extends RuntimeException {
    public ReplyNotFoundException(String msg){
        super(msg);
    }
}
