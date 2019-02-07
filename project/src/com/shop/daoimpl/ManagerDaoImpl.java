package com.shop.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shop.DBUtil.JDBCUtil;
import com.shop.beans.Manager;
import com.shop.dao.ManagerDao;

public class ManagerDaoImpl implements ManagerDao {

	// 1.添加管理员
	public boolean managerAdd(Manager manager) {
		Connection con = JDBCUtil.getConnection();
		String sql = "insert into manager(m_name,m_password,role) values(?,?,?);";
		PreparedStatement pstm = null;
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, manager.getM_name());
			pstm.setString(2, manager.getM_password());
			pstm.setInt(3, manager.getRole());
			pstm.executeUpdate();
			return true;
		} catch (SQLException e) {
			return false;
		} finally {
			JDBCUtil.close(null, pstm, con);
		}

	}

	// 2.修改管理员角色
	public boolean managerUpdate(Integer m_id, Integer role) {
		Manager manager = managerFindById(m_id);
		if (manager.getRole() == 1) {
			return false;
		} else {
			Connection con = JDBCUtil.getConnection();
			String sql = "update manager set role=? where m_id =?;";
			PreparedStatement pstm = null;
			try {
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, role);
				pstm.setInt(2, m_id);
				pstm.executeUpdate();
				return true;
			} catch (SQLException e) {
				return false;
			} finally {
				JDBCUtil.close(null, pstm, con);
			}
		}
	}

	// 3.根据m_id查看单个管理员
	public Manager managerFindById(Integer m_id) {
		String sql = "select m_id,m_name,m_password,role,m_del from manager where m_id=?";
		Connection con = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Manager manager = null;
		try {

			pstm = con.prepareStatement(sql);
			pstm.setInt(1, m_id);
			rs = pstm.executeQuery();
			while (rs.next()) {
				manager = new Manager(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getInt(4), rs.getInt(5));
			}
			return manager;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pstm, con);
		}
		return null;
	}

	// 4. 管理员逻辑删除
	public boolean managerDel(Integer m_id) {
		Manager manager = managerFindById(m_id);
		if (manager.getRole() == 1) {
			return false;
		} else {
			Connection con = JDBCUtil.getConnection();
			String sql = "update manager set m_del=0 where m_id=?;";
			PreparedStatement pstm = null;
			try {
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, m_id);
				pstm.executeUpdate();
				return true;
			} catch (SQLException e) {
				return false;
			} finally {
				JDBCUtil.close(null, pstm, con);
			}
		}
	}

	// 5. 查看所有管理员
	public List<Manager> managerFindAll(Integer m_id) {
		Connection con = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Manager manager = new Manager();
		int role = 0;
		String sql = "select role from manager where m_id=?;";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, m_id);
			rs = pstm.executeQuery();
			while (rs.next()) {
				role = rs.getInt(1);
			}
		} catch (SQLException e) {

		}
		List<Manager> list = new ArrayList<Manager>();
		if (role == 1) {
			String str1 = "select m_id,m_name,m_password,role,m_del from manager where m_del!=0;";
			try {
				pstm = con.prepareStatement(str1);
				rs = pstm.executeQuery();
				while (rs.next()) {
					manager = new Manager(rs.getInt("m_id"),
							rs.getString("m_name"), rs.getString("m_password"),
							rs.getInt("role"), rs.getInt("m_del"));
					list.add(manager);
				}
			} catch (SQLException e) {

			} finally {
				JDBCUtil.close(rs, pstm, con);
			}
		} else if (role == 2) {
			String str2 = "select m_id,m_name,m_password,role,m_del from manager where m_id=?;";
			try {
				pstm = con.prepareStatement(str2);
				pstm.setInt(1, m_id);
				rs = pstm.executeQuery();
				while (rs.next()) {
					manager = new Manager(rs.getInt("m_id"),
							rs.getString("m_name"), rs.getString("m_password"),
							rs.getInt("role"), rs.getInt("m_del"));

					list.add(manager);
				}
			} catch (SQLException e) {

			} finally {
				JDBCUtil.close(rs, pstm, con);
			}
		}
		return list;
	}

	// 6.管理员登录
	public Manager managerLogin(Manager manager) {
		Connection con = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String str = "select m_name,m_password from manager where m_name=?&&m_del!=0;";
		String m_name = null;
		String m_password = null;
		try {
			pstm = con.prepareStatement(str);
			pstm.setString(1, manager.getM_name());
			rs = pstm.executeQuery();
			while (rs.next()) {
				m_name = rs.getString("m_name");
				m_password = rs.getString("m_password");
			}
		} catch (SQLException e) {

		}
		if (manager.getM_name().equals(m_name)
				&& manager.getM_password().equals(m_password)) {
			String str1 = "select m_id,role,m_del from manager where m_name=?&&m_del!=0;";
			try {
				pstm = con.prepareStatement(str1);
				pstm.setString(1, manager.getM_name());
				rs = pstm.executeQuery();
				while (rs.next()) {
					manager.setM_id(rs.getInt("m_id"));
					manager.setRole(rs.getInt("role"));
					manager.setM_del(rs.getInt("m_del"));
				}
			} catch (SQLException e) {

			} finally {
				JDBCUtil.close(rs, pstm, con);
			}
			return manager;
		} else {
			return null;
		}
	}

	// 7.管理员修改密码
	public boolean managerUpdatePwd(Manager manager) {
		Connection con = JDBCUtil.getConnection();
		String sql = "update manager set m_password=? where m_id =?&&m_del!=0;";
		PreparedStatement pstm = null;
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, manager.getM_password());
			pstm.setInt(2, manager.getM_id());
			pstm.executeUpdate();
			return true;
		} catch (SQLException e) {
			return false;
		} finally {
			JDBCUtil.close(null, pstm, con);
		}
	}

	//  8.管理员注册帐号验证
	public boolean managerAddNameVerify(String m_name) {
		Connection con = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String str = "select m_id,m_name,m_password,role,m_del from manager where m_name=?;";
		try {
			pstm = con.prepareStatement(str);
			pstm.setString(1, m_name);
			rs = pstm.executeQuery();
			if (rs.next()) {
				return false;
			} else {
				return true;
			}
		} catch (SQLException e) {
			return false;
		} finally {
			JDBCUtil.close(rs, pstm, con);
		}

	}

}
