package com.danuri.review.controller;

import com.danuri.review.dto.ReviewDto;
import com.danuri.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController()
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity save(@RequestBody ReviewDto reviewDto) {
        reviewService.save(reviewDto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> readReview(@PathVariable Long id){
        return new ResponseEntity<>(reviewService.readReview(id), HttpStatus.OK);
    }
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> readReviewList(){
        return new ResponseEntity<>(reviewService.readReviewList(), HttpStatus.OK);
    }

    @PatchMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity updateReview(
            @PathVariable("id") Long id,
            @RequestBody @Valid ReviewDto reviewDto){
        reviewService.updateReview(id,reviewDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity deleteReview(@PathVariable("id") Long id){
        reviewService.deleteReview(id);
        return new ResponseEntity((HttpStatus.OK));
    }
}
