package com.shop.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shop.DBUtil.JDBCUtil;
import com.shop.beans.dto.SalesRank;
import com.shop.dao.SalesRankDao;

public class SalesRankDaoImpl implements SalesRankDao{

	public List<SalesRank> salesRank() {
		String sql = "select g_id,g_name,total_num from v_salesrank";
		Connection con = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		List<SalesRank> salesRanks = new ArrayList<SalesRank>();
		try {
			pstm = con.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				SalesRank salesRank = new SalesRank(rs.getInt(1), rs.getString(2),rs.getInt(3));
				salesRanks.add(salesRank);
			}
			return salesRanks;
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
