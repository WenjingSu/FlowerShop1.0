package com.shop.backservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.beans.FlowerNum;
import com.shop.beans.Goods;

import com.shop.daoimpl.FlowerNumDaoImpl;
import com.shop.daoimpl.GoodsDaoImpl;

import com.shop.page.PageList;

public class FlowerNumServlet extends BaseServlet {

	public void flowernum_list(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		FlowerNum flowerNum = new FlowerNum();
		String floNum_name = request.getParameter("search");
		String currentPageVal = request.getParameter("currentPage");
		FlowerNumDaoImpl flowerNumDaoImpl = new FlowerNumDaoImpl();

		// 指定当前页数
		int currentPage = 1;
		if (currentPageVal != null && !"".equals(currentPageVal)) {
			currentPage = Integer.parseInt(currentPageVal);
			// System.out.println(currentPage + "******");
		}

		// 直接将内页显示的内容的条数定义为5
		int pageSize = 5;

		// 查询数据
		flowerNum.setFloNum_name(floNum_name);
		PageList<FlowerNum> flowerNums = flowerNumDaoImpl
				.PageFuzzySelectFlowerNum(flowerNum, currentPage, pageSize);
		// System.out.println(list);
		request.setAttribute("flowerNums", flowerNums);
		request.getRequestDispatcher("backmanger/flowerNum_list.jsp").forward(
				request, response);
	}

	// 枝数逻辑删除
	public void updateFlowerNumDel(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Integer floNum_id = Integer.parseInt(request.getParameter("floNum_id"));
		FlowerNumDaoImpl flowerNumDaoImpl = new FlowerNumDaoImpl();
		FlowerNum flowerNum = flowerNumDaoImpl.flowerNumfindbyId(floNum_id);
		boolean flag = flowerNumDaoImpl.updateFlowerNumDel(flowerNum);
		if (flag == true) {
			out.print(1);
		} else {
			out.print(2);

		}
		out.flush();
		out.close();
	}

	// 添加新枝数
	public void add_FlowerNum(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String floNum_name = request.getParameter("floNum_name");

		String floNum_mean = request.getParameter("floNum_mean");
		FlowerNumDaoImpl flowerNumDaoImpl = new FlowerNumDaoImpl();
		FlowerNum flowerNum = new FlowerNum();
		flowerNum.setFloNum_name(floNum_name);
		flowerNum.setFloNum_mean(floNum_mean);
		boolean flag1 = flowerNumDaoImpl.flowerNumfindbyName(floNum_name);
		if (flag1 == true) {
			out.print(3);
		} else {
			boolean flag = flowerNumDaoImpl.addFlowerNum(flowerNum);
			if (flag == true) {
				out.print(1);
			} else {
				out.print(2);
			}
			out.flush();
			out.close();
		}
	}

	// 编辑枝数信息跳转
	public void redact_FlowerNum_skip(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Integer floNum_id = Integer.parseInt(request.getParameter("floNum_id"));
		FlowerNumDaoImpl flowerNumDaoImpl = new FlowerNumDaoImpl();
		FlowerNum flowerNum = new FlowerNum();
		flowerNum = flowerNumDaoImpl.flowerNumfindbyId(floNum_id);
		request.setAttribute("flowerNum", flowerNum);
		request.getRequestDispatcher("backmanger/edit_flowerNum.jsp").forward(
				request, response);

	}

	// 编辑枝数信息
	public void redact_FlowerNum(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		FlowerNumDaoImpl flowerNumDaoImpl = new FlowerNumDaoImpl();
		FlowerNum flowerNum = new FlowerNum();
		FlowerNum flowerNum1 = new FlowerNum();
		// 获取参数
		Integer floNum_id = Integer.parseInt(request.getParameter("floNum_id"));
		String floNum_name = request.getParameter("floNum_name");
		String floNum_mean = request.getParameter("floNum_mean");
		flowerNum = flowerNumDaoImpl.flowerNumfindbyId(floNum_id);
		// System.out.println(flowerNum1.getG_name());
		// System.out.println(g_name);
		flowerNum1.setFloNum_id(floNum_id);
		flowerNum1.setFloNum_name(floNum_name);
		flowerNum1.setFloNum_mean(floNum_mean);

		if (floNum_name.equals(flowerNum.getFloNum_name())) {
			boolean flag = flowerNumDaoImpl.flowerNumUpdate(flowerNum1);
			if (flag == true) {
				out.print(1);
			} else {
				out.print(2);
			}
		} else {
			boolean flag1 = flowerNumDaoImpl.flowerNumUpdateVertify(
					floNum_name, flowerNum.getFloNum_name());
			if (flag1 == false) {
				out.print(3);

			} else {
				boolean flag = flowerNumDaoImpl.flowerNumUpdate(flowerNum1);
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
