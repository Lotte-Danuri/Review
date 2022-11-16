package com.danuri.review.client;

import com.danuri.review.dto.MemberDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "member")
public interface MemberClient {
    @GetMapping("/{memberId}")
    MemberDto getMemberById(@PathVariable Long memberId);
}
