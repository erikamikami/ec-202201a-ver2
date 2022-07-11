package com.example.ecommerce_a.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.commons.codec.net.PercentCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ecommerce_a.domain.BeverageTopping;
import com.example.ecommerce_a.domain.BeverrageItem;
import com.example.ecommerce_a.domain.OrderItem;
import com.example.ecommerce_a.domain.OrderTopping;
import com.example.ecommerce_a.form.OrderItemForm;
import com.example.ecommerce_a.service.BeverageToppingService;
import com.example.ecommerce_a.service.BeverrageItemService;
import com.example.ecommerce_a.service.ItemDetailService;

@Controller
@RequestMapping("/beverrageItemDetail")
public class BeverrageItemDetailController {
	@Autowired
    private BeverrageItemService beverrageItemService;

    @Autowired
    private ItemDetailService itemDetailService;
    
    @Autowired
    private BeverageToppingService beverageToppingService;
    
    @ModelAttribute
	public OrderItemForm setUpUserForm() {
		return new OrderItemForm();
	}
    
    @Autowired
    private HttpSession session;
    
    /**商品詳細画面に遷移
     * @return
     */
    @RequestMapping("")
    public String index(String id, Model model) {
    	// 飲み物詳細情報 取得
    	BeverrageItem beverrageItem = new BeverrageItem();
    	Integer intId = Integer.parseInt(id);
    	try {
    		beverrageItem = beverrageItemService.provideBeverrageItemDetails(intId); // 1件も見つからなかった場合、エラー画面に遷移
		} catch (Exception e) {
			return "errors/beverrage_item_not_found";
		}
    	
    	// すべてのトッピング 取得
    	List<BeverageTopping> beverageToppingList = beverageToppingService.provideAllBeverageTopping();
    	
    	
    	// 商品詳細とトッピングをモデルに格納
    	model.addAttribute("beverrageItem", beverrageItem);
    	model.addAttribute("beverageToppingList", beverageToppingList);
    	
    	return "beverrage_item_detail";
    }

    
    // ＝＝＝＝＝＝＝改修前＝＝＝＝＝＝＝＝＝＝
    
    /**
     * 商品詳細画面 遷移<br>
     * 商品IDから特定<br>
     * トッピングをすべて表示
     * 
     * @param id
     * @param model
     * @return
     */
//    @RequestMapping("")
//    public  String index(String id,Model model){
//        Item item=itemService.load(Integer.parseInt(id));
//        if(item.getName()==null){
//            return "redirect:/shoppingList";
//
//        }
//        List<Topping> toppingList=itemDetailService.findAll();
//        model.addAttribute("item",item);
//        model.addAttribute("toppingList",toppingList);
//        return "item_detail";
//    }

    @RequestMapping("/insert")
    public String insert(OrderItemForm form){
    	Integer userId = (Integer) session.getAttribute("userId");
    	Integer preId =  (Integer) session.getAttribute("preId");
    	int orderId = 0;
    	int orderItemId = 0;
    	
    	if(userId!=null) { // ログインしている状態
    		OrderItem orderItem = itemDetailService.load(userId); // ユーザーIDをショッピングカートに詰める
    		if(orderItem!=null) { // ショッピングカートに商品があった場合
    			orderItem.setItemId(form.getItemId()); // ショッピングカートに追加
    	        orderItem.setQuantity(form.getQuantity());
    	        char[] c = form.getSize().toCharArray();
    	        orderItem.setSize(c[0]);
    	        orderItemId = itemDetailService.insertOrderItem(orderItem);
    		}else{
    			orderId = itemDetailService.insertOrder(userId); // ショッピングカートにユーザーIDをインサートし、ショッピングカートに追加
    			OrderItem orderItem2 = new OrderItem();
    			orderItem2.setOrderId(orderId);
    			orderItem2.setItemId(form.getItemId());
    	        orderItem2.setQuantity(form.getQuantity());
    	        char[] c = form.getSize().toCharArray();
    	        orderItem2.setSize(c[0]);
    	        orderItemId = itemDetailService.insertOrderItem(orderItem2);
    		}
    	}else if(userId==null) { // ログイン状態ではなかった場合
    		if(preId!=null) { // プレIDがあった場合、プレIDでカートに商品を詰めていく
    			System.out.println(preId);
    			OrderItem orderItem = itemDetailService.load(preId); 
    			orderItem.setItemId(form.getItemId());
    	        orderItem.setQuantity(form.getQuantity());
    	        char[] c = form.getSize().toCharArray();
    	        orderItem.setSize(c[0]);
    	        orderItemId = itemDetailService.insertOrderItem(orderItem);
    		}else if(preId==null) { // プレIDがなかった場合、プレIDを作成後、カートに商品を詰めていく
    			int uuid = Math.abs(UUID.randomUUID().hashCode());
    			System.out.println(uuid);
    			session.setAttribute("preId", uuid);
    			orderId = itemDetailService.insertOrder(uuid);
    			OrderItem orderItem = new OrderItem();
    			orderItem.setOrderId(orderId);
    			orderItem.setItemId(form.getItemId());
    	        orderItem.setQuantity(form.getQuantity());
    	        char[] c = form.getSize().toCharArray();
    	        orderItem.setSize(c[0]);
    	        orderItemId = itemDetailService.insertOrderItem(orderItem);
    			}
    	}
    	
    	if(form.getOrderToppings()==null) { // トッピングの選択がなかったら、カートに遷移
    		return "redirect:/shoppingCart";
    	}
        for(String topping : form.getOrderToppings()) { // トッピングの選択があったら、トッピングと一緒にカートに追加
        	Integer toppingId = Integer.parseInt(topping);
        	OrderTopping orderTopping = new OrderTopping();
        	orderTopping.setOrderItemId(orderItemId);
        	orderTopping.setToppingId(toppingId);
        	itemDetailService.insertTopping(orderTopping);
        	}
        return "redirect:/shoppingCart";
    }
}
