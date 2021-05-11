package com.pbrk.pbook.entity;

import java.util.Date;

public class BookReview {

	private int book_no;   				// 도서 일련번호
	private int book_review_no;         // 도서 리뷰 번호
	private int book_score;     		// 점수
	private String book_review_content; // 리뷰
	private boolean book_review_pub;    // 공개여부
	private boolean book_review_del;    // 삭제여부
	private int reg_no; 				// 작성자
	private Date reg_date; 				// 작성일자
	private int mod_no;					// 수정자
	private Date mod_date; 				// 수정일자

	
	public BookReview() {
		// TODO Auto-generated constructor stub
	}

	public BookReview(int book_no, int book_review_no, int book_score, String book_review_content,
			boolean book_review_pub, boolean book_review_del, int reg_no, Date reg_date, int mod_no, Date mod_date) {
		super();
		this.book_no = book_no;
		this.book_review_no = book_review_no;
		this.book_score = book_score;
		this.book_review_content = book_review_content;
		this.book_review_pub = book_review_pub;
		this.book_review_del = book_review_del;
		this.reg_no = reg_no;
		this.reg_date = reg_date;
		this.mod_no = mod_no;
		this.mod_date = mod_date;
	}

	public int getBook_no() {
		return book_no;
	}

	public void setBook_no(int book_no) {
		this.book_no = book_no;
	}

	public int getBook_review_no() {
		return book_review_no;
	}

	public void setBook_review_no(int book_review_no) {
		this.book_review_no = book_review_no;
	}

	public int getBook_score() {
		return book_score;
	}

	public void setBook_score(int book_score) {
		this.book_score = book_score;
	}

	public String getBook_review_content() {
		return book_review_content;
	}

	public void setBook_review_content(String book_review_content) {
		this.book_review_content = book_review_content;
	}

	public boolean isBook_review_pub() {
		return book_review_pub;
	}

	public void setBook_review_pub(boolean book_review_pub) {
		this.book_review_pub = book_review_pub;
	}

	public boolean isBook_review_del() {
		return book_review_del;
	}

	public void setBook_review_del(boolean book_review_del) {
		this.book_review_del = book_review_del;
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
		return "BookReview [book_no=" + book_no + ", book_review_no=" + book_review_no + ", book_score=" + book_score
				+ ", book_review_content=" + book_review_content + ", book_review_pub=" + book_review_pub
				+ ", book_review_del=" + book_review_del + ", reg_no=" + reg_no + ", reg_date=" + reg_date + ", mod_no="
				+ mod_no + ", mod_date=" + mod_date + "]";
	}
	
}
