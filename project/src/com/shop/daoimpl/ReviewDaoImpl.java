package com.shop.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.shop.DBUtil.JDBCUtil;
import com.shop.DBUtil.MD5;
import com.shop.beans.Goods;
import com.shop.beans.Review;
import com.shop.beans.User;
import com.shop.beans.dto.ReviewUser;
import com.shop.dao.ReviewDao;
import com.shop.page.PageList;

public class ReviewDaoImpl implements ReviewDao {
	// �������
	public boolean reviewAdd(Review review) {
		java.sql.Date date = new java.sql.Date(review.getReview_time()
				.getTime());
		Connection con = JDBCUtil.getConnection();
		String str1 = "insert into review(g_id,u_id,review_time,content,state) values(?,?,?,?,?);";
		PreparedStatement pstm = null;
		try {
			pstm = con.prepareStatement(str1);
			pstm.setInt(1, review.getG_id());
			// pstm.setString(2,review.getGoodsname());
			pstm.setInt(2, review.getU_id());
			pstm.setDate(3, date);
			pstm.setString(4, review.getContent());
			pstm.setInt(5, review.getState());
			pstm.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.close(null, pstm, con);
		}
	}

	// ɾ������
	public boolean reviewDel(Review review) {
		// TODO Auto-generated method stub
		return false;
	}

	// �鿴��������
	// public List<ReviewUser> reviewFindAll(int g_id) {
	// Connection con=JDBCUtil.getConnection();
	// PreparedStatement pstm = null;
	// ResultSet rs = null;
	// String str1 = "select g_name from goods where g_id=?";
	// String g_name = null;
	// try {
	// pstm = con.prepareStatement(str1);
	// pstm.setInt(1,g_id);
	// rs = pstm.executeQuery();
	// while (rs.next()) {
	// g_name = rs.getString("g_name");
	// }
	// }catch (SQLException e) {
	// e.printStackTrace();
	// }
	// String
	// str="SELECT review_id,review_time,content,review.state,user.u_id,u_name,u_img from review LEFT JOIN user ON review .u_id=user.u_id WHERE g_name like ?&&review_del!=0 order by review_id desc limit 0,5;";
	// List<ReviewUser> list = new ArrayList<ReviewUser>();
	// try {
	// pstm = con.prepareStatement(str);
	// pstm.setString(1,g_name+"%");
	// rs = pstm.executeQuery();
	// while (rs.next()) {
	// ReviewUser review_User = new
	// ReviewUser(rs.getInt("review_id"),rs.getDate("review_time"),rs.getString("content"),rs.getInt("review.state"),rs.getInt("user.u_id"),rs.getString("username"),rs.getString("u_img"));
	// list.add(review_User);
	// }
	// }catch (SQLException e) {
	// e.printStackTrace();
	// } finally {
	// JDBCUtil.close(rs, pstm, con);
	// }
	// return list;
	// }
	// ������Ʒid�鿴����
	public List<ReviewUser> findReviewBygid(int g_id) {
		// TODO Auto-generated method stub

		String sql = "SELECT r_id,review_time,content,state,`user`.u_img,`user`.u_name from review LEFT JOIN  `user` on review.u_id=`user`.u_id  WHERE r_del=1 AND g_id=?";
		Connection con = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		List<ReviewUser> list = new ArrayList<ReviewUser>();
		ReviewUser ru = null;
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, g_id);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				ru = new ReviewUser(rs.getInt(1), rs.getDate(2),
						rs.getString(3), rs.getInt(4), rs.getString(6),
						rs.getString(5));
				list.add(ru);
			}
			return list;
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

	public PageList<ReviewUser> findReviewBygid1(Goods good, int currentPage,
			int pageSize) throws ParseException {
		PageList<ReviewUser> page = null;// �����ٷ��ؽ����ʱ�����ʵ����
		List<Object> paramList = new ArrayList<Object>();// ���йؼ����ֶε��������� list

		// ��ȡ����----������д�������Ĳ���

		Integer g_id = good.getG_id();
		// ��������sql��䣺�����ѯ����
		StringBuffer sql = new StringBuffer(
				"SELECT r_id,review_time,content,state,`user`.u_img,`user`.u_name from review LEFT JOIN  `user` on review.u_id=`user`.u_id  WHERE r_del=1 AND g_id=?");
		// ����ͳ������
		StringBuffer countSql = new StringBuffer(
				"select count(r_id)  as totalRecord from review LEFT JOIN  `user` on review.u_id=`user`.u_id  WHERE r_del=1 AND g_id=?");

		sql.append(" order By r_id DESC");
		// System.out.println(sql);
		// System.out.println(countSql);
		paramList.add(g_id);
		// ��ѯ����ʼ����
		int fromIndex = pageSize * (currentPage - 1);

		// ʹ��limit�ؼ���ʵ�ַ�ҳ
		sql.append(" limit " + fromIndex + "," + pageSize);
		// System.out.println(sql);
		// ����һ�����ϴ�����в�ѯ�����Ķ���
		List<ReviewUser> reviewUsersList = new ArrayList<ReviewUser>();

		// ʵ�������ݿ��ѯ�Ķ���
		JDBCUtil jdbcUtil = new JDBCUtil();

		try {
			// ��ȡ�ܵļ�¼
			List<Map<String, Object>> countResult = jdbcUtil.findResults(
					countSql.toString(), paramList);
			int totalRecord = Integer.parseInt(countResult.get(0)
					.get("totalRecord").toString());
			// System.out.println(totalRecord);
			// ��ȡ��ѯ�Ķ����Ķ���ļ���
			List<Map<String, Object>> reviewUsersResult = jdbcUtil.findResults(
					sql.toString(), paramList);
			// System.out.println(goodsResult);
			if (reviewUsersResult != null) {
				for (Map<String, Object> map : reviewUsersResult) {// ��Map�б��������ת����Student����
					ReviewUser reviewUser = new ReviewUser();

					reviewUser.setReview_id(Integer.parseInt(map.get("r_id")
							.toString()));
//					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
//					Date date = sdf.parse(map.get("review_time").toString());
					reviewUser.setReview_time1(map.get("review_time").toString().substring(0, 10));
					reviewUser.setContent(map.get("content").toString());
					reviewUser.setState(Integer.parseInt(map.get("state")
							.toString()));
					reviewUser.setU_img(map.get("u_img").toString());
					String nameChange = map.get("u_name").toString().replaceFirst(map.get("u_name").toString().substring(1,3),"**");
					reviewUser.setU_name(nameChange);

					reviewUsersList.add(reviewUser);
				}
			}
			// ��ȡ�ܵ�ҳ��
			int totalPage = totalRecord / pageSize;
			if (totalRecord % pageSize != 0) {
				totalPage += 1;// ��ҳ����1
			}
			// ����Page�������װ
			page = new PageList<ReviewUser>(pageSize, currentPage, totalRecord,
					totalPage, reviewUsersList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return page;
	}

	public List<ReviewUser> findReviewBygid1(int g_id) {
		// TODO Auto-generated method stub

		String sql = "SELECT r_id,review_time,content,state,`user`.u_img,`user`.u_name from review LEFT JOIN  `user` on review.u_id=`user`.u_id  WHERE r_del=1 AND g_id=?";
		Connection con = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		List<ReviewUser> list = new ArrayList<ReviewUser>();
		ReviewUser ru = null;
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, g_id);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				ru = new ReviewUser(rs.getInt(1), rs.getDate(2),
						rs.getString(3), rs.getInt(4), rs.getString(6),
						rs.getString(5));
				list.add(ru);
			}
			return list;
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
