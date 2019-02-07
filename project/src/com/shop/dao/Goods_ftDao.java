package com.shop.dao;

import com.shop.beans.Goods_ft;



public interface Goods_ftDao {
	public boolean g_ft_add(Integer g_id, String floType_ids);
	public String floType_ids(Integer g_id);
	public boolean g_ft_update(Integer g_id, String floType_ids);
	public Goods_ft g_ft_findbyId(Integer g_id);
}
