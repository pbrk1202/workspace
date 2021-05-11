package com.pbrk.pbook.entity;

import java.util.Date;


public class FaqView extends Faq {
	
	private String faq_pub_nm; // 공개여부 명 
	private String group_nm;   // 그룹코드 명
	private String code_nm;	   // 공통코드 명
	private String reg_nm;	   // 작성자 명
	private String mod_nm;     // 수정자 명
	
	public FaqView() {
		// TODO Auto-generated constructor stub
	}

	public FaqView(int faq_no, String faq_title, String faq_content, String faq_answer, boolean faq_pub, int group_cd,
			int code_cd, int reg_no, Date reg_date, int mod_no, Date mod_date,
			String faq_pub_nm, String group_nm, String code_nm, String reg_nm, String mod_nm) {
		super(faq_no, faq_title, faq_content, faq_answer, faq_pub, group_cd, code_cd, reg_no, reg_date, mod_no, mod_date);

		this.faq_pub_nm = faq_pub_nm;
		this.group_nm = group_nm;
		this.code_nm = code_nm;
		this.reg_nm = reg_nm;
		this.mod_nm = mod_nm;
	}

	public String getFaq_pub_nm() {
		return faq_pub_nm;
	}

	public void setFaq_pub_nm(String faq_pub_nm) {
		this.faq_pub_nm = faq_pub_nm;
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
		return "FaqView [faq_pub_nm=" + faq_pub_nm + ", group_nm=" + group_nm + ", code_nm=" + code_nm + ", reg_nm="
				+ reg_nm + ", mod_nm=" + mod_nm + ", getFaq_no()=" + getFaq_no() + ", getFaq_title()=" + getFaq_title()
				+ ", getFaq_content()=" + getFaq_content() + ", getFaq_answer()=" + getFaq_answer() + ", isFaq_pub()="
				+ isFaq_pub() + ", getGroup_cd()=" + getGroup_cd() + ", getCode_cd()=" + getCode_cd() + ", getReg_no()="
				+ getReg_no() + ", getReg_date()=" + getReg_date() + ", getMod_no()=" + getMod_no() + ", getMod_date()="
				+ getMod_date() + ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + "]";
	}

	
	
}
