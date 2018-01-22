package com.hk.dtos;

import java.util.Date;

public class MemberDto {

	private int m_seq;
	private String m_name;
	private String m_id;
	private String m_pw;
	private String m_email;
	private String m_role;
	private Date m_regdate;
	private String m_enabled;
	
	public MemberDto() {
		// TODO Auto-generated constructor stub
	}
	

	public MemberDto(int m_seq, String m_name, String m_pw, String m_email) {
		super();
		this.m_seq = m_seq;
		this.m_name = m_name;
		this.m_pw = m_pw;
		this.m_email = m_email;
	}



	public MemberDto(int m_seq, String m_name, String m_id, String m_pw, String m_email, String m_role,
			Date m_regdate, String m_enabled) {
		super();
		this.m_seq = m_seq;
		this.m_name = m_name;
		this.m_id = m_id;
		this.m_pw = m_pw;
		this.m_email = m_email;
		this.m_role = m_role;
		this.m_regdate = m_regdate;
		this.m_enabled = m_enabled;
	}
	
	
	public MemberDto(String m_name, String m_id, String m_pw, String m_email) {
		super();
		this.m_name = m_name;
		this.m_id = m_id;
		this.m_pw = m_pw;
		this.m_email = m_email;
	}

	public int getM_seq() {
		return m_seq;
	}

	public void setM_seq(int m_seq) {
		this.m_seq = m_seq;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getM_pw() {
		return m_pw;
	}

	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}

	public String getM_email() {
		return m_email;
	}

	public void setM_email(String m_email) {
		this.m_email = m_email;
	}

	public String getM_role() {
		return m_role;
	}

	public void setM_role(String m_role) {
		this.m_role = m_role;
	}

	public Date getM_regdate() {
		return m_regdate;
	}

	public void setM_regdate(Date m_regdate) {
		this.m_regdate = m_regdate;
	}

	public String getM_enabled() {
		return m_enabled;
	}

	public void setM_enabled(String m_enabled) {
		this.m_enabled = m_enabled;
	}

	@Override
	public String toString() {
		return "MemberDto [m_seq=" + m_seq + ", m_name=" + m_name + ", m_id=" + m_id + ", m_pw=" + m_pw + ", m_email=" + m_email + ", m_role=" + m_role + ", m_regdate=" + m_regdate + ", m_enabled="
				+ m_enabled + "]";
	}
	
	
	
}
