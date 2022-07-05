package com.example.ecommerce_a.controller;

import com.example.ecommerce_a.domain.User;
import com.example.ecommerce_a.util.XlsDataSetLoader;
import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@DbUnitConfiguration(dataSetLoader = XlsDataSetLoader.class)
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class, // このテストクラスでDIを使えるように指定
        TransactionDbUnitTestExecutionListener.class // @DatabaseSetupや@ExpectedDatabaseなどを使えるように指定
})
class UserControllerTest {
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
    }

    @BeforeEach
    void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    /**
     * 登録系サンプル
     *
     * 実行後のテーブルの状態（期待値）をExcelで作成しておき、DBUnitの機能でチェックをおこなう（@ExpectedDatabaseの所）　
     * ※テーブル名はExcelのシート名で合わせる
     */
    @Test
    @DisplayName("ユーザー登録（正常系）")
    @ExpectedDatabase(value = "classpath:user_insert_01.xlsx", assertionMode = DatabaseAssertionMode.NON_STRICT)
    void insert_01() throws Exception {

        MvcResult mvcResult = mockMvc.perform(post("/register/insert")
                        .param("name", "山田太郎")
                        .param("email", "yamada@example.com")
                        .param("password", "Abcd1234")
                        .param("confirmpassword", "Abcd1234")
                        .param("zipcode", "111-1111")
                        .param("address", "東京都新宿区")
                        .param("telephone", "080-0000-0000")
                ).andExpect(view().name("redirect:/login"))
                .andReturn();

    }

}