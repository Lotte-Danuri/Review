package com.danuri.review.controller;

import com.danuri.review.dto.ReviewDto;
import com.danuri.review.service.ReviewService;
import com.danuri.review.util.S3Upload;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController()
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    @ApiOperation(value = "리뷰 작성", notes = "리뷰 작성")
    public ResponseEntity save(@RequestPart ReviewDto reviewDto,
                               @RequestPart MultipartFile image) {
        reviewService.save(reviewDto, image);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "리뷰 조회", notes = "리뷰 아이디로 리뷰를 조회한다.")
    public ResponseEntity<?> readReview(@PathVariable Long id){
        return new ResponseEntity<>(reviewService.readReview(id), HttpStatus.OK);
    }
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "리뷰 조회", notes = "모든 리뷰를 조회한다.")
    public ResponseEntity<?> readReviewList(){
        return new ResponseEntity<>(reviewService.readReviewList(), HttpStatus.OK);
    }

    @PatchMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    @ApiOperation(value = "리뷰 수정", notes = "리뷰 아이디로 리뷰를 수정한다.")
    public ResponseEntity updateReview(
            @PathVariable("id") Long id,
            @RequestPart @Valid ReviewDto reviewDto,
            @RequestPart MultipartFile image){
        reviewService.updateReview(id,reviewDto, image);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "리뷰 삭제", notes = "리뷰 아이디로 리뷰를 삭제한다.")
    public ResponseEntity deleteReview(@PathVariable("id") Long id){
        reviewService.deleteReview(id);
        return new ResponseEntity((HttpStatus.OK));
    }
}
