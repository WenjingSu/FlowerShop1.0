package com.shop.beans;


public class G_Order {
	private Integer order_id;// 1.唯一标识
	private String orderserial;// 2.订单序列号
	private Integer order_goods_num;// 3.订单中商品种类数量
	private double order_total_price;// 4.订单总价
	private String ordertime;// 5.订单时间
	private Integer u_id;// 6.用户id
	private Integer add_id;// 7.地址表唯一标识
	private Integer orderstate;// 8.订单状态（1.表示未支付2.表示已支付（待发货）3.已发货（待收货）4.交易完成（收货））
	private Integer order_del;// 9.逻辑删除标识(1表示显示 ，0表示不显示)

	public G_Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public G_Order(Integer order_id, String orderserial,
			Integer order_goods_num, double order_total_price,
			String ordertime, Integer u_id, Integer add_id, Integer orderstate,
			Integer order_del) {
		super();
		this.order_id = order_id;
		this.orderserial = orderserial;
		this.order_goods_num = order_goods_num;
		this.order_total_price = order_total_price;
		this.ordertime = ordertime;
		this.u_id = u_id;
		this.add_id = add_id;
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

	public Integer getU_id() {
		return u_id;
	}

	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}

	public Integer getAdd_id() {
		return add_id;
	}

	public void setAdd_id(Integer add_id) {
		this.add_id = add_id;
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
		return "G_Order [order_id=" + order_id + ", orderserial=" + orderserial
				+ ", order_goods_num=" + order_goods_num
				+ ", order_total_price=" + order_total_price + ", ordertime="
				+ ordertime + ", u_id=" + u_id + ", add_id=" + add_id
				+ ", orderstate=" + orderstate + ", order_del=" + order_del
				+ "]";
	}

}
