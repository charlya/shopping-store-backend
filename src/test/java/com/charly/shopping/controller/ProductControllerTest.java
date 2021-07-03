package com.charly.shopping.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getProducts() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/product").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$[0].name").value("TAMA drum"));

        // https://howtodoinjava.com/spring-boot2/testing/spring-boot-mockmvc-example/
        // https://start.spring.io/
        // https://spring.io/guides/gs/spring-boot/
        // https://spring.io/guides/tutorials/rest/
        // https://spring.io/guides/gs/consuming-rest-angularjs/
    }

}
