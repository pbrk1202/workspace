package com.pbrk.pbook.entity;

import java.util.Date;

public class SingleLine {
		
	private int sngl_line_no;         // 한줄글 번호
	private String sngl_line_title;   // 한줄글 제목
	private String sngl_line_content; // 한줄글 내용
	private boolean sngl_line_pub;    // 한줄글 공개여부
	private int group_cd;             // 그룹코드
	private int code_cd;              // 공통코드
	private int reg_no;	              // 작성자
	private Date reg_date;            // 작성일자
	private int mod_no;               // 수정자
	private Date mod_date;            // 수정일자
	
	public SingleLine() {
		// TODO Auto-generated constructor stub
	}

	public SingleLine(int sngl_line_no, String sngl_line_title, String sngl_line_content, boolean sngl_line_pub,
			int group_cd, int code_cd, int reg_no, Date reg_date, int mod_no, Date mod_date) {
		super();
		this.sngl_line_no = sngl_line_no;
		this.sngl_line_title = sngl_line_title;
		this.sngl_line_content = sngl_line_content;
		this.sngl_line_pub = sngl_line_pub;
		this.group_cd = group_cd;
		this.code_cd = code_cd;
		this.reg_no = reg_no;
		this.reg_date = reg_date;
		this.mod_no = mod_no;
		this.mod_date = mod_date;
	}

	public int getSngl_line_no() {
		return sngl_line_no;
	}

	public void setSngl_line_no(int sngl_line_no) {
		this.sngl_line_no = sngl_line_no;
	}

	public String getSngl_line_title() {
		return sngl_line_title;
	}

	public void setSngl_line_title(String sngl_line_title) {
		this.sngl_line_title = sngl_line_title;
	}

	public String getSngl_line_content() {
		return sngl_line_content;
	}

	public void setSngl_line_content(String sngl_line_content) {
		this.sngl_line_content = sngl_line_content;
	}

	public boolean isSngl_line_pub() {
		return sngl_line_pub;
	}

	public void setSngl_line_pub(boolean sngl_line_pub) {
		this.sngl_line_pub = sngl_line_pub;
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
		return "SingleLine [sngl_line_no=" + sngl_line_no + ", sngl_line_title=" + sngl_line_title
				+ ", sngl_line_content=" + sngl_line_content + ", sngl_line_pub=" + sngl_line_pub + ", group_cd="
				+ group_cd + ", code_cd=" + code_cd + ", reg_no=" + reg_no + ", reg_date=" + reg_date + ", mod_no="
				+ mod_no + ", mod_date=" + mod_date + "]";
	}


}
