package com.shop.beans;

public class FlowerNum {
	private Integer floNum_id;
	private String floNum_name;
	private String floNum_mean;
	private Integer floNum_del;
	public FlowerNum() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FlowerNum(Integer floNum_id, String floNum_name, String floNum_mean,
			Integer floNum_del) {
		super();
		this.floNum_id = floNum_id;
		this.floNum_name = floNum_name;
		this.floNum_mean = floNum_mean;
		this.floNum_del = floNum_del;
	}
	public Integer getFloNum_id() {
		return floNum_id;
	}
	public void setFloNum_id(Integer floNum_id) {
		this.floNum_id = floNum_id;
	}
	public String getFloNum_name() {
		return floNum_name;
	}
	public void setFloNum_name(String floNum_name) {
		this.floNum_name = floNum_name;
	}
	public String getFloNum_mean() {
		return floNum_mean;
	}
	public void setFloNum_mean(String floNum_mean) {
		this.floNum_mean = floNum_mean;
	}
	public Integer getFloNum_del() {
		return floNum_del;
	}
	public void setFloNum_del(Integer floNum_del) {
		this.floNum_del = floNum_del;
	}
	@Override
	public String toString() {
		return "FlowerNum [floNum_id=" + floNum_id + ", floNum_name="
				+ floNum_name + ", floNum_mean=" + floNum_mean
				+ ", floNum_del=" + floNum_del + "]";
	}
	

	
}
