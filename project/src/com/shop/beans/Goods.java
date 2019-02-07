package com.shop.beans;

import java.util.Date;

public class Goods {
	private Integer g_id;// Ψһ��ʶ
	private String g_name;// ��Ʒ����
	private Integer gt_id;// ��Ʒ���
	private Integer floNum_id;// �ʻ�����id
	private double purchasing_price;// ����
	private double original_price;// ԭ��
	private double goods_price;// �ۼ�
	private String g_imgurl;// ��ƷͼƬ·��
	private Date putaway_time;// ��Ʒ�ϼ�ʱ��
	private Integer g_state;// ��Ʒ״̬��1.�ϼܣ�2.�¼ܣ�
	private String g_info;// ��Ʒ�ļ��
	private Integer amount;// ���
	private Integer g_del;// �߼�ɾ����ʶ(1��ʾ��ʾ ��0��ʾ����ʾ)
	private String g_putaway_time;// ��Ʒ�ϼ�ʱ��

	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Goods(Integer g_id, String g_name, Integer gt_id, Integer floNum_id,
			double purchasing_price, double original_price, double goods_price,
			String g_imgurl, Date putaway_time, Integer g_state, String g_info,
			Integer amount, Integer g_del) {
		super();
		this.g_id = g_id;
		this.g_name = g_name;
		this.gt_id = gt_id;
		this.floNum_id = floNum_id;
		this.purchasing_price = purchasing_price;
		this.original_price = original_price;
		this.goods_price = goods_price;
		this.g_imgurl = g_imgurl;
		this.putaway_time = putaway_time;
		this.g_state = g_state;
		this.g_info = g_info;
		this.amount = amount;
		this.g_del = g_del;
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

	public Integer getGt_id() {
		return gt_id;
	}

	public void setGt_id(Integer gt_id) {
		this.gt_id = gt_id;
	}

	public Integer getFloNum_id() {
		return floNum_id;
	}

	public void setFloNum_id(Integer floNum_id) {
		this.floNum_id = floNum_id;
	}

	public double getPurchasing_price() {
		return purchasing_price;
	}

	public void setPurchasing_price(double purchasing_price) {
		this.purchasing_price = purchasing_price;
	}

	public double getOriginal_price() {
		return original_price;
	}

	public void setOriginal_price(double original_price) {
		this.original_price = original_price;
	}

	public double getGoods_price() {
		return goods_price;
	}

	public void setGoods_price(double goods_price) {
		this.goods_price = goods_price;
	}

	public String getG_imgurl() {
		return g_imgurl;
	}

	public void setG_imgurl(String g_imgurl) {
		this.g_imgurl = g_imgurl;
	}

	public Date getPutaway_time() {
		return putaway_time;
	}

	public void setPutaway_time(Date putaway_time) {
		this.putaway_time = putaway_time;
	}

	public Integer getG_state() {
		return g_state;
	}

	public void setG_state(Integer g_state) {
		this.g_state = g_state;
	}

	public String getG_info() {
		return g_info;
	}

	public void setG_info(String g_info) {
		this.g_info = g_info;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getG_del() {
		return g_del;
	}

	public void setG_del(Integer g_del) {
		this.g_del = g_del;
	}

	public String getG_putaway_time() {
		return g_putaway_time;
	}

	public void setG_putaway_time(String g_putaway_time) {
		this.g_putaway_time = g_putaway_time;
	}

	@Override
	public String toString() {
		return "Goods [g_id=" + g_id + ", g_name=" + g_name + ", gt_id="
				+ gt_id + ", floNum_id=" + floNum_id + ", purchasing_price="
				+ purchasing_price + ", original_price=" + original_price
				+ ", goods_price=" + goods_price + ", g_imgurl=" + g_imgurl
				+ ", putaway_time=" + putaway_time + ", g_state=" + g_state
				+ ", g_info=" + g_info + ", amount=" + amount + ", g_del="
				+ g_del + "]";
	}

}
