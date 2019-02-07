package com.shop.beans.dto;

public class CartDetail {
	private Integer u_id;
	private String u_name;
	private Integer c_id;//购物车唯一标识
	private Integer g_id;// 1.商品唯一标识
	private String g_name;// 2.商品名称
	private String g_info;// 2.商品名称
	private double goods_price;// 6.售价
	private Integer goods_amount;// 4.数量
	private String g_imgurl;// 7.商品图片路径
	private Integer amount;// 11.库存

	public CartDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public CartDetail(Integer u_id, String u_name, Integer c_id, Integer g_id,
			String g_name, String g_info, double goods_price,
			Integer goods_amount, String g_imgurl, Integer amount) {
		super();
		this.u_id = u_id;
		this.u_name = u_name;
		this.c_id = c_id;
		this.g_id = g_id;
		this.g_name = g_name;
		this.g_info = g_info;
		this.goods_price = goods_price;
		this.goods_amount = goods_amount;
		this.g_imgurl = g_imgurl;
		this.amount = amount;
	}



	public Integer getU_id() {
		return u_id;
	}

	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public Integer getC_id() {
		return c_id;
	}

	public void setC_id(Integer c_id) {
		this.c_id = c_id;
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

	
	public String getG_info() {
		return g_info;
	}



	public void setG_info(String g_info) {
		this.g_info = g_info;
	}



	public double getGoods_price() {
		return goods_price;
	}

	public void setGoods_price(double goods_price) {
		this.goods_price = goods_price;
	}

	public Integer getGoods_amount() {
		return goods_amount;
	}

	public void setGoods_amount(Integer goods_amount) {
		this.goods_amount = goods_amount;
	}

	public String getG_imgurl() {
		return g_imgurl;
	}

	public void setG_imgurl(String g_imgurl) {
		this.g_imgurl = g_imgurl;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}



	@Override
	public String toString() {
		return "CartDetail [u_id=" + u_id + ", u_name=" + u_name + ", c_id="
				+ c_id + ", g_id=" + g_id + ", g_name=" + g_name + ", g_info="
				+ g_info + ", goods_price=" + goods_price + ", goods_amount="
				+ goods_amount + ", g_imgurl=" + g_imgurl + ", amount="
				+ amount + "]";
	}

	

	

	

}
