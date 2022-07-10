package com.example.ecommerce_a.service;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce_a.domain.BeverrageItem;
import com.example.ecommerce_a.repository.BeverrageItemRepository;

@Service
public class BeverrageItemService {

	@Autowired
	private BeverrageItemRepository repository;

	/**
	 * 飲み物商品 全件検索する.<br>
	 * デフォでは、価格の昇順で取得
	 * 
	 * @return 飲み物商品 全件
	 */
	public List<BeverrageItem> findAll() {
		List<BeverrageItem> beverrageItemList = repository.findAll();
		int i=0;
		for(BeverrageItem beverrageItem : beverrageItemList) {
			beverrageItem.setImageStr(Base64.getEncoder().encodeToString(beverrageItem.getImage()));
			beverrageItemList.get(i).setImageStr(beverrageItem.getImageStr());
		}
		return beverrageItemList;
	}


}
