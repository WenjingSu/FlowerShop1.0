package com.shop.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.shop.page.PageList;
import com.shop.DBUtil.JDBCUtil;
import com.shop.beans.Goods;
import com.shop.beans.Order_goods_info;
import com.shop.beans.User;
import com.shop.beans.dto.G_Order_User_Address;
import com.shop.beans.dto.OrderList;
import com.shop.beans.dto.Order_goods_goodsimg;
import com.shop.dao.OrderDao;
import com.shop.dao.UserDao;

public class OrderDaoImpl implements OrderDao {

	public List<G_Order_User_Address> order_formsFindAll() {
		Connection conn = JDBCUtil.getConnection();
		String sql = "select order_id, orderserial, u_id,username,order_goods_num,order_total_price,ordertime,consignee_name,consignee_tel,address ,orderstate,order_del from v_order_user_address ";
		List<G_Order_User_Address> g_orderlist = new ArrayList<G_Order_User_Address>();
		double total_price = 0;
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {

				g_orderlist.add(new G_Order_User_Address(rs.getInt(1), rs
						.getString(2), rs.getInt(3), rs.getString(4), rs
						.getInt(5), rs.getDouble(6), rs.getString(7), rs
						.getString(8), rs.getString(9), rs.getString(10), rs
						.getInt(11), rs.getInt(12)));
			}
			JDBCUtil.close(rs, stmt, conn);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return g_orderlist;
	}

	public List<G_Order_User_Address> order_formFindByUsername(String u_name) {
		Connection conn = JDBCUtil.getConnection();
		String sql = "select order_id, orderserial, u_id,username,order_goods_num,order_total_price,ordertime,consignee_name,consignee_tel,address ,orderstate,order_del from v_order_user_address where username=?";
		List<G_Order_User_Address> order_u_alist = new ArrayList<G_Order_User_Address>();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, u_name);
			ResultSet rs = stmt.executeQuery();
			G_Order_User_Address order_u_a = new G_Order_User_Address();
			while (rs.next()) {
				order_u_a = new G_Order_User_Address(rs.getInt(1),
						rs.getString(2), rs.getInt(3), rs.getString(4),
						rs.getInt(5), rs.getDouble(6), rs.getString(7),
						rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getInt(11), rs.getInt(12));
				order_u_alist.add(order_u_a);
			}
			JDBCUtil.close(rs, stmt, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return order_u_alist;
	}

