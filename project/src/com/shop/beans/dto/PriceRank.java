package com.shop.beans.dto;

public class PriceRank {
	private Integer g_id;
	private String g_name;
	private double total_price;

	public PriceRank() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PriceRank(Integer g_id, String g_name, double total_price) {
		super();
		this.g_id = g_id;
		this.g_name = g_name;
		this.total_price = total_price;
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

	public double getTotal_price() {
		return total_price;
	}

	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}

	@Override
	public String toString() {
		return "PriceRank [g_id=" + g_id + ", g_name=" + g_name
				+ ", total_price=" + total_price + "]";
	}

}
