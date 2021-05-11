package com.pbrk.pbook.entity;

import java.util.Date;

public class Code {
		
	private int group_cd;     // 그룹코드
	private int code_cd;      // 공통코드
	private String code_nm;   // 공통코드 명
	private boolean code_del; // 공통코드 삭제여부
	private int reg_no;       // 작성자 번호
	private Date reg_date;    // 작성일
	private int mod_no;       // 수정자 번호
	private Date mod_date;    // 수정일
	
	public Code() {
		// TODO Auto-generated constructor stub
	}

	public Code(int group_cd, int code_cd, String code_nm, boolean code_del, int reg_no, Date reg_date, int mod_no,
			Date mod_date) {
		super();
		this.group_cd = group_cd;
		this.code_cd = code_cd;
		this.code_nm = code_nm;
		this.code_del = code_del;
		this.reg_no = reg_no;
		this.reg_date = reg_date;
		this.mod_no = mod_no;
		this.mod_date = mod_date;
	}

	public int getGroup_cd() {
		return group_cd;
	}

	public void setGroup_cd(int group_cd) {
		this.group_cd = group_cd;
	}

	public int getCode_cd() {
		return code_cd;
	}

	public void setCode_cd(int code_cd) {
		this.code_cd = code_cd;
	}

	public String getCode_nm() {
		return code_nm;
	}

	public void setCode_nm(String code_nm) {
		this.code_nm = code_nm;
	}

	public boolean isCode_del() {
		return code_del;
	}

	public void setCode_del(boolean code_del) {
		this.code_del = code_del;
	}

	public int getReg_no() {
		return reg_no;
	}

	public void setReg_no(int reg_no) {
		this.reg_no = reg_no;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	public int getMod_no() {
		return mod_no;
	}

	public void setMod_no(int mod_no) {
		this.mod_no = mod_no;
	}

	public Date getMod_date() {
		return mod_date;
	}

	public void setMod_date(Date mod_date) {
		this.mod_date = mod_date;
	}

	@Override
	public String toString() {
		return "Code [group_cd=" + group_cd + ", code_cd=" + code_cd + ", code_nm=" + code_nm + ", code_del=" + code_del
				+ ", reg_no=" + reg_no + ", reg_date=" + reg_date + ", mod_no=" + mod_no + ", mod_date=" + mod_date
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	
}
