package com.pbrk.pbook.entity;

import java.util.Date;

public class Faq {
		 
	private int faq_no;
	private String faq_title;
	private String faq_content;
	private String faq_answer;
	private boolean faq_pub;
	private int group_cd;
	private int code_cd;
	private int reg_no;
	private Date reg_date;
	private int mod_no;
	private Date mod_date;
	
	public Faq() {
		// TODO Auto-generated constructor stub
	}

	public Faq(int faq_no, String faq_title, String faq_content, String faq_answer, boolean faq_pub, int group_cd,
			int code_cd, int reg_no, Date reg_date, int mod_no, Date mod_date) {
		super();
		this.faq_no = faq_no;
		this.faq_title = faq_title;
		this.faq_content = faq_content;
		this.faq_answer = faq_answer;
		this.faq_pub = faq_pub;
		this.group_cd = group_cd;
		this.code_cd = code_cd;
		this.reg_no = reg_no;
		this.reg_date = reg_date;
		this.mod_no = mod_no;
		this.mod_date = mod_date;
	}

	public int getFaq_no() {
		return faq_no;
	}

	public void setFaq_no(int faq_no) {
		this.faq_no = faq_no;
	}

	public String getFaq_title() {
		return faq_title;
	}

	public void setFaq_title(String faq_title) {
		this.faq_title = faq_title;
	}

	public String getFaq_content() {
		return faq_content;
	}

	public void setFaq_content(String faq_content) {
		this.faq_content = faq_content;
	}

	public String getFaq_answer() {
		return faq_answer;
	}

	public void setFaq_answer(String faq_answer) {
		this.faq_answer = faq_answer;
	}

	public boolean isFaq_pub() {
		return faq_pub;
	}

	public void setFaq_pub(boolean faq_pub) {
		this.faq_pub = faq_pub;
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
		return "Faq [faq_no=" + faq_no + ", faq_title=" + faq_title + ", faq_content=" + faq_content + ", faq_answer="
				+ faq_answer + ", faq_pub=" + faq_pub + ", group_cd=" + group_cd + ", code_cd=" + code_cd + ", reg_no="
				+ reg_no + ", reg_date=" + reg_date + ", mod_no=" + mod_no + ", mod_date=" + mod_date + "]";
	}
		
	
}
