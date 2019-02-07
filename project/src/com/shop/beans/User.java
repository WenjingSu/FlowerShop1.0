package com.shop.beans;

import java.util.Date;

public class User {
	private Integer u_id;
	private String u_name;
	private String u_password;
	private String u_img;
	private String u_realname;
	private String u_idcard;
	private Integer u_sex;
	private String u_residence;
	private Date u_birthday;
	private String u_phone;
	private String u_info;
	private Integer u_state;
	private Date regist_time;
	private Date login_time;
	private String regist_IP;
	private String login_IP;
	private Integer u_del;
	private String u_birthday_date;
	private String u_regist_time;
	private String u_login_time;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Integer u_id, String u_name, String u_password, String u_img,
			String u_realname, String u_idcard, Integer u_sex,
			String u_residence, Date u_birthday, String u_phone, String u_info,
			Integer u_state, Date regist_time, Date login_time,
			String regist_IP, String login_IP, Integer u_del) {
		super();
		this.u_id = u_id;
		this.u_name = u_name;
		this.u_password = u_password;
		this.u_img = u_img;
		this.u_realname = u_realname;
		this.u_idcard = u_idcard;
		this.u_sex = u_sex;
		this.u_residence = u_residence;
		this.u_birthday = u_birthday;
		this.u_phone = u_phone;
		this.u_info = u_info;
		this.u_state = u_state;
		this.regist_time = regist_time;
		this.login_time = login_time;
		this.regist_IP = regist_IP;
		this.login_IP = login_IP;
		this.u_del = u_del;
	}

	public Integer getU_id() {
		return u_id;
	}

	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public String getU_password() {
		return u_password;
	}

	public void setU_password(String u_password) {
		this.u_password = u_password;
	}

	public String getU_img() {
		return u_img;
	}

	public void setU_img(String u_img) {
		this.u_img = u_img;
	}

	public String getU_realname() {
		return u_realname;
	}

	public void setU_realname(String u_realname) {
		this.u_realname = u_realname;
	}

	public String getU_idcard() {
		return u_idcard;
	}

	public void setU_idcard(String u_idcard) {
		this.u_idcard = u_idcard;
	}

	public Integer getU_sex() {
		return u_sex;
	}

	public void setU_sex(Integer u_sex) {
		this.u_sex = u_sex;
	}

	public String getU_residence() {
		return u_residence;
	}

	public void setU_residence(String u_residence) {
		this.u_residence = u_residence;
	}

	public Date getU_birthday() {
		return u_birthday;
	}

	public void setU_birthday(Date u_birthday) {
		this.u_birthday = u_birthday;
	}

	public String getU_phone() {
		return u_phone;
	}

	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}

	public String getU_info() {
		return u_info;
	}

	public void setU_info(String u_info) {
		this.u_info = u_info;
	}

	public Integer getU_state() {
		return u_state;
	}

	public void setU_state(Integer u_state) {
		this.u_state = u_state;
	}

	public Date getRegist_time() {
		return regist_time;
	}

	public void setRegist_time(Date regist_time) {
		this.regist_time = regist_time;
	}

	public Date getLogin_time() {
		return login_time;
	}

	public void setLogin_time(Date login_time) {
		this.login_time = login_time;
	}

	public String getRegist_IP() {
		return regist_IP;
	}

	public void setRegist_IP(String regist_IP) {
		this.regist_IP = regist_IP;
	}

	public String getLogin_IP() {
		return login_IP;
	}

	public void setLogin_IP(String login_IP) {
		this.login_IP = login_IP;
	}

	public Integer getU_del() {
		return u_del;
	}

	public void setU_del(Integer u_del) {
		this.u_del = u_del;
	}

	public String getU_birthday_date() {
		return u_birthday_date;
	}

	public void setU_birthday_date(String u_birthday_date) {
		this.u_birthday_date = u_birthday_date;
	}

	public String getU_regist_time() {
		return u_regist_time;
	}

	public void setU_regist_time(String u_regist_time) {
		this.u_regist_time = u_regist_time;
	}

	public String getU_login_time() {
		return u_login_time;
	}

	public void setU_login_time(String u_login_time) {
		this.u_login_time = u_login_time;
	}

	@Override
	public String toString() {
		return "User [u_id=" + u_id + ", u_name=" + u_name + ", u_password="
				+ u_password + ", u_img=" + u_img + ", u_realname="
				+ u_realname + ", u_idcard=" + u_idcard + ", u_sex=" + u_sex
				+ ", u_residence=" + u_residence + ", u_birthday=" + u_birthday
				+ ", u_phone=" + u_phone + ", u_info=" + u_info + ", u_state="
				+ u_state + ", regist_time=" + regist_time + ", login_time="
				+ login_time + ", regist_IP=" + regist_IP + ", login_IP="
				+ login_IP + ", u_del=" + u_del + "]";
	}

}
