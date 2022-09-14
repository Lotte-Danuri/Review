package com.danuri.review.controller;

import com.danuri.review.dto.ReviewDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
public class ReviewControllerFailTest {

    private final String REVIEW_URL = "/review";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    private static ReviewDto reviewDto;

    @BeforeAll
    public static void initReview(){
        reviewDto =
                ReviewDto.builder()
                        .memberId(3)
                        .productId(1)
                        .thumbnailImage("")
                        .contents("test")
                        .build();
    }

    @Test
    public void saveReviewControllerTest() throws Exception {

        //given
        String content = objectMapper.writeValueAsString(reviewDto);

        //when
        MvcResult result = mockMvc.perform(
                        MockMvcRequestBuilders.post(REVIEW_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .header("memberId","3")
                                .content(content)
                                .accept(MediaType.APPLICATION_JSON)
                )
                //then
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andDo(print())
                .andReturn();
    }

    @Test
    public void readReviewControllerTest() throws Exception{
        //given
        long reviewId = -10;

        //when
        MvcResult result = mockMvc.perform(
                        MockMvcRequestBuilders.get(REVIEW_URL+"/" + reviewId)
                                .accept(MediaType.APPLICATION_JSON)
                )
                //then
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andDo(print())
                .andReturn();
    }

    @Test
    public void updateReviewControllerTest() throws Exception {

        //given
        String content = objectMapper.writeValueAsString(reviewDto);

        //when
        MvcResult result = mockMvc.perform(
                        MockMvcRequestBuilders.patch(REVIEW_URL+"/999")
                                .contentType(MediaType.APPLICATION_JSON)
                                .header("memberId","12")
                                .content(content)
                                .accept(MediaType.APPLICATION_JSON)
                )
                //then
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andDo(print())
                .andReturn();
    }

}
