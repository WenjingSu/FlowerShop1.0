package com.shop.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.shop.DBUtil.JDBCUtil;
import com.shop.beans.FlowerUse;
import com.shop.dao.FlowerUseDao;
import com.shop.page.PageList;

public class FlowerUseDaoImpl implements FlowerUseDao {
    //查找所有用途
	public List<FlowerUse> FlowerUseFindAll() {
		String sql = "select floUse_id,floUse_name,floUse_del,floUse_img from floweruse where floUse_del=1";

		Connection con = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		List<FlowerUse> flowerUses = new ArrayList<FlowerUse>();
		try {
			pstm = con.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				FlowerUse flowerUse = new FlowerUse(rs.getInt(1),
						rs.getString(2), rs.getInt(3),rs.getString(4));
				flowerUses.add(flowerUse);
			}
			return flowerUses;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("==");
		} finally {
			JDBCUtil.close(null, pstm, con);
		}

		return null;
	}
	//查找部分用途
		public List<FlowerUse> FlowerUseFindAllLimit() {
			String sql = "select floUse_id,floUse_name,floUse_del,floUse_img from floweruse where floUse_del=1 limit 10";

			Connection con = JDBCUtil.getConnection();
			PreparedStatement pstm = null;
			List<FlowerUse> flowerUses = new ArrayList<FlowerUse>();
			try {
				pstm = con.prepareStatement(sql);
				ResultSet rs = pstm.executeQuery();
				while (rs.next()) {
					FlowerUse flowerUse = new FlowerUse(rs.getInt(1),
							rs.getString(2), rs.getInt(3),rs.getString(4));
					flowerUses.add(flowerUse);
				}
				return flowerUses;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("==");
			} finally {
				JDBCUtil.close(null, pstm, con);
			}

			return null;
		}
    //分页
	public PageList<FlowerUse> PageFuzzySelectFlowerUse(FlowerUse flowerUse,
			int currentPage, int pageSize) {
		PageList<FlowerUse> page = null;// 待会再返回结果的时候进行实例化
		List<Object> paramList = new ArrayList<Object>();// 含有关键字字段的所有名称 list

		// 获取参数----输入框中传输过来的参数
		String floUse_name = flowerUse.getFloUse_name();

		// 定义两个sql语句：负责查询数据
		StringBuffer sql = new StringBuffer(
				"select floUse_id,floUse_name,floUse_del,floUse_img from floweruse where 1=1");
		// 负责统计数据
		StringBuffer countSql = new StringBuffer(
				"select count(floUse_id)  as totalRecord from floweruse where 1=1");
		// 根据用户名查询
		if (floUse_name != null && !"".equals(floUse_name)) {// 表示编号这个参数不为空
			sql.append(" and floUse_name like ?");// 给查询语句进行参数的拼接
			countSql.append(" and floUse_name like ?");// 给统计语句进行参数的拼接
			paramList.add("%" + floUse_name + "%");// 实际参数
		}
		sql.append(" and floUse_del=1  order By floUse_id ASC");
		// System.out.println(sql);
		// System.out.println(countSql);
		// 查询的起始索引
		int fromIndex = pageSize * (currentPage - 1);

		// 使用limit关键字实现分页
		sql.append(" limit " + fromIndex + "," + pageSize);
		// System.out.println(sql);
		// 定义一个集合存放所有查询出来的对象
		List<FlowerUse> flowerUsesList = new ArrayList<FlowerUse>();

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
			List<Map<String, Object>> flowerUsesResult = jdbcUtil.findResults(
					sql.toString(), paramList);
			// System.out.println(goodsResult);
			if (flowerUsesResult != null) {
				for (Map<String, Object> map : flowerUsesResult) {// 将Map中保存的数据转换成user对象
					FlowerUse flowerUse1 = new FlowerUse();
					flowerUse1.setFloUse_id(Integer.parseInt(map.get(
							"floUse_id").toString()));
					flowerUse1
							.setFloUse_name(map.get("floUse_name").toString());
					flowerUse1.setFloUse_del(Integer.parseInt(map.get(
							"floUse_del").toString()));
					flowerUse1.setFloUse_img(map.get("floUse_img").toString());
					flowerUsesList.add(flowerUse1);
				}
			}
			// 获取总的页数
			int totalPage = totalRecord / pageSize;
			if (totalRecord % pageSize != 0) {
				totalPage += 1;// 总页数加1
			}
			// 进行Page对象的组装
			page = new PageList<FlowerUse>(pageSize, currentPage, totalRecord,
					totalPage, flowerUsesList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return page;
	}
    //根据id查找单个用途
	public FlowerUse flowerUsefindbyId(Integer floUse_id) {
		// TODO Auto-generated method stub
		String sql = "select floUse_id,floUse_name,floUse_del,floUse_img from floweruse where floUse_id=? and floUse_del=1";
		Connection con = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		FlowerUse flowerUse = null;
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, floUse_id);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				flowerUse = new FlowerUse(rs.getInt(1), rs.getString(2),
						rs.getInt(3),rs.getString(4));

			}
			return flowerUse;
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
    //用途逻辑删除
	public boolean updateFlowerUseDel(FlowerUse flowerUse) {
		// TODO Auto-generated method stub
		String sql = "update floweruse set floUse_del=0 where floUse_id=?";
		Connection con = JDBCUtil.getConnection();
		PreparedStatement pstm = null;

		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, flowerUse.getFloUse_id());
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
    //添加新用途
	public boolean addFlowerUse(FlowerUse flowerUse) {
		Connection con = JDBCUtil.getConnection();
		String sql = "insert into flowerUse (floUse_name) values(?)";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, flowerUse.getFloUse_name());
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
    //根据名字查找单个用途
	public boolean flowerUsefindbyName(String floUse_name) {
		Connection con = JDBCUtil.getConnection();
		String sql = "select floUse_id,floUse_name,floUse_del from flowerUse where floUse_name = ?";
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, floUse_name);
			rs = pstm.executeQuery();
			while (rs.next()) {
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		} finally {
			JDBCUtil.close(rs, pstm, con);
		}
		return false;
	}
    //修改用途信息
	public boolean flowerUseUpdate(FlowerUse flowerUse) {
		Connection con = JDBCUtil.getConnection();
		String sql = "update flowerUse set floUse_name=? where floUse_id =?";
		PreparedStatement pstm = null;
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, flowerUse.getFloUse_name());
			pstm.setInt(2, flowerUse.getFloUse_id());
			int i = pstm.executeUpdate();
			if (i > 0) {
				return true;
			} else {
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
	//修改用途信息 ：用途名验证
	public boolean flowerUseUpdateVertify(String floUse_name,
			String floUse_name_old) {
		Connection con = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		if (!floUse_name.equals(floUse_name_old)) {
			String sql = "select floUse_id,floUse_name,floUse_del from flowerUse where floUse_name=?;";
			try {
				pstm = con.prepareStatement(sql);
				pstm.setString(1, floUse_name);
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
		return true;
	}

}
