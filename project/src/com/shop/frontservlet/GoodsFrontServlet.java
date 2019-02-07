package com.shop.frontservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.beans.FlowerNum;
import com.shop.beans.FlowerType;
import com.shop.beans.FlowerUse;
import com.shop.beans.Goods;
import com.shop.beans.GoodsType;
import com.shop.beans.dto.SalesRank;
import com.shop.daoimpl.FlowerNumDaoImpl;
import com.shop.daoimpl.FlowerTypeDaoImpl;
import com.shop.daoimpl.FlowerUseDaoImpl;
import com.shop.daoimpl.GoodsDaoImpl;
import com.shop.daoimpl.GoodsTypeDaoImpl;
import com.shop.daoimpl.Goods_ftDaoImpl;
import com.shop.daoimpl.Goods_fuDaoImpl;
import com.shop.daoimpl.Goods_imgDaoImpl;
import com.shop.daoimpl.SalesRankDaoImpl;
import com.shop.page.PageList;

public class GoodsFrontServlet extends FrontBaseServlet {
	// 根据种类查找商品
	public void find_second_type(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		Integer gt_id = Integer.parseInt(request.getParameter("g_id"));
		
		GoodsDaoImpl goodsDaoImpl = new GoodsDaoImpl();
		

		GoodsTypeDaoImpl goodsTypeDaoImpl = new GoodsTypeDaoImpl();
		FlowerUseDaoImpl flowerUseDaoImpl = new FlowerUseDaoImpl();
		FlowerTypeDaoImpl flowerTypeDaoImpl = new FlowerTypeDaoImpl();
		SalesRankDaoImpl s=new SalesRankDaoImpl();
		Goods good = new Goods();

		String goodsname = request.getParameter("search");
		String currentPageVal = request.getParameter("currentPage");

		// System.out.println(currentPageVal);

		// 指定当前页数
		int currentPage = 1;
		if (currentPageVal != null && !"".equals(currentPageVal)) {
			currentPage = Integer.parseInt(currentPageVal);
			// System.out.println(currentPage + "******");
		}

		// 直接将内页显示的内容的条数定义为9
		int pageSize = 9;

		// 查询数据
		good.setG_name(goodsname);
		good.setGt_id(gt_id);
		PageList<Goods> list = goodsDaoImpl.FuzzySelectPartGoods(good,
				currentPage, pageSize);
		//System.out.println(list.getDataList());

		List<GoodsType> goodstypes = goodsTypeDaoImpl.goodstypeFindAll();//商品种类列表
		List<FlowerUse> flowerUses = flowerUseDaoImpl.FlowerUseFindAll();//用途列表
		List<FlowerType> flowerTypes = flowerTypeDaoImpl.FlowerTypeFindAllLimit();//花材列表
		List<SalesRank> salesRank=s.salesRank();
		List<Goods> list1=new ArrayList<Goods>();
		for(SalesRank sales:salesRank)
		{
			Goods g=goodsDaoImpl.goodsFindByGid(sales.getG_id());
			list1.add(g);
		}
		
		if (gt_id != null) {
			request.setAttribute("gt_id", gt_id);
		}
		// request.setAttribute("goods", goods);
		request.setAttribute("list", list);
		request.setAttribute("goodsTypes01", goodstypes);
		request.setAttribute("flowerUses", flowerUses);
		request.setAttribute("flowerTypes", flowerTypes);
		request.setAttribute("goodsname", goodsname);
		request.setAttribute("list1", list1);
		request.getRequestDispatcher("frontmanager/products1.jsp").forward(
				request, response);
	}

