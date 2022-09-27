package com.danuri.review.service;

import com.danuri.review.dto.ReplyDto;
import com.danuri.review.entity.Reply;
import com.danuri.review.exception.ReplyDuplicationException;
import com.danuri.review.exception.ReplyNotFoundException;
import com.danuri.review.repository.ReplyRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ReplyService {

    private final ReplyRepo replyRepo;

    public void save(ReplyDto replyDto) {
        if(replyRepo.findByReviewId(replyDto.getReviewId()).isPresent()){
            throw new ReplyDuplicationException("이미 리뷰가 작성되었습니다.");
        }

        replyRepo.save(Reply
                .builder()
                .reviewId(replyDto.getReviewId())
                .contents(replyDto.getContents())
                .storeId(replyDto.getStoreId())
                .build());
    }

    public ReplyDto getReply(Long id) {
        return new ReplyDto(getReplyById(id));
    }

    @Transactional
    public void updateReply(Long id, ReplyDto replyDto) {
        Reply reply = getReplyById(id);

        reply.updateContents(replyDto.getContents());
    }

    public Reply getReplyById(Long id){
        return replyRepo.findById(id).orElseThrow(() -> new ReplyNotFoundException("리뷰가 존재하지 않습니다."));
    }

    @Transactional
    public void deleteReply(Long id) {
        Reply reply = getReplyById(id);

        reply.updateDeletedDate(LocalDateTime.now());
    }
}
