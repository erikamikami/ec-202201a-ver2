//package com.example.ecommerce_a.controller;
//
//import com.example.ecommerce_a.util.XlsDataSetLoader;
//import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener;
//import com.github.springtestdbunit.annotation.DatabaseSetup;
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
//import org.springframework.web.servlet.ModelAndView;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
//
//@SpringBootTest
//@DbUnitConfiguration(dataSetLoader = XlsDataSetLoader.class)
//@TestExecutionListeners({
//        DependencyInjectionTestExecutionListener.class, // このテストクラスでDIを使えるように指定
//        TransactionDbUnitTestExecutionListener.class // @DatabaseSetupや@ExpectedDatabaseなどを使えるように指定
//})
//class PasswordResetControllerTest {
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
//    @AfterEach
//    void tearDown() throws Exception {
//    }
//
//    /**
//     * 表示系サンプルその２
//     *
//     * テスト実行前にテストデータの投入がある例（data.sqlとは別に、本テストで個別に必要なテストデータ）
//     * @throws Exception
//     */
//    @Test
//    @DisplayName("パスワードリセット（メアド存在確認）")
//    @DatabaseSetup("classpath:password_rest_01.xlsx") // テスト実行前に初期データを投入
//    void confirmPasswordReset_01() throws Exception {
//        MvcResult mvcResult = mockMvc.perform(post("/reset/resetConfirm")
//                        .param("userEmail", "nobuhiko.tobita@gmail.com"))
//                .andExpect(view().name("email_submit"))
//                .andReturn();
//
//        // セッションに値がセットされていることを確認
//        MockHttpSession session = (MockHttpSession) mvcResult.getRequest().getSession();
//        String email = (String) session.getAttribute("userEmailPass");
//        assertEquals("nobuhiko.tobita@gmail.com", email);
//    }
//}