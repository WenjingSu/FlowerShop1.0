package com.shop.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shop.DBUtil.JDBCUtil;
import com.shop.beans.Address;
import com.shop.dao.AddressDao;

public class AddressDaoImpl implements AddressDao{

	public boolean addressAdd(Address address) {
		Connection con = JDBCUtil.getConnection();
		String sql = "insert into Address (u_id,address,postcode,consignee_name,consignee_tel,add_memo) values(?,?,?,?,?,?)";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, address.getU_id());
			ps.setString(2, address.getAddress());
			ps.setString(3, address.getPostcode());
			ps.setString(4, address.getConsignee_name());
			ps.setString(5, address.getConsignee_tel());
			ps.setString(6, address.getAdd_memo());
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

	public boolean addressDel(Integer add_id) {
		String sql = "update address set add_del=0 where add_id=?";
		Connection con = JDBCUtil.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, add_id);
			int i = stmt.executeUpdate();
			if (i > 0) {
				return true;
			} else
				return false;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, stmt, con);
		}
		return false;
	}

	public boolean addressUpdate(Integer add_id, Address address) {
		Connection con = JDBCUtil.getConnection();
		String sql = "update address set address=?,postcode=?,consignee_name=?,consignee_tel=? where add_id=?  ";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, address.getAddress());
			ps.setString(2, address.getPostcode());
			ps.setString(3, address.getConsignee_name());
			ps.setString(4, address.getConsignee_tel());
			ps.setInt(5, add_id);
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

	public List<Address> addressFindAll(Integer u_id) {
		Connection con = JDBCUtil.getConnection();
		String sql = "select add_id,u_id,address,postcode,consignee_name,consignee_tel,add_del,add_memo from address  where u_id=? and add_del=1";
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Address> list = new ArrayList<Address>();
		Address address = null;
		try {
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, u_id);
			rs = ps.executeQuery();
			while (rs.next()) {
				address = new Address(rs.getInt(1), rs.getInt(2), rs.getString(3),
						rs.getString(4),rs.getString(5), rs.getString(6),
						rs.getInt(7),rs.getString(8));
				list.add(address);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, ps, con);
		}
		return null;
	}

	

}
