package com.shop.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import com.shop.DBUtil.PhoneUtil;
import com.shop.beans.Goods;
import com.shop.beans.dto.ReviewUser;
import com.shop.beans.dto.SalesRank;
import com.shop.dao.GoodsDao;
import com.shop.daoimpl.GoodsDaoImpl;
import com.shop.daoimpl.Goods_fuDaoImpl;
import com.shop.daoimpl.OrderDaoImpl;
import com.shop.daoimpl.ReviewDaoImpl;
import com.shop.daoimpl.SalesRankDaoImpl;
import com.shop.daoimpl.UserDaoImpl;
import com.shop.page.PageList;

public class TestDemo01 {

	@Test
	public void test() {
			UserDaoImpl u=new UserDaoImpl();
			boolean flag=u.addVertifyCode("15234024635", "666321");
			System.out.println(flag);

	}

}
