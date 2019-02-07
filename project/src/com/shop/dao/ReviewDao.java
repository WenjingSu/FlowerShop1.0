package com.shop.dao;

import java.text.ParseException;
import java.util.List;

import com.shop.beans.Goods;
import com.shop.beans.Review;
import com.shop.beans.dto.ReviewUser;
import com.shop.page.PageList;

public interface ReviewDao {
	public boolean reviewAdd(Review review);// �������

	public boolean reviewDel(Review review);// ɾ������

	//public List<ReviewUser> reviewFindAll(int gt_id);// ��ѯ����
	public List<ReviewUser> findReviewBygid(int g_id);// ������Ʒid��ѯ����
	public PageList<ReviewUser> findReviewBygid1(Goods good, int currentPage,
			int pageSize) throws ParseException;
}
