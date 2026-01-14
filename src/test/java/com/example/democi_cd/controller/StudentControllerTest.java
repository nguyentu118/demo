package com.example.democi_cd.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnListOfStudents() throws Exception {
        mockMvc.perform(get("/students"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(3)) // Kiểm tra có đúng 3 student không
                .andExpect(jsonPath("$[0].name").value("Alice"));
    }

    @Test
    void testAddStudentSuccess() throws Exception {
        String studentJson = "{\"name\": \"David\", \"email\": \"david@gmail.com\", \"age\": 25, \"address\": \"Hanoi\"}";

        mockMvc.perform(post("/students")
                        .contentType(MediaType.APPLICATION_JSON) // Cần import MediaType
                        .content(studentJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("David"));
    }

    @Test
    void testAddStudentFail_InvalidEmail() throws Exception {
        String invalidJson = "{\"name\": \"Error\", \"email\": \"sai-email\", \"age\": 25}";

        mockMvc.perform(post("/students")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidJson))
                .andExpect(status().isBadRequest()); // CI sẽ kiểm tra xem có đúng là trả về lỗi 400 không
    }
}