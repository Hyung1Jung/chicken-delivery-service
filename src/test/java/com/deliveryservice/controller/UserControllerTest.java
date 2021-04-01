package com.deliveryservice.controller;

import com.deliveryservice.controller.dto.UserDto;

import com.deliveryservice.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(UserController.class)
@MockBean(JpaMetamodelMappingContext.class)
class UserControllerTest {

    private final ObjectMapper objectMapper;
    private final WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;


    @Autowired
    public UserControllerTest(ObjectMapper objectMapper, WebApplicationContext webApplicationContext, MockMvc mockMvc) {
        this.objectMapper = objectMapper;
        this.webApplicationContext = webApplicationContext;
        this.mockMvc = mockMvc;
    }


    @MockBean
    private UserService userService;

    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .addFilters(new CharacterEncodingFilter("UTF-8", true))
                .alwaysDo(print())
                .build();
    }

    @Test
    @DisplayName("회원가입 성공")
    void createUser() throws Exception {
        UserDto userDto = UserDto.builder()
                .email("guddlf13@naver.com")
                .password("a123123123a")
                .name("형일")
                .phone("010-8865-8860")
                .address("서울")
                .build();

        doNothing().when(userService).saveUser(userDto);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/user/sign-up")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toJsonString(userDto)))
                .andExpect(status().isCreated());
    }

    private String toJsonString(UserDto userDto) throws JsonProcessingException {
        return objectMapper.writeValueAsString(userDto);
    }
}