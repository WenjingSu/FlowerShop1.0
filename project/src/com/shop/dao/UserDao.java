package com.shop.dao;

import java.util.List;

import com.shop.beans.Goods;
import com.shop.beans.User;
import com.shop.page.PageList;

public interface UserDao {
	// �û���һЩ��Ϣ����  ������  ���֤�� ��
 		public List<User> userfindall();// ���������û�

		public User userfindbyuId(Integer u_id);// ����id���ҵ����û�
		public User userfindbyPhone(String u_phone);
		public boolean updateUserDel(User user);// �߼�ɾ��
		
		public boolean userRegister(User user);//�û�ע��
		
		public User userLogin(User user);//�û���¼
		
		public boolean userUpdate(User user);//�û����ĸ�����Ϣ
		public boolean  userHeadShotUpdate(User user);//�û�����ͷ��
		
		public boolean userFindbyName(String username);//�ʺ���֤
		
		public boolean userUpdatepsw(User user);//�û���������
		
		public boolean userUpdatephone(User user);//�û����İ��ֻ���
		
		public PageList<User> PageFuzzySelectUser(User user, int currentPage,
				int pageSize);//��ҳ
		
		public boolean addVertifyCode(String phone,String phoneCode);//�����֤��
		public String findVertifyCode(String phone);//������֤
}
