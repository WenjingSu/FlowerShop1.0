package com.shop.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.shop.DBUtil.JDBCUtil;
import com.shop.beans.Goods;
import com.shop.beans.dto.GoodsDetail;
import com.shop.dao.GoodsDao;
import com.shop.page.PageList;

public class GoodsDaoImpl implements GoodsDao {
	// 添加商品基本信息（不包括图片）
	public boolean goodsAdd(Goods good) {
		Connection con = JDBCUtil.getConnection();
		String sql = "insert into goods (g_name,gt_id,floNum_id,purchasing_price,original_price,goods_price,g_info,amount) values(?,?,?,?,?,?,?,?)";
		PreparedStatement pstm = null;
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, good.getG_name());
			pstm.setInt(2, good.getGt_id());
			pstm.setInt(3, good.getFloNum_id());
			pstm.setDouble(4, good.getPurchasing_price());
			pstm.setDouble(5, good.getOriginal_price());
			pstm.setDouble(6, good.getGoods_price());
			pstm.setString(7, good.getG_info());
			pstm.setInt(8, good.getAmount());
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

	// 修改商品基本信息（不包括图片）
	public boolean goodsUpdate(Goods good) {
		Connection con = JDBCUtil.getConnection();
		String sql = "update goods set g_name=?,gt_id=?,floNum_id=?,purchasing_price=?,original_price=?,goods_price=?,g_info=?,amount=? where g_id =?";
		PreparedStatement pstm = null;
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, good.getG_name());
			pstm.setInt(2, good.getGt_id());
			pstm.setInt(3, good.getFloNum_id());
			pstm.setDouble(4, good.getPurchasing_price());
			pstm.setDouble(5, good.getOriginal_price());
			pstm.setDouble(6, good.getGoods_price());
			pstm.setString(7, good.getG_info());
			pstm.setInt(8, good.getAmount());
			pstm.setInt(9, good.getG_id());
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

