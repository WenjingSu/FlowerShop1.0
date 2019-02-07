package com.shop.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shop.DBUtil.JDBCUtil;
import com.shop.beans.dto.CartDetail;
import com.shop.dao.CartDao;

public class CartDaoImpl implements CartDao {

	public boolean addshopIntoCart(Integer u_id, Integer g_id,
			Integer goods_amount) {
		Connection conn = JDBCUtil.getConnection();
		String sql = "INSERT INTO cart (u_id,g_id,goods_amount) values (?,?,?);";
		boolean flag = false;
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, u_id);
			stmt.setInt(2, g_id);
			stmt.setInt(3, goods_amount);
			int i = stmt.executeUpdate();
			if (i > 0) {
				flag = true;
			} else {
				flag = false;
			}

			JDBCUtil.close(null, stmt, conn);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return flag;
	}

	public boolean UpdateGoodIntoCart(Integer u_id, Integer g_id, Integer amount) {
		Connection conn = JDBCUtil.getConnection();
		String str = "select goods_amount from cart where u_id=? and g_id=?";

		try {
			PreparedStatement stmt = conn.prepareStatement(str);
			stmt.setInt(1, u_id);
			stmt.setInt(2, g_id);
			ResultSet rs = stmt.executeQuery();
			int oldamount = 0;
			while (rs.next()) {
				oldamount = rs.getInt(1);
			}
			// System.out.println(oldamount);
			String sql = "UPDATE cart set goods_amount=? where u_id=? and g_id=?;";
			PreparedStatement stmt1 = conn.prepareStatement(sql);
			int goods_amount = oldamount + amount;
			stmt1.setInt(1, goods_amount);
			stmt1.setInt(2, u_id);
			stmt1.setInt(3, g_id);
			int s = stmt1.executeUpdate();
			JDBCUtil.close(rs, stmt, conn);
			if (s > 1) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return false;

	}

	public boolean cartHasCont(Integer u_id, Integer g_id) {
		Connection conn = JDBCUtil.getConnection();

		String sql = "select g_id from v_cart where u_id=? and g_id=?";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, u_id);
			stmt.setInt(2, g_id);
			ResultSet rs = stmt.executeQuery();
			List<Integer> list = new ArrayList<Integer>();
			while (rs.next()) {
				list.add(rs.getInt(1));
			}
			JDBCUtil.close(rs, stmt, conn);
			if (list.contains(g_id)) {
				return true;
			} else
				return false;

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return false;
	}

	public CartDetail cartFindByCid(Integer c_id) {
		Connection conn = JDBCUtil.getConnection();
		String sql = "select * from v_cart WHERE c_id=?";
		CartDetail cartdetail = null;
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, c_id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				cartdetail = new CartDetail(rs.getInt(1), rs.getString(2),
						rs.getInt(3), rs.getInt(4), rs.getString(5),
						rs.getString(6), rs.getDouble(7), rs.getInt(8),
						rs.getString(9), rs.getInt(10));
			}
			JDBCUtil.close(rs, stmt, conn);

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return cartdetail;
	}

	public List<CartDetail> CartInfoByUid(int u_id) {
		Connection conn = JDBCUtil.getConnection();
		List<CartDetail> list = new ArrayList<CartDetail>();
		String sql = "select * from v_cart WHERE u_id=?";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, u_id);
			ResultSet rs = stmt.executeQuery();

			CartDetail cartdetail = new CartDetail();
			while (rs.next()) {
				cartdetail = new CartDetail(rs.getInt(1), rs.getString(2),
						rs.getInt(3), rs.getInt(4), rs.getString(5),
						rs.getString(6), rs.getDouble(7), rs.getInt(8),
						rs.getString(9), rs.getInt(10));
				list.add(cartdetail);
			}
			JDBCUtil.close(rs, stmt, conn);

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

	public boolean UpdateAmountByCid(int c_id, int amount) {
		Connection conn = JDBCUtil.getConnection();
		String sql = "UPDATE cart SET goods_amount =? where c_id=?";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, amount);
			stmt.setInt(2, c_id);
			int s = stmt.executeUpdate();
			JDBCUtil.close(null, stmt, conn);
			if (s >= 1) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return false;
	}

	public boolean deleteCartByCid(int c_id) {
		Connection conn = JDBCUtil.getConnection();
		String sql = "DELETE FROM cart where c_id=?";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, c_id);
			int s = stmt.executeUpdate();
			JDBCUtil.close(null, stmt, conn);
			if (s >= 1) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return false;
	}

}
