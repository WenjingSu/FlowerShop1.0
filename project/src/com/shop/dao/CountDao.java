package com.shop.dao;

import com.shop.beans.dto.OrderCount;

public interface CountDao {
	public int[] tablechart(String year);

	/**
	 * 
	 * ��̨��ҳ
	 */
	public OrderCount count_number();
}
