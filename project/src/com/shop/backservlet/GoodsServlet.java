package com.shop.backservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import batchUpload.BatchUpload;

import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.shop.page.PageList;
import com.shop.beans.FlowerNum;
import com.shop.beans.FlowerType;
import com.shop.beans.FlowerUse;
import com.shop.beans.Goods;
import com.shop.beans.GoodsImgs;
import com.shop.beans.GoodsType;
import com.shop.beans.Goods_ft;
import com.shop.beans.Goods_fu;
import com.shop.daoimpl.FlowerNumDaoImpl;
import com.shop.daoimpl.FlowerTypeDaoImpl;
import com.shop.daoimpl.FlowerUseDaoImpl;
import com.shop.daoimpl.GoodsDaoImpl;
import com.shop.daoimpl.GoodsTypeDaoImpl;
import com.shop.daoimpl.Goods_ftDaoImpl;
import com.shop.daoimpl.Goods_fuDaoImpl;
import com.shop.daoimpl.Goods_imgDaoImpl;

public class GoodsServlet extends BaseServlet {
	private ServletConfig config;

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		super.init(config);
	}

	// 分页
	public void product_list(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		Goods goods = new Goods();
		// List<Goods> list = goods.goodsFindAll();
		String goodsname = request.getParameter("search");
		// System.out.println(goodsname);
		String currentPageVal = request.getParameter("currentPage");
		GoodsDaoImpl goodsDaoImpl = new GoodsDaoImpl();
		// System.out.println(currentPageVal);

		// 指定当前页数
		int currentPage = 1;
		if (currentPageVal != null && !"".equals(currentPageVal)) {
			currentPage = Integer.parseInt(currentPageVal);
			// System.out.println(currentPage + "******");
		}

		// 直接将内页显示的内容的条数定义为10
		int pageSize = 10;

		// 查询数据
		
		goods.setG_name(goodsname);
	
		PageList<Goods> list = goodsDaoImpl.PageFuzzySelectGoods(goods,
				currentPage, pageSize);
		// System.out.println(list);
		request.setAttribute("list", list);
		request.setAttribute("goodsname",goodsname);
		request.getRequestDispatcher("backmanger/product_list.jsp").forward(
				request, response);
	}

	// 添加商品页面的跳转
	public void add_product(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		GoodsTypeDaoImpl goodsTypeDaoImpl = new GoodsTypeDaoImpl();
		// 查找所有种类
		List<GoodsType> goodstypes = new ArrayList<GoodsType>();
		goodstypes = goodsTypeDaoImpl.goodstypeFindAll();
		// 查找所有朵数
		FlowerNumDaoImpl flowerNumDaoImpl = new FlowerNumDaoImpl();
		List<FlowerNum> flowerNums = new ArrayList<FlowerNum>();
		flowerNums = flowerNumDaoImpl.FlowerNumFindAll();
		// 查找所有用途
		FlowerUseDaoImpl flowerUseDaoImpl = new FlowerUseDaoImpl();
		List<FlowerUse> flowerUses = new ArrayList<FlowerUse>();
		flowerUses = flowerUseDaoImpl.FlowerUseFindAll();
		// 查找所有花材
		FlowerTypeDaoImpl flowerTypeDaoImpl = new FlowerTypeDaoImpl();
		List<FlowerType> flowerTypes = new ArrayList<FlowerType>();
		flowerTypes = flowerTypeDaoImpl.FlowerTypeFindAll();
		request.setAttribute("goodstypes", goodstypes);
		request.setAttribute("flowerNums", flowerNums);
		request.setAttribute("flowerUses", flowerUses);
		request.setAttribute("flowerTypes", flowerTypes);
		request.getRequestDispatcher("backmanger/edit_product.jsp").forward(
				request, response);
	}

	// 修改商品基本信息的跳转
	public void update_product_skip(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Integer g_id = Integer.parseInt(request.getParameter("g_id"));
		GoodsDaoImpl goodsDaoImpl = new GoodsDaoImpl();
		GoodsTypeDaoImpl goodsTypeDaoImpl = new GoodsTypeDaoImpl();
		FlowerNumDaoImpl flowerNumDaoImpl = new FlowerNumDaoImpl();
		Goods good = new Goods();
		good = goodsDaoImpl.goodsFindByGid(g_id);
		Integer gt_id = good.getGt_id();
		Integer fn_id = good.getFloNum_id();
		// 查找所有种类
		List<GoodsType> goodstypes = new ArrayList<GoodsType>();
		goodstypes = goodsTypeDaoImpl.goodstypeFindAll();
		// 查找所有朵数

		List<FlowerNum> flowerNums = new ArrayList<FlowerNum>();
		flowerNums = flowerNumDaoImpl.FlowerNumFindAll();

		GoodsType goodstype = goodsTypeDaoImpl.goodstypeFindByGtid(gt_id);
		FlowerNum flowernum = flowerNumDaoImpl.flowerNumfindbyId(fn_id);
		request.setAttribute("goodstypes", goodstypes);
		request.setAttribute("flowerNums", flowerNums);
		request.setAttribute("goodstype", goodstype);
		request.setAttribute("flowernum", flowernum);
		request.setAttribute("good", good);
		request.getRequestDispatcher("backmanger/edit_product2.jsp").forward(
				request, response);

	}

	// 修改商品基本信息
	public void update_product(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		GoodsDaoImpl goodsDaoImpl = new GoodsDaoImpl();
		Goods good = new Goods();
		Goods good1 = new Goods();
		// 获取参数
		Integer g_id = Integer.parseInt(request.getParameter("g_id"));
		String g_name = request.getParameter("g_name");
		Integer gt_id = Integer.parseInt(request.getParameter("gt_id"));
		Integer floNum_id = Integer.parseInt(request.getParameter("floNum_id"));
		Double purchasing_price = Double.parseDouble(request
				.getParameter("purchasing_price"));
		Double original_price = Double.parseDouble(request
				.getParameter("original_price"));
		Double goods_price = Double.parseDouble(request
				.getParameter("goods_price"));
		Integer amount = Integer.parseInt(request.getParameter("amount"));
		String g_info = request.getParameter("g_info");

		good = goodsDaoImpl.goodsFindByGid(g_id);
		// System.out.println(good1.getG_name());
		// System.out.println(g_name);
		good1.setG_id(g_id);
		good1.setG_name(g_name);
		good1.setGt_id(gt_id);
		good1.setFloNum_id(floNum_id);
		good1.setPurchasing_price(purchasing_price);
		good1.setOriginal_price(original_price);
		good1.setGoods_price(goods_price);
		good1.setG_info(g_info);
		good1.setAmount(amount);
		if (g_name.equals(good.getG_name())) {
			boolean flag = goodsDaoImpl.goodsUpdate(good1);
			if (flag == true) {
				out.print(1);
			} else {
				out.print(2);
			}
		} else {
			boolean flag1 = goodsDaoImpl.goodUpdateNameVerify(g_name,
					good.getG_name());
			if (flag1 == false) {
				out.print(3);

			} else {
				boolean flag = goodsDaoImpl.goodsUpdate(good1);
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

	// 添加新商品的基本信息
	public void upload_product(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		GoodsDaoImpl goodsDaoImpl = new GoodsDaoImpl();
		Goods good = new Goods();
		String g_name = request.getParameter("g_name");
		Integer gt_id = Integer.parseInt(request.getParameter("gt_id"));
		Integer floNum_id = Integer.parseInt(request.getParameter("floNum_id"));

		Double purchasing_price = Double.parseDouble(request
				.getParameter("purchasing_price"));
		Double original_price = Double.parseDouble(request
				.getParameter("original_price"));
		Double goods_price = Double.parseDouble(request
				.getParameter("goods_price"));
		Integer amount = Integer.parseInt(request.getParameter("amount"));
		String g_info = request.getParameter("g_info");

		good.setG_name(g_name);
		good.setGt_id(gt_id);
		good.setFloNum_id(floNum_id);
		good.setPurchasing_price(purchasing_price);
		good.setOriginal_price(original_price);
		good.setGoods_price(goods_price);
		good.setG_info(g_info);
		good.setAmount(amount);

		boolean flag1 = goodsDaoImpl.goodsFindByGname(g_name);
		if (flag1 == true) {
			out.print(3);
		} else {
			boolean flag = goodsDaoImpl.goodsAdd(good);
			if (flag == true) {
				out.print(1);
			} else {
				out.print(2);
			}
			out.flush();
			out.close();
		}
	}

	// 商品回收站的跳转
	public void recycle_bin(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		GoodsDaoImpl goodsDaoImpl = new GoodsDaoImpl();
		List<Goods> recycled_goods = goodsDaoImpl.goodsFindAlreadyDel();
		request.setAttribute("recycled_goods", recycled_goods);
		request.getRequestDispatcher("backmanger/recycle_bin.jsp").forward(
				request, response);
	}

	// 查看商品详情
	public void examine_product(HttpServletRequest request,
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
		Goods good = new Goods();
		good = goodsDaoImpl.goodsFindByGid(g_id);
		Integer gt_id = good.getGt_id();
		Integer fn_id = good.getFloNum_id();
		GoodsType goodstype = goodsTypeDaoImpl.goodstypeFindByGtid(gt_id);
		FlowerNum flowernum = flowerNumDaoImpl.flowerNumfindbyId(fn_id);
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
		request.setAttribute("goodstype", goodstype);
		request.setAttribute("flowernum", flowernum);
		request.setAttribute("good", good);
		request.getRequestDispatcher("backmanger/examine_product.jsp").forward(
				request, response);
	}

	// 商品删除/恢复
	public void del_and_recycle(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		Integer id = Integer.parseInt(request.getParameter("id"));
		Integer id1 = Integer.parseInt(request.getParameter("id1"));
		GoodsDaoImpl goodsDaoImpl = new GoodsDaoImpl();
		Goods good = goodsDaoImpl.goodsFindByGid(id);
		if (id1 == 0) {
			good.setG_del(0);
			goodsDaoImpl.goodsUpdateDel(good);

			this.product_list(request, response);
		} else if (id1 == 1) {
			good.setG_del(1);
			goodsDaoImpl.goodsUpdateDel(good);

			this.recycle_bin(request, response);
		}
	}

	// 编辑商品所包含的花材跳转
	public void edit_g_flowerType_skip(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Integer g_id = Integer.parseInt(request.getParameter("g_id"));
		FlowerTypeDaoImpl flowerTypeDaoImpl = new FlowerTypeDaoImpl();
		Goods_ftDaoImpl goods_ftDaoImpl = new Goods_ftDaoImpl();
		String str = goods_ftDaoImpl.floType_ids(g_id);
		// System.out.println(str);
		if (str != null) {
			List<String> floType_ids = new ArrayList<String>();
			String[] s = str.split(",");
			for (int i = 0; i < s.length; i++) {
				floType_ids.add(s[i]);
			}
			// 查找所有花材
			List<FlowerType> flowerTypes = new ArrayList<FlowerType>();
			flowerTypes = flowerTypeDaoImpl.FlowerTypeFindAll();
			request.setAttribute("flowerTypes", flowerTypes);
			request.setAttribute("floType_ids", floType_ids);
			request.setAttribute("g_id", g_id);
			request.getRequestDispatcher("backmanger/edit_g_flowerType.jsp")
					.forward(request, response);
		} else {
			String floType_ids = goods_ftDaoImpl.floType_ids(g_id);
			List<FlowerType> flowerTypes = new ArrayList<FlowerType>();
			flowerTypes = flowerTypeDaoImpl.FlowerTypeFindAll();
			request.setAttribute("flowerTypes", flowerTypes);
			request.setAttribute("floType_ids", floType_ids);
			request.setAttribute("g_id", g_id);
			request.getRequestDispatcher("backmanger/edit_g_flowerType.jsp")
					.forward(request, response);
		}

	}

	// 上传商品花材
	public void upload_flowerType(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String[] arr = request.getParameterValues("flowerTypes");
		Integer g_id = Integer.parseInt(request.getParameter("g_id"));
		// System.out.println(g_id);
		String floType_ids = StringUtils.join(arr, ",");
		// System.out.println(floType_ids);
		Goods_ftDaoImpl goods_ftDaoImpl = new Goods_ftDaoImpl();
		Goods_ft goods_ft = new Goods_ft();
		goods_ft = goods_ftDaoImpl.g_ft_findbyId(g_id);
		if (goods_ft == null) {
			boolean flag = goods_ftDaoImpl.g_ft_add(g_id, floType_ids);
			if (flag == true) {
				String message = "编辑成功";
				request.setAttribute("message", message);
				String targetURL = "/backmanger/edit_goods_ft_success.jsp";
				request.getRequestDispatcher(targetURL).forward(request,
						response);
			} else {
				String message = "编辑失败";
				request.setAttribute("message", message);
				String targetURL = "/backmanger/edit_goods_ft_fail.jsp";
				request.getRequestDispatcher(targetURL).forward(request,
						response);
			}
		} else {
			boolean flag = goods_ftDaoImpl.g_ft_update(g_id, floType_ids);
			if (flag == true) {
				String message = "编辑成功";
				request.setAttribute("message", message);
				String targetURL = "/backmanger/edit_goods_ft_success.jsp";
				request.getRequestDispatcher(targetURL).forward(request,
						response);
			} else {
				String message = "编辑失败";
				request.setAttribute("message", message);
				String targetURL = "/backmanger/edit_goods_ft_fail.jsp";
				request.getRequestDispatcher(targetURL).forward(request,
						response);
			}
		}

	}

	// 编辑商品所包含的用途跳转
	public void edit_g_flowerUse_skip(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Integer g_id = Integer.parseInt(request.getParameter("g_id"));
		FlowerUseDaoImpl flowerUseDaoImpl = new FlowerUseDaoImpl();
		Goods_fuDaoImpl goods_fuDaoImpl = new Goods_fuDaoImpl();
		String str = goods_fuDaoImpl.floUse_ids(g_id);
		// System.out.println(str);
		if (str != null) {
			List<String> floUse_ids = new ArrayList<String>();
			String[] s = str.split(",");
			for (int i = 0; i < s.length; i++) {
				floUse_ids.add(s[i]);
			}
			// 查找所有花材
			List<FlowerUse> flowerUses = new ArrayList<FlowerUse>();
			flowerUses = flowerUseDaoImpl.FlowerUseFindAll();

			request.setAttribute("flowerUses", flowerUses);
			request.setAttribute("floUse_ids", floUse_ids);
			request.setAttribute("g_id", g_id);
			request.getRequestDispatcher("backmanger/edit_g_flowerUse.jsp")
					.forward(request, response);
		} else {
			String floUse_ids = goods_fuDaoImpl.floUse_ids(g_id);

			List<FlowerUse> flowerUses = new ArrayList<FlowerUse>();
			flowerUses = flowerUseDaoImpl.FlowerUseFindAll();

			request.setAttribute("flowerUses", flowerUses);
			request.setAttribute("floUse_ids", floUse_ids);
			request.setAttribute("g_id", g_id);
			request.getRequestDispatcher("backmanger/edit_g_flowerUse.jsp")
					.forward(request, response);
		}

	}

	// 上传商品用途
	public void upload_flowerUse(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String[] arr = request.getParameterValues("flowerUses");
		Integer g_id = Integer.parseInt(request.getParameter("g_id"));

		System.out.println(g_id);
		String floUse_ids = StringUtils.join(arr, ",");
		// System.out.println(floUse_ids);
		Goods_fuDaoImpl goods_fuDaoImpl = new Goods_fuDaoImpl();
		Goods_fu goods_fu = goods_fuDaoImpl.g_fu_findbyId(g_id);
		if (goods_fu == null) {
			boolean flag = goods_fuDaoImpl.g_fu_add(g_id, floUse_ids);
			if (flag == true) {
				String message = "编辑成功";
				request.setAttribute("message", message);
				String targetURL = "/backmanger/edit_goods_fu.jsp";
				request.getRequestDispatcher(targetURL).forward(request,
						response);
			} else {
				String message = "编辑失败";
				request.setAttribute("message", message);
				String targetURL = "/backmanger/edit_goods_fu.jsp";
				request.getRequestDispatcher(targetURL).forward(request,
						response);
			}
		} else {
			boolean flag = goods_fuDaoImpl.g_fu_update(g_id, floUse_ids);
			if (flag == true) {
				String message = "编辑成功";
				request.setAttribute("message", message);
				String targetURL = "/backmanger/edit_goods_fu.jsp";
				request.getRequestDispatcher(targetURL).forward(request,
						response);
			} else {
				String message = "编辑失败";
				request.setAttribute("message", message);
				String targetURL = "/backmanger/edit_goods_fu.jsp";
				request.getRequestDispatcher(targetURL).forward(request,
						response);
			}
		}

	}

	// 上传图片的跳转
	public void edit_images_skip(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Integer g_id = Integer.parseInt(request.getParameter("g_id"));
		GoodsDaoImpl goodsDaoImpl = new GoodsDaoImpl();
		Goods good = new Goods();
		good = goodsDaoImpl.goodsFindByGid(g_id);
		// System.out.println(good);
		Goods_imgDaoImpl goods_imgDaoImpl = new Goods_imgDaoImpl();
		String str = goods_imgDaoImpl.images(g_id);
		if (str != null) {
			List<String> images = new ArrayList<String>();
			String[] s = str.split(",");
			for (int i = 0; i < s.length; i++) {
				images.add(s[i]);
			}
			request.setAttribute("images", images);
			request.setAttribute("good", good);
			request.getRequestDispatcher("backmanger/products_imgs_upload.jsp")
					.forward(request, response);

		} else {
			String images = goods_imgDaoImpl.images(g_id);
			request.setAttribute("images", images);
			request.setAttribute("good", good);
			request.getRequestDispatcher("backmanger/products_imgs_upload.jsp")
					.forward(request, response);
		}

	}

	// 上传商品图片
	public void edit_images(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		Integer g_id = Integer.parseInt(request.getParameter("id"));
		// System.out.println(g_id);
		SmartUpload upload = new SmartUpload();
		upload.initialize(config, request, response);
		// Integer g_id = Integer.parseInt(upload.getRequest()
		// .getParameter("id"));
		// Integer g_id =
		// Integer.parseInt(upload.getRequest().getParameter("namegood"));
		GoodsDaoImpl goodsDaoImpl = new GoodsDaoImpl();
		Goods_imgDaoImpl goods_imgDaoImpl = new Goods_imgDaoImpl();
		Goods good = goodsDaoImpl.goodsFindByGid(g_id);
		GoodsImgs goodsImgs = new GoodsImgs();

		String img = null;
		// upload.setMaxFileSize(10*100);
		upload.setAllowedFilesList("jpg,png");
		try {
			upload.upload();
			for (int i = 0; i < upload.getFiles().getCount(); i++) {
				File file = upload.getFiles().getFile(i);

				if (file.getSize() != 0) {
					if (i == 0) {
						good.setG_imgurl(file.getFileName());
					} else {

						img = img + "," + file.getFileName();
					}
					String path = this.getServletContext().getRealPath("/img");
					String fileName = path + "/" + file.getFileName();
					file.saveAs(fileName);
				}
			}

			boolean flag1 = goodsDaoImpl.goodsImgUpload(good);
			// System.out.println(flag1);
			String images = goods_imgDaoImpl.images(g_id);
			if (images != null) {
				goodsImgs.setG_id(g_id);
				goodsImgs.setImg_url(img);
				boolean flag = goods_imgDaoImpl.updateImg(goodsImgs);
				// System.out.println(flag);
				if (flag1 == true && flag == true) {
					String message = "上传成功";
					request.setAttribute("message", message);
					String targetURL = "/backmanger/upload_goods_img.jsp";
					request.getRequestDispatcher(targetURL).forward(request,
							response);
				} else {
					String message = "上传失败";
					request.setAttribute("message", message);
					String targetURL = "/backmanger/upload_goods_img.jsp";
					request.getRequestDispatcher(targetURL).forward(request,
							response);
				}
			} else {
				goodsImgs.setG_id(g_id);
				goodsImgs.setImg_url(img);
				boolean flag = goods_imgDaoImpl.addImg(goodsImgs);
				// System.out.println(flag);
				if (flag1 == true && flag == true) {
					String message = "上传成功";
					request.setAttribute("message", message);
					String targetURL = "/backmanger/upload_goods_img.jsp";
					request.getRequestDispatcher(targetURL).forward(request,
							response);
				} else {
					String message = "上传失败";
					request.setAttribute("message", message);
					String targetURL = "/backmanger/upload_goods_img.jsp";
					request.getRequestDispatcher(targetURL).forward(request,
							response);
				}

			}

		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 上架、下架
	public void state(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		Integer id = Integer.parseInt(request.getParameter("id"));
		Integer id1 = Integer.parseInt(request.getParameter("id1"));
		GoodsDaoImpl goods = new GoodsDaoImpl();
		Goods good = new Goods();
		if (id1 == 1) {
			good.setG_id(id);
			good.setG_state(1);
			goods.goodsUpdateState(good);
			// System.out.println("nihao");
			this.product_list(request, response);
		} else if (id1 == 2) {
			good.setG_id(id);
			good.setG_state(2);
			goods.goodsUpdateState(good);
			// System.out.println("nihao");
			this.product_list(request, response);
		}
	}

	// 批量上传商品
	public void goodsAddBatch(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// Integer id = Integer.parseInt(request.getParameter("id"));
		SmartUpload upload = new SmartUpload();
		upload.initialize(config, request, response);
		// GoodsDaoImpl goods = new GoodsDaoImpl();
		// Goods_imgDaoImpl goodsimg = new Goods_imgDaoImpl();
		Goods good = null;
		// GoodsImgs goodsImgs = null;
		// String img = null;
		String fileName = null;
		try {
			// upload.setMaxFileSize(10*1024);
			upload.setAllowedFilesList("xls");
			upload.upload();
			for (int i = 0; i < upload.getFiles().getCount(); i++) {
				File file = upload.getFiles().getFile(i);
				String path = this.getServletContext().getRealPath("/files");
				// String fileName = path+"/"+file.getFileName();
				fileName = path + "\\" + file.getFileName();
				file.saveAs(fileName);
			}
			BatchUpload batchUpload = new BatchUpload();
			Map<Integer, List<String>> map = batchUpload.read(fileName);
			GoodsDaoImpl goodsDaoImpl = new GoodsDaoImpl();
			goodsDaoImpl.batchUploadGoods(map);
		} catch (SecurityException e) {

			e.printStackTrace();
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.product_list(request, response);

	}

	// 批量删除
	public void Batchdel(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String string = request.getParameter("deleid");
		String[] id = string.split(",");

		for (int i = 1; i < id.length; i++) {
			GoodsDaoImpl goods = new GoodsDaoImpl();
			Goods good = goods.goodsFindByGid(Integer.parseInt(id[i]));
			good.setG_del(0);
			// goods.goodsUpdateById(Integer.parseInt(id[i]), good);
			goods.goodsUpdateDel(good);
		}
		this.product_list(request, response);
	}

	// 批量恢复
	public void Batchadd(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String string = request.getParameter("addid");
		//System.out.println(string);
		String[] id = string.split(",");
         
		for (int i = 1; i < id.length; i++) {
			GoodsDaoImpl goods = new GoodsDaoImpl();
			Goods good = goods.goodsFindByGid(Integer.parseInt(id[i]));
			good.setG_del(1);
			// goods.goodsUpdateById(Integer.parseInt(id[i]), good);
			goods.goodsUpdateDel(good);
		}
		this.product_list(request, response);
	}

}
