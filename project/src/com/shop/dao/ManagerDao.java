package com.shop.dao;

import java.util.List;

import com.shop.beans.Manager;

public interface ManagerDao {
	public boolean managerAdd(Manager manager);//��ӹ���Ա[��������Ա]
	public boolean managerUpdate(Integer m_id,Integer role);//�޸Ĺ���Ա��Ϣ[��������Ա]
	public boolean managerDel(Integer m_id);//����ɾ������Ա[��������Ա]
	public Manager managerFindById(Integer m_id);//����m_id�鿴��������Ա
	public List<Manager> managerFindAll(Integer m_id);//��ѯ���й���Ա[��������Ա]
	public Manager managerLogin(Manager manager);//����Ա��¼
	public boolean managerUpdatePwd(Manager manager);//����Ա�޸�����
	public boolean managerAddNameVerify(String m_name);//����Աע���ʺ���֤
}
