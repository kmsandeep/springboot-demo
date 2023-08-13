package com.sandeep.springbootdemo.controller;

import com.sandeep.springbootdemo.dao.UserRepository;
import com.sandeep.springbootdemo.dto.User;
import com.sandeep.springbootdemo.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalManagementPort;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class UserControllerTest {
    @LocalManagementPort
    private int port;
    @Mock
    public UserRepository userRepository;

    @Mock
    public UserService userService;

    @InjectMocks
    public UserController userController;

    @Autowired
    public MockMvc mockMvc;
    @Autowired
    TestRestTemplate testRestTemplate;

    @BeforeEach
    public void setUp() {
//        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "sandeep", 45, "ADMIN"));
//        Mockito.when(userRepository.findByRole("USER")).thenReturn(users);
        Mockito.when(userService.getUsers()).thenReturn(users);
    }

    @Test
    @WithMockUser(username = "sandeep", password = "pass", roles = "ADMIN")
    public void getUserTest() throws Exception {
        mockMvc.perform(get("/api/user"))
                .andExpect(status().isFound())
                .andExpect(content().string(containsString("sandeep")));
    }

    @Test
    @WithMockUser(username = "sandeep", password = "pass", roles = "ADMIN")
    public void getAdminTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/admin")
                        .accept(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(content().string(containsString("rajan")));
    }

//    @Test
//    @WithMockUser(username = "sandeep", password = "pass", roles = "ADMIN")
//    public void testAddUser(){
//        User user = new User(9L, "mukesh", 47, "ADMIN");
//        HttpEntity<User> request = new HttpEntity<>(user);
//        ResponseEntity<User> responseEntity = testRestTemplate.exchange("/api/admin/addUser", HttpMethod.POST, request, User.class);
//        User userResponse = responseEntity.getBody();
//        Assertions.assertEquals("mukesh",userResponse.getUsername());
//        Assertions.assertEquals(47,userResponse.getAge());
//    }
}
