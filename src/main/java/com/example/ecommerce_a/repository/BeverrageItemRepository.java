package com.example.ecommerce_a.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.ecommerce_a.domain.BeverrageItem;
import com.example.ecommerce_a.domain.Item;

@Repository
public class BeverrageItemRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	// RowMapper
	private static final RowMapper<BeverrageItem> BEVERRAGE_ITEM_ROW_MAPPER = new BeanPropertyRowMapper<>(
			BeverrageItem.class);

	/**
	 * 全件検索を行う（価格昇順）
	 * 
	 * @return 商品一覧
	 */
	public List<BeverrageItem> findAll() {
		String sql = "SELECT id,name,description,price_s,price_m,price_l,image,deleted_flg,recommend_flg,season_flg,beverrage_items_category_id"
				+ " FROM BeverrageItem ORDER BY price_s  ASC";
		List<BeverrageItem> beverrageItemList = template.query(sql, BEVERRAGE_ITEM_ROW_MAPPER);

		return beverrageItemList;
	}


}