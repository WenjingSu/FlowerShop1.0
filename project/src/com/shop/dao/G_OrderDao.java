package com.shop.dao;

import com.shop.beans.G_Order;
import com.shop.beans.Order_goods_info;


public interface G_OrderDao {
	public boolean g_orderAdd(G_Order g_order);

	/**
	 * ����¶�����Ʒ
	 * 
	 * @param order_goods_info
	 * @return
	 */
	public G_Order g_orderFindByorderserial(String orderserial);

	public boolean order_goods_infoAdd(Order_goods_info order_goods_info);

}
