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
	 * ��ѯ���ж���
	 * 
	 * @return
	 */
	public List<G_Order_User_Address> order_formsFindAll();

	/**
	 * ��ѯĳ�û������ж��������û���
	 * 
	 * @param username
	 * @return List<G_Order_User_Address>
	 */
	public List<G_Order_User_Address> order_formFindByUsername(String u_name);

	/**
	 * ���ݶ����Ų�ѯ��������
	 * 
	 * @param orderserial
	 * @return
	 */
	public G_Order_User_Address order_formFindByOid(Integer orderserial);

	/**
	 * �������ڲ�ѯ����
	 * 
	 * @param otime
	 * @return
	 */
	public List<G_Order_User_Address> order_formsFindByDate(String otime);

	/**
	 * �޸Ķ���״̬
	 * 
	 * @param oid
	 * @return
	 */
	public boolean order_formUpdateStaByOId(Integer orderstate, Integer oid);
	public PageList<G_Order_User_Address> findPage(G_Order_User_Address address, int currentPage, int pageSize); 
	/**
	 * ���ݶ����Ų�ѯ��������
	 * 
	 * @param oid
	 * @return List<Order_goods_info>
	 */
	public List<Order_goods_info> order_formfindOid(Integer oid);

	/**
	 * ���ݶ����Ų�ѯ����״̬�Ķ���
	 * 
	 * @param oid
	 * @param orderstate
	 * @return List<Order_goods_goodsimg>
	 */

	public List<Order_goods_goodsimg> SelectCartStateByState(Integer u_id);

	/**
	 * ���ݶ���״̬��ѯ���ж���
	 * 
	 * @param orderstate
	 * @return G_order
	 */
	//ͳ��ÿ������
	public int[] salesVolume();
	//ͳ��������Ʒ
	 
	public List<OrderList> selectOrderAllByState(Integer orderstate, Integer uid);
	public PageList<OrderList> selectOrderAllByState1(User user, int currentPage,
			int pageSize,Integer orderstate);
	public List<Order_goods_goodsimg> UserOrderDetailByoid(Integer oid);
}
