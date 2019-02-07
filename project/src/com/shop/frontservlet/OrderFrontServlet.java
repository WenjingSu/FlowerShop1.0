package com.shop.frontservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.shop.beans.User;
import com.shop.beans.dto.OrderList;
import com.shop.daoimpl.OrderDaoImpl;
import com.shop.beans.FlowerType;
import com.shop.beans.FlowerUse;
import com.shop.beans.Goods;
import com.shop.beans.GoodsType;
import com.shop.beans.dto.G_Order_User_Address;
import com.shop.beans.dto.Order_goods_goodsimg;
import com.shop.daoimpl.FlowerTypeDaoImpl;
import com.shop.daoimpl.FlowerUseDaoImpl;
import com.shop.daoimpl.GoodsTypeDaoImpl;
import com.shop.page.PageList;

public class OrderFrontServlet extends FrontBaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 待付款页面
	public void User_order_detail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		Integer oid = Integer.parseInt(request.getParameter("oid"));
		OrderDaoImpl o = new OrderDaoImpl();
		Integer state = Integer.parseInt(request.getParameter("state"));

		List<Order_goods_goodsimg> list = o.SelectCartStateByState(oid);
		// for (Order_goods_goodsimg order : list) {
		// System.out.println(order.toString());
		// }

		GoodsTypeDaoImpl goodsTypeDaoImpl = new GoodsTypeDaoImpl();
		FlowerTypeDaoImpl flowerTypeDaoImpl = new FlowerTypeDaoImpl();
		FlowerUseDaoImpl flowerUseDaoImpl = new FlowerUseDaoImpl();
		List<GoodsType> goodstypes = goodsTypeDaoImpl.goodstypeFindAll();
		List<FlowerType> flowerTypes = flowerTypeDaoImpl
				.FlowerTypeFindAllLimit();
		List<FlowerUse> flowerUses = flowerUseDaoImpl.FlowerUseFindAll();
		request.setAttribute("goodsTypes01", goodstypes);
		request.setAttribute("flowerTypes", flowerTypes);
		request.setAttribute("flowerUses", flowerUses);

		G_Order_User_Address add = o.order_formFindByOid(oid);
		request.setAttribute("list", list);
		request.setAttribute("add", add);
		request.setAttribute("state", state);
		request.setAttribute("oid", oid);
		if (state == 1) {
			request.getRequestDispatcher("frontmanager/orderDetail.jsp")
					.forward(request, response);
		} else {
			request.getRequestDispatcher("frontmanager/orderLogistics.jsp")
					.forward(request, response);
		}
	}

	// 付款结束转发至所有订单页面
	public void userupdateorder(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		Integer oid = Integer.parseInt(request.getParameter("oid"));
		Integer orderstate = Integer.parseInt(request
				.getParameter("orderstate"));
		OrderDaoImpl o = new OrderDaoImpl();
		boolean sin = o.order_formUpdateStaByOId(orderstate, oid);
		request.setAttribute("oid", oid);
		request.getRequestDispatcher(
				"OrderFrontServlet?method=orderState&orderstate=0&oid=" + oid)
				.forward(request, response);
	}

	// 订单状态
	public void orderState(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		User u = (User) request.getSession().getAttribute("user");
		request.getSession().getAttribute("user").toString();
	
		int orderState = Integer.parseInt(request.getParameter("orderstate"));
		
		String currentPageVal = request.getParameter("currentPage");
        OrderDaoImpl orderDaoImpl =new OrderDaoImpl();
		// System.out.println(currentPageVal);

		// 指定当前页数
		int currentPage = 1;
		if (currentPageVal != null && !"".equals(currentPageVal)) {
			currentPage = Integer.parseInt(currentPageVal);
			// System.out.println(currentPage + "******");
		}

		// 直接将内页显示的内容的条数定义为6
		int pageSize = 6;

		// 查询数据
		
		
		PageList<OrderList> list = orderDaoImpl.selectOrderAllByState1(u,
				currentPage, pageSize,orderState);

		request.setAttribute("orderstate", orderState);
		request.setAttribute("list", list);
		request.getRequestDispatcher("frontmanager/user_orderlist.jsp")
				.forward(request, response);
	}

	
}
