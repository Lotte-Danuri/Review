package com.danuri.review.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class MemberDto {

    private Long id;

    private String name;

    private String phoneNumber;

    private String address;

    private int age;

    private int role;

    private String birthDate;

}