package com.danuri.review.controller;

import com.danuri.review.dto.ReviewDto;
import com.danuri.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping(value = "/review",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity save(@RequestBody ReviewDto reviewDto){
        reviewService.save(reviewDto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

}
