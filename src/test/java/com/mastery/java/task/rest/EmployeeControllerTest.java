package com.mastery.java.task.rest;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EmployeeController controller;

    @Test
    public void StartPage() throws Exception{
        assertThat(controller).isNotNull();
        this.mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void StartAdd() throws Exception{
        assertThat(controller).isNotNull();
        this.mockMvc.perform(get("/add"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void StartSearch() throws Exception{
        assertThat(controller).isNotNull();
        this.mockMvc.perform(get("/search"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}