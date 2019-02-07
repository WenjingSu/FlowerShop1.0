package com.shop.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.shop.DBUtil.JDBCUtil;
import com.shop.beans.G_Order;
import com.shop.beans.Order_goods_info;
import com.shop.dao.G_OrderDao;

public class G_OrderDaoImpl implements G_OrderDao{

	public boolean g_orderAdd(G_Order g_order) {
		Connection con = JDBCUtil.getConnection();
		String sql = "insert into G_order (orderserial,order_goods_num,order_total_price,ordertime,u_id,add_id) values(?,?,?,?,?,?)";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, g_order.getOrderserial());
			ps.setInt(2,g_order.getOrder_goods_num());
			ps.setDouble(3, g_order.getOrder_total_price());
			ps.setString(4, g_order.getOrdertime());
			ps.setInt(5,g_order.getU_id());
			ps.setInt(6,g_order.getAdd_id());
			//System.out.println(g_order);
			//ps.setInt(7,g_order.getOrderstate());
			int i = ps.executeUpdate();
			if (i > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, ps, con);
		}
		return false;
	}

	public G_Order g_orderFindByorderserial(String orderserial) {
		Connection con = JDBCUtil.getConnection();
		String sql = "select order_id,orderserial,order_goods_num,order_total_price,ordertime,u_id,add_id,orderstate,order_del from G_order where orderserial=? and order_del=1";
		PreparedStatement ps = null;
		ResultSet rs = null;
		G_Order g_order = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, orderserial);
			rs = ps.executeQuery();
			while (rs.next()) {
				g_order = new G_Order(rs.getInt(1), rs.getString(2), rs.getInt(3),
						rs.getDouble(4),rs.getString(5), rs.getInt(6),
						rs.getInt(7),rs.getInt(8),rs.getInt(9));
			}
			return g_order;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, ps, con);
		}
		return null;
	}

	public boolean order_goods_infoAdd(Order_goods_info order_goods_info) {
		Connection con = JDBCUtil.getConnection();
		String sql = "insert into Order_goods_info (order_id,goods_num,g_id,g_name,g_price) values(?,?,?,?,?)";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1,order_goods_info.getOrder_id());
			ps.setInt(2,order_goods_info.getGoods_num());
			ps.setInt(3,order_goods_info.getG_id());
			ps.setString(4,order_goods_info.getG_name());
			ps.setDouble(5,order_goods_info.getG_price());
			int i = ps.executeUpdate();
			if (i > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, ps, con);
		}
		return false;
	}
}
