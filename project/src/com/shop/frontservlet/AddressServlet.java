package com.shop.frontservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.beans.Address;
import com.shop.beans.FlowerType;
import com.shop.beans.FlowerUse;
import com.shop.beans.G_Order;
import com.shop.beans.Goods;
import com.shop.beans.GoodsType;
import com.shop.beans.Order_goods_info;
import com.shop.beans.User;
import com.shop.beans.dto.CartDetail;
import com.shop.dao.CartDao;
import com.shop.dao.GoodsDao;
import com.shop.daoimpl.AddressDaoImpl;
import com.shop.daoimpl.CartDaoImpl;
import com.shop.daoimpl.FlowerTypeDaoImpl;
import com.shop.daoimpl.FlowerUseDaoImpl;
import com.shop.daoimpl.G_OrderDaoImpl;
import com.shop.daoimpl.GoodsDaoImpl;
import com.shop.daoimpl.GoodsTypeDaoImpl;
import com.shop.frontservlet.FrontBaseServlet;

public class AddressServlet extends FrontBaseServlet {
	// 直接购买
	public void order(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer goodsnum = Integer.parseInt(request.getParameter("buynum"));

		Integer g_id = Integer.parseInt(request.getParameter("g_id"));
		User u = (User) request.getSession().getAttribute("user");
		AddressDaoImpl address = new AddressDaoImpl();
		GoodsDaoImpl goods = new GoodsDaoImpl();

		int uid = u.getU_id();
		List<Address> list = address.addressFindAll(uid);

		Goods good = goods.goodsFindByGid(g_id);
		//System.out.println(list);
		Double totalmoney = goodsnum * good.getGoods_price();
		//System.out.println(totalmoney);
		request.setAttribute("list", list);
		request.setAttribute("goodsnum", goodsnum);
		request.setAttribute("listgood", good);
		request.setAttribute("totalmoney", totalmoney);

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
		request.getRequestDispatcher("frontmanager/ordercart1.jsp").forward(
				request, response);

	}

	// 添加地址
	public void addaddress(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("Consignee");
		String addressrel = request.getParameter("address");
		String zipcode = request.getParameter("Zipcode");
		String tel = request.getParameter("tel");
		String tag_name = request.getParameter("tag");
		User u = (User) request.getSession().getAttribute("user");
		int uid = u.getU_id();
		// System.out.println(zipcode);
		Address address = new Address();
		address.setU_id(uid);
		address.setConsignee_name(name);
		address.setConsignee_tel(tel);
		address.setAddress(addressrel);
		address.setPostcode(zipcode);
		address.setAdd_memo(tag_name);
		AddressDaoImpl addressdao = new AddressDaoImpl();
		addressdao.addressAdd(address);
		List<Address> list = addressdao.addressFindAll(4001);
		// System.out.println(list);
		PrintWriter out = response.getWriter();
		out.print(1);
		out.flush();

	}

	// 删除地址
	public void deladdress(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Integer add_id = Integer.parseInt(request.getParameter("add_id"));
		AddressDaoImpl addressdao = new AddressDaoImpl();
		boolean flag = addressdao.addressDel(add_id);
		PrintWriter out = response.getWriter();
		if (flag == true) {
			out.print(1);
		} else {
			out.flush();
		}

	}

	/*
	 * public void addorderlist(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { G_Order g_order = new
	 * G_Order(); Integer add_id =
	 * Integer.parseInt(request.getParameter("add_id")); Integer num =
	 * Integer.parseInt(request.getParameter("num")); Integer g_id =
	 * Integer.parseInt(request.getParameter("g_id")); Double goodsprice =
	 * Double.parseDouble(request .getParameter("good.goodsprice"));
	 * 
	 * Random rand = new Random(); int i = (int) (Math.random() * 100000); //
	 * 生成0-100的随机数 int j = rand.nextInt(100000); // 这里是一个方法的重载，参数的内容是指定范围 //
	 * System.out.println("i:" + i + "\nj:" + j);
	 * 
	 * Date dNow = new Date(); SimpleDateFormat ft = new
	 * SimpleDateFormat(" yyyy-MM-dd HH:mm:ss");// 生成日期 String time =
	 * ft.format(dNow);
	 * 
	 * String orderserial = time + i;
	 * 
	 * User u = (User) request.getSession().getAttribute("user"); int uid =
	 * u.getU_id(); // int uid=4001;
	 * 
	 * g_order.setOrderserial(orderserial); g_order.setOrder_goods_num(1);
	 * g_order.setOrder_total_price(goodsprice); g_order.setOrdertime(time);
	 * g_order.setU_id(uid); g_order.setAdd_id(add_id);
	 * 
	 * AddressDaoImpl address = new AddressDaoImpl(); boolean s =
	 * address.g_orderAdd(g_order); System.out.println(s); AddressDaoImpl
	 * address1 = new AddressDaoImpl(); G_Order gorder =
	 * address1.g_orderFindByorderserial(orderserial); Integer order_id =
	 * gorder.getOrder_id();
	 * 
	 * GoodsDao goods = new GoodsDaoImpl(); Goods good =
	 * goods.goodsFindByGid(g_id); Order_goods_info goodorder = new
	 * Order_goods_info();
	 * 
	 * goodorder.setG_id(g_id); goodorder.setG_name(good.getG_name());
	 * goodorder.setOrder_id(order_id); goodorder.setGoods_num(num);
	 * goodorder.setG_price(goodsprice);
	 * 
	 * address1.order_goods_infoAdd(goodorder); request.setAttribute("oid",
	 * order_id); System.out.println(goodorder); request.getRequestDispatcher(
	 * "OrderServlet?method=User_order_detail&state=1&oid=" + order_id)
	 * .forward(request, response); }
	 */

