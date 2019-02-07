package com.shop.dao;

import java.util.List;

import com.shop.beans.Goods;
import com.shop.beans.Order_goods_info;
import com.shop.beans.User;
import com.shop.beans.dto.G_Order_User_Address;
import com.shop.beans.dto.Order_goods_goodsimg;
import com.shop.beans.dto.OrderList;
import com.shop.page.PageList;

public interface OrderDao {
	/**
	 * 查询所有订单
	 * 
	 * @return
	 */
	public List<G_Order_User_Address> order_formsFindAll();

	/**
	 * 查询某用户的所有订单根据用户名
	 * 
	 * @param username
	 * @return List<G_Order_User_Address>
	 */
	public List<G_Order_User_Address> order_formFindByUsername(String u_name);

	/**
	 * 根据订单号查询单个订单
	 * 
	 * @param orderserial
	 * @return
	 */
	public G_Order_User_Address order_formFindByOid(Integer orderserial);

	/**
	 * 根据日期查询订单
	 * 
	 * @param otime
	 * @return
	 */
	public List<G_Order_User_Address> order_formsFindByDate(String otime);

	/**
	 * 修改订单状态
	 * 
	 * @param oid
	 * @return
	 */
	public boolean order_formUpdateStaByOId(Integer orderstate, Integer oid);
	public PageList<G_Order_User_Address> findPage(G_Order_User_Address address, int currentPage, int pageSize); 
	/**
	 * 根据订单号查询订单详情
	 * 
	 * @param oid
	 * @return List<Order_goods_info>
	 */
	public List<Order_goods_info> order_formfindOid(Integer oid);

	/**
	 * 根据订单号查询各个状态的订单
	 * 
	 * @param oid
	 * @param orderstate
	 * @return List<Order_goods_goodsimg>
	 */

	public List<Order_goods_goodsimg> SelectCartStateByState(Integer u_id);

	/**
	 * 根据订单状态查询所有订单
	 * 
	 * @param orderstate
	 * @return G_order
	 */
	//统计每月销量
	public int[] salesVolume();
	//统计热销产品
	 
	public List<OrderList> selectOrderAllByState(Integer orderstate, Integer uid);
	public PageList<OrderList> selectOrderAllByState1(User user, int currentPage,
			int pageSize,Integer orderstate);
	public List<Order_goods_goodsimg> UserOrderDetailByoid(Integer oid);
}
