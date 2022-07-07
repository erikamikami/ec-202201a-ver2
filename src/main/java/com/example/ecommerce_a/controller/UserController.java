package com.example.ecommerce_a.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Conventions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String check(@Validated(GroupOrder.class) UserForm1 form, BindingResult result, RedirectAttributes redirectAttributes, Model model) {
		if (result.hasErrors()) {
			redirectAttributes.addFlashAttribute(form);
			redirectAttributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + Conventions.getVariableName(form), result);
			return "redirect:/register";
		}
		User user = new User();
		BeanUtils.copyProperties(form, user);
		
		// サービスを呼ぶ
		// 既に登録されているEmailだった場合、エラー表示する
		try {
			userService.emailCheck(user.getEmail());
		} catch (SqlConstraintViolationException e) {
			result.rejectValue("email", null, "このメールアドレスは新規登録できません");
			redirectAttributes.addFlashAttribute(form);
			redirectAttributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + Conventions.getVariableName(form), result);
			return "redirect:/register";
		}
		
		model.addAttribute("user", user);
		return "register_user_confirmation";
	}
	
	
	/**
	 * ユーザーを登録する
	 * @param model
	 * @return
	 */
	@RequestMapping("/insert")
	public String register(UserForm1 userForm) {
		User user = new User();
		
		user.setUserName(userForm.getUserName());
		user.setEmail(userForm.getEmail());
		user.setPassword(userForm.getPassword());
		
		user = userService.insert(user);
		session.setAttribute("user", user);
		return "redirect:/register/complete";
	}
	
	/**
	 * 登録完了画面
	 * @return
	 */
	@RequestMapping("/complete")
	public String complete() {
		return "register_user_complete";
	}
	
}
