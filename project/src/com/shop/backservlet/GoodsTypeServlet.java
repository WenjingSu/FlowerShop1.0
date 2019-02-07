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
	// ��ѯ��������
	public void goodstypeFindAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		GoodsTypeDaoImpl GoodsTypeDaoImpl = new GoodsTypeDaoImpl();
		List<GoodsType> goodstypes = GoodsTypeDaoImpl.goodstypeFindAll();
		// System.out.println(goodstypes);
		request.setAttribute("goodsTypes01", goodstypes);
		request.getRequestDispatcher("backmanger/product_category.jsp")
				.forward(request, response);
	}

	

	// ��Ʒ�����߼�ɾ��
	public void goodstypeDel(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// ���ñ���
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

	// ���Ҳ������ࣨǰ̨��
	public void goodstypeFindAllLimit(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		GoodsTypeDaoImpl GoodsTypeDaoImpl = new GoodsTypeDaoImpl();
		List<GoodsType> goodstypes = GoodsTypeDaoImpl.goodstypeFindAllLimit();
		System.out.println(goodstypes);
		request.setAttribute("goodsTypes", goodstypes);
		request.getRequestDispatcher("frontmanger/index.jsp").forward(request,
				response);
	}

	// ���һ���������ת
	public void goodstypeAddSkip(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("backmanger/edit_category1.jsp").forward(
				request, response);
	}

	// ��Ʒ���������������֤
	public void gt_typenameVertify(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// ���ñ���
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
	// ��Ʒ�����޸���������֤
		public void gt_typenameVertify02(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			// ���ñ���
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
	// �������Ʒ����
	public void goodstypeAdd(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// ���ñ���
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
		// �����ӳɹ������������
		if (flag == true) {
			out.print(1);
		} else {
			out.print(2);
		}
		out.flush();
		out.close();
	}

	// �޸���Ʒ������Ϣ
	public void goodstypeUpdate(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// ���ñ���
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

	// �༭������Ϣ
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

	// ��һ��������Ӷ����������ת
	public void goodstypeAddChildrenSkip(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Integer gt_id = Integer.parseInt(request.getParameter("g_id"));
		request.setAttribute("g_id", gt_id);
		request.getRequestDispatcher("backmanger/edit_category3.jsp").forward(
				request, response);
	}

	// ��һ��������Ӷ�������
	public void goodstypeAddChildren(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// ���ñ���
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
		// �����ӳɹ������������
		if (flag == true) {
			out.print(1);
		} else {
			out.print(2);
		}
		out.flush();
		out.close();
	}

}
