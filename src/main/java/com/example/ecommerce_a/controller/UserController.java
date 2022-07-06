package com.example.ecommerce_a.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ecommerce_a.customException.SqlConstraintViolationException;
import com.example.ecommerce_a.domain.User;
import com.example.ecommerce_a.domain.model.GroupOrder;
import com.example.ecommerce_a.form.UserForm1;
import com.example.ecommerce_a.service.UserService;

/**
 * ユーザーを操作するコントローラー
 * 
 * @author kashimamiyu
 *
 */
@Controller
@RequestMapping("/register")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private HttpSession session;
	
	/**
	 * @return UserFormをインスタンス化
	 */
	@ModelAttribute
	public UserForm1 setUpUserForm1() {
		return new UserForm1();
	}
	
	/**
	 * ユーザー登録画面を出力します
	 * 
	 * @return ユーザー登録画面
	 */
	@RequestMapping("")
	public String toRegister() {
		return "register_user";
	}
	
	/**
	 * @param form ユーザー情報用フォーム
	 * @return ログイン画面へリダイレクト
	 */
	@RequestMapping("/check")
	public String check(@Validated(GroupOrder.class) UserForm1 form, BindingResult result) {
		if (result.hasErrors()) {
			return "register_user";
		}
		User user = new User();
		BeanUtils.copyProperties(form, user);
		
		// サービスを呼ぶ
		// 既に登録されているEmailだった場合、エラー表示する
		try {
			userService.insert(user);
		} catch (SqlConstraintViolationException e) {
			result.rejectValue("email", null, "このメールアドレスは新規登録できません");
			return "register_user";
		}
		
		return "register_user_confirmation";
	}
	
}
