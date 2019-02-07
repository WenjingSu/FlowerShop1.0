package com.shop.backservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.beans.GoodsType;
import com.shop.daoimpl.GoodsTypeDaoImpl;
import com.shop.daoimpl.ManagerDaoImpl;

public class GoodsTypeServlet extends BaseServlet {
	// 查询所有种类
	public void goodstypeFindAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		GoodsTypeDaoImpl GoodsTypeDaoImpl = new GoodsTypeDaoImpl();
		List<GoodsType> goodstypes = GoodsTypeDaoImpl.goodstypeFindAll();
		// System.out.println(goodstypes);
		request.setAttribute("goodsTypes01", goodstypes);
		request.getRequestDispatcher("backmanger/product_category.jsp")
				.forward(request, response);
	}

	

	// 商品种类逻辑删除
	public void goodstypeDel(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Integer gt_id = Integer.parseInt(request.getParameter("gtype_id"));
		GoodsTypeDaoImpl GoodsTypeDaoImpl = new GoodsTypeDaoImpl();
		boolean flag = GoodsTypeDaoImpl.goodstypeDel(gt_id);
		if (flag == true) {
			out.print(1);
		} else {
			out.print(2);
		}
		out.flush();
		out.close();
	}

	// 查找部分种类（前台）
	public void goodstypeFindAllLimit(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		GoodsTypeDaoImpl GoodsTypeDaoImpl = new GoodsTypeDaoImpl();
		List<GoodsType> goodstypes = GoodsTypeDaoImpl.goodstypeFindAllLimit();
		System.out.println(goodstypes);
		request.setAttribute("goodsTypes", goodstypes);
		request.getRequestDispatcher("frontmanger/index.jsp").forward(request,
				response);
	}

	// 添加一级分类的跳转
	public void goodstypeAddSkip(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("backmanger/edit_category1.jsp").forward(
				request, response);
	}

	// 商品种类添加种类名验证
	public void gt_typenameVertify(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String gt_typename = request.getParameter("gt_typename");
		GoodsTypeDaoImpl goodsTypeDaoImpl = new GoodsTypeDaoImpl();
		boolean flag = goodsTypeDaoImpl.goodsTypeAddNameVerify(gt_typename);
		if (flag == true) {
			out.print(1);
		} else {
			out.print(2);
		}
		out.flush();
		out.close();
	}
	// 商品种类修改种类名验证
		public void gt_typenameVertify02(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			// 设置编码
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();	
			String gt_typename = request.getParameter("gt_typename");
			String gt_typenameold = request.getParameter("gt_typenameold");
			GoodsTypeDaoImpl goodsTypeDaoImpl = new GoodsTypeDaoImpl();
			boolean flag = goodsTypeDaoImpl.goodsTypeUpdateNameVerify(gt_typename,gt_typenameold);
			if (flag == true) {
				out.print(1);
			} else {
				out.print(2);
			}
			out.flush();
			out.close();
		}
	// 添加新商品种类
	public void goodstypeAdd(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String gt_typename = request.getParameter("gt_typename");
		String gt_mark = request.getParameter("gt_mark");
		GoodsTypeDaoImpl GoodsTypeDaoImpl = new GoodsTypeDaoImpl();
		GoodsType goodstype = new GoodsType();
		goodstype.setGt_typename(gt_typename);
		goodstype.setGt_mark(gt_mark);
		boolean flag = GoodsTypeDaoImpl.goodstypeAdd(goodstype);
		// System.out.println(flag);
		// 如果添加成功，则查找所有
		if (flag == true) {
			out.print(1);
		} else {
			out.print(2);
		}
		out.flush();
		out.close();
	}

	// 修改商品种类信息
	public void goodstypeUpdate(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		Integer gtype_id = Integer.parseInt(request.getParameter("gtype_id"));
		String gt_typename = request.getParameter("gt_typename");
		String gt_mark = request.getParameter("gt_mark");
		GoodsType goodstype = new GoodsType();
		goodstype.setGt_id(gtype_id);
		goodstype.setGt_typename(gt_typename);
		goodstype.setGt_mark(gt_mark);
		GoodsTypeDaoImpl GoodsTypeDaoImpl = new GoodsTypeDaoImpl();
		boolean flag = GoodsTypeDaoImpl.goodstypeUpdate(goodstype);
		// System.out.println(flag);
		if (flag == true) {
			out.print(1);
		} else {
			out.print(2);
		}
		out.flush();
		out.close();

	}

	// 编辑分类信息
	public void goodstypeEdit(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Integer gt_id = Integer.parseInt(request.getParameter("g_id"));
		// System.out.println(gt_id);
		GoodsTypeDaoImpl GoodsTypeDaoImpl = new GoodsTypeDaoImpl();
		GoodsType goodtype = GoodsTypeDaoImpl.goodstypeFindByGtid(gt_id);
		// System.out.println(goodtype);
		request.setAttribute("goodtype", goodtype);
		request.getRequestDispatcher("backmanger/edit_category2.jsp").forward(
				request, response);
	}

	// 给一级分类添加二级分类的跳转
	public void goodstypeAddChildrenSkip(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Integer gt_id = Integer.parseInt(request.getParameter("g_id"));
		request.setAttribute("g_id", gt_id);
		request.getRequestDispatcher("backmanger/edit_category3.jsp").forward(
				request, response);
	}

	// 给一级分类添加二级分类
	public void goodstypeAddChildren(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Integer fgt_id = Integer.parseInt(request.getParameter("fgt_id"));
		String gt_typename = request.getParameter("gt_typename");
		String gt_mark = request.getParameter("gt_mark");
		GoodsType goodstype = new GoodsType();
		goodstype.setGt_id(fgt_id);
		goodstype.setGt_typename(gt_typename);
		goodstype.setGt_mark(gt_mark);
		GoodsTypeDaoImpl GoodsTypeDaoImpl = new GoodsTypeDaoImpl();
		boolean flag = GoodsTypeDaoImpl.goodstypeAddChildren(goodstype);
		// 如果添加成功，则查找所有
		if (flag == true) {
			out.print(1);
		} else {
			out.print(2);
		}
		out.flush();
		out.close();
	}

}
