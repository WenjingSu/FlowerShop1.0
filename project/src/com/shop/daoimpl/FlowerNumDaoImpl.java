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
	// ��������
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

	// ��ҳ
	public PageList<FlowerNum> PageFuzzySelectFlowerNum(FlowerNum flowerNum,
			int currentPage, int pageSize) {
		PageList<FlowerNum> page = null;// �����ٷ��ؽ����ʱ�����ʵ����
		List<Object> paramList = new ArrayList<Object>();// ���йؼ����ֶε��������� list

		// ��ȡ����----������д�������Ĳ���
		String floNum_name = flowerNum.getFloNum_name();

		// ��������sql��䣺�����ѯ����
		StringBuffer sql = new StringBuffer(
				"select floNum_id,floNum_name,floNum_mean,floNum_del from flowernum where 1=1");
		// ����ͳ������
		StringBuffer countSql = new StringBuffer(
				"select count(floNum_id)  as totalRecord from flowerNum where 1=1");
		// �����û�����ѯ
		if (floNum_name != null && !"".equals(floNum_name)) {// ��ʾ������������Ϊ��
			sql.append(" and floNum_name like ?");// ����ѯ�����в�����ƴ��
			countSql.append(" and floNum_name like ?");// ��ͳ�������в�����ƴ��
			paramList.add("%" + floNum_name + "%");// ʵ�ʲ���
		}
		sql.append(" and floNum_del=1  order By floNum_id ASC");
		// System.out.println(sql);
		// System.out.println(countSql);
		// ��ѯ����ʼ����
		int fromIndex = pageSize * (currentPage - 1);

		// ʹ��limit�ؼ���ʵ�ַ�ҳ
		sql.append(" limit " + fromIndex + "," + pageSize);
		// System.out.println(sql);
		// ����һ�����ϴ�����в�ѯ�����Ķ���
		List<FlowerNum> flowerNumsList = new ArrayList<FlowerNum>();

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
			List<Map<String, Object>> flowerNumsResult = jdbcUtil.findResults(
					sql.toString(), paramList);
			// System.out.println(goodsResult);
			if (flowerNumsResult != null) {
				for (Map<String, Object> map : flowerNumsResult) {// ��Map�б��������ת����user����
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
			// ��ȡ�ܵ�ҳ��
			int totalPage = totalRecord / pageSize;
			if (totalRecord % pageSize != 0) {
				totalPage += 1;// ��ҳ����1
			}
			// ����Page�������װ
			page = new PageList<FlowerNum>(pageSize, currentPage, totalRecord,
					totalPage, flowerNumsList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return page;
	}

	// ����id���ҵ���
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

	// �߼�ɾ��
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
				// System.out.println("�޸ĳɹ�");
				return true;
			} else {
				// System.out.println("�޸�ʧ��");
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

	// �����֦��
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

	// �������ֲ���֦��
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

	// �޸���Ϣ
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

	// �޸���Ϣ������֤
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
