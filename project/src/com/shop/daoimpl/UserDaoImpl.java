package com.shop.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.shop.DBUtil.MD5;
import com.shop.DBUtil.JDBCUtil;
import com.shop.beans.Goods;
import com.shop.beans.User;
import com.shop.dao.UserDao;
import com.shop.page.PageList;

public class UserDaoImpl implements UserDao {
	// 查找所有用户
	public List<User> userfindall() {
		String sql = "select u_id,u_name,u_password,u_img,u_realname,u_idcard,u_sex,u_residence,u_birthday,u_phone,u_info,u_state,regist_time,login_time,regist_IP,login_IP,u_del from user where u_del=1";
		Connection con = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		List<User> users = new ArrayList<User>();
		try {
			pstm = con.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				User u = new User(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getString(8),
						rs.getDate(9), rs.getString(10), rs.getString(11),
						rs.getInt(12), rs.getDate(13), rs.getDate(14),
						rs.getString(15), rs.getString(16), rs.getInt(17));
				users.add(u);
			}
			return users;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("==");
		} finally {
			JDBCUtil.close(null, pstm, con);
		}

		return null;
	}

	// 查找单个用户
	public User userfindbyuId(Integer u_id) {
		// TODO Auto-generated method stub
		String sql = "select u_id,u_name,u_password,u_img,u_realname,u_idcard,u_sex,u_residence,u_birthday,u_phone,u_info,u_state,regist_time,login_time,regist_IP,login_IP,u_del from user where u_id=? and u_del=1";
		Connection con = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		User u = null;
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, u_id);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				u = new User(rs.getInt(1), rs.getString(2),
						MD5.parseStrToMd5(rs.getString(3)), rs.getString(4),
						rs.getString(5), MD5.parseStrToMd5(rs.getString(6)),
						rs.getInt(7), rs.getString(8), rs.getDate(9),
						rs.getString(10), rs.getString(11), rs.getInt(12),
						rs.getDate(13), rs.getDate(14), rs.getString(15),
						rs.getString(16), rs.getInt(17));

			}
			return u;
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

	// 根据手机号查找单个用户
	// 查找单个用户
	public User userfindbyPhone(String u_phone) {
		// TODO Auto-generated method stub
		String sql = "select u_id,u_name,u_password,u_img,u_realname,u_idcard,u_sex,u_residence,u_birthday,u_phone,u_info,u_state,regist_time,login_time,regist_IP,login_IP,u_del from user where u_phone=? and u_del=1";
		Connection con = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		User u = null;
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, u_phone);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				u = new User(rs.getInt(1), rs.getString(2),
						MD5.parseStrToMd5(rs.getString(3)), rs.getString(4),
						rs.getString(5), MD5.parseStrToMd5(rs.getString(6)),
						rs.getInt(7), rs.getString(8), rs.getDate(9),
						rs.getString(10), rs.getString(11), rs.getInt(12),
						rs.getDate(13), rs.getDate(14), rs.getString(15),
						rs.getString(16), rs.getInt(17));

			}
			return u;
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

	// 用户逻辑删除
	public boolean updateUserDel(User user) {
		// TODO Auto-generated method stub
		String sql = "update user set u_del=0 where u_id=?";
		Connection con = JDBCUtil.getConnection();
		PreparedStatement pstm = null;

		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, user.getU_id());
			int i = pstm.executeUpdate();
			if (i > 0) {
				// System.out.println("修改成功");
				return true;
			} else {
				// System.out.println("修改失败");
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pstm, con);
		}
		return false;
	}

	// 用户注册
	public boolean userRegister(User user) {
		// TODO Auto-generated method stub
		String sql = "insert into user(u_name,u_password,u_phone) values(?,?,?)";
		Connection con = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, user.getU_name());
			pstm.setString(2, MD5.parseStrToMd5(user.getU_password()));
			pstm.setString(3, user.getU_phone());
			int i = pstm.executeUpdate();
			if (i > 0) {
				System.out.println("注册成功");
				return true;
			} else {
				System.out.println("注册失败");
				return false;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pstm, con);
		}
		return false;
	}

	// 用户登录
	public User userLogin(User user) {
		// TODO Auto-generated method stub
		String sql = "select u_id,u_name,u_password,u_img,u_realname,u_idcard,u_sex,u_residence,u_birthday,u_phone,u_info,u_state,regist_time,login_time,regist_IP,login_IP,u_del from user where u_phone=? and u_password=? and u_del=1";
		Connection con = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		User u = null;
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, user.getU_phone());
			pstm.setString(2, MD5.parseStrToMd5(user.getU_password()));
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				u = new User(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6),
						rs.getInt(7), rs.getString(8), rs.getDate(9),
						rs.getString(10), rs.getString(11), rs.getInt(12),
						rs.getDate(13), rs.getDate(14), rs.getString(15),
						rs.getString(16), rs.getInt(17));

			}
			return u;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("===");
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pstm, con);
		}
		return null;
	}

	// 用户修改个人资料
	public boolean userUpdate(User user) {
		// TODO Auto-generated method stub
		String sql = "update user set u_realname=?,u_sex=?,u_birthday=?,u_info=? where u_id =?";
		java.sql.Date date = new java.sql.Date(user.getU_birthday().getTime());// 进行日期的转换
		Connection con = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, user.getU_realname());
			pstm.setInt(2, user.getU_sex());
			pstm.setDate(3, date);
			pstm.setString(4, user.getU_info());
			pstm.setInt(5, user.getU_id());
			pstm.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.close(null, pstm, con);
		}

	}

	// 用户修改个人头像
	public boolean userHeadShotUpdate(User user) {
		Connection con = JDBCUtil.getConnection();
		PreparedStatement pstm = null;

		String str = "update user set u_img=? where u_id =?;";
		try {
			pstm = con.prepareStatement(str);
			pstm.setString(1, user.getU_img());
			pstm.setInt(2, user.getU_id());
			pstm.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("===");
			return false;
		} finally {
			JDBCUtil.close(null, pstm, con);
		}
	}

	// 用户注册验证帐号名是否已经被注册
	public boolean userFindbyName(String username) {
		Connection con = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String str = "select u_id,u_name,u_password,u_img,u_realname,u_idcard,u_sex,u_residence,u_birthday,u_phone,u_info,u_state,regist_time,login_time,regist_IP,login_IP,u_del from user where u_name=? or u_phone=?;";
		try {
			pstm = con.prepareStatement(str);
			pstm.setString(1, username);
			pstm.setString(2, username);
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

	// 用户修改密码
	public boolean userUpdatepsw(User user) {
		Connection con = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		String str = "update user set u_password=? where u_id =?;";
		try {
			pstm = con.prepareStatement(str);
			pstm.setString(1, user.getU_password());
			pstm.setInt(2, user.getU_id());
			pstm.executeUpdate();
			return true;
		} catch (SQLException e) {
			return false;
		} finally {
			JDBCUtil.close(null, pstm, con);
		}
	}

	// 用户修改绑定手机号
	public boolean userUpdatephone(User user) {
		Connection con = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		String str = "update user set u_phone=? where u_id =?;";
		try {
			pstm = con.prepareStatement(str);
			pstm.setString(1, user.getU_phone());
			pstm.setInt(2, user.getU_id());
			pstm.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.close(null, pstm, con);
		}

	}

	// 分页
	public PageList<User> PageFuzzySelectUser(User user, int currentPage,
			int pageSize) {
		PageList<User> page = null;// 待会再返回结果的时候进行实例化
		List<Object> paramList = new ArrayList<Object>();// 含有关键字字段的所有名称 list

		// 获取参数----输入框中传输过来的参数
		String u_name = user.getU_name();

		// 定义两个sql语句：负责查询数据
		StringBuffer sql = new StringBuffer(
				"select u_id,u_name,u_password,u_img,u_realname,u_idcard,u_sex,u_residence,u_birthday,u_phone,u_info,u_state,regist_time,login_time,regist_IP,login_IP,u_del from user where 1=1");
		// 负责统计数据
		StringBuffer countSql = new StringBuffer(
				"select count(u_id)  as totalRecord from user where 1=1");
		// 根据用户名查询
		if (u_name != null && !"".equals(u_name)) {// 表示编号这个参数不为空
			sql.append(" and u_name like ?");// 给查询语句进行参数的拼接
			countSql.append(" and u_name like ?");// 给统计语句进行参数的拼接
			paramList.add("%" + u_name + "%");// 实际参数
		}
		sql.append(" and u_del=1  order By u_id ASC");
		// System.out.println(sql);
		// System.out.println(countSql);
		// 查询的起始索引
		int fromIndex = pageSize * (currentPage - 1);

		// 使用limit关键字实现分页
		sql.append(" limit " + fromIndex + "," + pageSize);
		// System.out.println(sql);
		// 定义一个集合存放所有查询出来的对象
		List<User> usersList = new ArrayList<User>();

		// 实例化数据库查询的对象
		JDBCUtil jdbcUtil = new JDBCUtil();

		try {
			// 获取总的记录
			List<Map<String, Object>> countResult = jdbcUtil.findResults(
					countSql.toString(), paramList);
			int totalRecord = Integer.parseInt(countResult.get(0)
					.get("totalRecord").toString());
			// System.out.println(totalRecord);
			// 获取查询的订单的对象的集合
			List<Map<String, Object>> usersResult = jdbcUtil.findResults(
					sql.toString(), paramList);
			// System.out.println(goodsResult);
			if (usersResult != null) {
				for (Map<String, Object> map : usersResult) {// 将Map中保存的数据转换成user对象
					User user1 = new User();
					user1.setU_id(Integer.parseInt(map.get("u_id").toString()));
					user1.setU_name(map.get("u_name").toString());
					user1.setU_password(MD5.parseStrToMd5(map.get("u_password")
							.toString()));
					user1.setU_img(map.get("u_img").toString());
					user1.setU_realname(map.get("u_realname").toString());
					user1.setU_idcard(MD5.parseStrToMd5(map.get("u_idcard")
							.toString()));
					user1.setU_sex(Integer
							.parseInt(map.get("u_sex").toString()));
					user1.setU_residence(map.get("u_residence").toString());
					user1.setU_birthday_date(map.get("u_birthday").toString());
					user1.setU_phone(map.get("u_phone").toString());
					user1.setU_info(map.get("u_info").toString());
					user1.setU_state(Integer.parseInt(map.get("u_state")
							.toString()));
					user1.setU_regist_time(map.get("regist_time").toString());
					user1.setU_login_time(map.get("login_time").toString());
					user1.setRegist_IP(map.get("regist_IP").toString());
					user1.setLogin_IP(map.get("login_IP").toString());
					user1.setU_del(Integer
							.parseInt(map.get("u_del").toString()));

					usersList.add(user1);
				}
			}
			// 获取总的页数
			int totalPage = totalRecord / pageSize;
			if (totalRecord % pageSize != 0) {
				totalPage += 1;// 总页数加1
			}
			// 进行Page对象的组装
			page = new PageList<User>(pageSize, currentPage, totalRecord,
					totalPage, usersList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return page;
	}

	public boolean addVertifyCode(String phone, String phoneCode) {
		// TODO Auto-generated method stub
		String sql = "select phonecode from user where u_phone=? and u_del=1";
		Connection con = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		PreparedStatement pstm1 = null;
		PreparedStatement pstm2 = null;
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, phoneCode);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				String sql1 = "update user set phonecode=? where u_phone=? and u_del=1";

				try {
					pstm1 = con.prepareStatement(sql1);
					pstm1.setString(1, phoneCode);
					int i = pstm1.executeUpdate();
					if (i > 0) {
						return true;
					} else {
						return false;
					}
				} catch (SQLException e) {
					e.printStackTrace();
					return false;
				} finally {
					JDBCUtil.close(null, pstm, con);
				}

			}

		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			JDBCUtil.close(null, pstm, con);
		}
		return false;

	}

	public boolean addVertifyCode2(String phone, String phoneCode) {
		// TODO Auto-generated method stub
		String sql = "select phonecode from phone_vertify where phone=?";
		Connection con = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		PreparedStatement pstm1 = null;
		PreparedStatement pstm2 = null;
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, phone);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				String sql1 = "update phone_vertify set phonecode=? where phone=?";

				try {
					pstm1 = con.prepareStatement(sql1);
					pstm1.setString(1, phoneCode);
					pstm1.setString(2, phone);
					int i = pstm1.executeUpdate();
					if (i > 0) {
						return true;
					} else {
						return false;
					}
				} catch (SQLException e) {
					e.printStackTrace();
					return false;
				} finally {
					JDBCUtil.close(null, pstm, con);
				}
			} else {
				String sql2 = "insert into phone_vertify(phone,phonecode) values(?,?)";

				try {
					pstm2 = con.prepareStatement(sql2);
					pstm2.setString(1, phone);
					pstm2.setString(2, phoneCode);

					int i = pstm2.executeUpdate();
					if (i > 0) {
						return true;
					} else {
						return false;
					}

				} catch (SQLException e) {
					e.printStackTrace();
					return false;
				} finally {
					JDBCUtil.close(null, pstm, con);
				}

			}

		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			JDBCUtil.close(null, pstm, con);
		}
		return false;

	}

	public String findVertifyCode(String phone) {
		String sql = "select phonecode from user where u_phone=? and u_del=1";
		Connection con = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		PreparedStatement pstm1 = null;
		String phoneCode = null;
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, phone);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				phoneCode = rs.getString(1);

			} else {
				String sql1 = "select phonecode from phone_vertify where phone=?";
				pstm1 = con.prepareStatement(sql1);
				pstm1.setString(1, phone);
				ResultSet rs1 = pstm1.executeQuery();
				if (rs1.next()) {
					phoneCode = rs1.getString(1);
				}
			}
			return phoneCode;
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
