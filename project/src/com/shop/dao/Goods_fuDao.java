package com.shop.dao;

import java.util.List;

import com.shop.beans.Goods_fu;

public interface Goods_fuDao {
	public boolean g_fu_add(Integer g_id, String floUse_id);
	public String floUse_ids(Integer g_id);
	public boolean g_fu_update(Integer g_id, String floUse_ids);
	public Goods_fu g_fu_findbyId(Integer g_id);
	public List<Integer> g_fu_ids();
	public String floUse_ids_second(Integer gfu_id);
	//public List<String> countTopFiveUse(Integer g_id);
}
