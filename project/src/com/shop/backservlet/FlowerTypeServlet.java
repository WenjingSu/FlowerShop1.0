package com.shop.backservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.beans.FlowerType;
import com.shop.beans.FlowerType;
import com.shop.daoimpl.FlowerTypeDaoImpl;
import com.shop.daoimpl.FlowerTypeDaoImpl;
import com.shop.page.PageList;

public class FlowerTypeServlet extends BaseServlet {

	public void flowertype_list(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		FlowerType flowerType = new FlowerType();
		// List<Goods> list = goods.goodsFindAll();
		String floType_name = request.getParameter("search");
		// System.out.println(goodsname);
		String currentPageVal = request.getParameter("currentPage");
		FlowerTypeDaoImpl flowerTypeDaoImpl = new FlowerTypeDaoImpl();
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
		flowerType.setFloType_name(floType_name);
		PageList<FlowerType> flowerTypes = flowerTypeDaoImpl
				.PageFuzzySelectFlowerType(flowerType, currentPage, pageSize);
		// System.out.println(list);
		request.setAttribute("flowerTypes", flowerTypes);
		request.getRequestDispatcher("backmanger/flowerType_list.jsp").forward(
				request, response);
	}

	// 花材逻辑删除
	public void updateFlowerTypeDel(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Integer floType_id = Integer.parseInt(request
				.getParameter("floType_id"));
		FlowerTypeDaoImpl flowerTypeDaoImpl = new FlowerTypeDaoImpl();
		FlowerType flowerType = flowerTypeDaoImpl
				.flowerTypefindbyId(floType_id);
		boolean flag = flowerTypeDaoImpl.updateFlowerTypeDel(flowerType);
		if (flag == true) {
			out.print(1);
		} else {
			out.print(2);

		}
		out.flush();
		out.close();
	}

	// 添加新花材
	public void add_FlowerType(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String floType_name = request.getParameter("floType_name");
		String floType_mean = request.getParameter("floType_mean");
		FlowerTypeDaoImpl flowerTypeDaoImpl = new FlowerTypeDaoImpl();
		FlowerType flowerType = new FlowerType();
		flowerType.setFloType_name(floType_name);
		flowerType.setFloType_mean(floType_mean);
		boolean flag1 = flowerTypeDaoImpl.flowerTypefindbyName(floType_name);
		if (flag1 == true) {
			out.print(3);
		} else {
			boolean flag = flowerTypeDaoImpl.addFlowerType(flowerType);
			if (flag == true) {
				out.print(1);
			} else {
				out.print(2);
			}
			out.flush();
			out.close();
		}
	}

	// 编辑花材信息跳转
	public void redact_FlowerType_skip(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Integer floType_id = Integer.parseInt(request.getParameter("floType_id"));
		FlowerTypeDaoImpl flowerTypeDaoImpl = new FlowerTypeDaoImpl();
		FlowerType flowerType = new FlowerType();
		flowerType = flowerTypeDaoImpl.flowerTypefindbyId(floType_id);
		request.setAttribute("flowerType", flowerType);
		request.getRequestDispatcher("backmanger/edit_flowerType.jsp").forward(
				request, response);

	}

	// 编辑花材信息
	public void redact_FlowerType(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		FlowerTypeDaoImpl flowerTypeDaoImpl = new FlowerTypeDaoImpl();
		FlowerType flowerType = new FlowerType();
		FlowerType flowerType1 = new FlowerType();
		// 获取参数
		Integer floType_id = Integer.parseInt(request.getParameter("floType_id"));
		String floType_name = request.getParameter("floType_name");
		String floType_mean = request.getParameter("floType_mean");
		flowerType = flowerTypeDaoImpl.flowerTypefindbyId(floType_id);
		// System.out.println(flowerType1.getG_name());
		// System.out.println(g_name);
		flowerType1.setFloType_id(floType_id);
		flowerType1.setFloType_name(floType_name);
		flowerType1.setFloType_mean(floType_mean);

		if (floType_name.equals(flowerType.getFloType_name())) {
			boolean flag = flowerTypeDaoImpl.flowerTypeUpdate(flowerType1);
			if (flag == true) {
				out.print(1);
			} else {
				out.print(2);
			}
		} else {
			boolean flag1 = flowerTypeDaoImpl.flowerTypeUpdateVertify(
					floType_name, flowerType.getFloType_name());
			if (flag1 == false) {
				out.print(3);

			} else {
				boolean flag = flowerTypeDaoImpl.flowerTypeUpdate(flowerType1);
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
