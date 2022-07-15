package com.ayush.testing.controller;

import com.ayush.testing.model.User;
import com.ayush.testing.service.UserService;
import com.ayush.testing.utils.CustomMessageSource;
import com.ayush.testing.utils.GlobalApiResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.validation.BindException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = UserController.class)
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @MockBean
    private CustomMessageSource customMessageSource;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    @DisplayName("Login with Not Null Credentials")
    public void loginWithValidCredentials() throws Exception {
        User user = new User("admin", "admin");
        BDDMockito.given(userService.login(any(User.class))).willReturn(user);

        String contentAsString = mockMvc.perform(
                post("/user/login")
                        .content(objectMapper.writeValueAsString(user))
                        .contentType(APPLICATION_JSON)
        ).andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        GlobalApiResponse response = objectMapper.readValue(contentAsString, GlobalApiResponse.class);
        User user1 = objectMapper.convertValue(response.getData(), User.class);
        assertEquals(user.getUsername(), user1.getUsername());
    }

    @Test
    @DisplayName("Login with Null Credentials")
    public void loginTestWithNullCredentials() throws Exception {
        User user = new User("user", null);
        BDDMockito.given(userService.login(any(User.class))).willReturn(user);

        ResultActions resultActions = mockMvc.perform(
                post("/user/login")
                        .content(objectMapper.writeValueAsString(user))
                        .contentType(APPLICATION_JSON)
        ).andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof BindException));
    }


    @Test
    @DisplayName("Login with Blank Credentials")
    public void loginTestWithBlankCredentials() throws Exception {
        User user = new User("user", "");
        BDDMockito.given(userService.login(any(User.class))).willReturn(user);

        ResultActions resultActions = mockMvc.perform(
                post("/user/login")
                        .content(objectMapper.writeValueAsString(user))
                        .contentType(APPLICATION_JSON)
        ).andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof BindException));
    }


    @Test
    public void whenExceptionThrown_thenAssertionSucceeds() {
        Exception exception = assertThrows(NumberFormatException.class, () -> {
            Integer.parseInt("1a");
        });

        String expectedMessage = "For input string";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
