package com.pbrk.pbook.entity;

import java.util.Date;


public class CodeView extends Code {
	
	private String group_nm;    // 그룹코드 명	 
	private String code_del_nm;	// 공통코드 삭제여부(삭제, 사용중)
	private String reg_nm;	    // 작성자 명
	private String mod_nm;      // 수정자 명
	
	public CodeView() {
		// TODO Auto-generated constructor stub
	}

	public CodeView(int group_cd, int code_cd, String code_nm, boolean code_del, int reg_no, Date reg_date, int mod_no,
			Date mod_date,
			String group_nm, String code_del_nm, String reg_nm, String mod_nm) {
		super(group_cd, code_cd, code_nm, code_del, reg_no, reg_date, mod_no, mod_date);

		this.group_nm = group_nm;
		this.code_del_nm = code_del_nm;
		this.reg_nm = reg_nm;
		this.mod_nm = mod_nm;
	}

	public String getGroup_nm() {
		return group_nm;
	}

	public void setGroup_nm(String group_nm) {
		this.group_nm = group_nm;
	}

	public String getCode_del_nm() {
		return code_del_nm;
	}

	public void setCode_del_nm(String code_del_nm) {
		this.code_del_nm = code_del_nm;
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
		return "CodeView [group_nm=" + group_nm + ", code_del_nm=" + code_del_nm + ", reg_nm=" + reg_nm + ", mod_nm="
				+ mod_nm + ", getGroup_cd()=" + getGroup_cd() + ", getCode_cd()=" + getCode_cd() + ", getCode_nm()="
				+ getCode_nm() + ", isCode_del()=" + isCode_del() + ", getReg_no()=" + getReg_no() + ", getReg_date()="
				+ getReg_date() + ", getMod_no()=" + getMod_no() + ", getMod_date()=" + getMod_date() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
}
