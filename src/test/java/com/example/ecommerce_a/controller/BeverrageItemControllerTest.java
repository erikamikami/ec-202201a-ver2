package com.example.ecommerce_a.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.ModelAndView;

import com.example.ecommerce_a.domain.BeverrageItem;
import com.example.ecommerce_a.service.BeverrageItemService;

@SpringBootTest
//@AutoConfigureMockMvc // これでコントローラー層のモック（MockMvc）を作成でき、コントローラーのJUnitテストが可能になる
class BeverrageItemControllerTest {

//	// MockMvcを注入する
//	@Autowired
//	private MockMvc mockMvc;
//
//	// これはMockitoではなくSpring Bootが提供するアノテーション
//	// @MockBeanを使うと、Spring Bootは通常のMockitoのモックを作成すると同時に、アプリケーションコンテキスト内に登録してくれる
//	@MockBean
//	private BeverrageItemService service;
	
	private MockMvc mockMvc;
	
	@Mock
	private BeverrageItemService service;
	
	@InjectMocks
	private BeverrageItemController beverrageItemController;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(beverrageItemController).build();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@DisplayName("飲み物メニュー一覧 全件表示できるか（正常系）")
	public void index() throws Exception {
		// サービスから実際のデータを持ってくる
		List<BeverrageItem> beverrageItemList = new ArrayList<>();
		when(service.findAll()).thenReturn(beverrageItemList);
		
		// コントローラーにリクエストを送り、戻り値（全件取得結果）を得る
		MvcResult result = mockMvc.perform(post("/beverage"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(view().name("beverage_list"))
				.andReturn();
		
		
		// 戻り値からビューとモデルを取得
		List<BeverrageItem> BeverrageItemList = (List<BeverrageItem>) result.getModelAndView().getModel().get("BeverrageItemList");
		
		assertEquals(BeverrageItemList, beverrageItemList);
	}
	
}
