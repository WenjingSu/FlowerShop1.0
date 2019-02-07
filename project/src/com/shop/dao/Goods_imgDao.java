package com.shop.dao;

import com.shop.beans.GoodsImgs;

public interface Goods_imgDao {
	public boolean addImg(GoodsImgs goodsImgs);
	public GoodsImgs findById(Integer g_id);
	public String images(Integer g_id);
	public boolean updateImg(GoodsImgs goodsImgs);
}
