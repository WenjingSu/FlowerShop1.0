package com.shop.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.shop.DBUtil.JDBCUtil;
import com.shop.beans.Goods_ft;
import com.shop.dao.Goods_ftDao;

public class Goods_ftDaoImpl implements Goods_ftDao {
    //商品花材表添加商品id和花材ids
	public boolean g_ft_add(Integer g_id, String floType_ids) {
		Connection con = JDBCUtil.getConnection();
		String sql = "insert into goods_ft (g_id,floType_ids) values(?,?)";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, g_id);
			ps.setString(2, floType_ids);
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
    //根据商品id查找花材ids
	public String floType_ids(Integer g_id) {
		String sql = "select floType_ids from goods_ft where g_id=?";

		Connection con = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		String floType_ids = null;

		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, g_id);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				floType_ids = rs.getString(1);
			}
			return floType_ids;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("==");
		} finally {
			JDBCUtil.close(null, pstm, con);
		}

		return null;
	}
    //修改花材ids
	public boolean g_ft_update(Integer g_id, String floType_ids) {
		Connection con = JDBCUtil.getConnection();
		String sql = "update goods_ft set floType_ids=? where g_id=?";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, floType_ids);
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
    //根据gid查找某花材
	public Goods_ft g_ft_findbyId(Integer g_id) {
		// TODO Auto-generated method stub
		String sql = "select gft_id,g_id,floType_ids from goods_ft where g_id=?";
		Connection con = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		Goods_ft goods_ft = null;
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, g_id);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				goods_ft = new Goods_ft(rs.getInt(1), rs.getInt(2),
						rs.getString(3));

			}
			return goods_ft;
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

}
