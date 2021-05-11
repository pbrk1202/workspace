package com.pbrk.pbook.entity;

import java.util.Date;


public class BookView extends Book {
	
	private String group_nm;    // 그룹코드 명	 
	private String code_nm;	    // 공통코드 명
	private String reg_nm;	    // 작성자 명
	private String mod_nm;      // 수정자 명
	private String book_pub_nm;	// 공개여부 명

	
	public BookView() {
		// TODO Auto-generated constructor stub
	}


	public BookView(int book_no, String book_title, String book_desc, String book_author, String book_author_desc,
			String book_publisher, String book_pub_date, String book_img_url, boolean book_pub, int group_cd, 
			int code_cd, int reg_no, Date reg_date, int mod_no, Date mod_date, 
			String group_nm, String code_nm, String reg_nm, String mod_nm, String book_pub_nm) {
		super(book_no, book_title, book_desc, book_author, book_author_desc, book_publisher, book_pub_date, book_img_url,
				book_pub, group_cd, code_cd, reg_no, reg_date, mod_no, mod_date);
		
		this.group_nm = group_nm;
		this.code_nm = code_nm;
		this.reg_nm = reg_nm;
		this.mod_nm = mod_nm;
		this.book_pub_nm = book_pub_nm;
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


	public String getBook_pub_nm() {
		return book_pub_nm;
	}


	public void setBook_pub_nm(String book_pub_nm) {
		this.book_pub_nm = book_pub_nm;
	}


	@Override
	public String toString() {
		return "BookView [group_nm=" + group_nm + ", code_nm=" + code_nm + ", reg_nm=" + reg_nm + ", mod_nm=" + mod_nm
				+ ", book_pub_nm=" + book_pub_nm + ", getBook_no()=" + getBook_no() + ", getBook_title()="
				+ getBook_title() + ", getBook_desc()=" + getBook_desc() + ", getBook_author()=" + getBook_author()
				+ ", getBook_author_desc()=" + getBook_author_desc() + ", getBook_publisher()=" + getBook_publisher()
				+ ", getBook_pub_date()=" + getBook_pub_date() + ", getBook_img_url()=" + getBook_img_url()
				+ ", isBook_pub()=" + isBook_pub() + ", getGroup_cd()=" + getGroup_cd() + ", getCode_cd()="
				+ getCode_cd() + ", getReg_no()=" + getReg_no() + ", getReg_date()=" + getReg_date() + ", getMod_no()="
				+ getMod_no() + ", getMod_date()=" + getMod_date() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}


	

}
