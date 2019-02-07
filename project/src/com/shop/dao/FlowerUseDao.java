package com.shop.dao;

import java.util.List;

import com.shop.beans.FlowerUse;
import com.shop.page.PageList;

public interface FlowerUseDao {
	public List<FlowerUse> FlowerUseFindAll();
	public List<FlowerUse> FlowerUseFindAllLimit();
	public PageList<FlowerUse> PageFuzzySelectFlowerUse(FlowerUse flowerUse,
			int currentPage, int pageSize);

	public FlowerUse flowerUsefindbyId(Integer floUse_id);

	public boolean updateFlowerUseDel(FlowerUse flowerUse);
	public boolean addFlowerUse(FlowerUse flowerUse);
	public boolean flowerUsefindbyName(String floUse_name);
	public boolean flowerUseUpdate(FlowerUse flowerUse);
	public boolean flowerUseUpdateVertify(String floUse_name,String floUse_name_old);
}
