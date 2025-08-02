package br.com.vinibelo.marketplace.api.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(PingController.class)
@WithMockUser
public class PingControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnPongInBody() throws Exception {
        this.mockMvc.perform(get("/ping"))
                .andExpect(content().string("pong"));
    }

    @Test
    public void shouldReturnStatusOk() throws Exception {
        this.mockMvc.perform(get("/ping"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
