package com.shop.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.shop.DBUtil.JDBCUtil;
import com.shop.beans.Order_goods_info;
import com.shop.dao.Order_goods_infoDao;

public class Order_goods_infoDaoImpl implements Order_goods_infoDao{

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
