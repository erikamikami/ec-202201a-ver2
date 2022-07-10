package com.example.ecommerce_a.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.ecommerce_a.domain.User;

/**
 * usersテーブルを操作するリポジトリです。
 * 
 * @author mikami
 */
@Repository
public class UserRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<User> USER_ROW_MAPPER  = (rs, i) -> {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setUserName(rs.getString("user_name"));
		user.setEmail(rs.getString("email"));
		user.setPassword(rs.getString("password"));
		return user;
	};
	
	/**
	 * ユーザー情報を挿入します。
	 * @param user ユーザー情報
	 */
	public User insert(User user) {
		User returnUser = new User();

		String sql = "INSERT INTO users(user_name, email, password) VALUES(:userName, :email, :password);";
		SqlParameterSource param = new BeanPropertySqlParameterSource(user);

		KeyHolder keyHolder = new GeneratedKeyHolder();
		String[] keyColumnNames = { "id" };
		template.update(sql, param, keyHolder, keyColumnNames);
		returnUser.setId(keyHolder.getKey().intValue());
		return returnUser;
	}
	
	/**
	 * @param email メールアドレス
	 * @return ユーザー情報 存在しない場合はnullを返します。
	 */
	public User findByEmail(String email) {
		String sql = "SELECT id, user_name, email, password FROM users WHERE email=:email;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("email", email);
		List<User> userList = template.query(sql, param, USER_ROW_MAPPER);
		
		if(userList.size() == 0) {
			return null;
		}
		return userList.get(0);
	}
	
	
	/**
	 * @param email メールアドレス
	 * @param password パスワード
	 * @return ユーザー情報 存在しない場合はnullを返します。
	 */
	public User findByEmailAndPassword(String email, String password) {
		String sql = "SELECT id, user_name, email, password FROM users WHERE email=:email AND password = :password";
		SqlParameterSource param = new MapSqlParameterSource().addValue("email", email).addValue("password", password);
		List<User> userList = template.query(sql, param, USER_ROW_MAPPER);
		
		if(userList.size() == 0) {
			return null;
		}
		User user = userList.get(0);
//		if(!passwordEncoder.matches(password,user.getPassword())) {
//			return null;
//		}
		return userList.get(0);
	}
	
//	public void updatePassword(String email, String password) {
//		String newPassword = passwordEncoder.encode(password);
//		String updateSql="UPDATE users SET password=:password WHERE email=:email";
//		SqlParameterSource param = new MapSqlParameterSource().addValue("email", email).addValue("password", newPassword);
//		template.update(updateSql, param);
//		System.out.println(newPassword);
//	}

}
