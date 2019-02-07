package com.shop.dao;

import java.util.List;

import com.shop.beans.GoodsType;

public interface GoodsTypeDao {
	// 查找所有商品种类
	public List<GoodsType> goodstypeFindAll();

	// 查找单个商品种类
	public GoodsType goodstypeFindByGtid(Integer gtid);

	// 逻辑删除商品子类
	public boolean goodstypeDel(Integer gtid);

	// 添加商品种类
	public boolean goodstypeAdd(GoodsType goodstype);

	// 添加子类
	public boolean goodstypeAddChildren(GoodsType goodstype);

	// 修改类型信息
	public boolean goodstypeUpdate(GoodsType goodstype);

	// 查找所有子类
	public List<GoodsType> goodstypefindByFather(Integer gtid);

	// 查找所有类型limit
	public List<GoodsType> goodstypeFindAllLimit();

	// 查找所有子类limit
	public List<GoodsType> goodstypefindByFatherLimit(Integer gtid);
	//添加商品类型种类名验证
	public boolean goodsTypeAddNameVerify(String gt_typename);
	//修改商品类型信息种类名验证
	public boolean goodsTypeUpdateNameVerify(String gt_typename,String gt_typenameold);
}
