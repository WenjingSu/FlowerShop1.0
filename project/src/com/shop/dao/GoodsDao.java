package com.shop.dao;

import java.util.List;
import java.util.Map;

import com.shop.beans.Goods;
import com.shop.beans.dto.GoodsDetail;
import com.shop.page.PageList;

public interface GoodsDao {
	// 添加商品
	public boolean goodsAdd(Goods good);

	// 修改商品基本信息
	public boolean goodsUpdate(Goods good);

	// 查询所有商品
	public List<Goods> goodsFindAll();

	// 根据id查询单个商品
	public Goods goodsFindByGid(Integer g_id);
	// 根据name查询单个商品
	public boolean goodsFindByGname(String g_name);
	// 查找商品回收站的商品
	public List<Goods> goodsFindAlreadyDel();

	// 商品列表
	public List<GoodsDetail> goodsFindByftid(Integer fid);

	// 商品详情
	public List<Goods> goodsFindByGtid(Integer gt_id);

    //查看商品单个图片
	public String image(Integer g_id);
	
	public List<Goods> goodsFindByTypeName(String name);

	// 查库存
	public Integer selectGoodsAmountBygid(Integer gid);

	// 修改库存
	public boolean UpdateGoodsAmountByGid(Integer g_id, Integer count);

	// 模糊查询
	public List<Goods> FuzzySelectGoods(String goodsname);
	// 模糊查询（根据g_id）
	public PageList<Goods> FuzzySelectPartGoods(Goods good, int currentPage,
			int pageSize);
    //分页
	public PageList<Goods> PageFuzzySelectGoods(Goods good, int currentPage,
			int pageSize);
	public boolean goodUpdateNameVerify(String g_name,String g_nameold);

	public boolean goodsUpdateDel(Goods good);
	public boolean goodsImgUpload(Goods good);
	public boolean goodsUpdateState(Goods good);
	//查询recent products
	public List<Goods> recentGoods();
	//批量上传商品
	public boolean batchUploadGoods(Map<Integer,List<String>> map);
	//根据鲜花用途查找商品
	public List<Integer> goodsFindByUse(String floUse_id);
	//根据鲜花用途查找商品
	public List<Integer> goodsFindByType(String floType_id);
	//根据商品价格范围查询
	public PageList<Goods> goodsFindByPrice(Goods good, int currentPage,
			int pageSize,String floPriceMin,String floPriceMax);
	
	
}
