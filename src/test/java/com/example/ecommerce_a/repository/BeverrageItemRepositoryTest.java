package com.example.ecommerce_a.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.example.ecommerce_a.domain.BeverrageItem;
import com.example.ecommerce_a.service.BeverrageItemService;

@SpringBootTest
class BeverrageItemRepositoryTest {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	@Autowired
	private BeverrageItemService beverrageItemService;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@DisplayName("飲み物アイテムテーブルから全件(15件)取得できるか(正常系)")
	public void findAll() {
		List<BeverrageItem> actual = beverrageItemService.findAll();
		assertEquals(15, actual.size());
	}

}
