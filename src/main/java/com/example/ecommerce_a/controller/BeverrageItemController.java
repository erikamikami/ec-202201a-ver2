package com.example.ecommerce_a.controller;

import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ecommerce_a.domain.BeverrageItem;
import com.example.ecommerce_a.service.BeverrageItemService;

@Controller
@RequestMapping("/beverage")
public class BeverrageItemController {

	@Autowired
	private BeverrageItemService service;
	
	/**
	 * 飲み物メニュー 全件表示させる<br>
	 * スタート地点
	 * 
	 * @return
	 */
	@RequestMapping("")
	public String index(Model model) {
		List<BeverrageItem> beverrageItemList = service.findAll();
		model.addAttribute("beverrageItemList", beverrageItemList);
		
		return "beverage_list";
	}

}
