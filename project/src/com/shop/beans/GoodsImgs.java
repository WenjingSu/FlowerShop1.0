package com.shop.beans;

public class GoodsImgs {
	private Integer img_id;
	private Integer g_id;;
	private String img_url;

	public GoodsImgs() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GoodsImgs(Integer img_id, Integer g_id, String img_url) {
		super();
		this.img_id = img_id;
		this.g_id = g_id;
		this.img_url = img_url;
	}

	public Integer getImg_id() {
		return img_id;
	}

	public void setImg_id(Integer img_id) {
		this.img_id = img_id;
	}

	public Integer getG_id() {
		return g_id;
	}

	public void setG_id(Integer g_id) {
		this.g_id = g_id;
	}

	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}

	@Override
	public String toString() {
		return "GoodsImgs [img_id=" + img_id + ", g_id=" + g_id + ", img_url="
				+ img_url + "]";
	}

}
