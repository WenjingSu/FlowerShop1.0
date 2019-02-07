package com.shop.dao;

import java.util.List;

import com.shop.beans.Address;
import com.shop.beans.G_Order;
import com.shop.beans.Order_goods_info;

public interface AddressDao {
	/**
	 * ����µ�ַ
	 */
	public boolean addressAdd(Address address);
	/**
	 * ɾ����ַ
	 */
	public boolean addressDel(Integer add_id);
	/**
	 * �޸ĵ�ַ
	 */
	public boolean addressUpdate(Integer add_id,Address address);
	/**
	 * �����û���ѯȫ����ַ
	 */
	public List<Address> addressFindAll(Integer u_id);
	

	
	
}
