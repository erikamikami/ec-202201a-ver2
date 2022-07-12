package com.example.ecommerce_a.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import com.example.ecommerce_a.domain.BeverageTopping;

@Service
public class BeverageToppingRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<BeverageTopping> BEVERRAGE_TOPPING_ROW_MAPPER = new BeanPropertyRowMapper<>(BeverageTopping.class);
	
	
	/**
	 * トッピング 全件検索
	 * @return トッピング全件
	 */
	public List<BeverageTopping> findAll(){
		String sql = "SELECT id, name, price, deleted_flg FROM beverage_topping";
		List<BeverageTopping> beverageToppingList = template.query(sql, BEVERRAGE_TOPPING_ROW_MAPPER);
		return beverageToppingList;
	}
	
	/**
	 * トッピング idから1件取得
	 * @param id
	 * @return トッピング１件
	 */
	public BeverageTopping findById(int id) {
		String sql = "SELECT id, name, price, deleted_flg FROM beverage_topping WHERE id = :id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		return template.queryForObject(sql, param, BEVERRAGE_TOPPING_ROW_MAPPER);
	}
}
