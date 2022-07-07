//package com.example.ecommerce_a.controller;
//
//import com.example.ecommerce_a.util.SessionUtil;
//import com.example.ecommerce_a.util.XlsDataSetLoader;
//import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener;
//import com.github.springtestdbunit.annotation.DbUnitConfiguration;
//import org.junit.jupiter.api.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.mock.web.MockHttpSession;
//import org.springframework.test.context.TestExecutionListeners;
//import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
//
//@SpringBootTest
//@DbUnitConfiguration(dataSetLoader = XlsDataSetLoader.class)
//@TestExecutionListeners({
//        DependencyInjectionTestExecutionListener.class, // このテストクラスでDIを使えるように指定
//        TransactionDbUnitTestExecutionListener.class // @DatabaseSetupや@ExpectedDatabaseなどを使えるように指定
//})
//class UserPageControllerTest {
//    @Autowired
//    private WebApplicationContext wac;
//
//    private MockMvc mockMvc;
//
//    @BeforeAll
//    static void setUpBeforeClass() throws Exception {
//    }
//
//    @AfterAll
//    static void tearDownAfterClass() throws Exception {
//    }
//
//    @BeforeEach
//    void setUp() throws Exception {
//        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
//    }
//
//    /**
//     * 事前にセッション登録が必要なサンプル
//     */
//    @Test
//    @DisplayName("マイページへの遷移")
//    void userPage_01() throws Exception {
//        MockHttpSession userIdSession = SessionUtil.createUserIdAndUserSession();
//        MvcResult mvcResult = mockMvc.perform(get("/userPage")
//                        .session(userIdSession))
//                .andExpect(view().name("user_page"))
//                .andReturn();
//    }
//
//}