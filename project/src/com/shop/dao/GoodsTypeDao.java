package com.shop.dao;

import java.util.List;

import com.shop.beans.GoodsType;

public interface GoodsTypeDao {
	// ����������Ʒ����
	public List<GoodsType> goodstypeFindAll();

	// ���ҵ�����Ʒ����
	public GoodsType goodstypeFindByGtid(Integer gtid);

	// �߼�ɾ����Ʒ����
	public boolean goodstypeDel(Integer gtid);

	// �����Ʒ����
	public boolean goodstypeAdd(GoodsType goodstype);

	// �������
	public boolean goodstypeAddChildren(GoodsType goodstype);

	// �޸�������Ϣ
	public boolean goodstypeUpdate(GoodsType goodstype);

	// ������������
	public List<GoodsType> goodstypefindByFather(Integer gtid);

	// ������������limit
	public List<GoodsType> goodstypeFindAllLimit();

	// ������������limit
	public List<GoodsType> goodstypefindByFatherLimit(Integer gtid);
	//�����Ʒ������������֤
	public boolean goodsTypeAddNameVerify(String gt_typename);
	//�޸���Ʒ������Ϣ��������֤
	public boolean goodsTypeUpdateNameVerify(String gt_typename,String gt_typenameold);
}