	// 主页模糊查询
	public void fuzzy_find_goods(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// String g_name = request.getParameter("g_name");
		// System.out.println(g_name);
		GoodsDaoImpl goodsDaoImpl = new GoodsDaoImpl();
		GoodsTypeDaoImpl goodsTypeDaoImpl = new GoodsTypeDaoImpl();
		FlowerUseDaoImpl flowerUseDaoImpl = new FlowerUseDaoImpl();
		FlowerTypeDaoImpl flowerTypeDaoImpl = new FlowerTypeDaoImpl();
		Goods good = new Goods();
		String goodsname = request.getParameter("search");
		String currentPageVal = request.getParameter("currentPage");

		// System.out.println(currentPageVal);

		// 指定当前页数
		int currentPage = 1;
		if (currentPageVal != null && !"".equals(currentPageVal)) {
			currentPage = Integer.parseInt(currentPageVal);
			// System.out.println(currentPage + "******");
		}

		// 直接将内页显示的内容的条数定义为12
		int pageSize = 12;

		// 查询数据

		good.setG_name(goodsname);
		good.setG_state(1);
		PageList<Goods> list = goodsDaoImpl.PageFuzzySelectGoods(good,
				currentPage, pageSize);
		// System.out.println(list);

		List<GoodsType> goodstypes = goodsTypeDaoImpl.goodstypeFindAll();
		List<FlowerUse> flowerUses = flowerUseDaoImpl.FlowerUseFindAll();
		List<FlowerType> flowerTypes = flowerTypeDaoImpl.FlowerTypeFindAllLimit();
		
		request.setAttribute("list", list);
		request.setAttribute("goodsTypes01", goodstypes);
		request.setAttribute("flowerUses", flowerUses);
		request.setAttribute("flowerTypes", flowerTypes);
		request.setAttribute("goodsname", goodsname);

		request.getRequestDispatcher("frontmanager/products.jsp").forward(
				request, response);
	}

	// 查看商品详情
	public void single_good_detail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Integer g_id = Integer.parseInt(request.getParameter("g_id"));
		GoodsDaoImpl goodsDaoImpl = new GoodsDaoImpl();
		GoodsTypeDaoImpl goodsTypeDaoImpl = new GoodsTypeDaoImpl();
		FlowerNumDaoImpl flowerNumDaoImpl = new FlowerNumDaoImpl();
		Goods_imgDaoImpl goods_imgDaoImpl = new Goods_imgDaoImpl();
		FlowerUseDaoImpl flowerUseDaoImpl = new FlowerUseDaoImpl();
		FlowerTypeDaoImpl flowerTypeDaoImpl = new FlowerTypeDaoImpl();
		Goods_ftDaoImpl goods_ftDaoImpl = new Goods_ftDaoImpl();
		Goods_fuDaoImpl goods_fuDaoImpl = new Goods_fuDaoImpl();
		SalesRankDaoImpl salesRankDaoImpl=new SalesRankDaoImpl();
		Goods good = new Goods();
		good = goodsDaoImpl.goodsFindByGid(g_id);
		Integer gt_id = good.getGt_id();
		Integer fn_id = good.getFloNum_id();
		
		GoodsType goodstype = goodsTypeDaoImpl.goodstypeFindByGtid(gt_id);
		FlowerNum flowernum = flowerNumDaoImpl.flowerNumfindbyId(fn_id);
		List<GoodsType> goodstypes = goodsTypeDaoImpl.goodstypeFindAll();
		List<FlowerUse> flowerUses = flowerUseDaoImpl.FlowerUseFindAll();
		List<FlowerType> flowerTypes = flowerTypeDaoImpl.FlowerTypeFindAllLimit();
		List<SalesRank> salesRank=salesRankDaoImpl.salesRank();
		List<Goods> list1=new ArrayList<Goods>();
		for(SalesRank sales:salesRank)
		{
			Goods g=goodsDaoImpl.goodsFindByGid(sales.getG_id());
			list1.add(g);
		}
		
