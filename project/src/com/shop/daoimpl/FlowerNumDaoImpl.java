package com.shop.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.shop.DBUtil.JDBCUtil;
import com.shop.beans.FlowerNum;
import com.shop.dao.FlowerNumDao;
import com.shop.page.PageList;

public class FlowerNumDaoImpl implements FlowerNumDao {
	// 查找所有
	public List<FlowerNum> FlowerNumFindAll() {
		String sql = "select floNum_id,floNum_name,floNum_mean,floNum_del from flowernum where floNum_del=1";

		Connection con = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		List<FlowerNum> flowerNums = new ArrayList<FlowerNum>();
		try {
			pstm = con.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				FlowerNum flowerNum = new FlowerNum(rs.getInt(1),
						rs.getString(2), rs.getString(3), rs.getInt(4));
				flowerNums.add(flowerNum);
			}
			return flowerNums;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("==");
		} finally {
			JDBCUtil.close(null, pstm, con);
		}

		return null;
	}

	// 分页
	public PageList<FlowerNum> PageFuzzySelectFlowerNum(FlowerNum flowerNum,
			int currentPage, int pageSize) {
		PageList<FlowerNum> page = null;// 待会再返回结果的时候进行实例化
		List<Object> paramList = new ArrayList<Object>();// 含有关键字字段的所有名称 list

		// 获取参数----输入框中传输过来的参数
		String floNum_name = flowerNum.getFloNum_name();

		// 定义两个sql语句：负责查询数据
		StringBuffer sql = new StringBuffer(
				"select floNum_id,floNum_name,floNum_mean,floNum_del from flowernum where 1=1");
		// 负责统计数据
		StringBuffer countSql = new StringBuffer(
				"select count(floNum_id)  as totalRecord from flowerNum where 1=1");
		// 根据用户名查询
		if (floNum_name != null && !"".equals(floNum_name)) {// 表示编号这个参数不为空
			sql.append(" and floNum_name like ?");// 给查询语句进行参数的拼接
			countSql.append(" and floNum_name like ?");// 给统计语句进行参数的拼接
			paramList.add("%" + floNum_name + "%");// 实际参数
		}
		sql.append(" and floNum_del=1  order By floNum_id ASC");
		// System.out.println(sql);
		// System.out.println(countSql);
		// 查询的起始索引
		int fromIndex = pageSize * (currentPage - 1);

		// 使用limit关键字实现分页
		sql.append(" limit " + fromIndex + "," + pageSize);
		// System.out.println(sql);
		// 定义一个集合存放所有查询出来的对象
		List<FlowerNum> flowerNumsList = new ArrayList<FlowerNum>();

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
			List<Map<String, Object>> flowerNumsResult = jdbcUtil.findResults(
					sql.toString(), paramList);
			// System.out.println(goodsResult);
			if (flowerNumsResult != null) {
				for (Map<String, Object> map : flowerNumsResult) {// 将Map中保存的数据转换成user对象
					FlowerNum flowerNum1 = new FlowerNum();
					flowerNum1.setFloNum_id(Integer.parseInt(map.get(
							"floNum_id").toString()));
					flowerNum1
							.setFloNum_name(map.get("floNum_name").toString());
					flowerNum1
							.setFloNum_mean(map.get("floNum_mean").toString());
					flowerNum1.setFloNum_del(Integer.parseInt(map.get(
							"floNum_del").toString()));
					flowerNumsList.add(flowerNum1);
				}
			}
			// 获取总的页数
			int totalPage = totalRecord / pageSize;
			if (totalRecord % pageSize != 0) {
				totalPage += 1;// 总页数加1
			}
			// 进行Page对象的组装
			page = new PageList<FlowerNum>(pageSize, currentPage, totalRecord,
					totalPage, flowerNumsList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return page;
	}

	// 根据id查找单个
	public FlowerNum flowerNumfindbyId(Integer floNum_id) {
		// TODO Auto-generated method stub
		String sql = "select floNum_id,floNum_name,floNum_mean,floNum_del from flowernum where floNum_id=? and floNum_del=1";
		Connection con = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		FlowerNum flowerNum = null;
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, floNum_id);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				flowerNum = new FlowerNum(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getInt(4));

			}
			return flowerNum;
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

	// 逻辑删除
	public boolean updateFlowerNumDel(FlowerNum flowerNum) {
		// TODO Auto-generated method stub
		String sql = "update flowernum set floNum_del=0 where floNum_id=?";
		Connection con = JDBCUtil.getConnection();
		PreparedStatement pstm = null;

		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, flowerNum.getFloNum_id());
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

	// 添加新枝数
	public boolean addFlowerNum(FlowerNum flowerNum) {
		Connection con = JDBCUtil.getConnection();
		String sql = "insert into flowernum (floNum_name,floNum_mean) values(?,?)";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, flowerNum.getFloNum_name());
			ps.setString(2, flowerNum.getFloNum_mean());
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

	// 根据名字查找枝数
	public boolean flowerNumfindbyName(String floNum_name) {
		Connection con = JDBCUtil.getConnection();
		String sql = "select floNum_id,floNum_name,floNum_mean,floNum_del from flowernum where floNum_name = ?";
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, floNum_name);
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

	// 修改信息
	public boolean flowerNumUpdate(FlowerNum flowerNum) {
		Connection con = JDBCUtil.getConnection();
		String sql = "update flowernum set floNum_name=?,floNum_mean=? where floNum_id =?";
		PreparedStatement pstm = null;
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, flowerNum.getFloNum_name());
			pstm.setString(2, flowerNum.getFloNum_mean());
			pstm.setInt(3, flowerNum.getFloNum_id());
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

	// 修改信息名字验证
	public boolean flowerNumUpdateVertify(String floNum_name,
			String floNum_name_old) {
		Connection con = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		if (!floNum_name.equals(floNum_name_old)) {
			String sql = "select floNum_id,floNum_name,floNum_mean,floNum_del from flowernum where floNum_name=?;";
			try {
				pstm = con.prepareStatement(sql);
				pstm.setString(1, floNum_name);
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
