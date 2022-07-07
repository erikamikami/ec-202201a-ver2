package com.example.ecommerce_a.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ecommerce_a.form.UserForm1;

@Controller
@RequestMapping("/userPage")
public class UserPageController {
	
	@Autowired
	private HttpSession session;
	
	@ModelAttribute
	public UserForm1 setUpUserForm() {
		return new UserForm1();
	}
	
	@RequestMapping("")
	public String userPage(UserForm1 form,Model model) {
		Integer userId = (Integer) session.getAttribute("userId");
		if (userId == null) {
			return "forward:/login";
		}
		return "user_page";
		
	}
}