	// 2、查找出所有的地址，转发到确认订单页面
	public void addorderlistall(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// Integer add_id=Integer.parseInt(request.getParameter("add_id"));
		User u = (User) request.getSession().getAttribute("user");
		double totalmoney = Double.parseDouble((String) request.getSession()
				.getAttribute("totalmoney"));
		int uid = u.getU_id();
		String c_id = (String) request.getSession().getAttribute("arrcid");
		String[] c_idArr = c_id.split(",");

		List<CartDetail> listgood = new ArrayList<CartDetail>();
		for (int i = 1; i < c_idArr.length; i++) {
			// System.out.println(cid);
			Integer id = Integer.parseInt(c_idArr[i]);
			CartDaoImpl cartDao = new CartDaoImpl();
			CartDetail cartdetail = cartDao.cartFindByCid(id);

			listgood.add(cartdetail);
		}
		// System.out.println(listgood);
		AddressDaoImpl address = new AddressDaoImpl();
		List<Address> list = address.addressFindAll(uid);
		// System.out.println(listgood);

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

		request.setAttribute("listgood", listgood);
		request.setAttribute("list", list);
		request.setAttribute("totalmoney", totalmoney);

		request.getRequestDispatcher("frontmanager/ordercart.jsp").forward(
				request, response);
	}

	// 3、生成订单，订单商品，删除购物车
	public void addorderlistcart(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		User u = (User) request.getSession().getAttribute("user");
		String[] c_id = request.getParameterValues("goodcid");
		Integer add_id = Integer.parseInt(request.getParameter("add_id_order"));
		//System.out.println(add_id);
		Double totalmoney = Double.parseDouble(request
				.getParameter("totalmoney"));

		G_Order g_order = new G_Order();// 新建一个订单

		/*
		 * Random rand = new Random(); int i = (int) (Math.random() * 100000);
		 * // 生成0-100000的随机数 int j = rand.nextInt(100000); //
		 * 这里是一个方法的重载，参数的内容是指定范围 System.out.println("i:" + i + "\nj:" + j);
		 */

		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat(" yyyy-MM-dd HH:mm:ss");// 生成日期
		String time = ft.format(dNow);
		int uid = u.getU_id();
		String orderserial = time + uid;

		int num = 0;
		for (String cid : c_id) {
			num++;

		}
		g_order.setOrderserial(orderserial);
		g_order.setOrder_goods_num(num);
		g_order.setOrder_total_price(totalmoney);
		g_order.setOrdertime(time);
		g_order.setU_id(uid);
		g_order.setAdd_id(add_id);

		G_OrderDaoImpl g_OrderDaoImpl = new G_OrderDaoImpl();
		boolean flag = g_OrderDaoImpl.g_orderAdd(g_order);// 添加新订单
		// System.out.println(flag);

		G_Order gorder = g_OrderDaoImpl.g_orderFindByorderserial(orderserial);
		Integer order_id = gorder.getOrder_id();

		CartDaoImpl cartDaoImpl = new CartDaoImpl();
		for (String cid : c_id) {
			Order_goods_info order_goods_info = new Order_goods_info();// 新建订单商品表
			Integer id = Integer.parseInt(cid);

			CartDetail cartdetail = cartDaoImpl.cartFindByCid(id);
			order_goods_info.setG_id(cartdetail.getG_id());
			order_goods_info.setG_name(cartdetail.getG_name());
			order_goods_info.setOrder_id(order_id);
			order_goods_info.setGoods_num(cartdetail.getGoods_amount());
			order_goods_info.setG_price(cartdetail.getGoods_price());
			cartDaoImpl.deleteCartByCid(id);// 删除购物车的内容

			// 减少库存
			GoodsDaoImpl g = new GoodsDaoImpl();
			int amount = g.selectGoodsAmountBygid(cartdetail.getG_id());
			// System.out.println("原始库存量" + amount);

			boolean change = g.UpdateGoodsAmountByGid(cartdetail.getG_id(),
					cartdetail.getGoods_amount());
			// if (change) {
			// amount = g.selectfBygid(cartdetail.getG_id());
			// System.out.println("改变后库存量" + amount);
			// }
			g_OrderDaoImpl.order_goods_infoAdd(order_goods_info);

		}
		request.removeAttribute("totalmoney");
		request.removeAttribute("arrcid");
		request.setAttribute("oid", order_id);
		request.getRequestDispatcher(
				"OrderFrontServlet?method=User_order_detail&state=1&oid="
						+ order_id).forward(request, response);

	}

