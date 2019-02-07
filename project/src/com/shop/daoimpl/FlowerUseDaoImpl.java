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
    //����������;
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
	//���Ҳ�����;
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
    //��ҳ
	public PageList<FlowerUse> PageFuzzySelectFlowerUse(FlowerUse flowerUse,
			int currentPage, int pageSize) {
		PageList<FlowerUse> page = null;// �����ٷ��ؽ����ʱ�����ʵ����
		List<Object> paramList = new ArrayList<Object>();// ���йؼ����ֶε��������� list

		// ��ȡ����----������д�������Ĳ���
		String floUse_name = flowerUse.getFloUse_name();

		// ��������sql��䣺�����ѯ����
		StringBuffer sql = new StringBuffer(
				"select floUse_id,floUse_name,floUse_del,floUse_img from floweruse where 1=1");
		// ����ͳ������
		StringBuffer countSql = new StringBuffer(
				"select count(floUse_id)  as totalRecord from floweruse where 1=1");
		// �����û�����ѯ
		if (floUse_name != null && !"".equals(floUse_name)) {// ��ʾ������������Ϊ��
			sql.append(" and floUse_name like ?");// ����ѯ�����в�����ƴ��
			countSql.append(" and floUse_name like ?");// ��ͳ�������в�����ƴ��
			paramList.add("%" + floUse_name + "%");// ʵ�ʲ���
		}
		sql.append(" and floUse_del=1  order By floUse_id ASC");
		// System.out.println(sql);
		// System.out.println(countSql);
		// ��ѯ����ʼ����
		int fromIndex = pageSize * (currentPage - 1);

		// ʹ��limit�ؼ���ʵ�ַ�ҳ
		sql.append(" limit " + fromIndex + "," + pageSize);
		// System.out.println(sql);
		// ����һ�����ϴ�����в�ѯ�����Ķ���
		List<FlowerUse> flowerUsesList = new ArrayList<FlowerUse>();

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
			List<Map<String, Object>> flowerUsesResult = jdbcUtil.findResults(
					sql.toString(), paramList);
			// System.out.println(goodsResult);
			if (flowerUsesResult != null) {
				for (Map<String, Object> map : flowerUsesResult) {// ��Map�б��������ת����user����
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
			// ��ȡ�ܵ�ҳ��
			int totalPage = totalRecord / pageSize;
			if (totalRecord % pageSize != 0) {
				totalPage += 1;// ��ҳ����1
			}
			// ����Page�������װ
			page = new PageList<FlowerUse>(pageSize, currentPage, totalRecord,
					totalPage, flowerUsesList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return page;
	}
    //����id���ҵ�����;
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
    //��;�߼�ɾ��
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
    //�������;
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
    //�������ֲ��ҵ�����;
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
    //�޸���;��Ϣ
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
	//�޸���;��Ϣ ����;����֤
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
