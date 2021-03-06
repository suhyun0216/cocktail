package com.hk.dtos;

import java.util.Date;

public class ReplyDto {

	private int rep_seq;
	private String rep_content;
	private String rep_id;
	private Date rep_regdate;
	private int rep_cock_seq;
	
	public ReplyDto() {
		// TODO Auto-generated constructor stub
	}
	
	
	

	public ReplyDto(String rep_content, String rep_id, int rep_cock_seq) {
		super();
		this.rep_content = rep_content;
		this.rep_id = rep_id;
		this.rep_cock_seq = rep_cock_seq;
	}



	public ReplyDto(int rep_seq, String rep_content, String rep_id, Date rep_regdate, int rep_cock_seq) {
		super();
		this.rep_seq = rep_seq;
		this.rep_content = rep_content;
		this.rep_id = rep_id;
		this.rep_regdate = rep_regdate;
		this.rep_cock_seq = rep_cock_seq;
	}




	public int getRep_seq() {
		return rep_seq;
	}

	public void setRep_seq(int rep_seq) {
		this.rep_seq = rep_seq;
	}

	public String getRep_content() {
		return rep_content;
	}

	public void setRep_content(String rep_content) {
		this.rep_content = rep_content;
	}

	public String getRep_id() {
		return rep_id;
	}

	public void setRep_id(String rep_id) {
		this.rep_id = rep_id;
	}

	public Date getRep_regdate() {
		return rep_regdate;
	}

	public void setRep_regdate(Date rep_regdate) {
		this.rep_regdate = rep_regdate;
	}

	public int getRep_cock_seq() {
		return rep_cock_seq;
	}

	public void setRep_cock_seq(int rep_cock_seq) {
		this.rep_cock_seq = rep_cock_seq;
	}

	@Override
	public String toString() {
		return "ReplyDto [rep_seq=" + rep_seq + ", rep_content=" + rep_content + ", rep_id=" + rep_id + ", rep_regdate="
				+ rep_regdate + ", rep_cock_seq=" + rep_cock_seq + "]";
	}
	

	 
}
