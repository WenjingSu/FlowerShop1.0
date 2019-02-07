package com.shop.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shop.DBUtil.JDBCUtil;
import com.shop.beans.GoodsType;
import com.shop.dao.GoodsTypeDao;

public class GoodsTypeDaoImpl implements GoodsTypeDao {
	// 查找所有种类
	public List<GoodsType> goodstypeFindAll() {
		String sql = "select gt_id,gt_typename,ft_id,gt_mark,gt_del from goodstype " +
				"where gt_del=1 and ft_id is Null order by gt_id";
		Connection con = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		List<GoodsType> fathers = new ArrayList<GoodsType>();
		try {
			pstm = con.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				GoodsType gtype = new GoodsType();
				gtype.setGt_id(rs.getInt(1));
				gtype.setGt_typename(rs.getString(2));
				gtype.setGt_mark(rs.getString(4));
				gtype.setGt_del(rs.getInt(5));
				fathers.add(gtype);

			}
			for (GoodsType father : fathers) {
				List<GoodsType> children = goodstypefindByFather(father
						.getGt_id());
				father.setChildren(children);
			}
			return fathers;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			JDBCUtil.close(null, pstm, con);
		}
		return null;
	}

	// 根据id查找种类
	public GoodsType goodstypeFindByGtid(Integer gtid) {
		// TODO Auto-generated method stub
		String sql = "select gt_id,gt_typename,ft_id,gt_mark,gt_del from goodstype where gt_id=? and gt_del=1";
		Connection con = JDBCUtil.getConnection();
		GoodsType gtype = new GoodsType();
		PreparedStatement pstm = null;
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, gtid);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				gtype.setGt_id(gtid);
				gtype.setGt_typename(rs.getString(2));
				gtype.setGt_mark(rs.getString(4));
				gtype.setGt_del(rs.getInt(5));
			}
			return gtype;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pstm, con);
		}

		return null;
	}

	// 逻辑删除商品种类
	public boolean goodstypeDel(Integer gtid) {
		Connection con = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		List<GoodsType> children = goodstypefindByFather(gtid);
		if (children == null || children.isEmpty()) {
			String sql = "update goodstype set gt_del=0 where gt_id=?";
			try {
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, gtid);
				int i = pstm.executeUpdate();
				if (i > 0) {
					// System.out.println("删除成功");
					return true;
				} else {
					// System.out.println("NO no");
					return false;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			} finally {
				JDBCUtil.close(null, pstm, con);
			}

		} else {
			// System.out.println("您删除的类型有子类，删除失败");
			return false;
		}

	}

	// 添加种类
	public boolean goodstypeAdd(GoodsType goodstype) {
		Connection con = JDBCUtil.getConnection();
		String sql = "insert into goodsType (gt_typename,gt_mark) values(?,?)";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, goodstype.getGt_typename());
			ps.setString(2, goodstype.getGt_mark());
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

	// 添加子类
	public boolean goodstypeAddChildren(GoodsType goodstype) {
		Connection con = JDBCUtil.getConnection();
		String sql = "insert into goodsType (gt_typename,ft_id,gt_mark) values(?,?,?)";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, goodstype.getGt_typename());
			ps.setInt(2, goodstype.getGt_id());
			ps.setString(3, goodstype.getGt_mark());

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

	// 修改某种类信息
	public boolean goodstypeUpdate(GoodsType goodstype) {
		Connection con = JDBCUtil.getConnection();
		String sql = "update goodsType set gt_typename=?,gt_mark=? where gt_id=?";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, goodstype.getGt_typename());
			ps.setString(2, goodstype.getGt_mark());
			ps.setInt(3, goodstype.getGt_id());
			int i = ps.executeUpdate();
			if (i > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.close(null, ps, con);
		}
		
	}

	// 根据父类查找子类
	public List<GoodsType> goodstypefindByFather(Integer gtid) {
		String sql = "select gt_id,gt_typename,gt_mark,gt_del from goodstype where ft_id=? and gt_del=1";
		Connection con = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		List<GoodsType> children = new ArrayList<GoodsType>();
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, gtid);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				GoodsType gtype = new GoodsType();
				gtype.setGt_id(rs.getInt(1));
				gtype.setGt_typename(rs.getString(2));
				gtype.setGt_mark(rs.getString(3));
				gtype.setGt_del(rs.getInt(4));
				children.add(gtype);
			}
			return children;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pstm, con);
		}

		return null;
	}

	// 查询一部分种类
	public List<GoodsType> goodstypeFindAllLimit() {
		String sql = "select gt_id,gt_typename,ft_id,gt_mark,gt_del from goodstype where gt_del=1 and ft_id is Null order by gt_id limit 4";
		Connection con = JDBCUtil.getConnection();
		PreparedStatement pstmt = null;
		List<GoodsType> fathers = new ArrayList<GoodsType>();
		try {
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				GoodsType gt = new GoodsType();
				gt.setGt_id(rs.getInt(1));
				gt.setGt_typename(rs.getString(2));
				gt.setGt_mark(rs.getString(4));
				gt.setGt_del(rs.getInt(5));
				fathers.add(gt);
			}
			// System.out.println(fathers);
			for (GoodsType father : fathers) {

				List<GoodsType> children = goodstypefindByFatherLimit(father
						.getGt_id());

				father.setChildren(children);
			}

			return fathers;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pstmt, con);
		}
		return null;
	}

	// 根据父类查询一部分子类
	public List<GoodsType> goodstypefindByFatherLimit(Integer gtid) {
		String sql = "select gt_id,gt_typename,gt_mark,gt_del from goodstype where ft_id=? and gt_del=1 order by gt_id  limit 4";
		Connection con = JDBCUtil.getConnection();
		PreparedStatement pstmt = null;
		List<GoodsType> children = new ArrayList<GoodsType>();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, gtid);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				GoodsType g = new GoodsType();
				g.setGt_id(rs.getInt(1));
				g.setGt_typename(rs.getString(2));
				g.setGt_mark(rs.getString(3));
				g.setGt_del(rs.getInt(4));
				children.add(g);
				// System.out.println(children);
			}
			return children;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pstmt, con);
		}
		return null;
	}

	// 添加商品类型种类名验证
	public boolean goodsTypeAddNameVerify(String gt_typename) {
		Connection con = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "select gt_id,gt_typename,gt_mark,gt_del from goodstype where gt_typename=?;";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, gt_typename);
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

	// 修改商品类型信息种类名验证
	public boolean goodsTypeUpdateNameVerify(String gt_typename,
			String gt_typenameold) {
		Connection con = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		if (!gt_typename.equals(gt_typenameold)) {
			String sql = "select gt_id,gt_typename,gt_mark,gt_del from goodstype where gt_typename=?;";
			try {
				pstm = con.prepareStatement(sql);
				pstm.setString(1, gt_typename);
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
