package com.shop.frontservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.beans.FlowerType;
import com.shop.beans.FlowerUse;
import com.shop.beans.Goods;
import com.shop.beans.GoodsType;
import com.shop.daoimpl.FlowerTypeDaoImpl;
import com.shop.daoimpl.FlowerUseDaoImpl;
import com.shop.daoimpl.GoodsDaoImpl;
import com.shop.daoimpl.GoodsTypeDaoImpl;

public class FirstServlet extends FrontBaseServlet {

	// 查询所有种类
	public void goodstypeFindAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		GoodsTypeDaoImpl goodsTypeDaoImpl = new GoodsTypeDaoImpl();
		GoodsDaoImpl goodsDaoImpl = new GoodsDaoImpl();
		FlowerTypeDaoImpl flowerTypeDaoImpl=new FlowerTypeDaoImpl();
		FlowerUseDaoImpl flowerUseDaoImpl=new FlowerUseDaoImpl();
		List<Goods> goods = goodsDaoImpl.recentGoods();
		List<GoodsType> goodstypes = goodsTypeDaoImpl.goodstypeFindAll();
		List<FlowerType> flowerTypes=flowerTypeDaoImpl.FlowerTypeFindAllLimit();
		List<FlowerUse> flowerUses=flowerUseDaoImpl.FlowerUseFindAll();
		request.setAttribute("goods", goods);
		request.setAttribute("goodsTypes01", goodstypes);
		request.setAttribute("flowerTypes", flowerTypes);
		request.setAttribute("flowerUses", flowerUses);
		request.getRequestDispatcher("frontmanager/index.jsp").forward(request,
				response);
	}
}
