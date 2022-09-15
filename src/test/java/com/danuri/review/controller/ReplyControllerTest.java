package com.danuri.review.controller;

import com.danuri.review.dto.ReplyDto;
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
public class ReplyControllerTest {
    private final String REPLY_URL = "/reply";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private static ReplyDto replyDto;

    @BeforeAll
    private static void initReply() {
        replyDto = ReplyDto.builder()
                .reviewId(3)
                .contents("asdf")
                .storeId(3)
                .build();
    }

    @Test
    void save() throws Exception {
        //given
        String content = objectMapper.writeValueAsString(replyDto);

        //when
        MvcResult result = mockMvc.perform(
                        MockMvcRequestBuilders.post(REPLY_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .header("memberId", "5")
                                .content(content)
                                .accept(MediaType.APPLICATION_JSON)
                )
                //then
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(print())
                .andReturn();
    }

    @Test
    void getReplyControllerTest() throws Exception{

        //given
        String replyId = "1";

        //when
        MvcResult result = mockMvc.perform(
                        MockMvcRequestBuilders.get(REPLY_URL+"/"+replyId)
                                .contentType(MediaType.APPLICATION_JSON)
                                .header("memberId", "5")
                                .accept(MediaType.APPLICATION_JSON)
                )
                //then
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print())
                .andReturn();
    }
}
