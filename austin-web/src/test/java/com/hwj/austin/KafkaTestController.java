package com.hwj.austin;

import cn.hutool.http.ContentType;
import cn.hutool.http.Header;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.annotation.GetMapping;

import java.nio.charset.StandardCharsets;

/**
 * @Author: hwj
 * @CreateTime: 2023-04-11  14:48
 * @Version: 1.0
 * @Description: TODO
 */
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class KafkaTestController {

    @Autowired
    protected MockMvc mvc;

    protected HttpHeaders headers;
    protected ResultActions resultActions;

    @BeforeEach
    public void beforeEach() {
        headers = new HttpHeaders();
        headers.add(Header.CONTENT_TYPE.getValue(), ContentType.JSON.getValue());
    }

    @AfterEach
    public void afterEach() {
        try {
            MvcResult mvcResult = resultActions
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andReturn();

            String content = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);
            log.info("response content: \n {}", content);
        } catch (Exception e) {
            log.error("error message: \n {}", e.getMessage());
        }
    }

    @Test
    public void test()  throws Exception{

        resultActions = mvc.perform(MockMvcRequestBuilders
                .get("/kafka/insert")
                .headers(headers)
                .param("userId", "1"));
    }
}
