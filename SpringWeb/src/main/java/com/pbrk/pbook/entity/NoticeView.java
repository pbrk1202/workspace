package com.pbrk.pbook.entity;

import java.util.Date;

public class NoticeView extends Notice {
	
	private String group_nm;
	private String code_nm;
	private String reg_nm;
	private String mod_nm;
	
	public NoticeView() {
		// TODO Auto-generated constructor stub
	}

	public NoticeView(int notice_no, String notice_title, String notice_content, int notice_hit, boolean notice_pub,
			String notice_files, int group_cd, int code_cd, int reg_no, Date reg_date, int mod_no, Date mod_date,
			String group_nm, String code_nm, String reg_nm, String mod_nm) {
		super(notice_no, notice_title, notice_content, notice_hit, notice_pub, notice_files, group_cd, code_cd, reg_no,
				reg_date, mod_no, mod_date);

		this.group_nm = group_nm;
		this.code_nm = code_nm;
		this.reg_nm = reg_nm;
		this.mod_nm = mod_nm;
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
		return "NoticeView [group_nm=" + group_nm + ", code_nm=" + code_nm + ", reg_nm=" + reg_nm + ", mod_nm=" + mod_nm
				+ ", getNotice_no()=" + getNotice_no() + ", getNotice_title()=" + getNotice_title()
				+ ", getNotice_content()=" + getNotice_content() + ", getNotice_hit()=" + getNotice_hit()
				+ ", isNotice_pub()=" + isNotice_pub() + ", getNotice_files()=" + getNotice_files() + ", getGroup_cd()="
				+ getGroup_cd() + ", getCode_cd()=" + getCode_cd() + ", getReg_no()=" + getReg_no() + ", getReg_date()="
				+ getReg_date() + ", getMod_no()=" + getMod_no() + ", getMod_date()=" + getMod_date() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
}

