package com.pbrk.pbook.entity;

import java.util.Date;

public class GroupCode {
	
	
	private int group_cd;       // 그룹코드
	private String group_cd_nm; // 그룹코드 명
	private boolean group_del;  // 그룹코드 삭제여부
	private int reg_no;         // 작성자 번호
	private Date reg_date;		// 작성일
	private int mod_no;			// 수정자 번호
	private Date mod_date;		// 수정일
	
	public GroupCode() {
		// TODO Auto-generated constructor stub
	}

	public GroupCode(int group_cd, String group_cd_nm, boolean group_del, int reg_no, Date reg_date, int mod_no,
			Date mod_date) {
		super();
		this.group_cd = group_cd;
		this.group_cd_nm = group_cd_nm;
		this.group_del = group_del;
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

	public String getGroup_cd_nm() {
		return group_cd_nm;
	}

	public void setGroup_cd_nm(String group_cd_nm) {
		this.group_cd_nm = group_cd_nm;
	}

	public boolean isGroup_del() {
		return group_del;
	}

	public void setGroup_del(boolean group_del) {
		this.group_del = group_del;
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
		return "GroupCode [group_cd=" + group_cd + ", group_cd_nm=" + group_cd_nm + ", group_del=" + group_del
				+ ", reg_no=" + reg_no + ", reg_date=" + reg_date + ", mod_no=" + mod_no + ", mod_date=" + mod_date
				+ "]";
	}
	
}
