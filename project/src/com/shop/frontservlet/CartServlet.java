package com.shop.frontservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.beans.FlowerType;
import com.shop.beans.FlowerUse;
import com.shop.beans.Goods;
import com.shop.beans.GoodsType;
import com.shop.beans.User;
import com.shop.beans.dto.CartDetail;
import com.shop.dao.CartDao;
import com.shop.daoimpl.CartDaoImpl;
import com.shop.daoimpl.FlowerTypeDaoImpl;
import com.shop.daoimpl.FlowerUseDaoImpl;
import com.shop.daoimpl.GoodsDaoImpl;
import com.shop.daoimpl.GoodsTypeDaoImpl;
import com.shop.frontservlet.FrontBaseServlet;

public class CartServlet extends FrontBaseServlet {

	public void goodCart(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		if (request.getSession().getAttribute("user") == null) {
			out.print(2);
		} else {
			User u = (User) request.getSession().getAttribute("user");
			CartDaoImpl cartDao = new CartDaoImpl();
			int g_id = Integer.parseInt(request.getParameter("g_id"));
			int amount = Integer.parseInt(request.getParameter("amount"));
			int u_id = u.getU_id();
			if (cartDao.cartHasCont(u_id, g_id)) {
				boolean i = cartDao.UpdateGoodIntoCart(u_id, g_id, amount);
			} else {
				boolean i = cartDao.addshopIntoCart(u_id, g_id, amount);

			}
			out.print(1);
		}
		out.flush();
	}

	public void gotoCartSkip(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		if (request.getSession().getAttribute("user") == null) {
			out.print(2);
		}
		else
		{
			out.print(1);
		}
	}
	
	public void gotoCart(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		CartDaoImpl cartDao = new CartDaoImpl();
		User u = (User) request.getSession().getAttribute("user");
		request.getSession().getAttribute("user").toString();
		int uid = u.getU_id();
		List<CartDetail> list = cartDao.CartInfoByUid(uid);
		request.setAttribute("list", list);
		request.getRequestDispatcher("frontmanager/cart.jsp").forward(request,
				response);

	}

	public void UpdateAmountInCart(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		CartDaoImpl cartDao = new CartDaoImpl();
		int cid = Integer.parseInt(request.getParameter("c_id"));
		int count = Integer.parseInt(request.getParameter("amount"));

		boolean s = cartDao.UpdateAmountByCid(cid, count);

		if (s == true) {
			out.print(1);

		} else {
			out.print(2);
		}

		out.flush();
	}

	public void deleteCart(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		CartDaoImpl cartDao = new CartDaoImpl();
		//System.out.println("de");
		int cid = Integer.parseInt(request.getParameter("c_id"));
		boolean s = cartDao.deleteCartByCid(cid);
		//System.out.println(s);
		if (s == true) {
			out.print(1);
		} else {
			out.print(2);
		}

		out.flush();
	}

}
