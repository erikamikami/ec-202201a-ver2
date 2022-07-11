package com.example.ecommerce_a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce_a.domain.BeverageTopping;
import com.example.ecommerce_a.repository.BeverageToppingRepository;

@Service
public class BeverageToppingService {
	
	@Autowired
	private BeverageToppingRepository beverageToppingRepository;
	
	/**飲み物トッピングすべて提供
	 * @return
	 */
	public List<BeverageTopping> provideAllBeverageTopping(){
		List<BeverageTopping> beverageToppingList = beverageToppingRepository.findAll();
		return beverageToppingList;
	}

}
