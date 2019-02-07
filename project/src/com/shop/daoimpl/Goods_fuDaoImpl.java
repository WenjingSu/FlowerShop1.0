package com.shop.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shop.DBUtil.JDBCUtil;
import com.shop.beans.Goods;
import com.shop.beans.Goods_fu;
import com.shop.dao.Goods_fuDao;

public class Goods_fuDaoImpl implements Goods_fuDao {
    //商品用途添加
	public boolean g_fu_add(Integer g_id, String floUse_ids) {
		Connection con = JDBCUtil.getConnection();
		String sql = "insert into goods_fu (g_id,floUse_ids) values(?,?)";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, g_id);
			ps.setString(2, floUse_ids);
			int i = ps.executeUpdate();
			if (i > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			return false;
		} finally {
			JDBCUtil.close(null, ps, con);
		}
	}
    //根据商品id查询商品用途ids
	public String floUse_ids(Integer g_id) {
		String sql = "select floUse_ids from goods_fu where g_id=?";

		Connection con = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		String floUse_ids = null;

		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, g_id);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				floUse_ids = rs.getString(1);
			}
			return floUse_ids;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("==");
		} finally {
			JDBCUtil.close(null, pstm, con);
		}

		return null;
	}
    //修改商品用途信息
	public boolean g_fu_update(Integer g_id, String floUse_ids) {
		Connection con = JDBCUtil.getConnection();
		String sql = "update goods_fu set floUse_ids=? where g_id=?";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, floUse_ids);
			ps.setInt(2, g_id);
			int i = ps.executeUpdate();
			if (i > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.close(null, ps, con);
		}
	}
    //根据g_id查询商品用途ids
	public Goods_fu g_fu_findbyId(Integer g_id) {
		// TODO Auto-generated method stub
		String sql = "select gfu_id,g_id,floUse_ids from goods_fu where g_id=?";
		Connection con = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		Goods_fu goods_fu = null;
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, g_id);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				goods_fu = new Goods_fu(rs.getInt(1), rs.getInt(2),
						rs.getString(3));

			}
			return goods_fu;
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			JDBCUtil.close(null, pstm, con);
		}
		return null;
	}

	public List<Integer> g_fu_ids() {
		Connection con = JDBCUtil.getConnection();
		String sql = "select gfu_id from goods_fu order by gfu_id";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<Integer> list = new ArrayList<Integer>();
		Integer gfu_id = null;
		try {
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				gfu_id =rs.getInt(1);
				list.add(gfu_id);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstm, con);
		}
		return null;
	}
	public String floUse_ids_second(Integer gfu_id) {
		String sql = "select floUse_ids from goods_fu where gfu_id=?";

		Connection con = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		String floUse_ids = null;

		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, gfu_id);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				floUse_ids = rs.getString(1);
			}
			return floUse_ids;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("==");
		} finally {
			JDBCUtil.close(null, pstm, con);
		}

		return null;
	}
	

}
