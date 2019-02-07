package com.shop.backservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.beans.Order_goods_info;
import com.shop.beans.dto.G_Order_User_Address;
import com.shop.beans.dto.PriceRank;
import com.shop.beans.dto.SalesRank;
import com.shop.daoimpl.OrderDaoImpl;
import com.shop.daoimpl.PriceDaoImpl;
import com.shop.daoimpl.SalesRankDaoImpl;
import com.shop.page.PageList;

public class OrderBackServlet extends BaseServlet {

	// 后台
	public void order_list(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		OrderDaoImpl o = new OrderDaoImpl();
		List<G_Order_User_Address> list = o.order_formsFindAll();
		request.setAttribute("list", list);
		request.getRequestDispatcher("backmanger/order_list.jsp").forward(
				request, response);
	}

	// 后台
	public void order_detail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		Integer oid = Integer.parseInt(request.getParameter("oid"));
		OrderDaoImpl o = new OrderDaoImpl();

		List<Order_goods_info> list = o.order_formfindOid(oid);
		// for (Order_goods_info order : list) {
		// System.out.println(order.toString());
		// }
		G_Order_User_Address add = o.order_formFindByOid(oid);
		request.setAttribute("list", list);
		request.setAttribute("add", add);
		request.getRequestDispatcher("backmanger/order_detail.jsp").forward(
				request, response);
	}

	public void updatesta(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		Integer oid = Integer.parseInt(request.getParameter("oid"));
		OrderDaoImpl o = new OrderDaoImpl();

		boolean sin = o.order_formUpdateStaByOId(3, oid);
		PrintWriter out = response.getWriter();
		if (sin) {
			out.print(1);
		} else {
			out.print(2);
		}
		out.flush();

		// request.getRequestDispatcher("backmanger/order_detail.jsp")
		// .forward(request, response);
	}

	// 后台
	public void print(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		Integer oid = Integer.parseInt(request.getParameter("oid"));
		OrderDaoImpl o = new OrderDaoImpl();
		// System.out.println(oid);
		List<Order_goods_info> list = o.order_formfindOid(oid);
		for (Order_goods_info order : list) {
			// System.out.println(order.toString());
		}
		G_Order_User_Address add = o.order_formFindByOid(oid);
		request.setAttribute("list", list);
		request.setAttribute("add", add);
		// System.out.println(oid);
		request.getRequestDispatcher("backmanger/orderprint.jsp").forward(
				request, response);
		PrintWriter out = response.getWriter();

		out.print(1);
		// System.out.println(oid);
		out.flush();

	}

	// 后台
	public void pageOrderList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		OrderDaoImpl o = new OrderDaoImpl();
		String orderserial = request.getParameter("orderserial");
		String ordertime = request.getParameter("ordertime");
		// String ordertime = "2017-12-10";
		int orderstate = Integer.parseInt(request.getParameter("orderstate"));
		// System.out.println(orderserial + "--" + ordertime + "---" +
		// orderstate);
		G_Order_User_Address address = new G_Order_User_Address();
		String curentPageVal = request.getParameter("currentPage");

		// 指定当前页数
		int currentPage = 1;
		if (curentPageVal != null && !"".equals(curentPageVal)) {
			currentPage = Integer.parseInt(curentPageVal);
			// System.out.println(currentPage + "******");
		}

		// 直接将内页显示的内容的条数定义为10
		int pageSize = 10;

		// 查询数据

		address.setOrderserial(orderserial);
		address.setOrdertime(ordertime);
		address.setOrderstate(orderstate);
		PageList<G_Order_User_Address> list = o.findPage(address, currentPage,
				pageSize);
		// System.out.println(list);
		request.setAttribute("list", list);
		request.setAttribute("address", address);
		request.getRequestDispatcher("backmanger/order_list.jsp").forward(
				request, response);
	}

	// 后台
	public void sales(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		OrderDaoImpl o = new OrderDaoImpl();
		SalesRankDaoImpl s=new SalesRankDaoImpl();
		PriceDaoImpl p=new PriceDaoImpl();
		
		int[] a= o.salesVolume();
		request.setAttribute("a", a);
		
		List<SalesRank> salesRank=s.salesRank();
		request.setAttribute("salesRank", salesRank);
		
		List<PriceRank> priceRank=p.priceRank();
		request.setAttribute("priceRank", priceRank);
		/*List<String> g_name=new ArrayList<String>();
		for(SalesRank strings:salesRank)
		{
			g_name.add(strings.getG_name());
		}
		System.out.println(g_name);
		request.setAttribute("g_name", g_name);*/
		request.getRequestDispatcher("backmanger/Chart.jsp").forward(
				request, response);
	}

}
