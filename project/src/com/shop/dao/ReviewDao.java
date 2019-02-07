package com.shop.dao;

import java.text.ParseException;
import java.util.List;

import com.shop.beans.Goods;
import com.shop.beans.Review;
import com.shop.beans.dto.ReviewUser;
import com.shop.page.PageList;

public interface ReviewDao {
	public boolean reviewAdd(Review review);// 添加评论

	public boolean reviewDel(Review review);// 删除评论

	//public List<ReviewUser> reviewFindAll(int gt_id);// 查询评论
	public List<ReviewUser> findReviewBygid(int g_id);// 根据商品id查询评论
	public PageList<ReviewUser> findReviewBygid1(Goods good, int currentPage,
			int pageSize) throws ParseException;
}
