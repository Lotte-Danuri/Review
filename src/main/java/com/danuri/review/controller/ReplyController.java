package com.danuri.review.controller;

import com.danuri.review.dto.ReplyDto;
import com.danuri.review.service.ReplyService;
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
    public ResponseEntity save(@RequestBody @Valid ReplyDto replyDto){
        replyService.save(replyDto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getReply(@PathVariable("id")Long id){
        return new ResponseEntity<>(replyService.getReply(id), HttpStatus.OK);
    }

    @PatchMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity updateReply(@PathVariable("id")Long id,
                                      @RequestBody @Valid ReplyDto replyDto){
        replyService.updateReply(id, replyDto);
        return new ResponseEntity(HttpStatus.OK);
    }

}
