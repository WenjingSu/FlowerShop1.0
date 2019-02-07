package com.shop.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shop.beans.GoodsImgs;
import com.shop.DBUtil.JDBCUtil;
import com.shop.dao.Goods_imgDao;

public class Goods_imgDaoImpl implements Goods_imgDao {
    //上传商品分图片
	public boolean addImg(GoodsImgs goodsImgs) {
		Connection con = JDBCUtil.getConnection();
		String sql = "insert into goods_images (g_id,img_url) values(?,?)";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, goodsImgs.getG_id());
			ps.setString(2, goodsImgs.getImg_url());
			// System.out.println(goods_images);
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
    //根据商品g_id查询商品分图片
	public GoodsImgs findById(Integer g_id) {
		Connection con = JDBCUtil.getConnection();
		String sql = "select img_id,g_id,img_url from goods_images where g_id=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		GoodsImgs goodsImgs = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, g_id);
			rs = ps.executeQuery();
			while (rs.next()) {
				goodsImgs = new GoodsImgs(rs.getInt(1), rs.getInt(2),
						rs.getString(3));
			}
			return goodsImgs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, ps, con);
		}
		return null;
	}
    //根据商品g_id查询商品分图片url
	public String images(Integer g_id) {
		String sql = "select img_url from goods_images where g_id=?";

		Connection con = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		String images = null;

		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, g_id);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				images = rs.getString(1);
			}
			return images;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("==");
		} finally {
			JDBCUtil.close(null, pstm, con);
		}

		return null;
	}
    //修改商品图片url
	public boolean updateImg(GoodsImgs goodsImgs) {
		Connection con = JDBCUtil.getConnection();
		String sql = "update goods_images set img_url=? where g_id=?";
		PreparedStatement pstm = null;
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, goodsImgs.getImg_url());
			pstm.setInt(2, goodsImgs.getG_id());
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

	
}
