package com.hk.dtos;

public class CocktailDto {

	private int cock_seq;
	private String cock_name;
	private String base;
	private String base_amt;
	private String leq;
	private String leq_amt;
	private String drink;
	private String drink_amt;
	private String syrup;
	private String syrup_amt;
	private String etc;
	private String etc_amt;
	private String color;
	private String taste;
	private String alchol;
	private String liked;
	private String explain;
	private String make;
	
	
	public CocktailDto() {
		// TODO Auto-generated constructor stub
	}


	
	public CocktailDto(String cock_name, String base, String base_amt, String leq, String leq_amt, String drink,
			String drink_amt, String syrup, String syrup_amt, String etc, String etc_amt, String color, String taste,
			String alchol, String explain, String make) {
		super();
		this.cock_name = cock_name;
		this.base = base;
		this.base_amt = base_amt;
		this.leq = leq;
		this.leq_amt = leq_amt;
		this.drink = drink;
		this.drink_amt = drink_amt;
		this.syrup = syrup;
		this.syrup_amt = syrup_amt;
		this.etc = etc;
		this.etc_amt = etc_amt;
		this.color = color;
		this.taste = taste;
		this.alchol = alchol;
		this.explain = explain;
		this.make = make;
	}






	public CocktailDto(int cock_seq, String cock_name, String base, String base_amt, String leq, String leq_amt,
			String drink, String drink_amt, String syrup, String syrup_amt, String etc, String etc_amt, String color,
			String taste, String alchol, String liked, String explain, String make) {
		super();
		this.cock_seq = cock_seq;
		this.cock_name = cock_name;
		this.base = base;
		this.base_amt = base_amt;
		this.leq = leq;
		this.leq_amt = leq_amt;
		this.drink = drink;
		this.drink_amt = drink_amt;
		this.syrup = syrup;
		this.syrup_amt = syrup_amt;
		this.etc = etc;
		this.etc_amt = etc_amt;
		this.color = color;
		this.taste = taste;
		this.alchol = alchol;
		this.liked = liked;
		this.explain = explain;
		this.make = make;
	}




	public String getLiked() {
		return liked;
	}




	public void setLiked(String liked) {
		this.liked = liked;
	}




	public String getExplain() {
		return explain;
	}




	public void setExplain(String explain) {
		this.explain = explain;
	}




	public String getMake() {
		return make;
	}




	public void setMake(String make) {
		this.make = make;
	}




	public int getCock_seq() {
		return cock_seq;
	}


	public void setCock_seq(int cock_seq) {
		this.cock_seq = cock_seq;
	}


	public String getCock_name() {
		return cock_name;
	}


	public void setCock_name(String cock_name) {
		this.cock_name = cock_name;
	}


	public String getBase() {
		return base;
	}


	public void setBase(String base) {
		this.base = base;
	}


	public String getBase_amt() {
		return base_amt;
	}


	public void setBase_amt(String base_amt) {
		this.base_amt = base_amt;
	}


	public String getLeq() {
		return leq;
	}


	public void setLeq(String leq) {
		this.leq = leq;
	}


	public String getLeq_amt() {
		return leq_amt;
	}


	public void setLeq_amt(String leq_amt) {
		this.leq_amt = leq_amt;
	}


	public String getDrink() {
		return drink;
	}


	public void setDrink(String drink) {
		this.drink = drink;
	}


	public String getDrink_amt() {
		return drink_amt;
	}


	public void setDrink_amt(String drink_amt) {
		this.drink_amt = drink_amt;
	}


	public String getSyrup() {
		return syrup;
	}


	public void setSyrup(String syrup) {
		this.syrup = syrup;
	}


	public String getSyrup_amt() {
		return syrup_amt;
	}


	public void setSyrup_amt(String syrup_amt) {
		this.syrup_amt = syrup_amt;
	}


	public String getEtc() {
		return etc;
	}


	public void setEtc(String etc) {
		this.etc = etc;
	}


	public String getEtc_amt() {
		return etc_amt;
	}


	public void setEtc_amt(String etc_amt) {
		this.etc_amt = etc_amt;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getTaste() {
		return taste;
	}


	public void setTaste(String taste) {
		this.taste = taste;
	}


	public String getAlchol() {
		return alchol;
	}


	public void setAlchol(String alchol) {
		this.alchol = alchol;
	}




	@Override
	public String toString() {
		return "CocktailDto [cock_seq=" + cock_seq + ", cock_name=" + cock_name + ", base=" + base + ", base_amt="
				+ base_amt + ", leq=" + leq + ", leq_amt=" + leq_amt + ", drink=" + drink + ", drink_amt=" + drink_amt
				+ ", syrup=" + syrup + ", syrup_amt=" + syrup_amt + ", etc=" + etc + ", etc_amt=" + etc_amt + ", color="
				+ color + ", taste=" + taste + ", alchol=" + alchol + ", liked=" + liked + ", explain=" + explain
				+ ", make=" + make + "]";
	}


	
	
	
}
