package com.onehub.api.v1.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class EmployeesRestControllerTest {

  @Autowired private MockMvc mockMvc;

  @Test
  void whenEmployeeDtoIsValidThenReturnStatusOk() throws Exception {
    // given
    final String employeeDto =
        "{\n"
            + "  \"title\": \"Mrs.\",\n"
            + "  \"firstName\": \"Jane\",\n"
            + "  \"surName\": \"Doe\",\n"
            + "  \"dateOfBirth\": \"1990-01-01\",\n"
            + "  \"address\": \"1234 Main St, Springfield, IL 62701\",\n"
            + "  \"gender\": \"F\",\n"
            + "  \"email\": \"Jane.Doe@gmail.com\"\n"
            + "}";

    // when
    mockMvc
        .perform(
            post("/api/v1/Employees", employeeDto)
                .content(employeeDto)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andExpect(status().isOk());
  }

  //TODO: Add more tests
}