		String str = goods_imgDaoImpl.images(g_id);
		String str1 = goods_fuDaoImpl.floUse_ids(g_id);
		String str2 = goods_ftDaoImpl.floType_ids(g_id);
		// System.out.println(str);
		if (str1 != null) {
			List<String> floUse_ids = new ArrayList<String>();
			String[] s = str1.split(",");
			for (int i = 0; i < s.length; i++) {
				floUse_ids.add(s[i]);
			}
			List<FlowerUse> uses = new ArrayList<FlowerUse>();
			for (int i = 0; i < floUse_ids.size(); i++) {
				FlowerUse flowerUse = flowerUseDaoImpl
						.flowerUsefindbyId(Integer.parseInt(floUse_ids.get(i)));
				uses.add(flowerUse);
				// System.out.println(flowerUse.toString());
				// request.setAttribute("goodstype", goodstype);
			}
			request.setAttribute("uses", uses);
			// System.out.println(uses);

		} else {
			List<FlowerUse> uses = new ArrayList<FlowerUse>();
			request.setAttribute("uses", uses);
		}
		if (str2 != null) {
			List<String> floType_ids = new ArrayList<String>();
			String[] s = str2.split(",");
			for (int i = 0; i < s.length; i++) {
				floType_ids.add(s[i]);
			}
			List<FlowerType> types = new ArrayList<FlowerType>();
			for (int i = 0; i < floType_ids.size(); i++) {
				FlowerType flowerType = flowerTypeDaoImpl
						.flowerTypefindbyId(Integer.parseInt(floType_ids.get(i)));
				types.add(flowerType);
				// System.out.println(flowerUse.toString());
				// request.setAttribute("goodstype", goodstype);
			}
			request.setAttribute("types", types);
			// System.out.println(uses);

		} else {
			List<FlowerType> types = new ArrayList<FlowerType>();
			request.setAttribute("types", types);
		}
		// FlowerUse flowerUse=flowerUseDaoImpl.flowerUsefindbyId(floUse_id);

		if (str != null) {
			List<String> images = new ArrayList<String>();
			String[] s = str.split(",");
			for (int i = 0; i < s.length; i++) {
				images.add(s[i]);
			}
			// System.out.println(images.toString());
			request.setAttribute("images", images);
		} else {
			String images = goods_imgDaoImpl.images(g_id);
			request.setAttribute("images", images);

		}
		request.setAttribute("list1", list1);
		request.setAttribute("goodstype", goodstype);
		request.setAttribute("flowernum", flowernum);
		request.setAttribute("goodsTypes01", goodstypes);
		request.setAttribute("flowerUses", flowerUses);
		request.setAttribute("flowerTypes", flowerTypes);
		
