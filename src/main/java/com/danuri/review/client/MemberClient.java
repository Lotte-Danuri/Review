package com.danuri.review.client;

import com.danuri.review.dto.MemberDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(name = "member")
public interface MemberClient {
    @GetMapping("/:memberId")
    MemberDto getMemberById(@RequestHeader Long memberId);
}
