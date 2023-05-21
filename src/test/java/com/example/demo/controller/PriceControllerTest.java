package com.example.demo.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PriceControllerTest {

    @LocalServerPort
    private int port;
    private String baseUrl = "http://localhost";

    @Autowired
    private MockMvc mockMvc; //2

    @BeforeEach
    public void setUp() {
        baseUrl = baseUrl.concat(":").concat(port + "").concat("/product");
    }

    @Test
    public void getActivePrice_testCaseOne() throws Exception {
        this.mockMvc
                .perform(get(baseUrl.concat("/35455"))
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .queryParam("brand_id", "1")
                        .queryParam("date", "2020-06-14T10:00:00")
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price_list").value(1))
                .andExpect(jsonPath("$.product_id").value(35455))
                .andExpect(jsonPath("$.brand_id").value(1))
                .andExpect(jsonPath("$.start_date").value("2020-06-14 00:00:00"))
                .andExpect(jsonPath("$.end_date").value("2020-12-31 23:59:59"))
                .andExpect(jsonPath("$.price").value(35.5))
                .andReturn();
    }

    @Test
    public void getActivePrice_testCaseTwo() throws Exception {
        this.mockMvc
                .perform(get(baseUrl.concat("/35455"))
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .queryParam("brand_id", "1")
                        .queryParam("date", "2020-06-14T16:00:00")
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price_list").value(2))
                .andExpect(jsonPath("$.product_id").value(35455))
                .andExpect(jsonPath("$.brand_id").value(1))
                .andExpect(jsonPath("$.start_date").value("2020-06-14 15:00:00"))
                .andExpect(jsonPath("$.end_date").value("2020-06-14 18:30:00"))
                .andExpect(jsonPath("$.price").value(25.45))
                .andReturn();
    }

    @Test
    public void getActivePrice_testCaseThree() throws Exception {
        this.mockMvc
                .perform(get(baseUrl.concat("/35455"))
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .queryParam("brand_id", "1")
                        .queryParam("date", "2020-06-14T21:00:00")
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price_list").value(1))
                .andExpect(jsonPath("$.product_id").value(35455))
                .andExpect(jsonPath("$.brand_id").value(1))
                .andExpect(jsonPath("$.start_date").value("2020-06-14 00:00:00"))
                .andExpect(jsonPath("$.end_date").value("2020-12-31 23:59:59"))
                .andExpect(jsonPath("$.price").value(35.5))
                .andReturn();
    }

    @Test
    public void getActivePrice_testCaseFour() throws Exception {
        this.mockMvc
                .perform(get(baseUrl.concat("/35455"))
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .queryParam("brand_id", "1")
                        .queryParam("date", "2020-06-15T10:00:00")
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price_list").value(3))
                .andExpect(jsonPath("$.product_id").value(35455))
                .andExpect(jsonPath("$.brand_id").value(1))
                .andExpect(jsonPath("$.start_date").value("2020-06-15 00:00:00"))
                .andExpect(jsonPath("$.end_date").value("2020-06-15 11:00:00"))
                .andExpect(jsonPath("$.price").value(30.5))
                .andReturn();
    }

    @Test
    public void getActivePrice_testCaseFive() throws Exception {
        this.mockMvc
                .perform(get(baseUrl.concat("/35455"))
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .queryParam("brand_id", "1")
                        .queryParam("date", "2020-06-16T21:00:00")
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price_list").value(4))
                .andExpect(jsonPath("$.product_id").value(35455))
                .andExpect(jsonPath("$.brand_id").value(1))
                .andExpect(jsonPath("$.start_date").value("2020-06-15 16:00:00"))
                .andExpect(jsonPath("$.end_date").value("2020-12-31 23:59:59"))
                .andExpect(jsonPath("$.price").value(38.95))
                .andReturn();
    }
}