		request.setAttribute("good", good);
		request.getRequestDispatcher("frontmanager/single.jsp").forward(
				request, response);
	}

	// 根据用途查找商品
	public void goodsFindAllByUse(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String floUse_id = request.getParameter("floUse_id");
		GoodsTypeDaoImpl goodsTypeDaoImpl = new GoodsTypeDaoImpl();
		FlowerTypeDaoImpl flowerTypeDaoImpl = new FlowerTypeDaoImpl();
		FlowerUseDaoImpl flowerUseDaoImpl = new FlowerUseDaoImpl();

		List<GoodsType> goodstypes = goodsTypeDaoImpl.goodstypeFindAll();
		List<FlowerType> flowerTypes = flowerTypeDaoImpl.FlowerTypeFindAllLimit();
		List<FlowerUse> flowerUses = flowerUseDaoImpl.FlowerUseFindAll();

		FlowerUse flowerUse = flowerUseDaoImpl.flowerUsefindbyId(Integer
				.parseInt(floUse_id));

		request.setAttribute("goodsTypes01", goodstypes);
		request.setAttribute("flowerTypes", flowerTypes);
		request.setAttribute("flowerUses", flowerUses);
		request.setAttribute("floUse_img", flowerUse.getFloUse_img());
		GoodsDaoImpl goodsDaoImpl = new GoodsDaoImpl();
		List<Integer> goodsId = goodsDaoImpl.goodsFindByUse(floUse_id);
		//System.out.println(goodsId);
		List<Goods> goods = new ArrayList<Goods>();
		// System.out.println(goodsId);
		for (Integer ids : goodsId) {
			Goods good = goodsDaoImpl.goodsFindByGid(ids);
			goods.add(good);
		}
		request.setAttribute("goods", goods);
		request.getRequestDispatcher("frontmanager/products2.jsp").forward(
				request, response);

	}

	// 根据花材查找商品
	public void goodsFindAllByType(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String floType_id = request.getParameter("floType_id");

		GoodsTypeDaoImpl goodsTypeDaoImpl = new GoodsTypeDaoImpl();
		FlowerTypeDaoImpl flowerTypeDaoImpl = new FlowerTypeDaoImpl();
		FlowerUseDaoImpl flowerUseDaoImpl = new FlowerUseDaoImpl();

		List<GoodsType> goodstypes = goodsTypeDaoImpl.goodstypeFindAll();
		List<FlowerType> flowerTypes = flowerTypeDaoImpl
				.FlowerTypeFindAllLimit();
		List<FlowerUse> flowerUses = flowerUseDaoImpl.FlowerUseFindAll();

		FlowerType flowerType = flowerTypeDaoImpl.flowerTypefindbyId(Integer
		 .parseInt(floType_id));
		request.setAttribute("goodsTypes01", goodstypes);
		request.setAttribute("flowerTypes", flowerTypes);
		request.setAttribute("flowerUses", flowerUses);
		request.setAttribute("floType_img", flowerType.getFloType_img());
		GoodsDaoImpl goodsDaoImpl = new GoodsDaoImpl();
		List<Integer> goodsId = goodsDaoImpl.goodsFindByType(floType_id);
		//System.out.println(goodsId);
		List<Goods> goods = new ArrayList<Goods>();
		// System.out.println(goodsId);
		for (Integer ids : goodsId) {
			Goods good = goodsDaoImpl.goodsFindByGid(ids);
			goods.add(good);
		}
		
		request.setAttribute("goods", goods);
		request.getRequestDispatcher("frontmanager/products4.jsp").forward(
				request, response);

	}

	// 根据价格范围查找商品
	public void goodsFindAllByPrice(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		String floPriceMin = request.getParameter("floPriceMin");
		String floPriceMax = request.getParameter("floPriceMax");

		// System.out.println(floPriceMin);
		// System.out.println(floPriceMax);
		GoodsTypeDaoImpl goodsTypeDaoImpl = new GoodsTypeDaoImpl();
		FlowerUseDaoImpl flowerUseDaoImpl = new FlowerUseDaoImpl();
		FlowerTypeDaoImpl flowerTypeDaoImpl = new FlowerTypeDaoImpl();

		List<GoodsType> goodstypes = goodsTypeDaoImpl.goodstypeFindAll();
		List<FlowerUse> flowerUses = flowerUseDaoImpl.FlowerUseFindAll();
		List<FlowerType> flowerTypes = flowerTypeDaoImpl
				.FlowerTypeFindAllLimit();
		GoodsDaoImpl goodsDaoImpl = new GoodsDaoImpl();

		Goods good = new Goods();

		String goodsname = request.getParameter("search");
		String currentPageVal = request.getParameter("currentPage");

		// System.out.println(currentPageVal);

		// 指定当前页数
		int currentPage = 1;
		if (currentPageVal != null && !"".equals(currentPageVal)) {
			currentPage = Integer.parseInt(currentPageVal);
			// System.out.println(currentPage + "******");
		}

		// 直接将内页显示的内容的条数定义为12
		int pageSize = 12;

		// 查询数据

		good.setG_name(goodsname);
		good.setG_state(1);
		PageList<Goods> list = goodsDaoImpl.goodsFindByPrice(good, currentPage,
				pageSize, floPriceMin, floPriceMax);

		request.setAttribute("goodsTypes01", goodstypes);
		request.setAttribute("flowerUses", flowerUses);
		request.setAttribute("flowerTypes", flowerTypes);
		request.setAttribute("list", list);
		request.setAttribute("goodsname", goodsname);
		request.setAttribute("floPriceMin", floPriceMin);
		request.setAttribute("floPriceMax", floPriceMax);
		request.getRequestDispatcher("frontmanager/products3.jsp").forward(
				request, response);


	}

}
