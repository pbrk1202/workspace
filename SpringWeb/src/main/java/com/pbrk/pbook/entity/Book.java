package com.pbrk.pbook.entity;

import java.util.Date;


public class Book {
	
	private int book_no;			 // 일련번호
	private String book_title;		 // 도서제목
	private String book_desc;	     // 책소개
	private String book_author;		 // 저자
	private String book_author_desc; // 저자소개
	private String book_publisher;	 // 출판사
	private String book_pub_date;	 // 발행일자
	private String book_img_url;	 // 도서표지 이미지
	private boolean book_pub;        // 도서 사용여부
	private int group_cd;  		 // 그룹 코드
	private int code_cd;			 // 코드 번호
	private int reg_no;				 // 작성자
	private Date reg_date;      	 // 작성일자
	private int mod_no; 		  	 // 수정자
	private Date mod_date;      	 // 수정일자
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(int book_no, String book_title, String book_desc, String book_author, String book_author_desc,
			String book_publisher, String book_pub_date, String book_img_url, boolean book_pub, int group_cd, 
			int code_cd, int reg_no, Date reg_date, int mod_no, Date mod_date) {
		super();
		this.book_no = book_no;
		this.book_title = book_title;
		this.book_desc = book_desc;
		this.book_author = book_author;
		this.book_author_desc = book_author_desc;
		this.book_publisher = book_publisher;
		this.book_pub_date = book_pub_date;
		this.book_img_url = book_img_url;
		this.book_pub = book_pub;
		this.group_cd = group_cd;
		this.code_cd = code_cd;
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

	public String getBook_title() {
		return book_title;
	}

	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}

	public String getBook_desc() {
		return book_desc;
	}

	public void setBook_desc(String book_desc) {
		this.book_desc = book_desc;
	}

	public String getBook_author() {
		return book_author;
	}

	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}

	public String getBook_author_desc() {
		return book_author_desc;
	}

	public void setBook_author_desc(String book_author_desc) {
		this.book_author_desc = book_author_desc;
	}

	public String getBook_publisher() {
		return book_publisher;
	}

	public void setBook_publisher(String book_publisher) {
		this.book_publisher = book_publisher;
	}

	public String getBook_pub_date() {
		return book_pub_date;
	}

	public void setBook_pub_date(String book_pub_date) {
		this.book_pub_date = book_pub_date;
	}

	public String getBook_img_url() {
		return book_img_url;
	}

	public void setBook_img_url(String book_img_url) {
		this.book_img_url = book_img_url;
	}
	
	public boolean isBook_pub() {
		return book_pub;
	}

	public void setBook_pub(boolean book_pub) {
		this.book_pub = book_pub;
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
		return "Book [book_no=" + book_no + ", book_title=" + book_title + ", book_desc=" + book_desc + ", book_author="
				+ book_author + ", book_author_desc=" + book_author_desc + ", book_publisher=" + book_publisher
				+ ", book_pub_date=" + book_pub_date + ", book_img_url=" + book_img_url + ", book_pub=" + book_pub
				+ ", group_cd=" + group_cd + ", code_cd=" + code_cd + ", reg_no=" + reg_no + ", reg_date=" + reg_date
				+ ", mod_no=" + mod_no + ", mod_date=" + mod_date + "]";
	}
		
	
}
