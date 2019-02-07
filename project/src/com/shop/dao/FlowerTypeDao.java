package com.shop.dao;

import java.util.List;

import com.shop.beans.FlowerType;
import com.shop.page.PageList;

public interface FlowerTypeDao {
	public List<FlowerType> FlowerTypeFindAll();
	public List<FlowerType> FlowerTypeFindAllLimit();
	public PageList<FlowerType> PageFuzzySelectFlowerType(
			FlowerType flowerType, int currentPage, int pageSize);

	public FlowerType flowerTypefindbyId(Integer floType_id);
	public boolean updateFlowerTypeDel(FlowerType flowerType);
	public boolean addFlowerType(FlowerType flowerType);
	public boolean flowerTypefindbyName(String floType_name);
	public boolean flowerTypeUpdate(FlowerType flowerType);
	public boolean flowerTypeUpdateVertify(String floType_name,String floType_name_old);
	


}