	// 查找商品基本信息（包括图片）
	public List<Goods> goodsFindAll() {
		Connection con = JDBCUtil.getConnection();
		String sql = "select g_id,g_name,gt_id,floNum_id,purchasing_price,original_price,goods_price,g_imgurl,putaway_time,g_state,g_info,amount,g_del from goods where g_del!=0 order by g_id desc";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<Goods> list = new ArrayList<Goods>();
		Goods goods = null;
		try {
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				goods = new Goods(rs.getInt(1), rs.getString(2), rs.getInt(3),
						rs.getInt(4), rs.getDouble(5), rs.getDouble(6),
						rs.getDouble(7), rs.getString(8), rs.getDate(9),
						rs.getInt(10), rs.getString(11), rs.getInt(12),
						rs.getInt(13));
				list.add(goods);
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

	// 根据商品id查询单个商品基本信息（包括图片）
	public Goods goodsFindByGid(Integer g_id) {
		Connection con = JDBCUtil.getConnection();
		String sql = "select g_id,g_name,gt_id,floNum_id,purchasing_price,original_price,goods_price,g_imgurl,putaway_time,g_state,g_info,amount,g_del from goods where g_id = ?";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Goods good = null;
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, g_id);
			rs = pstm.executeQuery();
			while (rs.next()) {
				good = new Goods(rs.getInt(1), rs.getString(2), rs.getInt(3),
						rs.getInt(4), rs.getDouble(5), rs.getDouble(6),
						rs.getDouble(7), rs.getString(8), rs.getDate(9),
						rs.getInt(10), rs.getString(11), rs.getInt(12),
						rs.getInt(13));
			}
			return good;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstm, con);
		}
		return null;
	}

	// 查询回收站里的商品
	public List<Goods> goodsFindAlreadyDel() {
		Connection con = JDBCUtil.getConnection();
		String sql = "select g_id,g_name,gt_id,floNum_id,purchasing_price,original_price,goods_price,g_imgurl,putaway_time,g_state,g_info,amount,g_del from goods where g_del=0";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<Goods> goods = new ArrayList<Goods>();
		Goods good = null;
		try {
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				good = new Goods(rs.getInt(1), rs.getString(2), rs.getInt(3),
						rs.getInt(4), rs.getDouble(5), rs.getDouble(6),
						rs.getDouble(7), rs.getString(8), rs.getDate(9),
						rs.getInt(10), rs.getString(11), rs.getInt(12),
						rs.getInt(13));
				goods.add(good);
			}
			return goods;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstm, con);
		}
		return null;
	}

	// 模糊查询
	public PageList<Goods> PageFuzzySelectGoods(Goods good, int currentPage,
			int pageSize) {
		PageList<Goods> page = null;// 待会再返回结果的时候进行实例化
		List<Object> paramList = new ArrayList<Object>();// 含有关键字字段的所有名称 list

		// 获取参数----输入框中传输过来的参数
		String g_name = good.getG_name();
		Integer g_state = good.getG_state();
		// 定义两个sql语句：负责查询数据
		StringBuffer sql = new StringBuffer(
				"select g_id,g_name,gt_id,floNum_id,purchasing_price," +
				"original_price,goods_price,g_imgurl,putaway_time,g_state,g_info,amount,g_del from goods where 1=1");
		// 负责统计数据
		StringBuffer countSql = new StringBuffer(
				"select count(g_id)  as totalRecord from goods where 1=1");
		// 前台只查询已上架的商品
		if (g_state != null) {
			sql.append(" and g_state = ?");// 给查询语句进行参数的拼接
			countSql.append(" and g_state = ?");// 给统计语句进行参数的拼接
			paramList.add(g_state);// 实际参数
		}
		// 根据商品名查询
		if (g_name != null && !"".equals(g_name)) {// 表示编号这个参数不为空
			sql.append(" and g_name like ?");// 给查询语句进行参数的拼接
			countSql.append(" and g_name like ?");// 给统计语句进行参数的拼接
			paramList.add("%" + g_name + "%");// 实际参数
		}
		sql.append(" and g_del=1  order By g_id DESC");
		// System.out.println(sql);
		// System.out.println(countSql);
		// 查询的起始索引
		int fromIndex = pageSize * (currentPage - 1);

		// 使用limit关键字实现分页
		sql.append(" limit " + fromIndex + "," + pageSize);
		// System.out.println(sql);
		// 定义一个集合存放所有查询出来的对象
		List<Goods> goodsList = new ArrayList<Goods>();

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
			List<Map<String, Object>> goodsResult = jdbcUtil.findResults(
					sql.toString(), paramList);
			// System.out.println(goodsResult);
			if (goodsResult != null) {
				for (Map<String, Object> map : goodsResult) {// 将Map中保存的数据转换成Student对象
					Goods goods = new Goods();

					goods.setG_id(Integer.parseInt(map.get("g_id").toString()));
					goods.setG_name(map.get("g_name").toString());
					goods.setGt_id(Integer
							.parseInt(map.get("gt_id").toString()));
					goods.setFloNum_id(Integer.parseInt(map.get("floNum_id")
							.toString()));
					goods.setPurchasing_price(Double.parseDouble("".equals(map
							.get("purchasing_price").toString()) ? "0.00" : map
							.get("purchasing_price").toString()));

					goods.setOriginal_price(Double.parseDouble("".equals(map
							.get("original_price").toString()) ? "0.00" : map
							.get("original_price").toString()));
					goods.setGoods_price(Double.parseDouble("".equals(map.get(
							"goods_price").toString()) ? "0.00" : map.get(
							"goods_price").toString()));

					goods.setG_imgurl(map.get("g_imgurl").toString());
					goods.setG_putaway_time(map.get("putaway_time").toString());
					goods.setG_state(Integer.parseInt(map.get("g_state")
							.toString()));
					goods.setG_info(map.get("g_info").toString());
					goods.setAmount(Integer.parseInt(map.get("amount")
							.toString()));
					goods.setG_del(Integer
							.parseInt(map.get("g_del").toString()));
					goodsList.add(goods);
				}
			}
			// 获取总的页数
			int totalPage = totalRecord / pageSize;
			if (totalRecord % pageSize != 0) {
				totalPage += 1;// 总页数加1
			}
			// 进行Page对象的组装
			page = new PageList<Goods>(pageSize, currentPage, totalRecord,
					totalPage, goodsList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return page;
	}

	// 是否有name为？的商品
	public boolean goodsFindByGname(String g_name) {
		Connection con = JDBCUtil.getConnection();
		String sql = "select g_id,g_name,gt_id,floNum_id,purchasing_price,original_price,goods_price,g_imgurl,putaway_time,g_state,g_info,amount,g_del from goods where g_name = ?";
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, g_name);
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

	// 商品修改商品名验证
	public boolean goodUpdateNameVerify(String g_name, String g_nameold) {
		Connection con = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		if (!g_name.equals(g_nameold)) {
			String sql = "select g_id,g_name,gt_id,floNum_id,purchasing_price,original_price,goods_price,g_imgurl,putaway_time,g_state,g_info,amount,g_del from goods where g_name=?;";
			try {
				pstm = con.prepareStatement(sql);
				pstm.setString(1, g_name);
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

	// 商品删除
	public boolean goodsUpdateDel(Goods good) {
		Connection con = JDBCUtil.getConnection();
		String sql = "update goods set g_del=? where g_id =?";
		PreparedStatement pstm = null;
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, good.getG_del());
			pstm.setInt(2, good.getG_id());
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

	// 查看商品图片
	public String image(Integer g_id) {
		String sql = "select g_imgurl from goods where g_id=?";

		Connection con = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		String image = null;

		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, g_id);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				image = rs.getString(1);
			}
			return image;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("==");
		} finally {
			JDBCUtil.close(null, pstm, con);
		}

		return null;
	}

	// 上传商品图片
	public boolean goodsImgUpload(Goods good) {
		Connection con = JDBCUtil.getConnection();
		String sql = "update goods set g_imgurl=? where g_id=?";
		PreparedStatement pstm = null;
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, good.getG_imgurl());
			pstm.setInt(2, good.getG_id());
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

	// 上架、下架
	public boolean goodsUpdateState(Goods good) {
		Connection con = JDBCUtil.getConnection();
		String sql = "update goods set g_state=? where g_id = ?";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);

			ps.setInt(1, good.getG_state());
			ps.setInt(2, good.getG_id());
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

	public List<GoodsDetail> goodsFindByftid(Integer fid) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Goods> goodsFindByGtid(Integer gt_id) {
		Connection con = JDBCUtil.getConnection();
		String sql = "select g_id,g_name,gt_id,floNum_id,purchasing_price,original_price,goods_price,g_imgurl,putaway_time,g_state,g_info,amount,g_del from goods where g_del!=0 and gt_id=? order by g_id desc";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<Goods> list = new ArrayList<Goods>();
		Goods goods = null;
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, gt_id);
			rs = pstm.executeQuery();
			while (rs.next()) {
				goods = new Goods(rs.getInt(1), rs.getString(2), rs.getInt(3),
						rs.getInt(4), rs.getDouble(5), rs.getDouble(6),
						rs.getDouble(7), rs.getString(8), rs.getDate(9),
						rs.getInt(10), rs.getString(11), rs.getInt(12),
						rs.getInt(13));
				list.add(goods);
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

	public List<Goods> goodsFindByTypeName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
    //根据商品g_id查询库存
	public Integer selectGoodsAmountBygid(Integer gid) {
		String sql="SELECT amount FROM goods where g_id=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = JDBCUtil.getConnection();
		int amount=0;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, gid);
			 rs=ps.executeQuery();
			 while(rs.next()){
				 amount=rs.getInt(1); 
			 }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return amount;
	}
	
	// 修改库存
	public boolean UpdateGoodsAmountByGid(Integer g_id, Integer count) {
		//GoodsDaoImpl g = new GoodsDaoImpl();
		int amount = selectGoodsAmountBygid(g_id);
		String sql = "UPDATE  goods set amount =? WHERE g_id=?;";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = JDBCUtil.getConnection();

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, amount - count);
			ps.setInt(2, g_id);
			int s = ps.executeUpdate();
			if (s > 0) {
				return true;

			} else {
				return false;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public List<Goods> FuzzySelectGoods(String goodsname) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Goods> recentGoods() {
		Connection con = JDBCUtil.getConnection();
		String sql = "select g_id,g_name,gt_id,floNum_id,purchasing_price,original_price,goods_price,g_imgurl,putaway_time,g_state,g_info,amount,g_del from goods where g_del!=0 order by g_id desc limit 8";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<Goods> list = new ArrayList<Goods>();
		Goods goods = null;
		try {
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				goods = new Goods(rs.getInt(1), rs.getString(2), rs.getInt(3),
						rs.getInt(4), rs.getDouble(5), rs.getDouble(6),
						rs.getDouble(7), rs.getString(8), rs.getDate(9),
						rs.getInt(10), rs.getString(11), rs.getInt(12),
						rs.getInt(13));
				list.add(goods);
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

	// 根据父类id模糊查询商品
	public PageList<Goods> FuzzySelectPartGoods(Goods good, int currentPage,
			int pageSize) {
		PageList<Goods> page = null;// 待会再返回结果的时候进行实例化
		List<Object> paramList = new ArrayList<Object>();// 含有关键字字段的所有名称 list

		// 获取参数----输入框中传输过来的参数
		String g_name = good.getG_name();
		Integer gt_id = good.getGt_id();
		// System.out.println(gt_id);
		// 定义两个sql语句：负责查询数据
		StringBuffer sql = new StringBuffer(
				"select g_id,g_name,gt_id,floNum_id,purchasing_price,original_price,goods_price,g_imgurl,putaway_time,g_state,g_info,amount,g_del from goods where g_state=1 and 1=1");

		// 负责统计数据
		StringBuffer countSql = new StringBuffer(
				"select count(g_id)  as totalRecord from goods where g_state=1 and 1=1");

		// 根据商品名查询
		if (g_name != null && !"".equals(g_name)) {// 表示编号这个参数不为空
			sql.append(" and g_name like ?");// 给查询语句进行参数的拼接
			countSql.append(" and g_name like ?");// 给统计语句进行参数的拼接
			paramList.add("%" + g_name + "%");// 实际参数
		}
		if (gt_id != null && !"".equals(gt_id)) {
			// System.out.println(gt_id);
			sql.append(" and gt_id = ?");
			countSql.append(" and gt_id =?");
			paramList.add(gt_id);

		}

		sql.append(" and g_del=1  order By g_id DESC");
		// System.out.println("=========="+sql);

		// 查询的起始索引
		int fromIndex = pageSize * (currentPage - 1);

		// 使用limit关键字实现分页
		sql.append(" limit " + fromIndex + "," + pageSize);
		// System.out.println(sql);
		// 定义一个集合存放所有查询出来的对象
		List<Goods> goodsList = new ArrayList<Goods>();

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
			List<Map<String, Object>> goodsResult = jdbcUtil.findResults(
					sql.toString(), paramList);
			// System.out.println(goodsResult);
			if (goodsResult != null) {
				for (Map<String, Object> map : goodsResult) {// 将Map中保存的数据转换成Student对象
					Goods goods = new Goods();

					goods.setG_id(Integer.parseInt(map.get("g_id").toString()));
					goods.setG_name(map.get("g_name").toString());
					goods.setGt_id(Integer
							.parseInt(map.get("gt_id").toString()));
					goods.setFloNum_id(Integer.parseInt(map.get("floNum_id")
							.toString()));
					goods.setPurchasing_price(Double.parseDouble("".equals(map
							.get("purchasing_price").toString()) ? "0.00" : map
							.get("purchasing_price").toString()));

					goods.setOriginal_price(Double.parseDouble("".equals(map
							.get("original_price").toString()) ? "0.00" : map
							.get("original_price").toString()));
					goods.setGoods_price(Double.parseDouble("".equals(map.get(
							"goods_price").toString()) ? "0.00" : map.get(
							"goods_price").toString()));

					goods.setG_imgurl(map.get("g_imgurl").toString());
					goods.setG_putaway_time(map.get("putaway_time").toString());
					goods.setG_state(Integer.parseInt(map.get("g_state")
							.toString()));
					goods.setG_info(map.get("g_info").toString());
					goods.setAmount(Integer.parseInt(map.get("amount")
							.toString()));
					goods.setG_del(Integer
							.parseInt(map.get("g_del").toString()));
					goodsList.add(goods);
				}
			}
			// 获取总的页数
			int totalPage = totalRecord / pageSize;
			if (totalRecord % pageSize != 0) {
				totalPage += 1;// 总页数加1
			}
			// 进行Page对象的组装
			page = new PageList<Goods>(pageSize, currentPage, totalRecord,
					totalPage, goodsList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return page;
	}

	public boolean batchUploadGoods(Map<Integer, List<String>> map) {
		String sql = "insert into goods (g_name,gt_id,purchasing_price,original_price,goods_price,g_imgurl,g_info,amount) values(?,?,?,?,?,?,?,?) ";
		int count = 0;
		Connection con = JDBCUtil.getConnection();
		PreparedStatement ps = null;
		try {
			con.setAutoCommit(false);
			ps = con.prepareStatement(sql);
			for (Map.Entry<Integer, List<String>> list1 : map.entrySet()) {
				String aa = list1.getValue().toString();
				String s = aa.substring(1, aa.length() - 1);
				String[] ss = s.split(",");
				System.out.println(ss);
				System.out.println(aa);
				System.out.println(s);
				ps.setString(1, ss[0]);
				ps.setInt(2, Integer.parseInt(ss[1].trim()));
				ps.setDouble(3, Double.parseDouble(ss[2]));
				ps.setDouble(4, Double.parseDouble(ss[3]));
				ps.setDouble(5, Double.parseDouble(ss[4]));
				ps.setString(6, ss[5]);
				ps.setString(7, ss[6]);
				ps.setInt(8, Integer.parseInt(ss[7].trim()));
				ps.addBatch();
				count++;
			}
			int[] i = ps.executeBatch(); // 执行批量处理
			con.commit(); // 提交
			System.out.println("All down : " + count);
			if (i.length > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				con.rollback(); // 进行事务回滚
				System.out.println("导入数据失败");
			} catch (SQLException ex) {
			}
		}
		return false;
	}

	// 根据用途查询商品（位置需要改正）
	public List<Integer> goodsFindByUse(String floUse_id) {
		Connection con = JDBCUtil.getConnection();
		String sql = "select gfu_id,g_id from goods_fu where floUse_ids=? or floUse_ids like ?  or floUse_ids like ? or floUse_ids like ?  order by gfu_id desc limit 12";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<Integer> list = new ArrayList<Integer>();
		Integer g_id = 0;
		try {

			pstm = con.prepareStatement(sql);
			pstm.setString(1, floUse_id);
			pstm.setString(2, floUse_id + "," + "%");
			pstm.setString(3, "%" + "," + floUse_id + "," + "%");
			pstm.setString(4, "%" + "," + floUse_id);
			rs = pstm.executeQuery();
			while (rs.next()) {
				g_id = rs.getInt(2);
				list.add(g_id);
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

	public PageList<Goods> goodsFindByPrice(Goods good, int currentPage,
			int pageSize, String floPriceMin, String floPriceMax) {
		PageList<Goods> page = null;// 待会再返回结果的时候进行实例化
		List<Object> paramList = new ArrayList<Object>();// 含有关键字字段的所有名称 list

		// 获取参数----输入框中传输过来的参数
		String g_name = good.getG_name();
		Integer g_state = good.getG_state();
		// 定义两个sql语句：负责查询数据
		StringBuffer sql = new StringBuffer(
				"select g_id,g_name,gt_id,floNum_id,purchasing_price,original_price,goods_price,g_imgurl,putaway_time,g_state,g_info,amount,g_del from goods where 1=1");
		// 负责统计数据
		StringBuffer countSql = new StringBuffer(
				"select count(g_id)  as totalRecord from goods where g_del=1 and 1=1");
		// 前台只查询已上架的商品
		if (g_state != null) {
			sql.append(" and g_state = ?");// 给查询语句进行参数的拼接
			countSql.append(" and g_state = ?");// 给统计语句进行参数的拼接
			paramList.add(g_state);// 实际参数
		}
		// 根据商品名查询
		if (g_name != null && !"".equals(g_name)) {// 表示编号这个参数不为空
			sql.append(" and g_name like ?");// 给查询语句进行参数的拼接
			countSql.append(" and g_name like ?");// 给统计语句进行参数的拼接
			paramList.add("%" + g_name + "%");// 实际参数
		}

		sql.append(" and goods_price between ? and ?");// 给查询语句进行参数的拼接
		countSql.append(" and goods_price between ? and ?");// 给统计语句进行参数的拼接
		paramList.add(Integer.parseInt(floPriceMin));// 实际参数
		paramList.add(Integer.parseInt(floPriceMax));

		sql.append(" and g_del=1  order By g_id DESC");
		// System.out.println(sql);
		// System.out.println(countSql);
		// 查询的起始索引
		int fromIndex = pageSize * (currentPage - 1);

		// 使用limit关键字实现分页
		sql.append(" limit " + fromIndex + "," + pageSize);
		// System.out.println(sql);
		// 定义一个集合存放所有查询出来的对象
		List<Goods> goodsList = new ArrayList<Goods>();

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
			List<Map<String, Object>> goodsResult = jdbcUtil.findResults(
					sql.toString(), paramList);
			// System.out.println(goodsResult);
			if (goodsResult != null) {
				for (Map<String, Object> map : goodsResult) {// 将Map中保存的数据转换成Student对象
					Goods goods = new Goods();

					goods.setG_id(Integer.parseInt(map.get("g_id").toString()));
					goods.setG_name(map.get("g_name").toString());
					goods.setGt_id(Integer
							.parseInt(map.get("gt_id").toString()));
					goods.setFloNum_id(Integer.parseInt(map.get("floNum_id")
							.toString()));
					goods.setPurchasing_price(Double.parseDouble("".equals(map
							.get("purchasing_price").toString()) ? "0.00" : map
							.get("purchasing_price").toString()));

					goods.setOriginal_price(Double.parseDouble("".equals(map
							.get("original_price").toString()) ? "0.00" : map
							.get("original_price").toString()));
					goods.setGoods_price(Double.parseDouble("".equals(map.get(
							"goods_price").toString()) ? "0.00" : map.get(
							"goods_price").toString()));

					goods.setG_imgurl(map.get("g_imgurl").toString());
					goods.setG_putaway_time(map.get("putaway_time").toString());
					goods.setG_state(Integer.parseInt(map.get("g_state")
							.toString()));
					goods.setG_info(map.get("g_info").toString());
					goods.setAmount(Integer.parseInt(map.get("amount")
							.toString()));
					goods.setG_del(Integer
							.parseInt(map.get("g_del").toString()));
					goodsList.add(goods);
				}
			}
			// 获取总的页数
			int totalPage = totalRecord / pageSize;
			if (totalRecord % pageSize != 0) {
				totalPage += 1;// 总页数加1
			}
			// 进行Page对象的组装
			page = new PageList<Goods>(pageSize, currentPage, totalRecord,
					totalPage, goodsList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return page;
	}

	public List<Integer> goodsFindByType(String floType_id) {
		Connection con = JDBCUtil.getConnection();
		String sql = "select gft_id,g_id from goods_ft where floType_ids=? or floType_ids like ?  or floType_ids like ? or floType_ids like ? order by gft_id desc limit 12";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<Integer> list = new ArrayList<Integer>();
		Integer g_id = 0;
		try {

			pstm = con.prepareStatement(sql);
			pstm.setString(1, floType_id);
			pstm.setString(2, floType_id + "," + "%");
			pstm.setString(3, "%" + "," + floType_id + "," + "%");
			pstm.setString(4, "%" + "," + floType_id);
			rs = pstm.executeQuery();
			while (rs.next()) {
				g_id = rs.getInt(2);
				list.add(g_id);
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

	

	

	

}
