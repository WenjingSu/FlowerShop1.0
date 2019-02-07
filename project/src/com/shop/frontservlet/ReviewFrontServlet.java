package com.shop.frontservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.beans.FlowerType;
import com.shop.beans.FlowerUse;
import com.shop.beans.Goods;
import com.shop.beans.GoodsType;
import com.shop.beans.Review;
import com.shop.beans.User;
import com.shop.dao.ReviewDao;
import com.shop.daoimpl.FlowerTypeDaoImpl;
import com.shop.daoimpl.FlowerUseDaoImpl;
import com.shop.daoimpl.GoodsDaoImpl;
import com.shop.daoimpl.GoodsTypeDaoImpl;
import com.shop.daoimpl.ReviewDaoImpl;
import com.shop.daoimpl.OrderDaoImpl;
import com.shop.page.PageList;
import com.shop.beans.dto.G_Order_User_Address;
import com.shop.beans.dto.OrderList;
import com.shop.beans.dto.Order_goods_goodsimg;
import com.shop.beans.dto.ReviewUser;

public class ReviewFrontServlet extends FrontBaseServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// �������
	public void reviewAdd(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		Integer u_id = Integer.parseInt(request.getParameter("u_id"));
		Integer o_id = Integer.parseInt(request.getParameter("o_id"));
		String g_ids[] = request.getParameterValues("g_id");
		// String content[]=request.getParameterValues("content");
		// String state[]=request.getParameterValues("state");
		ReviewDaoImpl r = new ReviewDaoImpl();
		Review review = new Review();
		Date dNow = new Date();
		// SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//
		// ��������
		// String time = ft.format(dNow);
		for (String string1 : g_ids) {
			String state = request.getParameter("state" + string1);
			String content = request.getParameter("content" + string1);
			//
			//
			System.out.println(state);
			System.out.println(content);
			review.setU_id(u_id);
			review.setG_id(Integer.parseInt(string1));
			review.setContent(content);
			review.setReview_time(new Date());
			review.setState(Integer.parseInt(state));
			boolean flag = r.reviewAdd(review);
			// System.out.println(flag);
			if (flag == true) {
				OrderDaoImpl o = new OrderDaoImpl();
				boolean flag1 = o.order_formUpdateStaByOId(5, o_id);
				if (flag1 == true) {
					String message = "���۳ɹ�";
					request.setAttribute("message", message);
					String targetURL = "/frontmanager/review_feedback.jsp";
					request.getRequestDispatcher(targetURL).forward(request,
							response);
					// System.out.println("success");
				} else {
					String message = "����ʧ��";
					request.setAttribute("message", message);
					String targetURL = "/frontmanager/review_feedback.jsp";
					request.getRequestDispatcher(targetURL).forward(request,
							response);
					// System.out.println("fail");
				}
			}

		}

	}

	// ����
	public void review(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		Integer oid = Integer.parseInt(request.getParameter("oid"));
		OrderDaoImpl o = new OrderDaoImpl();

		List<Order_goods_goodsimg> list = o.SelectCartStateByState(oid);
		// for (Order_goods_goodsimg order : list) {
		// System.out.println(order.toString());
		// }
		G_Order_User_Address add = o.order_formFindByOid(oid);
		request.setAttribute("list", list);
		request.setAttribute("add", add);
		request.getRequestDispatcher("frontmanager/review.jsp").forward(
				request, response);
	}
	//�鿴��Ʒ����
	
	public void findReviewBygid(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String currentPageVal = request.getParameter("currentPage");
		Integer g_id = Integer.parseInt(request.getParameter("g_id"));
		ReviewDaoImpl r=new ReviewDaoImpl();
		// ָ����ǰҳ��
		int currentPage = 1;
		if (currentPageVal != null && !"".equals(currentPageVal)) {
			currentPage = Integer.parseInt(currentPageVal);
			// System.out.println(currentPage + "******");
		}

		// ֱ�ӽ���ҳ��ʾ�����ݵ���������Ϊ6
		int pageSize = 6;

		// ��ѯ����
		GoodsDaoImpl g=new GoodsDaoImpl();
		Goods good=new Goods();
		good.setG_id(g_id);
		PageList<ReviewUser> list = r.findReviewBygid1(good, currentPage, pageSize);
		//System.out.println(list.getDataList());
		request.setAttribute("list", list);
		request.setAttribute("g_id", g_id);
		
		GoodsTypeDaoImpl goodsTypeDaoImpl = new GoodsTypeDaoImpl();
		FlowerTypeDaoImpl flowerTypeDaoImpl=new FlowerTypeDaoImpl();
		FlowerUseDaoImpl flowerUseDaoImpl=new FlowerUseDaoImpl();
		List<GoodsType> goodstypes = goodsTypeDaoImpl.goodstypeFindAll();
		List<FlowerType> flowerTypes=flowerTypeDaoImpl.FlowerTypeFindAllLimit();
		List<FlowerUse> flowerUses=flowerUseDaoImpl.FlowerUseFindAll();
		request.setAttribute("goodsTypes01", goodstypes);
		request.setAttribute("flowerTypes", flowerTypes);
		request.setAttribute("flowerUses", flowerUses);
		request.getRequestDispatcher("frontmanager/examineReview.jsp").forward(
				request, response);
		
		
		
//		Integer g_id = Integer.parseInt(request.getParameter("g_id"));
//		ReviewDaoImpl r=new ReviewDaoImpl();
//		List<ReviewUser> rlist=new ArrayList<ReviewUser>();
//		rlist=r.findReviewBygid(g_id);
//		for (ReviewUser reviewUser : list) {
//			System.out.println(reviewUser);
//		}
		
//		GoodsTypeDaoImpl goodsTypeDaoImpl = new GoodsTypeDaoImpl();
//		FlowerTypeDaoImpl flowerTypeDaoImpl=new FlowerTypeDaoImpl();
//		FlowerUseDaoImpl flowerUseDaoImpl=new FlowerUseDaoImpl();
//		List<GoodsType> goodstypes = goodsTypeDaoImpl.goodstypeFindAll();
//		List<FlowerType> flowerTypes=flowerTypeDaoImpl.FlowerTypeFindAllLimit();
//		List<FlowerUse> flowerUses=flowerUseDaoImpl.FlowerUseFindAll();
//		request.setAttribute("goodsTypes01", goodstypes);
//		request.setAttribute("flowerTypes", flowerTypes);
//		request.setAttribute("flowerUses", flowerUses);
//		
//		request.setAttribute("rlist", rlist);
//		request.setAttribute("g_id", g_id);
//		request.getRequestDispatcher("frontmanager/examineReview.jsp").forward(
//				request, response);
	}
	
}
