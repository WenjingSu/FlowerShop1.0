package com.shop.dao;

import com.shop.beans.dto.OrderCount;

public interface CountDao {
	public int[] tablechart(String year);

	/**
	 * 
	 * ºóÌ¨Ê×Ò³
	 */
	public OrderCount count_number();
}
