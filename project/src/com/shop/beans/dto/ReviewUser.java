package com.shop.beans.dto;

import java.util.Date;

public class ReviewUser {
	private Integer review_id;
	private Date review_time;
	private String review_time1;
	private String content;
	private Integer state;
	//private Integer u_id;
	private String u_name;
	private String u_img;

	public ReviewUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReviewUser(Integer review_id, Date review_time, String content,
			Integer state, String u_name, String u_img) {
		super();
		this.review_id = review_id;
		this.review_time = review_time;
		this.content = content;
		this.state = state;
		this.u_name = u_name;
		this.u_img = u_img;
	}

	public ReviewUser(Integer review_id, Date review_time, String review_time1,
			String content, Integer state, String u_name, String u_img) {
		super();
		this.review_id = review_id;
		this.review_time = review_time;
		this.review_time1 = review_time1;
		this.content = content;
		this.state = state;
		this.u_name = u_name;
		this.u_img = u_img;
	}

	public Integer getReview_id() {
		return review_id;
	}

	public void setReview_id(Integer review_id) {
		this.review_id = review_id;
	}

	public Date getReview_time() {
		return review_time;
	}

	public void setReview_time(Date review_time) {
		this.review_time = review_time;
	}

	public String getReview_time1() {
		return review_time1;
	}

	public void setReview_time1(String review_time1) {
		this.review_time1 = review_time1;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public String getU_img() {
		return u_img;
	}

	public void setU_img(String u_img) {
		this.u_img = u_img;
	}

	@Override
	public String toString() {
		return "ReviewUser [review_id=" + review_id + ", review_time="
				+ review_time + ", review_time1=" + review_time1 + ", content="
				+ content + ", state=" + state + ", u_name=" + u_name
				+ ", u_img=" + u_img + "]";
	}

	

}
