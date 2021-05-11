package com.pbrk.pbook.entity;

import java.util.Date;


public class GroupCodeView extends GroupCode {
		
	private String group_del_nm; // 그룹코드 삭제여부 명	 
	private String reg_nm;	     // 작성자 명
	private String mod_nm;       // 수정자 명
	
	public GroupCodeView() {
		// TODO Auto-generated constructor stub
	}

	public GroupCodeView(int group_cd, String group_cd_nm, boolean group_del, int reg_no, Date reg_date, int mod_no,
			Date mod_date,
			String group_del_nm, String reg_nm, String mod_nm) {
		super(group_cd, group_cd_nm, group_del, reg_no, reg_date, mod_no, mod_date);

		this.group_del_nm = group_del_nm;
		this.reg_nm = reg_nm;
		this.mod_nm = mod_nm;
	}

	public String getGroup_del_nm() {
		return group_del_nm;
	}

	public void setGroup_del_nm(String group_del_nm) {
		this.group_del_nm = group_del_nm;
	}

	public String getReg_nm() {
		return reg_nm;
	}

	public void setReg_nm(String reg_nm) {
		this.reg_nm = reg_nm;
	}

	public String getMod_nm() {
		return mod_nm;
	}

	public void setMod_nm(String mod_nm) {
		this.mod_nm = mod_nm;
	}

	@Override
	public String toString() {
		return "GroupCodeView [group_del_nm=" + group_del_nm + ", reg_nm=" + reg_nm + ", mod_nm=" + mod_nm
				+ ", getGroup_cd()=" + getGroup_cd() + ", getGroup_cd_nm()=" + getGroup_cd_nm() + ", isGroup_del()="
				+ isGroup_del() + ", getReg_no()=" + getReg_no() + ", getReg_date()=" + getReg_date() + ", getMod_no()="
				+ getMod_no() + ", getMod_date()=" + getMod_date() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
	
}
