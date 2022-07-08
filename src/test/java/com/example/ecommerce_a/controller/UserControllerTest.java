package com.example.ecommerce_a.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.ecommerce_a.domain.User;
import com.example.ecommerce_a.form.UserForm1;
import com.example.ecommerce_a.service.UserService;

@SpringBootTest
//@AutoConfigureMockMvc
class UserControllerTest {

	private MockMvc mockMvc;
	
//	@Autowired
//	private UserController userController;

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
    	mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

   
    @Test
    @DisplayName("ユーザー登録画面 出力（正常系）")
    public void toRegister() throws Exception {
		mockMvc.perform(post("/register"))
				.andExpect(status().isOk())
				.andExpect(view().name("register_user"));
	}

	@Test
	@DisplayName("ユーザー登録 入力値チェック (正常系)")
	public void check2() throws Exception {
		String userName = "ヤマダタロウ";
		String email = "exmam@email.com";
		String password = "TestPassword1";
		
		UserForm1 userForm = new UserForm1();
		userForm.setUserName(userName);
		userForm.setEmail(email);
		userForm.setPassword(password);

		User user = new User();
		user.setUserName(userName);
		user.setEmail(email);
		user.setPassword(password);

		mockMvc.perform(post("/register/check").flashAttr("form", userForm))
				.andExpect(view().name("register_user_confirmation"));
	}

	@Test
	@DisplayName("ユーザー登録 入力値チェック 必須チェック（異常系）")
	public void check1() throws Exception {
		UserForm1 userForm = new UserForm1();
		userForm.setUserName("");
		userForm.setEmail("");
		userForm.setPassword("");
		mockMvc.perform(post("/register/check").flashAttr("form", userForm))
				.andExpect(view().name("redirect:/register"));
	}

	@Test
	@DisplayName("ユーザー登録(正常系)")
	public void register() throws Exception {
		UserForm1 userForm1 = new UserForm1();
		userForm1.setUserName("ヤマダタロウ");
		userForm1.setEmail("exmam@email.com");
		userForm1.setPassword("TestPassword1");
		
		User user = new User();
		user.setUserName(userForm1.getUserName());
		user.setEmail(userForm1.getEmail());
		user.setPassword(userForm1.getPassword());
		
		mockMvc.perform(post("/register/insert").flashAttr("UserForm1", userForm1))
		.andExpect(model().attribute("user", user))
		.andExpect(view().name("register_user_confirmation"));
	}
	
	@Test
	@DisplayName("登録完了画面（正常系）")
	public void complete() throws Exception {
		mockMvc.perform(post("/register/complete"))
		.andExpect(view().name("register_user_complete"));
	}

}