package com.shop.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shop.DBUtil.JDBCUtil;
import com.shop.beans.dto.PriceRank;
import com.shop.dao.PriceRankDao;

public class PriceDaoImpl implements PriceRankDao{

	public List<PriceRank> priceRank() {
		String sql = "select g_id,g_name,total_price from v_total_price";
		Connection con = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		List<PriceRank> pricesRanks = new ArrayList<PriceRank>();
		try {
			pstm = con.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				PriceRank priceRank = new PriceRank(rs.getInt(1), rs.getString(2),rs.getDouble(3));
				pricesRanks.add(priceRank);
			}
			return pricesRanks;
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
