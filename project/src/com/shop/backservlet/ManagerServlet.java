package com.shop.backservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.beans.Manager;
import com.shop.dao.ManagerDao;
import com.shop.daoimpl.ManagerDaoImpl;

public class ManagerServlet extends BaseServlet {

	// 1.��¼
	public void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ���ñ���
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		// ��������
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// ��������
		ManagerDaoImpl managerDaoImpl = new ManagerDaoImpl();
		Manager manager = new Manager();
		manager.setM_name(username);
		manager.setM_password(password);
		manager = managerDaoImpl.managerLogin(manager);
		// ������Ӧ
		if (manager == null) {
			request.getRequestDispatcher("backmanger/adminLogin1.jsp").forward(
					request, response);
		} else {
			request.getSession().setAttribute("manager", manager);
			request.getRequestDispatcher("backmanger/index1.jsp").forward(
					request, response);
		}
	}

	// 2.��ȫ�˳�
	public void exit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ���ñ���
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		// �Ƴ�session�е�����
		request.getSession().removeAttribute("manager");
		// request.getRequestDispatcher("backmanger/adminLogin.jsp").forward(
		// request, response);
		String path = request.getContextPath();
		// System.out.println(path);
		response.sendRedirect(path + "/backmanger/adminLogin.jsp");//
	}

	// 3.��֤����
	public void pwd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ���ñ���
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// ��ȡҳ�������
		String password = request.getParameter("oldpassword");
		Manager manager = (Manager) request.getSession()
				.getAttribute("manager");
		String realpwd = manager.getM_password();
		if (password.equals(realpwd)) {
			out.print(1);
		} else {
			out.print(2);
		}
		out.flush();
		out.close();
	}

	// 4.�޸�����
	public void m_pwd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ���ñ���
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// ��ȡҳ�������
		String password = request.getParameter("newpassword");
		Manager manager = (Manager) request.getSession()
				.getAttribute("manager");
		manager.setM_password(password);
		ManagerDaoImpl managerDaoImpl = new ManagerDaoImpl();
		boolean flag = managerDaoImpl.managerUpdatePwd(manager);
		if (flag == true) {
			out.print(1);
		} else {
			out.print(2);
		}
		out.flush();
		out.close();
	}

	// 5.����Ա�б�ҳ��
	public void managerFindAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// ���ñ���
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		Manager manager = (Manager) request.getSession()
				.getAttribute("manager");
		ManagerDaoImpl managerDaoImpl = new ManagerDaoImpl();
		List<Manager> list = managerDaoImpl.managerFindAll(manager.getM_id());
		request.setAttribute("list", list);
		request.getRequestDispatcher("backmanger/admin_list.jsp").forward(
				request, response);
	}

	// 6.��ӹ���Ա
	public void add_manager(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// ���ñ���
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String m_name = request.getParameter("m_name");
		String m_password = request.getParameter("m_password");
		ManagerDaoImpl managerDaoImpl = new ManagerDaoImpl();
		Manager manager = new Manager();
		manager.setM_name(m_name);
		manager.setM_password(m_password);
		manager.setRole(2);
		boolean flag = managerDaoImpl.managerAdd(manager);
		if (flag == true) {
			out.print(1);
		} else {
			out.print(2);
		}
		out.flush();
		out.close();
	}

	// 7.�޸Ĺ���ԱȨ��
	public void revise_manager(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// ���ñ���
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String mid = request.getParameter("m_id");
		int m_id = Integer.parseInt(mid);
		String role = request.getParameter("m_role");
		int m_role = Integer.parseInt(role);
		//System.out.println(m_role);
		ManagerDaoImpl managerDaoImpl = new ManagerDaoImpl();
		boolean flag = managerDaoImpl.managerUpdate(m_id, m_role);
		if (flag == true) {
			out.print(1);
		} else {
			out.print(2);
		}
		out.flush();
		out.close();
	}

	// 8.ɾ������Ա
	public void del_manager(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// ���ñ���
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String mid = request.getParameter("m_id");
		int m_id = Integer.parseInt(mid);
		ManagerDaoImpl managerDaoImpl = new ManagerDaoImpl();
		boolean flag = managerDaoImpl.managerDel(m_id);
		if (flag == true) {
			out.print(1);
		} else {
			out.print(2);
		}
		out.flush();
		out.close();
	}

	// 9.��ӹ���Ա�˺���֤
	public void m_name(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ���ñ���
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String m_name = request.getParameter("m_name");
		ManagerDaoImpl managerDaoImpl = new ManagerDaoImpl();
		boolean flag = managerDaoImpl.managerAddNameVerify(m_name);
		if (flag == true) {
			out.print(1);
		} else {
			out.print(2);
		}
		out.flush();
		out.close();
	}

}
