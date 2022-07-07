package com.example.ecommerce_a.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ecommerce_a.customException.SqlConstraintViolationException;
import com.example.ecommerce_a.domain.User;
import com.example.ecommerce_a.repository.UserRepository;

/**
 * ユーザー情報を操作するサービス
 * 
 * @author kashimamiyu
 *
 */
@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	/**
	 * ユーザー情報登録前のEmail重複制約チェック
	 * 
	 * @param user
	 * @throws SqlConstraintViolationException
	 */
	public void emailCheck(String email) throws SqlConstraintViolationException {
		// Emailの重複がないかチェックする
		// 重複があった場合、カスタム例外を投げる
		User checkEmailResult = userRepository.findByEmail(email);
		if (checkEmailResult != null) {
			throw new SqlConstraintViolationException();
		}
	}
	
	
	/**
	 * ユーザー情報を登録します
	 * 
	 * @param user
	 * @throws SqlConstraintViolationException
	 */
	public User insert(User insertUser)  {
		// ユーザーを登録し、idを含め登録したUser情報を返す
		User user = userRepository.insert(insertUser);
		return user;
	}
	
	/**
	 * メールアドレスからユーザー情報を取得します。
	 * 
	 * @param email メールアドレス
	 * @return ユーザー情報
	 */
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	/**
	 * @param email　メールアドレス
	 * @param password パスワード
	 * @return　ユーザー情報
	 */
	public User login(String email, String password) {
		User user = userRepository.findByEmailAndPassword(email, password);
		return user;
	}
	
	public void updatePassword(String email, String password) {
//		userRepository.updatePassword(email, password);
	}
}