package com.shop.beans;

//订单商品表
public class Order_goods_info {
	private Integer ord_g_info_id;// 1.唯一标识
	private Integer order_id;// 2.订单id
	private Integer goods_num;// 3.商品数量
	private Integer g_id;// 4.商品id
	private String g_name;// 5.商品名称
	private double g_price;// 6.购买时商品单价
	private Integer ord_g_info_del;// 7.逻辑删除标识

	public Order_goods_info() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Order_goods_info(Integer ord_g_info_id, Integer order_id,
			Integer goods_num, Integer g_id, String g_name, double g_price,
			Integer ord_g_info_del) {
		super();
		this.ord_g_info_id = ord_g_info_id;
		this.order_id = order_id;
		this.goods_num = goods_num;
		this.g_id = g_id;
		this.g_name = g_name;
		this.g_price = g_price;
		this.ord_g_info_del = ord_g_info_del;
	}



	public Integer getOrd_g_info_id() {
		return ord_g_info_id;
	}

	public void setOrd_g_info_id(Integer ord_g_info_id) {
		this.ord_g_info_id = ord_g_info_id;
	}

	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

	

	public Integer getGoods_num() {
		return goods_num;
	}



	public void setGoods_num(Integer goods_num) {
		this.goods_num = goods_num;
	}



	public Integer getG_id() {
		return g_id;
	}

	public void setG_id(Integer g_id) {
		this.g_id = g_id;
	}

	public String getG_name() {
		return g_name;
	}

	public void setG_name(String g_name) {
		this.g_name = g_name;
	}

	public double getG_price() {
		return g_price;
	}

	public void setG_price(double g_price) {
		this.g_price = g_price;
	}

	public Integer getOrd_g_info_del() {
		return ord_g_info_del;
	}

	public void setOrd_g_info_del(Integer ord_g_info_del) {
		this.ord_g_info_del = ord_g_info_del;
	}



	@Override
	public String toString() {
		return "Order_goods_info [ord_g_info_id=" + ord_g_info_id
				+ ", order_id=" + order_id + ", goods_num=" + goods_num
				+ ", g_id=" + g_id + ", g_name=" + g_name + ", g_price="
				+ g_price + ", ord_g_info_del=" + ord_g_info_del + "]";
	}

	

}
