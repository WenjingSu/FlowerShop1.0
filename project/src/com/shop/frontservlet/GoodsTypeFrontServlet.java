package com.shop.frontservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.beans.Goods;
import com.shop.beans.GoodsType;
import com.shop.daoimpl.GoodsDaoImpl;
import com.shop.daoimpl.GoodsTypeDaoImpl;

public class GoodsTypeFrontServlet extends FrontBaseServlet {

	// 查询所有种类
		public void goodstypeFindAll(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			GoodsTypeDaoImpl goodsTypeDaoImpl = new GoodsTypeDaoImpl();
			GoodsDaoImpl goodsDaoImpl=new GoodsDaoImpl();
			List<Goods> goods=goodsDaoImpl.recentGoods();
			List<GoodsType> goodstypes =goodsTypeDaoImpl.goodstypeFindAll();
			request.setAttribute("goods", goods);
			request.setAttribute("goodsTypes01", goodstypes);
			request.getRequestDispatcher("frontmanager/index.jsp")
					.forward(request, response);
		}

}
