package com.shop.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.shop.DBUtil.JDBCUtil;
import com.shop.beans.FlowerType;
import com.shop.dao.FlowerTypeDao;
import com.shop.page.PageList;

public class FlowerTypeDaoImpl implements FlowerTypeDao {
	// �������л���
	public List<FlowerType> FlowerTypeFindAll() {

		String sql = "select floType_id,floType_name,floType_mean,floType_del,floType_img from flowertype where floType_del=1";

		Connection con = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		List<FlowerType> flowerTypes = new ArrayList<FlowerType>();
		try {
			pstm = con.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				FlowerType flowerType = new FlowerType(rs.getInt(1),
						rs.getString(2), rs.getString(3), rs.getInt(4),rs.getString(5));
				flowerTypes.add(flowerType);
			}
			return flowerTypes;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("==");
		} finally {
			JDBCUtil.close(null, pstm, con);
		}

		return null;
	}

	// ���Ҳ��ֻ���
	public List<FlowerType> FlowerTypeFindAllLimit() {

		String sql = "select floType_id,floType_name,floType_mean,floType_del,floType_img from flowertype where floType_del=1 limit 10";

		Connection con = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		List<FlowerType> flowerTypes = new ArrayList<FlowerType>();
		try {
			pstm = con.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				FlowerType flowerType = new FlowerType(rs.getInt(1),
						rs.getString(2), rs.getString(3), rs.getInt(4),rs.getString(5));
				flowerTypes.add(flowerType);
			}
			return flowerTypes;
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
	public PageList<FlowerType> PageFuzzySelectFlowerType(
			FlowerType flowerType, int currentPage, int pageSize) {
		PageList<FlowerType> page = null;// �����ٷ��ؽ����ʱ�����ʵ����
		List<Object> paramList = new ArrayList<Object>();// ���йؼ����ֶε��������� list

		// ��ȡ����----������д�������Ĳ���
		String floType_name = flowerType.getFloType_name();

		// ��������sql��䣺�����ѯ����
		StringBuffer sql = new StringBuffer(
				"select floType_id,floType_name,floType_mean,floType_del,floType_img from flowertype where 1=1");
		// ����ͳ������
		StringBuffer countSql = new StringBuffer(
				"select count(floType_id)  as totalRecord from flowertype where 1=1");
		// �����û�����ѯ
		if (floType_name != null && !"".equals(floType_name)) {// ��ʾ������������Ϊ��
			sql.append(" and floType_name like ?");// ����ѯ�����в�����ƴ��
			countSql.append(" and floType_name like ?");// ��ͳ�������в�����ƴ��
			paramList.add("%" + floType_name + "%");// ʵ�ʲ���
		}
		sql.append(" and floType_del=1  order By floType_id ASC");
		// System.out.println(sql);
		// System.out.println(countSql);
		// ��ѯ����ʼ����
		int fromIndex = pageSize * (currentPage - 1);

		// ʹ��limit�ؼ���ʵ�ַ�ҳ
		sql.append(" limit " + fromIndex + "," + pageSize);
		// System.out.println(sql);
		// ����һ�����ϴ�����в�ѯ�����Ķ���
		List<FlowerType> flowerTypesList = new ArrayList<FlowerType>();

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
			List<Map<String, Object>> flowerTypesResult = jdbcUtil.findResults(
					sql.toString(), paramList);
			// System.out.println(goodsResult);
			if (flowerTypesResult != null) {
				for (Map<String, Object> map : flowerTypesResult) {// ��Map�б��������ת����user����
					FlowerType flowertype1 = new FlowerType();
					flowertype1.setFloType_id(Integer.parseInt(map.get(
							"floType_id").toString()));
					flowertype1.setFloType_name(map.get("floType_name")
							.toString());
					flowertype1.setFloType_mean(map.get("floType_mean")
							.toString());
					flowertype1.setFloType_del(Integer.parseInt(map.get(
							"floType_del").toString()));
					flowertype1.setFloType_img(map.get("floType_img")
							.toString());
					flowerTypesList.add(flowertype1);
				}
			}
			// ��ȡ�ܵ�ҳ��
			int totalPage = totalRecord / pageSize;
			if (totalRecord % pageSize != 0) {
				totalPage += 1;// ��ҳ����1
			}
			// ����Page�������װ
			page = new PageList<FlowerType>(pageSize, currentPage, totalRecord,
					totalPage, flowerTypesList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return page;
	}

	// ����id���ҵ�������
	public FlowerType flowerTypefindbyId(Integer floType_id) {
		// TODO Auto-generated method stub
		String sql = "select floType_id,floType_name,floType_mean,floType_del,floType_img from flowertype where floType_id=? and floType_del=1";
		Connection con = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		FlowerType flowerType = null;
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, floType_id);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				flowerType = new FlowerType(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getInt(4),rs.getString(5));

			}
			return flowerType;
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

	// �߼�ɾ������
	public boolean updateFlowerTypeDel(FlowerType flowerType) {
		// TODO Auto-generated method stub
		String sql = "update flowertype set floType_del=0 where floType_id=?";
		Connection con = JDBCUtil.getConnection();
		PreparedStatement pstm = null;

		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, flowerType.getFloType_id());
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

	// ��ӻ���
	public boolean addFlowerType(FlowerType flowerType) {
		Connection con = JDBCUtil.getConnection();
		String sql = "insert into flowerType (floType_name,floType_mean) values(?,?)";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, flowerType.getFloType_name());
			ps.setString(2, flowerType.getFloType_mean());
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

	// �������ֲ��һ���
	public boolean flowerTypefindbyName(String floType_name) {
		Connection con = JDBCUtil.getConnection();
		String sql = "select floType_id,floType_name,floType_mean,floType_del from flowerType where floType_name = ?";
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, floType_name);
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

	// �޸Ļ�����Ϣ
	public boolean flowerTypeUpdate(FlowerType flowerType) {
		Connection con = JDBCUtil.getConnection();
		String sql = "update flowerType set floType_name=?,floType_mean=? where floType_id =?";
		PreparedStatement pstm = null;
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, flowerType.getFloType_name());
			pstm.setString(2, flowerType.getFloType_mean());
			pstm.setInt(3, flowerType.getFloType_id());
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

	// �޸Ļ�����Ϣ��������֤
	public boolean flowerTypeUpdateVertify(String floType_name,
			String floType_name_old) {
		Connection con = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		if (!floType_name.equals(floType_name_old)) {
			String sql = "select floType_id,floType_name,floType_mean,floType_del from flowerType where floType_name=?;";
			try {
				pstm = con.prepareStatement(sql);
				pstm.setString(1, floType_name);
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