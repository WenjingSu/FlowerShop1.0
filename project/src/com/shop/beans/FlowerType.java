package com.shop.beans;

public class FlowerType {
	private Integer floType_id;
	private String floType_name;
	private String floType_mean;
	private Integer floType_del;
	private String floType_img;
	public FlowerType() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public FlowerType(Integer floType_id, String floType_name,
			String floType_mean, Integer floType_del, String floType_img) {
		super();
		this.floType_id = floType_id;
		this.floType_name = floType_name;
		this.floType_mean = floType_mean;
		this.floType_del = floType_del;
		this.floType_img = floType_img;
	}



	public Integer getFloType_id() {
		return floType_id;
	}
	public void setFloType_id(Integer floType_id) {
		this.floType_id = floType_id;
	}
	public String getFloType_name() {
		return floType_name;
	}
	public void setFloType_name(String floType_name) {
		this.floType_name = floType_name;
	}
	public String getFloType_mean() {
		return floType_mean;
	}
	public void setFloType_mean(String floType_mean) {
		this.floType_mean = floType_mean;
	}
	public Integer getFloType_del() {
		return floType_del;
	}
	public void setFloType_del(Integer floType_del) {
		this.floType_del = floType_del;
	}
	
	
	public String getFloType_img() {
		return floType_img;
	}



	public void setFloType_img(String floType_img) {
		this.floType_img = floType_img;
	}



	@Override
	public String toString() {
		return "FlowerType [floType_id=" + floType_id + ", floType_name="
				+ floType_name + ", floType_mean=" + floType_mean
				+ ", floType_del=" + floType_del + ", floType_img="
				+ floType_img + "]";
	}



	
	
	
}
