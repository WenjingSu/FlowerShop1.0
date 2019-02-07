package com.shop.beans.dto;

public class SalesRank {
	private Integer g_id;
	private String g_name;
	private Integer total_num;

	public SalesRank() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SalesRank(Integer g_id, String g_name, Integer total_num) {
		super();
		this.g_id = g_id;
		this.g_name = g_name;
		this.total_num = total_num;
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

	public Integer getTotal_num() {
		return total_num;
	}

	public void setTotal_num(Integer total_num) {
		this.total_num = total_num;
	}

	@Override
	public String toString() {
		return "SalesRank [g_id=" + g_id + ", g_name=" + g_name
				+ ", total_num=" + total_num + "]";
	}

}
