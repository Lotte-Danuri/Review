package com.danuri.review.controller;

import com.danuri.review.dto.ReplyDto;
import com.danuri.review.service.ReplyService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reply")
public class ReplyController {

    private final ReplyService replyService;

    @PostMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "답변 작성", notes = "리뷰에 대한 답변 작성")
    public ResponseEntity save(@RequestBody @Valid ReplyDto replyDto){
        replyService.save(replyDto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "답변 조회", notes = "리뷰에 대한 답변 조회")
    public ResponseEntity<?> getReply(@PathVariable("id")Long id){
        return new ResponseEntity<>(replyService.getReply(id), HttpStatus.OK);
    }

    @PatchMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "답변 수정", notes = "리뷰에 대한 답변 수정")
    public ResponseEntity updateReply(@PathVariable("id")Long id,
                                      @RequestBody @Valid ReplyDto replyDto){
        replyService.updateReply(id, replyDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "답변 삭제", notes = "리뷰에 대한 답변 삭제")
    public ResponseEntity deleteReply(@PathVariable("id")Long id){
        replyService.deleteReply(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
