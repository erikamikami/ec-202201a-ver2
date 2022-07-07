package com.example.ecommerce_a.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.ecommerce_a.service.UserService;

@SpringBootTest
class UserControllerTest {

	private MockMvc mockMvc;
	
	@Mock
    private UserService userService;
	
	@InjectMocks
    private UserController userController;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
    }

    @BeforeEach
    void setUp() throws Exception {
    	MockitoAnnotations.initMocks(this);
    	mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

   
    @Test
    @DisplayName("ユーザー登録画面 出力（正常系）")
    public void toRegister() throws Exception {
    	mockMvc.perform(MockMvcRequestBuilders.post("/coffeeShop/register"))
    			.andExpect(status().isOk());
	}

}