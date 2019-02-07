package com.shop.beans;

public class Goods_fu {
	private Integer gfu_id;// 商品 鲜花用途表唯一标识
	private Integer g_id;// 商品唯一标识
	private String floUse_id;// 鲜花用途

	public Goods_fu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Goods_fu(Integer gfu_id, Integer g_id, String floUse_id) {
		super();
		this.gfu_id = gfu_id;
		this.g_id = g_id;
		this.floUse_id = floUse_id;
	}

	public Integer getGfu_id() {
		return gfu_id;
	}

	public void setGfu_id(Integer gfu_id) {
		this.gfu_id = gfu_id;
	}

	public Integer getG_id() {
		return g_id;
	}

	public void setG_id(Integer g_id) {
		this.g_id = g_id;
	}

	public String getFloUse_id() {
		return floUse_id;
	}

	public void setFloUse_id(String floUse_id) {
		this.floUse_id = floUse_id;
	}

	@Override
	public String toString() {
		return "Goods_fu [gfu_id=" + gfu_id + ", g_id=" + g_id + ", floUse_id="
				+ floUse_id + "]";
	}

	

}
