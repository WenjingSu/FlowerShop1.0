package com.shop.beans;

public class Cart {
	private Integer c_id;// 1.唯一标识
	private Integer u_id;// 2.用户id
	private Integer g_id;// 3.购物车中的商品id
	private Integer goods_amount;// 4.数量

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(Integer c_id, Integer u_id, Integer g_id, Integer goods_amount) {
		super();
		this.c_id = c_id;
		this.u_id = u_id;
		this.g_id = g_id;
		this.goods_amount = goods_amount;
	}

	public Integer getC_id() {
		return c_id;
	}

	public void setC_id(Integer c_id) {
		this.c_id = c_id;
	}

	public Integer getU_id() {
		return u_id;
	}

	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}

	public Integer getG_id() {
		return g_id;
	}

	public void setG_id(Integer g_id) {
		this.g_id = g_id;
	}

	public Integer getGoods_amount() {
		return goods_amount;
	}

	public void setGoods_amount(Integer goods_amount) {
		this.goods_amount = goods_amount;
	}

	@Override
	public String toString() {
		return "Cart [c_id=" + c_id + ", u_id=" + u_id + ", g_id=" + g_id
				+ ", goods_amount=" + goods_amount + "]";
	}

}
