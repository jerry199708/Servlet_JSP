package com.store.member.Model;

import java.util.Arrays;

public class MemberVO {
	private String email;
	private String pwd;
	private String name;
	private String phone;
	private byte[] pic;
	private Integer id;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public byte[] getPic() {
		return pic;
	}

	public void setPic(byte[] pic) {
		this.pic = pic;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "MemberVO [email=" + email + ", pwd=" + pwd + ", name=" + name + ", phone=" + phone + ", pic="
				+ Arrays.toString(pic) + ", id=" + id + "]";
	}

}
