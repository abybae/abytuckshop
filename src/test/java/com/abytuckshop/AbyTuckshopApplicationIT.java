package com.abytuckshop;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ExtendWith( SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AbyTuckshopApplicationIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getsAllProducts() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/product")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void getsSingleProduct() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/product/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void returnsNotFoundForInvalidSingleProduct() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/product/4")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andReturn();
    }

    @Test
    public void addsNewProduct() throws Exception {
        String newRide = "{\"name\":\"Bread\",\"description\":\"Wholewheat Bread.\",\"thrillFactor\":2,\"vomitFactor\":1}";
        mockMvc.perform(MockMvcRequestBuilders.post("/product")
                .contentType(MediaType.APPLICATION_JSON)
                .content(newRide)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }
}
