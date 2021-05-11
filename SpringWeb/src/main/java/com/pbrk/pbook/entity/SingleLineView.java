package com.pbrk.pbook.entity;

import java.util.Date;


public class SingleLineView extends SingleLine {
	
	private String sngl_line_pub_nm; // 좋은글 공개여부 명	 
	private String group_nm;		 // 그룹코드 명
	private String code_nm;			 // 공통코드 명
	private String reg_nm;	    	 // 작성자 명
	private String mod_nm;      	 // 수정자 명
	
	public SingleLineView() {
		// TODO Auto-generated constructor stub
	}

	public SingleLineView(int sngl_line_no, String sngl_line_title, String sngl_line_content, boolean sngl_line_pub,
			int group_cd, int code_cd, int reg_no, Date reg_date, int mod_no, Date mod_date,
			String sngl_line_pub_nm, String group_nm, String code_nm, String reg_nm, String mod_nm) {
		super(sngl_line_no, sngl_line_title, sngl_line_content, sngl_line_pub, group_cd, code_cd, reg_no, reg_date, mod_no,
				mod_date);
		
		this.sngl_line_pub_nm = sngl_line_pub_nm;
		this.group_nm = group_nm;
		this.code_nm = code_nm;
		this.reg_nm = reg_nm;
		this.mod_nm = mod_nm;
	}

	public String getSngl_line_pub_nm() {
		return sngl_line_pub_nm;
	}

	public void setSngl_line_pub_nm(String sngl_line_pub_nm) {
		this.sngl_line_pub_nm = sngl_line_pub_nm;
	}

	public String getGroup_nm() {
		return group_nm;
	}

	public void setGroup_nm(String group_nm) {
		this.group_nm = group_nm;
	}

	public String getCode_nm() {
		return code_nm;
	}

	public void setCode_nm(String code_nm) {
		this.code_nm = code_nm;
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
		return "SingleLineView [sngl_line_pub_nm=" + sngl_line_pub_nm + ", group_nm=" + group_nm + ", code_nm="
				+ code_nm + ", reg_nm=" + reg_nm + ", mod_nm=" + mod_nm + ", getSngl_line_no()=" + getSngl_line_no()
				+ ", getSngl_line_title()=" + getSngl_line_title() + ", getSngl_line_content()="
				+ getSngl_line_content() + ", isSngl_line_pub()=" + isSngl_line_pub() + ", getGroup_cd()="
				+ getGroup_cd() + ", getCode_cd()=" + getCode_cd() + ", getReg_no()=" + getReg_no() + ", getReg_date()="
				+ getReg_date() + ", getMod_no()=" + getMod_no() + ", getMod_date()=" + getMod_date() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}


}
