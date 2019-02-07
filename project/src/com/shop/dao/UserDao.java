package com.shop.dao;

import java.util.List;

import com.shop.beans.Goods;
import com.shop.beans.User;
import com.shop.page.PageList;

public interface UserDao {
	// 用户的一些信息加密  （密码  身份证号 ）
 		public List<User> userfindall();// 查找所有用户

		public User userfindbyuId(Integer u_id);// 根据id查找单个用户
		public User userfindbyPhone(String u_phone);
		public boolean updateUserDel(User user);// 逻辑删除
		
		public boolean userRegister(User user);//用户注册
		
		public User userLogin(User user);//用户登录
		
		public boolean userUpdate(User user);//用户更改个人信息
		public boolean  userHeadShotUpdate(User user);//用户更改头像
		
		public boolean userFindbyName(String username);//帐号验证
		
		public boolean userUpdatepsw(User user);//用户更改密码
		
		public boolean userUpdatephone(User user);//用户更改绑定手机号
		
		public PageList<User> PageFuzzySelectUser(User user, int currentPage,
				int pageSize);//分页
		
		public boolean addVertifyCode(String phone,String phoneCode);//添加验证码
		public String findVertifyCode(String phone);//查找验证
}
