package com.shop.frontservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.shop.DBUtil.MD5;
import com.shop.DBUtil.PhoneCodeUtil;
import com.shop.DBUtil.PhoneUtil;
import com.shop.beans.FlowerType;
import com.shop.beans.FlowerUse;
import com.shop.beans.Goods;
import com.shop.beans.GoodsImgs;
import com.shop.beans.GoodsType;
import com.shop.beans.Manager;
import com.shop.beans.User;
import com.shop.dao.UserDao;
import com.shop.daoimpl.FlowerTypeDaoImpl;
import com.shop.daoimpl.FlowerUseDaoImpl;
import com.shop.daoimpl.GoodsDaoImpl;
import com.shop.daoimpl.GoodsTypeDaoImpl;
import com.shop.daoimpl.Goods_imgDaoImpl;
import com.shop.daoimpl.ManagerDaoImpl;
import com.shop.daoimpl.OrderDaoImpl;
import com.shop.daoimpl.UserDaoImpl;

public class UserFrontServlet extends FrontBaseServlet {
	private ServletConfig config;

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		super.init(config);
	}

	// ������֤��
	public void userPhone(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String tel = request.getParameter("tel1");
		String code1 = request.getParameter("code1");
		// System.out.println(tel);
		UserDaoImpl u = new UserDaoImpl();
		String realcode = u.findVertifyCode(tel);
		if (code1.equals(realcode)) {
			System.out.println(code1.toString());
			System.out.println(realcode.toString());
			// int code = Integer.parseInt(code1);
			// boolean flag = PhoneUtil.phone(tel, code);
			// if (flag == true) {
			out.print(1);
			// } else {
			// out.print(2);
			// }
		} else {
			out.print(2);
		}
		out.flush();
		out.close();
	}

	// ��֤����֤
	public void userPhoneCodeVertify(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String tel = request.getParameter("tel1");
		String code1 = request.getParameter("code1");
		// System.out.println(tel);
		UserDaoImpl u = new UserDaoImpl();
		String realcode = u.findVertifyCode(tel);
		if (code1.equals(realcode)) {
			out.print(1);
		} else {
			out.print(2);
		}

		out.flush();
		out.close();
	}

	// ��֤�ʺ��Ƿ����ajax
	public void userFindbyName(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name1 = request.getParameter("name1");

		UserDaoImpl userDaoImpl = new UserDaoImpl();
		boolean flag = userDaoImpl.userFindbyName(name1);
		if (flag == true) {
			out.print(1);
		} else {
			out.print(2);
		}
		out.flush();
		out.close();
	}

	// ��֤�ֻ����Ƿ��Ѿ���ע��
	public void userPhoneFindbyName(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String tel1 = request.getParameter("tel1");

		UserDaoImpl userDaoImpl = new UserDaoImpl();
		boolean flag = userDaoImpl.userFindbyName(tel1);
		if (flag == true) {
			out.print(1);
		} else {
			out.print(2);
		}
		out.flush();
		out.close();
	}

	// �û�ע��
	public void userRegister(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// ���ñ���
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		// ��������
		String username = request.getParameter("Name");
		String password = request.getParameter("Password");
		String tel = request.getParameter("Tel");
		User user = new User();
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		user.setU_name(username);
		user.setU_password(password);
		user.setU_phone(tel);
		boolean flag = userDaoImpl.userRegister(user);
		if (flag == true) {
			System.out.println("ע��ɹ������¼��");
			request.setAttribute("msg", "ע��ɹ������¼��");
			request.getRequestDispatcher("frontmanager/account.jsp").forward(
					request, response);
		} else {
			System.out.println("ע��ʧ�ܣ������ԣ�");
			request.setAttribute("msg", "ע��ʧ�ܣ������ԣ�");
			request.getRequestDispatcher("frontmanager/register.jsp").forward(
					request, response);
		}
	}

	// �û���¼
	public void userLogin(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// ���ñ���
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		// ��������
		String u_phone = request.getParameter("u_phone");
		String password = request.getParameter("u_password");
		// System.out.println(u_phone);
		// System.out.println(password);
		User user = new User();
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		user.setU_phone(u_phone);
		user.setU_password(password);
		User user2 = userDaoImpl.userLogin(user);
		// System.out.println(user2);
		if (user2 == null) {
			request.setAttribute("msg", "�ʺŻ�����������������룡");
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
			request.getRequestDispatcher("frontmanager/account.jsp").forward(
					request, response);
		} else {
			request.getSession().setAttribute("user", user2);
			GoodsTypeDaoImpl goodsTypeDaoImpl = new GoodsTypeDaoImpl();
			GoodsDaoImpl goodsDaoImpl = new GoodsDaoImpl();
			FlowerTypeDaoImpl flowerTypeDaoImpl = new FlowerTypeDaoImpl();
			FlowerUseDaoImpl flowerUseDaoImpl = new FlowerUseDaoImpl();
			List<Goods> goods = goodsDaoImpl.recentGoods();
			List<GoodsType> goodstypes = goodsTypeDaoImpl.goodstypeFindAll();
			List<FlowerType> flowerTypes = flowerTypeDaoImpl
					.FlowerTypeFindAllLimit();
			List<FlowerUse> flowerUses = flowerUseDaoImpl.FlowerUseFindAll();
			request.setAttribute("goods", goods);
			request.setAttribute("goodsTypes01", goodstypes);
			request.setAttribute("flowerTypes", flowerTypes);
			request.setAttribute("flowerUses", flowerUses);
			request.getRequestDispatcher(
					"GoodsTypeFrontServlet?method=goodstypeFindAll").forward(
					request, response);
		}
	}

	// ��ȫ�˳�
	public void exit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ���ñ���
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		// �Ƴ�session�е�����
		request.getSession().removeAttribute("user");
		request.getRequestDispatcher("FirstServlet?method=goodstypeFindAll")
				.forward(request, response);
	}

	// ������֤�벢��֤
	public void userPhoneCode(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// ���ñ���
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		String tel1 = request.getParameter("tel1");
		PrintWriter out = response.getWriter();
		PhoneCodeUtil phoneCodeUtil = new PhoneCodeUtil();
		Integer code1 = phoneCodeUtil.getRandNum(99999, 999999);
		System.out.println(code1);
		if (code1 != null) {
			UserDaoImpl u = new UserDaoImpl();
			boolean flag = u.addVertifyCode(tel1, code1.toString());
			System.out.println(flag);
			if (flag == true) {
				out.print(code1);
			} else {
				boolean flag1 = u.addVertifyCode2(tel1, code1.toString());
				if (flag1 == true) {
					System.out.println(flag1);
					out.print(code1);
				} else {
					out.print(2);
				}
			}

		} else {
			out.print(2);
		}

	}

	// �û�ע�����ת
	public void userRegisterSkip(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		GoodsTypeDaoImpl goodsTypeDaoImpl = new GoodsTypeDaoImpl();
		FlowerUseDaoImpl flowerUseDaoImpl = new FlowerUseDaoImpl();
		FlowerTypeDaoImpl flowerTypeDaoImpl = new FlowerTypeDaoImpl();

		List<GoodsType> goodstypes = goodsTypeDaoImpl.goodstypeFindAll();
		List<FlowerUse> flowerUses = flowerUseDaoImpl.FlowerUseFindAll();
		List<FlowerType> flowerTypes = flowerTypeDaoImpl
				.FlowerTypeFindAllLimit();

		request.setAttribute("goodsTypes01", goodstypes);
		request.setAttribute("flowerUses", flowerUses);
		request.setAttribute("flowerTypes", flowerTypes);
		request.getRequestDispatcher("frontmanager/register.jsp").forward(
				request, response);

	}

	// �û���¼����ת
	public void userLoginSkip(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		GoodsTypeDaoImpl goodsTypeDaoImpl = new GoodsTypeDaoImpl();
		FlowerUseDaoImpl flowerUseDaoImpl = new FlowerUseDaoImpl();
		FlowerTypeDaoImpl flowerTypeDaoImpl = new FlowerTypeDaoImpl();

		List<GoodsType> goodstypes = goodsTypeDaoImpl.goodstypeFindAll();
		List<FlowerUse> flowerUses = flowerUseDaoImpl.FlowerUseFindAll();
		List<FlowerType> flowerTypes = flowerTypeDaoImpl
				.FlowerTypeFindAllLimit();

		request.setAttribute("goodsTypes01", goodstypes);
		request.setAttribute("flowerUses", flowerUses);
		request.setAttribute("flowerTypes", flowerTypes);

		request.getRequestDispatcher("frontmanager/account.jsp").forward(
				request, response);

	}

	// �û�ҳ�����ת
	public void userPageSkip(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("frontmanager/user.jsp").forward(request,
				response);

	}

	// �û��޸�����ҳ�����ת
	public void userUpdatePwdSkip(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("frontmanager/userPwd.jsp").forward(
				request, response);

	}

	// �û��޸�����
	public void userUpdatePwd(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// ���ñ���
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// ��ȡҳ�������
		String password = request.getParameter("newpassword");
		System.out.println(password);
		User user = (User) request.getSession().getAttribute("user");
		user.setU_password(MD5.parseStrToMd5(password));
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		boolean flag = userDaoImpl.userUpdatepsw(user);
		if (flag == true) {
			out.print(1);
		} else {
			out.print(2);
		}
		out.flush();
		out.close();

	}

	// �û��޸İ��ֻ�
	public void userUpdatePhone(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// ���ñ���
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		// ��������
		String tel = request.getParameter("tel");
		User user = (User) request.getSession().getAttribute("user");
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		user.setU_phone(tel);
		boolean flag = userDaoImpl.userUpdatephone(user);
		// System.out.println(flag);
		if (flag == true) {
			request.setAttribute("message", "�޸ĳɹ�,�����µ�¼");
			String targetURL = "/frontmanager/userInfoFeedback.jsp";
			request.getRequestDispatcher(targetURL).forward(request, response);
		} else {
			request.setAttribute("message", "�޸�ʧ�ܣ������ԣ�");
			request.getRequestDispatcher("frontmanager/userPhoneFeedback.jsp")
					.forward(request, response);
		}
	}

	// �û��޸��������֤
	public void userPwdVertify(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// ���ñ���
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// ��ȡҳ�������
		String password = request.getParameter("oldpassword");
		// System.out.println(password);
		User user = (User) request.getSession().getAttribute("user");
		String realpwd = user.getU_password();
		if (MD5.parseStrToMd5(password).equals(realpwd)) {
			out.print(1);
		} else {
			out.print(2);
		}
		out.flush();
		out.close();
	}

	// �û��޸ĸ�����Ϣ�����ת
	public void userUpdateLoginSkip(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getSession().removeAttribute("user");
		GoodsTypeDaoImpl goodsTypeDaoImpl = new GoodsTypeDaoImpl();
		FlowerUseDaoImpl flowerUseDaoImpl = new FlowerUseDaoImpl();
		FlowerTypeDaoImpl flowerTypeDaoImpl = new FlowerTypeDaoImpl();

		List<GoodsType> goodstypes = goodsTypeDaoImpl.goodstypeFindAll();
		List<FlowerUse> flowerUses = flowerUseDaoImpl.FlowerUseFindAll();
		List<FlowerType> flowerTypes = flowerTypeDaoImpl
				.FlowerTypeFindAllLimit();

		request.setAttribute("goodsTypes01", goodstypes);
		request.setAttribute("flowerUses", flowerUses);
		request.setAttribute("flowerTypes", flowerTypes);

		request.getRequestDispatcher("frontmanager/account.jsp").forward(
				request, response);
	}

	// �û��޸ĸ�����Ϣҳ�����ת
	public void userInfoSkip(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("frontmanager/userInfo1.jsp").forward(
				request, response);

	}

	// �û����˽�����Ϣ����ת
	public void userorderlist(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(
				"OrderFrontServlet?method=orderState&orderstate=0").forward(
				request, response);
	}

	// �û��һ��������ת
	public void userSetPwdSkip(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String tel = request.getParameter("tel");
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		User user = userDaoImpl.userfindbyPhone(tel);
		request.getSession().setAttribute("user", user);
		request.getRequestDispatcher("frontmanager/userResetPwd.jsp").forward(
				request, response);
	}

	// �û��޸ĸ�����Ϣ
	public void userInfoUpdate(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			ParseException {
		// ���ñ��� request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8"); //
		response.setContentType("text/html");
		User user = new User();
		Integer u_id = Integer.parseInt(request.getParameter("u_id"));
		user.setU_id(u_id);

		String u_realname = request.getParameter("u_realname"); //
		// System.out.println(userrealname);
		String usersex = request.getParameter("u_sex"); // System.out.println(usersex);
		String year = request.getParameter("year"); // System.out.println(year);
		String month = request.getParameter("month"); // System.out.println(month);
		String day = request.getParameter("day"); // System.out.println(day);

		String userInfo = request.getParameter("userInfo"); // System.out.println(userInfo);
		user.setU_realname(u_realname);
		if (usersex.equals("��")) {
			user.setU_sex(1);
		} else {
			user.setU_sex(0);
		}
		String birthday = year + "-" + month + "-" + day; // System.out.println(birthday);
		java.util.Date d = parseDate(birthday);// ���ַ���ת����date���� //
												// System.out.println(d);
		user.setU_birthday(d);

		user.setU_info(userInfo);
		// System.out.println(user.toString());
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		boolean flag = userDaoImpl.userUpdate(user);
		if (flag == true) {
			request.setAttribute("message", "�޸ĳɹ�,�����µ�¼");
			String targetURL = "/frontmanager/userInfoFeedback.jsp";
			request.getRequestDispatcher(targetURL).forward(request, response);
		} else {
			request.setAttribute("message", "�޸�ʧ��");
			String targetURL = "/frontmanager/userInfoFeedback.jsp";
			request.getRequestDispatcher(targetURL).forward(request, response);
		}

	}

	static public java.util.Date parseDate(String s) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.parse(s);

	}

	// �û��޸�ͷ��
	public void userHeadShotUpdate(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			ParseException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		User user = (User) request.getSession().getAttribute("user");
		// System.out.println(g_id);
		SmartUpload upload = new SmartUpload();
		upload.initialize(config, request, response);

		// String userimg=upload.getRequest().getParameter("userimg");
		UserDaoImpl userDaoImpl = new UserDaoImpl();

		// String img = null;

		upload.setAllowedFilesList("jpg,png");
		try {
			upload.upload();
			for (int i = 0; i < upload.getFiles().getCount(); i++) {
				File file = upload.getFiles().getFile(i);

				if (file.getSize() != 0) {
					if (i == 0) {
						user.setU_img(file.getFileName());
					}
					String path = this.getServletContext().getRealPath(
							"/userimg");
					String fileName = path + "/" + file.getFileName();
					file.saveAs(fileName);
				}
			}

			boolean flag = userDaoImpl.userHeadShotUpdate(user);

			if (flag == true) {
				String message = "�ϴ��ɹ�";
				request.setAttribute("message", message);
				String targetURL = "/frontmanager/upload_user_img.jsp";
				request.getRequestDispatcher(targetURL).forward(request,
						response);
			} else {
				String message = "�ϴ�ʧ��";
				request.setAttribute("message", message);
				String targetURL = "/frontmanager/upload_user_img.jsp";
				request.getRequestDispatcher(targetURL).forward(request,
						response);
			}

		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
