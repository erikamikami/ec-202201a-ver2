package com.example.ecommerce_a.controller;

import com.example.ecommerce_a.domain.Item;
import com.example.ecommerce_a.util.XlsDataSetLoader;
import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@DbUnitConfiguration(dataSetLoader = XlsDataSetLoader.class)
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class, // このテストクラスでDIを使えるように指定
        TransactionDbUnitTestExecutionListener.class // @DatabaseSetupや@ExpectedDatabaseなどを使えるように指定
})
class ItemControllerTest {
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

    @AfterEach
    void tearDown() throws Exception {
    }

    /**
     * 表示系サンプルその１（アサーションの部分は未完成）
     *
     * ①コントローラー呼出し
     * ②スコープのデータを取り出し
     * ③取り出したデータ（itemList）をassertEqualsでチェック
     */
    @Test
    @DisplayName("商品一覧画面表示（絞り込みなし、並び順もデフォルト）")
    void showList_01() throws Exception {
        // ①コントローラー呼出し
        MvcResult mvcResult = mockMvc.perform(get("/shoppingList"))
                .andExpect(view().name("item_list_coffee"))
                .andReturn();

        // ②スコープのデータを取り出し
        ModelAndView mav = mvcResult.getModelAndView();
        @SuppressWarnings(value = "unchecked")// 下のキャストのワーニングを出さないようにする
        List<Item> itemList = (List<Item>) mav.getModel().get("itemList");
//        System.out.println(itemList);

        // TODO: ③取り出したデータ（itemList）をassertEqualsでチェック
    }
}