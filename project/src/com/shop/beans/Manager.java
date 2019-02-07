package com.shop.beans;

public class Manager {
	private Integer m_id;
	private String m_name;
	private String m_password;
	private Integer role;
	private Integer m_del;

	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Manager(Integer m_id, String m_name, String m_password,
			Integer role, Integer m_del) {
		super();
		this.m_id = m_id;
		this.m_name = m_name;
		this.m_password = m_password;
		this.role = role;
		this.m_del = m_del;
	}

	public Integer getM_id() {
		return m_id;
	}

	public void setM_id(Integer m_id) {
		this.m_id = m_id;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getM_password() {
		return m_password;
	}

	public void setM_password(String m_password) {
		this.m_password = m_password;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public Integer getM_del() {
		return m_del;
	}

	public void setM_del(Integer m_del) {
		this.m_del = m_del;
	}

	@Override
	public String toString() {
		return "Manager [m_id=" + m_id + ", m_name=" + m_name + ", m_password="
				+ m_password + ", role=" + role + ", m_del=" + m_del + "]";
	}

}
