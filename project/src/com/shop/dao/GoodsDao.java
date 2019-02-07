package com.shop.dao;

import java.util.List;
import java.util.Map;

import com.shop.beans.Goods;
import com.shop.beans.dto.GoodsDetail;
import com.shop.page.PageList;

public interface GoodsDao {
	// �����Ʒ
	public boolean goodsAdd(Goods good);

	// �޸���Ʒ������Ϣ
	public boolean goodsUpdate(Goods good);

	// ��ѯ������Ʒ
	public List<Goods> goodsFindAll();

	// ����id��ѯ������Ʒ
	public Goods goodsFindByGid(Integer g_id);
	// ����name��ѯ������Ʒ
	public boolean goodsFindByGname(String g_name);
	// ������Ʒ����վ����Ʒ
	public List<Goods> goodsFindAlreadyDel();

	// ��Ʒ�б�
	public List<GoodsDetail> goodsFindByftid(Integer fid);

	// ��Ʒ����
	public List<Goods> goodsFindByGtid(Integer gt_id);

    //�鿴��Ʒ����ͼƬ
	public String image(Integer g_id);
	
	public List<Goods> goodsFindByTypeName(String name);

	// ����
	public Integer selectGoodsAmountBygid(Integer gid);

	// �޸Ŀ��
	public boolean UpdateGoodsAmountByGid(Integer g_id, Integer count);

	// ģ����ѯ
	public List<Goods> FuzzySelectGoods(String goodsname);
	// ģ����ѯ������g_id��
	public PageList<Goods> FuzzySelectPartGoods(Goods good, int currentPage,
			int pageSize);
    //��ҳ
	public PageList<Goods> PageFuzzySelectGoods(Goods good, int currentPage,
			int pageSize);
	public boolean goodUpdateNameVerify(String g_name,String g_nameold);

	public boolean goodsUpdateDel(Goods good);
	public boolean goodsImgUpload(Goods good);
	public boolean goodsUpdateState(Goods good);
	//��ѯrecent products
	public List<Goods> recentGoods();
	//�����ϴ���Ʒ
	public boolean batchUploadGoods(Map<Integer,List<String>> map);
	//�����ʻ���;������Ʒ
	public List<Integer> goodsFindByUse(String floUse_id);
	//�����ʻ���;������Ʒ
	public List<Integer> goodsFindByType(String floType_id);
	//������Ʒ�۸�Χ��ѯ
	public PageList<Goods> goodsFindByPrice(Goods good, int currentPage,
			int pageSize,String floPriceMin,String floPriceMax);
	
	
}
