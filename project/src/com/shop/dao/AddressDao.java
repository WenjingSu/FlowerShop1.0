package com.shop.dao;

import java.util.List;

import com.shop.beans.Address;
import com.shop.beans.G_Order;
import com.shop.beans.Order_goods_info;

public interface AddressDao {
	/**
	 * 添加新地址
	 */
	public boolean addressAdd(Address address);
	/**
	 * 删除地址
	 */
	public boolean addressDel(Integer add_id);
	/**
	 * 修改地址
	 */
	public boolean addressUpdate(Integer add_id,Address address);
	/**
	 * 根据用户查询全部地址
	 */
	public List<Address> addressFindAll(Integer u_id);
	

	
	
}
