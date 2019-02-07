package com.shop.backservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.beans.FlowerUse;
import com.shop.daoimpl.FlowerUseDaoImpl;
import com.shop.page.PageList;

public class FlowerUseServlet extends BaseServlet {

	public void flowerUse_list(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		FlowerUse flowerUse = new FlowerUse();
		// List<Goods> list = goods.goodsFindAll();
		String floUse_name = request.getParameter("search");
		// System.out.println(goodsname);
		String currentPageVal = request.getParameter("currentPage");
		FlowerUseDaoImpl flowerUseDaoImpl = new FlowerUseDaoImpl();
		// System.out.println(currentPageVal);

		// 指定当前页数
		int currentPage = 1;
		if (currentPageVal != null && !"".equals(currentPageVal)) {
			currentPage = Integer.parseInt(currentPageVal);
			// System.out.println(currentPage + "******");
		}

		// 直接将内页显示的内容的条数定义为5
		int pageSize = 5;

		// 查询数据
		flowerUse.setFloUse_name(floUse_name);
		PageList<FlowerUse> flowerUses = flowerUseDaoImpl
				.PageFuzzySelectFlowerUse(flowerUse, currentPage, pageSize);
		// System.out.println(list);
		request.setAttribute("flowerUses", flowerUses);
		request.getRequestDispatcher("backmanger/flowerUse_list.jsp").forward(
				request, response);
	}

	// 花材逻辑删除
	public void updateFlowerUseDel(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Integer floUse_id = Integer.parseInt(request.getParameter("floUse_id"));
		FlowerUseDaoImpl flowerUseDaoImpl = new FlowerUseDaoImpl();
		FlowerUse flowerUse = flowerUseDaoImpl.flowerUsefindbyId(floUse_id);
		boolean flag = flowerUseDaoImpl.updateFlowerUseDel(flowerUse);
		if (flag == true) {
			out.print(1);
		} else {
			out.print(2);

		}
		out.flush();
		out.close();
	}

	public void add_FlowerUse(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String floUse_name = request.getParameter("floUse_name");
		FlowerUseDaoImpl flowerUseDaoImpl = new FlowerUseDaoImpl();
		FlowerUse flowerUse = new FlowerUse();
		flowerUse.setFloUse_name(floUse_name);
		boolean flag1 = flowerUseDaoImpl.flowerUsefindbyName(floUse_name);
		if (flag1 == true) {
			out.print(3);
		} else {
			boolean flag = flowerUseDaoImpl.addFlowerUse(flowerUse);
			if (flag == true) {
				out.print(1);
			} else {
				out.print(2);
			}
			out.flush();
			out.close();
		}
	}

	// 编辑用途信息跳转
	public void redact_FlowerUse_skip(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Integer floUse_id = Integer.parseInt(request
				.getParameter("floUse_id"));
		FlowerUseDaoImpl flowerUseDaoImpl = new FlowerUseDaoImpl();
		FlowerUse flowerUse = new FlowerUse();
		flowerUse = flowerUseDaoImpl.flowerUsefindbyId(floUse_id);
		request.setAttribute("flowerUse", flowerUse);
		request.getRequestDispatcher("backmanger/edit_flowerUse.jsp").forward(
				request, response);

	}

	// 编辑用途信息
	public void redact_FlowerUse(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		FlowerUseDaoImpl flowerUseDaoImpl = new FlowerUseDaoImpl();
		FlowerUse flowerUse = new FlowerUse();
		FlowerUse flowerUse1 = new FlowerUse();
		// 获取参数
		Integer floUse_id = Integer.parseInt(request
				.getParameter("floUse_id"));
		String floUse_name = request.getParameter("floUse_name");
		flowerUse = flowerUseDaoImpl.flowerUsefindbyId(floUse_id);
		
		flowerUse1.setFloUse_id(floUse_id);
		flowerUse1.setFloUse_name(floUse_name);
		

		if (floUse_name.equals(flowerUse.getFloUse_name())) {
			boolean flag = flowerUseDaoImpl.flowerUseUpdate(flowerUse1);
			if (flag == true) {
				out.print(1);
			} else {
				out.print(2);
			}
		} else {
			boolean flag1 = flowerUseDaoImpl.flowerUseUpdateVertify(
					floUse_name, flowerUse.getFloUse_name());
			if (flag1 == false) {
				out.print(3);

			} else {
				boolean flag = flowerUseDaoImpl.flowerUseUpdate(flowerUse1);
				if (flag == true) {
					out.print(1);
				} else {
					out.print(2);
				}

			}

		}
		out.flush();
		out.close();

	}
}
