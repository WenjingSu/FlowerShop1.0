package com.shop.beans;

public class Goods_ft {
	private Integer gft_id;// 商品 鲜花种类表唯一标识
	private Integer g_id;// 商品唯一标识
	private String floType_id;// 鲜花种类

	public Goods_ft() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Goods_ft(Integer gft_id, Integer g_id, String floType_id) {
		super();
		this.gft_id = gft_id;
		this.g_id = g_id;
		this.floType_id = floType_id;
	}

	public Integer getGft_id() {
		return gft_id;
	}

	public void setGft_id(Integer gft_id) {
		this.gft_id = gft_id;
	}

	public Integer getG_id() {
		return g_id;
	}

	public void setG_id(Integer g_id) {
		this.g_id = g_id;
	}

	public String getFloType_id() {
		return floType_id;
	}

	public void setFloType_id(String floType_id) {
		this.floType_id = floType_id;
	}

	@Override
	public String toString() {
		return "Goods_ft [gft_id=" + gft_id + ", g_id=" + g_id
				+ ", floType_id=" + floType_id + "]";
	}

	

	

}
