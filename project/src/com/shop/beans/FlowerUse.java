package com.shop.beans;

public class FlowerUse {
	private Integer floUse_id;
	private String floUse_name;
	private Integer floUse_del;
	private String floUse_img;
	public FlowerUse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public FlowerUse(Integer floUse_id, String floUse_name, Integer floUse_del,
			String floUse_img) {
		super();
		this.floUse_id = floUse_id;
		this.floUse_name = floUse_name;
		this.floUse_del = floUse_del;
		this.floUse_img = floUse_img;
	}



	public Integer getFloUse_id() {
		return floUse_id;
	}
	public void setFloUse_id(Integer floUse_id) {
		this.floUse_id = floUse_id;
	}
	public String getFloUse_name() {
		return floUse_name;
	}
	public void setFloUse_name(String floUse_name) {
		this.floUse_name = floUse_name;
	}
	public Integer getFloUse_del() {
		return floUse_del;
	}
	public void setFloUse_del(Integer floUse_del) {
		this.floUse_del = floUse_del;
	}

	public String getFloUse_img() {
		return floUse_img;
	}

	public void setFloUse_img(String floUse_img) {
		this.floUse_img = floUse_img;
	}

	@Override
	public String toString() {
		return "FlowerUse [floUse_id=" + floUse_id + ", floUse_name="
				+ floUse_name + ", floUse_del=" + floUse_del + ", floUse_img="
				+ floUse_img + "]";
	}
	
	
}