	// 4、生成订单，订单商品，删除购物车(直接购买)
	public void addorderlistcart1(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		User u = (User) request.getSession().getAttribute("user");
		Integer add_id = Integer.parseInt(request.getParameter("add_id_order"));
		Double totalmoney = Double.parseDouble(request
				.getParameter("totalmoney"));
		Integer g_id = Integer.parseInt(request.getParameter("g_id"));
		//System.out.println(g_id);
		Integer goodsnum = Integer.parseInt(request.getParameter("goodsnum"));
		//System.out.println(goodsnum);

		GoodsDaoImpl g = new GoodsDaoImpl();
		Goods good = g.goodsFindByGid(g_id);

		G_Order g_order = new G_Order();// 新建一个订单

		/*
		 * Random rand = new Random(); int i = (int) (Math.random() * 100000);
		 * // 生成0-100000的随机数 int j = rand.nextInt(100000); //
		 * 这里是一个方法的重载，参数的内容是指定范围 System.out.println("i:" + i + "\nj:" + j);
		 */

		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 生成日期
		String time = ft.format(dNow);
		int uid = u.getU_id();
		String orderserial = time + uid;

		int num = 1;

		g_order.setOrderserial(orderserial);
		g_order.setOrder_goods_num(num);
		g_order.setOrder_total_price(totalmoney);
		g_order.setOrdertime(time);
		g_order.setU_id(uid);
		g_order.setAdd_id(add_id);

		G_OrderDaoImpl g_OrderDaoImpl = new G_OrderDaoImpl();
		boolean flag = g_OrderDaoImpl.g_orderAdd(g_order);// 添加新订单
		// System.out.println(flag);

		G_Order gorder = g_OrderDaoImpl.g_orderFindByorderserial(orderserial);
		Integer order_id = gorder.getOrder_id();

		CartDaoImpl cartDaoImpl = new CartDaoImpl();

		Order_goods_info order_goods_info = new Order_goods_info();// 新建订单商品表

		order_goods_info.setG_id(good.getG_id());
		order_goods_info.setG_name(good.getG_name());
		order_goods_info.setOrder_id(order_id);
		order_goods_info.setGoods_num(goodsnum);
		order_goods_info.setG_price(good.getGoods_price());

		// 减少库存

		// int amount = g.selectGoodsAmountBygid(good.getG_id());
		// System.out.println("原始库存量" + amount);

		boolean change = g.UpdateGoodsAmountByGid(good.getG_id(), goodsnum);
		// if (change) {
		// Goods good1=g.goodsFindByGid(g_id);
		// // amount = g.selectfBygid(cartdetail.getG_id());
		// System.out.println("改变后库存量" + good1.getAmount());
		// }
		g_OrderDaoImpl.order_goods_infoAdd(order_goods_info);

		request.removeAttribute("totalmoney");
		request.removeAttribute("arrcid");
		request.setAttribute("oid", order_id);
		request.getRequestDispatcher(
				"OrderFrontServlet?method=User_order_detail&state=1&oid="
						+ order_id).forward(request, response);

	}

	// 1、购物车中转
	public void setsession(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String arrcid = request.getParameter("arrcid");
		String totalmoney = request.getParameter("totalmoney");
		// System.out.println(arrcid + "  " + totalmoney);
		request.getSession().setAttribute("arrcid", arrcid);
		request.getSession().setAttribute("totalmoney", totalmoney);
		PrintWriter out = response.getWriter();
		out.print(1);
	}

}
