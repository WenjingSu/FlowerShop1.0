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

	// 发送验证码
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

	// 验证码验证
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

	// 验证帐号是否存在ajax
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

	// 验证手机号是否已经被注册
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

	// 用户注册
	public void userRegister(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		// 接收数据
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
			System.out.println("注册成功，请登录！");
			request.setAttribute("msg", "注册成功，请登录！");
			request.getRequestDispatcher("frontmanager/account.jsp").forward(
					request, response);
		} else {
			System.out.println("注册失败，请重试！");
			request.setAttribute("msg", "注册失败，请重试！");
			request.getRequestDispatcher("frontmanager/register.jsp").forward(
					request, response);
		}
	}

	// 用户登录
	public void userLogin(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		// 接收数据
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
			request.setAttribute("msg", "帐号或密码错误，请重新输入！");
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

	// 安全退出
	public void exit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		// 移除session中的数据
		request.getSession().removeAttribute("user");
		request.getRequestDispatcher("FirstServlet?method=goodstypeFindAll")
				.forward(request, response);
	}

	// 生成验证码并验证
	public void userPhoneCode(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// 设置编码
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

	// 用户注册的跳转
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

	// 用户登录的跳转
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

	// 用户页面的跳转
	public void userPageSkip(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("frontmanager/user.jsp").forward(request,
				response);

	}

	// 用户修改密码页面的跳转
	public void userUpdatePwdSkip(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("frontmanager/userPwd.jsp").forward(
				request, response);

	}

	// 用户修改密码
	public void userUpdatePwd(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// 获取页面的数据
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

	// 用户修改绑定手机
	public void userUpdatePhone(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		// 接收数据
		String tel = request.getParameter("tel");
		User user = (User) request.getSession().getAttribute("user");
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		user.setU_phone(tel);
		boolean flag = userDaoImpl.userUpdatephone(user);
		// System.out.println(flag);
		if (flag == true) {
			request.setAttribute("message", "修改成功,请重新登录");
			String targetURL = "/frontmanager/userInfoFeedback.jsp";
			request.getRequestDispatcher(targetURL).forward(request, response);
		} else {
			request.setAttribute("message", "修改失败，请重试！");
			request.getRequestDispatcher("frontmanager/userPhoneFeedback.jsp")
					.forward(request, response);
		}
	}

	// 用户修改密码的验证
	public void userPwdVertify(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// 获取页面的密码
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

	// 用户修改个人信息后的跳转
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

	// 用户修改个人信息页面的跳转
	public void userInfoSkip(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("frontmanager/userInfo1.jsp").forward(
				request, response);

	}

	// 用户个人交易信息的跳转
	public void userorderlist(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(
				"OrderFrontServlet?method=orderState&orderstate=0").forward(
				request, response);
	}

	// 用户找回密码的跳转
	public void userSetPwdSkip(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String tel = request.getParameter("tel");
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		User user = userDaoImpl.userfindbyPhone(tel);
		request.getSession().setAttribute("user", user);
		request.getRequestDispatcher("frontmanager/userResetPwd.jsp").forward(
				request, response);
	}

	// 用户修改个人信息
	public void userInfoUpdate(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			ParseException {
		// 设置编码 request.setCharacterEncoding("UTF-8");
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
		if (usersex.equals("男")) {
			user.setU_sex(1);
		} else {
			user.setU_sex(0);
		}
		String birthday = year + "-" + month + "-" + day; // System.out.println(birthday);
		java.util.Date d = parseDate(birthday);// 将字符串转换成date类型 //
												// System.out.println(d);
		user.setU_birthday(d);

		user.setU_info(userInfo);
		// System.out.println(user.toString());
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		boolean flag = userDaoImpl.userUpdate(user);
		if (flag == true) {
			request.setAttribute("message", "修改成功,请重新登录");
			String targetURL = "/frontmanager/userInfoFeedback.jsp";
			request.getRequestDispatcher(targetURL).forward(request, response);
		} else {
			request.setAttribute("message", "修改失败");
			String targetURL = "/frontmanager/userInfoFeedback.jsp";
			request.getRequestDispatcher(targetURL).forward(request, response);
		}

	}

	static public java.util.Date parseDate(String s) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.parse(s);

	}

	// 用户修改头像
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
				String message = "上传成功";
				request.setAttribute("message", message);
				String targetURL = "/frontmanager/upload_user_img.jsp";
				request.getRequestDispatcher(targetURL).forward(request,
						response);
			} else {
				String message = "上传失败";
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
