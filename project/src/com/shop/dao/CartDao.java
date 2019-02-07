package com.shop.dao;

import java.util.List;

import com.shop.beans.dto.CartDetail;

public interface CartDao {
	public boolean addshopIntoCart(Integer u_id,Integer g_id,Integer goods_amount);
	public boolean UpdateGoodIntoCart(Integer u_id, Integer g_id, Integer amount);
	public boolean cartHasCont(Integer u_id, Integer g_id);
	public CartDetail cartFindByCid(Integer c_id);
	public List<CartDetail> CartInfoByUid(int u_id);
	boolean UpdateAmountByCid(int c_id, int amount);
	public boolean deleteCartByCid(int c_id);
}
