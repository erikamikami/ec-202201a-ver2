package com.example.ecommerce_a.controller;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
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

import com.example.ecommerce_a.domain.BeverageTopping;
import com.example.ecommerce_a.domain.BeverrageItem;
import com.example.ecommerce_a.service.BeverageToppingService;
import com.example.ecommerce_a.service.BeverrageItemService;
import com.example.ecommerce_a.service.ItemDetailService;

@SpringBootTest
class BeverrageItemDetailControllerTest {
	
	private MockMvc mockMvc;
	
	@Mock
    private BeverrageItemService beverrageItemService;

	@Mock
    private ItemDetailService itemDetailService;
    
	@Mock
    private BeverageToppingService beverageToppingService;
	
	@InjectMocks
	private BeverrageItemDetailController beverrageItemDetailController;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(beverrageItemDetailController).build();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@DisplayName("??????????????????????????????????????????????????????")
	public void index() throws Exception {
		// Model???????????? ??????(???????????????
		BeverrageItem expectedBeverrageItem = new BeverrageItem();
		when(beverrageItemService.provideBeverrageItemDetails(1)).thenReturn(expectedBeverrageItem);
		
		// Model???????????? ??????(???????????????????????????
		List<BeverageTopping> expectedBeverrageToppingList = new ArrayList<>();
		when(beverageToppingService.provideAllBeverageTopping()).thenReturn(expectedBeverrageToppingList);
		
		// ??????????????????????????????????????????
		MvcResult result = mockMvc.perform(post("/beverrageItemDetail").param("id", "1"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(view().name("beverrage_item_detail"))
			.andReturn();
		
		// ?????????????????????????????????????????????
		BeverrageItem actualBeverrageItem = (BeverrageItem) result.getModelAndView().getModel().get("beverrageItem");
		List<BeverageTopping> actualBeverageToppingList = (List<BeverageTopping>) result.getModelAndView().getModel().get("beverageToppingList");
		
		// ??????
		assertEquals(expectedBeverrageItem, actualBeverrageItem);
		assertEquals(expectedBeverrageToppingList, actualBeverageToppingList);
	}

}
