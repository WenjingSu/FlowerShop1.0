package com.shop.beans.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.shop.beans.Goods;

public class ShopCart implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<Goods, Integer> shops;
	private double totalprice;


	public ShopCart() {
		this.shops = new HashMap<Goods, Integer>();
		totalprice = 0;
	}

	public Map<Goods, Integer> getShops() {
		return shops;
	}

	public void setShops(Map<Goods, Integer> shops) {
		this.shops = shops;
	}

	public double getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}
	public ShopCart(Map<Goods, Integer> shops, double totalprice) {
		super();
		this.shops = shops;
		this.totalprice = totalprice;
	}
	

	@Override
	public String toString() {
		return "ShopCart [shops=" + shops + ", totalprice=" + totalprice + "]";
	}

	/**
	 * 向购物车添加商品
	 * 
	 * @param cartdetail
	 * @param num
	 */
	public void addShopIntoCart(Goods Goods, Integer num) {
		if (this.shops.containsKey(Goods)) {
			this.shops.put(Goods, this.shops.get(shops) + num);
		} else {
			this.shops.put(Goods, num);
		}
		CaltotalPrice();
	}

	/**
	 * 删除购物车商品
	 * 
	 * @param cartdetail
	 */
	public void delshopIntoCart(Goods goods) {
		this.shops.remove(goods);
		CaltotalPrice();
	}

	public double CaltotalPrice() {
		this.totalprice = 0.0d;
		Set<Goods> set = this.shops.keySet();
		for (Goods Goods : set) {
			this.totalprice += this.shops.get(Goods) * Goods.getGoods_price();

		}
		return this.totalprice;
	}

}
