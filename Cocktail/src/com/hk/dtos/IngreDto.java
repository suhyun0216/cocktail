package com.hk.dtos;

public class IngreDto {

	private int ingre_seq;
	private String ingre_type;
	private String ingre_name;
	
	public IngreDto() {
		// TODO Auto-generated constructor stub
	}

	public IngreDto(int ingre_seq, String ingre_type, String ingre_name) {
		super();
		this.ingre_seq = ingre_seq;
		this.ingre_type = ingre_type;
		this.ingre_name = ingre_name;
	}

	public int getIngre_seq() {
		return ingre_seq;
	}

	public void setIngre_seq(int ingre_seq) {
		this.ingre_seq = ingre_seq;
	}

	public String getIngre_type() {
		return ingre_type;
	}

	public void setIngre_type(String ingre_type) {
		this.ingre_type = ingre_type;
	}

	public String getIngre_name() {
		return ingre_name;
	}

	public void setIngre_name(String ingre_name) {
		this.ingre_name = ingre_name;
	}

	@Override
	public String toString() {
		return "IngreDto [ingre_seq=" + ingre_seq + ", ingre_type=" + ingre_type + ", ingre_name=" + ingre_name + "]";
	}
	
	
}
