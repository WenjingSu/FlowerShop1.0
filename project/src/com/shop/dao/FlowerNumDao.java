package com.shop.dao;

import java.util.List;

import com.shop.beans.FlowerNum;
import com.shop.page.PageList;

public interface FlowerNumDao {
	public List<FlowerNum> FlowerNumFindAll();

	public PageList<FlowerNum> PageFuzzySelectFlowerNum(
			FlowerNum flowerNum, int currentPage, int pageSize);

	public FlowerNum flowerNumfindbyId(Integer floNum_id);
	public boolean updateFlowerNumDel(FlowerNum flowerNum);
	public boolean addFlowerNum(FlowerNum flowerNum);
	public boolean flowerNumfindbyName(String floNum_name);
	public boolean flowerNumUpdate(FlowerNum flowerNum);
	public boolean flowerNumUpdateVertify(String floNum_name,String floNum_name_old);

}
