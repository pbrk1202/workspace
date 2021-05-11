package com.pbrk.pbook.entity;

import java.util.Date;

public class Notice {
	
	private int notice_no;
	private String notice_title;
	private String notice_content;
	private int notice_hit;
	private boolean notice_pub;
	private String notice_files;
	private int group_cd;
	private int code_cd;
	private int reg_no;	
	private Date reg_date;
	private int mod_no;
	private Date mod_date;
	
	public Notice() {
		// TODO Auto-generated constructor stub
	}

	public Notice(int notice_no, String notice_title, String notice_content, int notice_hit, boolean notice_pub,
			String notice_files, int group_cd, int code_cd, int reg_no, Date reg_date, int mod_no, Date mod_date) {
		super();
		this.notice_no = notice_no;
		this.notice_title = notice_title;
		this.notice_content = notice_content;
		this.notice_hit = notice_hit;
		this.notice_pub = notice_pub;
		this.notice_files = notice_files;
		this.group_cd = group_cd;
		this.code_cd = code_cd;
		this.reg_no = reg_no;
		this.reg_date = reg_date;
		this.mod_no = mod_no;
		this.mod_date = mod_date;
	}

	public int getNotice_no() {
		return notice_no;
	}

	public void setNotice_no(int notice_no) {
		this.notice_no = notice_no;
	}

	public String getNotice_title() {
		return notice_title;
	}

	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}

	public String getNotice_content() {
		return notice_content;
	}

	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}

	public int getNotice_hit() {
		return notice_hit;
	}

	public void setNotice_hit(int notice_hit) {
		this.notice_hit = notice_hit;
	}

	public boolean isNotice_pub() {
		return notice_pub;
	}

	public void setNotice_pub(boolean notice_pub) {
		this.notice_pub = notice_pub;
	}

	public String getNotice_files() {
		return notice_files;
	}

	public void setNotice_files(String notice_files) {
		this.notice_files = notice_files;
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
		return "Notice [notice_no=" + notice_no + ", notice_title=" + notice_title + ", notice_content="
				+ notice_content + ", notice_hit=" + notice_hit + ", notice_pub=" + notice_pub + ", notice_files="
				+ notice_files + ", group_cd=" + group_cd + ", code_cd=" + code_cd + ", reg_no=" + reg_no
				+ ", reg_date=" + reg_date + ", mod_no=" + mod_no + ", mod_date=" + mod_date + "]";
	}


}