	public G_Order_User_Address order_formFindByOid(Integer oid) {
		String sql = "select order_id, orderserial,u_id,u_name,order_goods_num,order_total_price,ordertime,consignee_name,consignee_tel,address,orderstate,order_del from v_order_user_address where order_id=?";
		Connection conn = JDBCUtil.getConnection();
		G_Order_User_Address order_u_a = new G_Order_User_Address();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, oid);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				order_u_a = new G_Order_User_Address(rs.getInt(1),
						rs.getString(2), rs.getInt(3), rs.getString(4),
						rs.getInt(5), rs.getDouble(6), rs.getString(7),
						rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getInt(11), rs.getInt(12));
			}
			JDBCUtil.close(rs, stmt, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return order_u_a;
	}

	public List<G_Order_User_Address> order_formsFindByDate(String otime) {
		String sql = "select order_id, orderserial, u_id,username,order_goods_num,order_total_price,ordertime,consignee_name,consignee_tel,address ,orderstate,order_del from v_order_user_address where ordertime LIKE ?";
		Connection conn = JDBCUtil.getConnection();
		List<G_Order_User_Address> order_u_alist = new ArrayList<G_Order_User_Address>();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			otime = otime + "%";
			stmt.setString(1, otime);
			ResultSet rs = stmt.executeQuery();
			G_Order_User_Address order_u_a = new G_Order_User_Address();
			while (rs.next()) {
				order_u_a = new G_Order_User_Address(rs.getInt(1),
						rs.getString(2), rs.getInt(3), rs.getString(4),
						rs.getInt(5), rs.getDouble(6), rs.getString(7),
						rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getInt(11), rs.getInt(12));
				order_u_alist.add(order_u_a);
			}
			JDBCUtil.close(rs, stmt, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return order_u_alist;
	}

	public boolean order_formUpdateStaByOId(Integer orderstate, Integer oid) {
		String sql = "update g_order SET orderstate=? where order_id=? ";
		Connection conn = JDBCUtil.getConnection();
		boolean op = false;
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, orderstate);
			stmt.setInt(2, oid);
			int i = stmt.executeUpdate();

			// System.out.println(i);
			if (i > 0) {
				op = true;
			} else {
				op = false;
			}
			JDBCUtil.close(null, stmt, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return op;
	}

	public List<Order_goods_info> order_formfindOid(Integer oid) {
		String sql = "SELECT * from order_goods_info WHERE order_id=?";
		Connection conn = JDBCUtil.getConnection();
		List<Order_goods_info> order = new ArrayList<Order_goods_info>();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, oid);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				order.add(new Order_goods_info(rs.getInt(1), rs.getInt(2), rs
						.getInt(3), rs.getInt(4), rs.getString(5), rs
						.getDouble(6), rs.getInt(7)));
			}
			JDBCUtil.close(rs, stmt, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return order;
	}

	public PageList<G_Order_User_Address> findPage(
			G_Order_User_Address address, int currentPage, int pageSize) {

		PageList<G_Order_User_Address> page = null;// �����ٷ��ؽ����ʱ�����ʵ����
		// ��Ų����ļ���

		List<Object> paramList = new ArrayList<Object>();
		// ��ȡ����----������д�������Ĳ���
		String orderserial = address.getOrderserial();
		String otime = address.getOrdertime();
		int ostate = address.getOrderstate();

		// ��������sql��䣺һ�������ѯ���� һ������ͳ������
		StringBuffer sql = new StringBuffer(
				"SELECT * FROM v_order_user_address where true=true");
		StringBuffer countSql = new StringBuffer(
				"SELECT count(order_id) as totalRecord FROM  v_order_user_address where 1=1");

		// ������ƴ�ӵ�sql�����
		if (orderserial != null && !"".equals(orderserial)) {// ��ʾ�������������Ϊ��
			sql.append(" and orderserial like ?");// ����ѯ�����в�����ƴ��
			countSql.append(" and orderserial like ?");// ��ͳ�������в�����ƴ��
			paramList.add("%" + orderserial + "%");// ʵ�ʲ���
		}

		if (otime != null && !"".equals(otime)) {// ��ʾ�������������Ϊ��
			sql.append(" and  ordertime like ?");// ����ѯ�����в�����ƴ��
			countSql.append(" and ordertime  like ?");// ��ͳ�������в�����ƴ��
			paramList.add("%" + otime + "%");// ʵ�ʲ���
		}
		if (ostate != 0) {// �������Ա��������
			sql.append(" and orderstate = ?");
			countSql.append(" and orderstate = ?");
			paramList.add(ostate);
		}
		sql.append("  ORDER BY order_id DESC");
		// ��ѯ����ʼ����
		int fromIndex = pageSize * (currentPage - 1);

		// ʹ��limit�ؼ���ʵ�ַ�ҳ
		sql.append(" limit " + fromIndex + "," + pageSize);

		// ����һ�����ϴ�����в�ѯ�����Ķ���
		List<G_Order_User_Address> orderList = new ArrayList<G_Order_User_Address>();

		// ʵ�������ݿ��ѯ�Ķ���
		JDBCUtil jdbcUtil = new JDBCUtil();
		try {
			List<Map<String, Object>> countResult = jdbcUtil.findResults(
					countSql.toString(), paramList);
			int totalRecord = Integer.parseInt(countResult.get(0)
					.get("totalRecord").toString());
			// ��ȡ��ѯ��ѧ���Ķ���ļ���
			List<Map<String, Object>> orderResult = jdbcUtil.findResults(
					sql.toString(), paramList);

			if (orderResult != null) {
				for (Map<String, Object> map : orderResult) {// ��Map�б��������ת����Student����
					G_Order_User_Address g_Order_User_Address = new G_Order_User_Address();
					g_Order_User_Address.setOrder_id(Integer.parseInt(map.get(
							"order_id").toString()));
					g_Order_User_Address.setOrderserial(map.get("orderserial")
							.toString());
					g_Order_User_Address.setU_id(Integer.parseInt(map.get(
							"u_id").toString()));
					// System.out.println("aa");
					g_Order_User_Address
							.setU_name(map.get("u_name").toString());
					g_Order_User_Address.setOrder_goods_num(Integer
							.parseInt(map.get("order_goods_num").toString()));
					g_Order_User_Address.setOrder_total_price(Double
							.parseDouble(map.get("order_total_price")
									.toString()));
					g_Order_User_Address.setOrdertime(map.get("ordertime")
							.toString());
					g_Order_User_Address.setConsignee_name(map.get(
							"consignee_name").toString());
					g_Order_User_Address.setConsignee_tel(map.get(
							"consignee_tel").toString());
					g_Order_User_Address.setAddress(map.get("address")
							.toString());
					g_Order_User_Address.setOrderstate(Integer.parseInt(map
							.get("orderstate").toString()));
					g_Order_User_Address.setOrder_del(Integer.parseInt(map.get(
							"order_del").toString()));
					orderList.add(g_Order_User_Address);
				}
			}
			// ��ȡ�ܵ�ҳ��
			int totalPage = totalRecord / pageSize;
			if (totalRecord % pageSize != 0) {
				totalPage += 1;// ��ҳ����1
			}

			// ����Page�������װ
			page = new PageList<G_Order_User_Address>(pageSize, currentPage,
					totalRecord, totalPage, orderList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return page;

	}

	public List<Order_goods_goodsimg> SelectCartStateByState(Integer oid) {
		String sql = "select * FROM v_order_goods WHERE order_id=?";
		Connection conn = JDBCUtil.getConnection();
		List<Order_goods_goodsimg> list = new ArrayList<Order_goods_goodsimg>();

		Order_goods_goodsimg goods_goodsimg = new Order_goods_goodsimg();

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, oid);
			ResultSet rs = stmt.executeQuery();
			// System.out.println(sql);

			while (rs.next()) {
				goods_goodsimg = new Order_goods_goodsimg(
						rs.getInt("ord_g_info_id"), rs.getInt("order_id"),
						rs.getInt("goods_num"), rs.getInt("g_id"),
						rs.getString("g_name"), rs.getDouble("g_price"),
						rs.getInt("ord_g_info_del"), rs.getString("g_imgurl"));

				list.add(goods_goodsimg);
			}

			JDBCUtil.close(rs, stmt, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<OrderList> selectOrderAllByState(Integer orderstate, Integer uid) {
		String sql = "select * from  g_order where 1=1 and u_id=? ";
		PreparedStatement stmt = null;

		Connection conn = JDBCUtil.getConnection();
		List<OrderList> list = new ArrayList<OrderList>();
		OrderList orderlist = new OrderList();

		try {
			if (orderstate > 0) {
				sql += " " + "and orderstate=?" + " ORDER BY ordertime DESC";
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, uid);
				stmt.setInt(2, orderstate);
			} else {
				sql += " ORDER BY ordertime DESC";
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, uid);
			}
			// System.out.println(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {

				orderlist = new OrderList(rs.getInt("order_id"),
						rs.getString("orderserial"),
						rs.getInt("order_goods_num"),
						rs.getDouble("order_total_price"),
						rs.getString("ordertime"), rs.getInt("u_id"),
						rs.getInt("add_id"), rs.getInt("orderstate"),
						rs.getInt("order_del"));

				List<Order_goods_goodsimg> order_goodlist = SelectCartStateByState(rs
						.getInt("order_id"));
				orderlist.setOrder_goodlist(order_goodlist);
				list.add(orderlist);
			}

			JDBCUtil.close(rs, stmt, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<Order_goods_goodsimg> UserOrderDetailByoid(Integer oid) {
		// TODO Auto-generated method stub
		return null;
	}

	public int[] salesVolume() {
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement stmt1 = null;
		PreparedStatement stmt = null;
		String sql1 = "select SUBSTR(ordertime,6,2) monthly,sum(order_goods_num) from g_order where order_del=1 GROUP BY SUBSTR(ordertime,6,2)";

		// int[] salesNum = new int[12];
		int[] salesNum = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		try {
			stmt1 = conn.prepareStatement(sql1);
			ResultSet rs1 = stmt1.executeQuery();

			while (rs1.next()) {
				for (int i = 1; i <= 12; i++) {
					if (i == rs1.getInt(1)) {
						// System.out.println(rs1.getInt(1));
						salesNum[i - 1] = rs1.getInt(2);
						break;
					}
				}

			}
			return salesNum;

		}

		catch (SQLException e) {

			e.printStackTrace();
			return null;
		} finally {
			JDBCUtil.close(null, stmt, conn);
		}

	}

	public PageList<OrderList> selectOrderAllByState1(User user,
			int currentPage, int pageSize, Integer orderstate) {
		PageList<OrderList> page = null;// �����ٷ��ؽ����ʱ�����ʵ����
		List<Object> paramList = new ArrayList<Object>();// ���йؼ����ֶε��������� list
		List<OrderList> list = new ArrayList<OrderList>();
		// ��ȡ����----������д�������Ĳ���
		// System.out.println(user);
		Integer u_id = user.getU_id();
		StringBuffer sql = new StringBuffer();
		sql = new StringBuffer("select order_id,orderserial,order_goods_num,order_total_price,ordertime,u_id,add_id,orderstate,order_del from  g_order where 1=1");

		// ����ͳ������
		StringBuffer countSql = new StringBuffer(
		"select count(order_id)  as totalRecord from g_order where order_del=1 and 1=1");

		if (u_id != null && !"".equals(u_id)) {// ��ʾ������������Ϊ��
			sql.append(" and u_id = ?");// ����ѯ�����в�����ƴ��http://localhost:8080/FlowerShop1.0/GoodsFrontServlet?method=single_good_detail&g_id=94
			countSql.append(" and u_id = ?");// ��ͳ�������в�����ƴ��
			paramList.add(u_id);// ʵ�ʲ���
		}
		if (orderstate != null && !"".equals(orderstate)) {// ��ʾ������������Ϊ��
			if (orderstate > 0) {
				sql.append(" and orderstate = ?");// ����ѯ�����в�����ƴ��
				countSql.append(" and orderstate = ?");// ��ͳ�������в�����ƴ��
				paramList.add(orderstate);// ʵ�ʲ���
			}

		}
		
		
		// ��ѯ����ʼ����
		int fromIndex = pageSize * (currentPage - 1);
		sql.append(" order by order_id desc");
		// ʹ��limit�ؼ���ʵ�ַ�ҳ
		sql.append(" limit " + fromIndex + "," + pageSize);
		//System.out.println(sql);
		
		
		// ʵ�������ݿ��ѯ�Ķ���
		JDBCUtil jdbcUtil = new JDBCUtil();

		try {
			// ��ȡ�ܵļ�¼
			List<Map<String, Object>> countResult = jdbcUtil.findResults(
					countSql.toString(), paramList);
			int totalRecord = Integer.parseInt(countResult.get(0)
					.get("totalRecord").toString());
			// System.out.println(totalRecord);
			// ��ȡ��ѯ�Ķ����Ķ���ļ���
			List<Map<String, Object>> ordersResult = jdbcUtil.findResults(
					sql.toString(), paramList);
			// System.out.println(goodsResult);
			if (ordersResult != null) {
				for (Map<String, Object> map : ordersResult) {// ��Map�б��������ת����Order����
					OrderList orderlist = new OrderList();
					orderlist.setOrder_id(Integer.parseInt(map.get("order_id")
							.toString()));
					orderlist.setOrderserial(map.get("orderserial").toString());
					orderlist.setOrder_goods_num(Integer.parseInt(map.get(
							"order_goods_num").toString()));
					orderlist.setOrder_total_price(Double.parseDouble(map.get(
							"order_total_price").toString()));
					orderlist.setOrdertime(map.get("ordertime").toString());
					orderlist.setU_id(Integer.parseInt(map.get("u_id")
							.toString()));
					orderlist.setAdd_id(Integer.parseInt(map.get("add_id")
							.toString()));
					orderlist.setOrderstate(Integer.parseInt(map.get(
							"orderstate").toString()));
					orderlist.setOrder_del(Integer.parseInt(map
							.get("order_del").toString()));
					List<Order_goods_goodsimg> order_goodlist = SelectCartStateByState(Integer
							.parseInt(map.get("order_id").toString()));
					orderlist.setOrder_goodlist(order_goodlist);
					list.add(orderlist);
				}
			}
			// ��ȡ�ܵ�ҳ��
			int totalPage = totalRecord / pageSize;
			if (totalRecord % pageSize != 0) {
				totalPage += 1;// ��ҳ����1
			}
			// ����Page�������װ
			page = new PageList<OrderList>(pageSize, currentPage, totalRecord,
					totalPage, list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return page;
	}

	public static void main(String[] args) {
		OrderDao d = new OrderDaoImpl();
		UserDao ud = new UserDaoImpl();
		User user = ud.userfindbyuId(10);
		PageList<OrderList> list = d.selectOrderAllByState1(user, 1, 12, 1);
		for (OrderList l : list.getDataList()) {
			System.out.println(l);
		}
	}
}
