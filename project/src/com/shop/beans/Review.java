package com.shop.beans;

import java.util.Date;

public class Review {
	private Integer r_id;// 1.唯一标识
	private Integer g_id;// 2.商品id
	private Integer u_id;// 3.用户id
	private Date review_time;// 4.评论时间
	private String content;// 5.评论内容
	private Integer state;// 6.评论等级（好 1 中 2 差 3）
	private Integer r_del;// 7.逻辑删除标识(1表示显示 ，0表示不显示)

	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Review(Integer r_id, Integer g_id, Integer u_id, Date review_time,
			String content, Integer state, Integer r_del) {
		super();
		this.r_id = r_id;
		this.g_id = g_id;
		this.u_id = u_id;
		this.review_time = review_time;
		this.content = content;
		this.state = state;
		this.r_del = r_del;
	}

	public Integer getR_id() {
		return r_id;
	}

	public void setR_id(Integer r_id) {
		this.r_id = r_id;
	}

	public Integer getG_id() {
		return g_id;
	}

	public void setG_id(Integer g_id) {
		this.g_id = g_id;
	}

	public Integer getU_id() {
		return u_id;
	}

	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}

	public Date getReview_time() {
		return review_time;
	}

	public void setReview_time(Date review_time) {
		this.review_time = review_time;
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

	public Integer getR_del() {
		return r_del;
	}

	public void setR_del(Integer r_del) {
		this.r_del = r_del;
	}

	@Override
	public String toString() {
		return "Review [r_id=" + r_id + ", g_id=" + g_id + ", u_id=" + u_id
				+ ", review_time=" + review_time + ", content=" + content
				+ ", state=" + state + ", r_del=" + r_del + "]";
	}

}
