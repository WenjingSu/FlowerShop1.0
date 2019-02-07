package com.shop.backservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.DBUtil.PhoneUtil;
import com.shop.beans.Goods;
import com.shop.beans.User;
import com.shop.daoimpl.GoodsDaoImpl;
import com.shop.daoimpl.UserDaoImpl;
import com.shop.page.PageList;

public class UsersServlet extends BaseServlet {
	public void user_list(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		User user = new User();
		// List<Goods> list = goods.goodsFindAll();
		String u_name = request.getParameter("search");
		// System.out.println(goodsname);
		String currentPageVal = request.getParameter("currentPage");
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		// System.out.println(currentPageVal);

		// ָ����ǰҳ��
		int currentPage = 1;
		if (currentPageVal != null && !"".equals(currentPageVal)) {
			currentPage = Integer.parseInt(currentPageVal);
			// System.out.println(currentPage + "******");
		}

		// ֱ�ӽ���ҳ��ʾ�����ݵ���������Ϊ5
		int pageSize = 5;

		// ��ѯ����
		user.setU_name(u_name);
		PageList<User> users = userDaoImpl.PageFuzzySelectUser(user,
				currentPage, pageSize);
		// System.out.println(list);
		request.setAttribute("users", users);
		request.getRequestDispatcher("backmanger/user_list.jsp").forward(
				request, response);
	}

	// �鿴�����û�
	public void userfindall(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		UserDaoImpl userDaoImpl = new UserDaoImpl();
		List<User> users = userDaoImpl.userfindall();
		// System.out.println(users);
		request.setAttribute("users", users);

		request.getRequestDispatcher("backmanger/user_list.jsp").forward(
				request, response);
	}

	// �鿴�����û�����
	public void userfindbyuId1(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Integer u_id = Integer.parseInt(request.getParameter("u_id"));
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		User user = userDaoImpl.userfindbyuId(u_id);
		request.setAttribute("user", user);
		request.getRequestDispatcher("backmanger/user_info.jsp").forward(
				request, response);
	}

	// ��ѯ�����û�
	public void userfindbyuId2(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Integer u_id = Integer.parseInt(request.getParameter("userId"));
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		User user = userDaoImpl.userfindbyuId(u_id);
		// System.out.println(user);
		request.setAttribute("user", user);
		request.getRequestDispatcher("backmanger/user_info2.jsp").forward(
				request, response);

	}

	// �û��߼�ɾ��
	public void updateUserDel(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		Integer u_id = Integer.parseInt(request.getParameter("u_id"));
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		User user = userDaoImpl.userfindbyuId(u_id);
		boolean flag = userDaoImpl.updateUserDel(user);
		if (flag == true) {
			out.print(1);
		} else {
			out.print(2);
		}
		out.flush();
		out.close();
	}

}
