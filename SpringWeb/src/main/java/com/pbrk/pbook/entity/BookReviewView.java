package com.pbrk.pbook.entity;

import java.util.Date;


public class BookReviewView extends BookReview {
	
	private String book_pup_nm; // 공개여부 명	 
	private String book_del_nm;	// 삭제여부 명
	private String reg_nm;	    // 작성자 명
	private String mod_nm;      // 수정자 명

	
	public BookReviewView() {
		// TODO Auto-generated constructor stub
	}


	public BookReviewView(int book_no, int book_review_no, int book_score, String book_review_content, 
			boolean book_review_pub, boolean book_review_del, int reg_no, Date reg_date, int mod_no, 
			Date mod_date, 
			String book_pup_nm, String book_del_nm, String reg_nm, String mod_nm) {
		super(book_no, book_review_no, book_score, book_review_content, book_review_pub, book_review_del, reg_no, reg_date, mod_no, mod_date);
		
		this.book_pup_nm = book_pup_nm;
		this.book_del_nm = book_del_nm;
		this.reg_nm = reg_nm;
		this.mod_nm = mod_nm;		
		
	}


	public String getBook_pup_nm() {
		return book_pup_nm;
	}


	public void setBook_pup_nm(String book_pup_nm) {
		this.book_pup_nm = book_pup_nm;
	}


	public String getBook_del_nm() {
		return book_del_nm;
	}


	public void setBook_del_nm(String book_del_nm) {
		this.book_del_nm = book_del_nm;
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
		return "BookReviewView [book_pup_nm=" + book_pup_nm + ", book_del_nm=" + book_del_nm + ", reg_nm=" + reg_nm
				+ ", mod_nm=" + mod_nm + ", getBook_no()=" + getBook_no() + ", getBook_review_no()="
				+ getBook_review_no() + ", getBook_score()=" + getBook_score() + ", getBook_review_content()="
				+ getBook_review_content() + ", isBook_review_pub()=" + isBook_review_pub() + ", isBook_review_del()="
				+ isBook_review_del() + ", getReg_no()=" + getReg_no() + ", getReg_date()=" + getReg_date()
				+ ", getMod_no()=" + getMod_no() + ", getMod_date()=" + getMod_date() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
	
}
