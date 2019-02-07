package com.shop.beans.dto;

public class G_Order_User_Address {
	private Integer order_id;// 1.Ψһ��ʶ
	private String orderserial;// 2.�������к�
	private Integer u_id;// 6.�û�id
	private String u_name;// �û���
	private Integer order_goods_num;// 3.��������Ʒ��������
	private double order_total_price;// 4.�����ܼ�
	private String ordertime;// 5.����ʱ��
	private String consignee_name;// �ջ���
	private String consignee_tel;// �ջ��˵绰
	private String address;// �ջ���ַ
	private Integer orderstate;// 8.����״̬��1.��ʾδ֧��2.��ʾ��֧������������3.�ѷ��������ջ���4.������ɣ��ջ�����
	private Integer order_del;// 9.�߼�ɾ����ʶ(1��ʾ��ʾ ��0��ʾ����ʾ)

	public G_Order_User_Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public G_Order_User_Address(Integer order_id, String orderserial,
			Integer u_id, String u_name, Integer order_goods_num,
			double order_total_price, String ordertime, String consignee_name,
			String consignee_tel, String address, Integer orderstate,
			Integer order_del) {
		super();
		this.order_id = order_id;
		this.orderserial = orderserial;
		this.u_id = u_id;
		this.u_name = u_name;
		this.order_goods_num = order_goods_num;
		this.order_total_price = order_total_price;
		this.ordertime = ordertime;
		this.consignee_name = consignee_name;
		this.consignee_tel = consignee_tel;
		this.address = address;
		this.orderstate = orderstate;
		this.order_del = order_del;
	}

	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

	public String getOrderserial() {
		return orderserial;
	}

	public void setOrderserial(String orderserial) {
		this.orderserial = orderserial;
	}

	public Integer getU_id() {
		return u_id;
	}

	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public Integer getOrder_goods_num() {
		return order_goods_num;
	}

	public void setOrder_goods_num(Integer order_goods_num) {
		this.order_goods_num = order_goods_num;
	}

	public double getOrder_total_price() {
		return order_total_price;
	}

	public void setOrder_total_price(double order_total_price) {
		this.order_total_price = order_total_price;
	}

	public String getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}

	public String getConsignee_name() {
		return consignee_name;
	}

	public void setConsignee_name(String consignee_name) {
		this.consignee_name = consignee_name;
	}

	public String getConsignee_tel() {
		return consignee_tel;
	}

	public void setConsignee_tel(String consignee_tel) {
		this.consignee_tel = consignee_tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getOrderstate() {
		return orderstate;
	}

	public void setOrderstate(Integer orderstate) {
		this.orderstate = orderstate;
	}

	public Integer getOrder_del() {
		return order_del;
	}

	public void setOrder_del(Integer order_del) {
		this.order_del = order_del;
	}

	@Override
	public String toString() {
		return "G_Order_User_Address [order_id=" + order_id + ", orderserial="
				+ orderserial + ", u_id=" + u_id + ", u_name=" + u_name
				+ ", order_goods_num=" + order_goods_num
				+ ", order_total_price=" + order_total_price + ", ordertime="
				+ ordertime + ", consignee_name=" + consignee_name
				+ ", consignee_tel=" + consignee_tel + ", address=" + address
				+ ", orderstate=" + orderstate + ", order_del=" + order_del
				+ "]";
	}

}
