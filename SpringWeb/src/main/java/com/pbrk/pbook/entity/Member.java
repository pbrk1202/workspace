package com.pbrk.pbook.entity;

import java.util.Date;

public class Member {
		 
	private int member_no;        // 회원번호
	private String member_id;     // 회원아이디
	private String member_pwd;    // 회원비밀번호
	private String member_nm;     // 회원 명
	private int member_gender;    // 성별
	private String member_bth;    // 생년월일
	private String member_phone;  // 전화번호
	private String member_email;  // 이메일
	private boolean member_del;	  // 회원 삭제여부
	private int group_cd;         // 회원 그룹타입
	private int code_cd;          // 회원 타입 (관리자, 회원, 사용자)
	private int reg_no;		 	  // 작성자 번호
	private Date reg_date;        // 작성일자
	private int mod_no;           // 수정자 번호
	private Date mod_date;        // 수정일자
		
	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(int member_no, String member_id, String member_pwd, String member_nm, int member_gender,
			String member_bth, String member_phone, String member_email, boolean member_del, int group_cd, int code_cd,
			int reg_no, Date reg_date, int mod_no, Date mod_date) {
		super();
		this.member_no = member_no;
		this.member_id = member_id;
		this.member_pwd = member_pwd;
		this.member_nm = member_nm;
		this.member_gender = member_gender;
		this.member_bth = member_bth;
		this.member_phone = member_phone;
		this.member_email = member_email;
		this.member_del = member_del;
		this.group_cd = group_cd;
		this.code_cd = code_cd;
		this.reg_no = reg_no;
		this.reg_date = reg_date;
		this.mod_no = mod_no;
		this.mod_date = mod_date;
	}

	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_pwd() {
		return member_pwd;
	}

	public void setMember_pwd(String member_pwd) {
		this.member_pwd = member_pwd;
	}

	public String getMember_nm() {
		return member_nm;
	}

	public void setMember_nm(String member_nm) {
		this.member_nm = member_nm;
	}

	public int getMember_gender() {
		return member_gender;
	}

	public void setMember_gender(int member_gender) {
		this.member_gender = member_gender;
	}

	public String getMember_bth() {
		return member_bth;
	}

	public void setMember_bth(String member_bth) {
		this.member_bth = member_bth;
	}

	public String getMember_phone() {
		return member_phone;
	}

	public void setMember_phone(String member_phone) {
		this.member_phone = member_phone;
	}

	public String getMember_email() {
		return member_email;
	}

	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}

	public boolean isMember_del() {
		return member_del;
	}

	public void setMember_del(boolean member_del) {
		this.member_del = member_del;
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
		return "Member [member_no=" + member_no + ", member_id=" + member_id + ", member_pwd=" + member_pwd
				+ ", member_nm=" + member_nm + ", member_gender=" + member_gender + ", member_bth=" + member_bth
				+ ", member_phone=" + member_phone + ", member_email=" + member_email + ", member_del=" + member_del
				+ ", group_cd=" + group_cd + ", code_cd=" + code_cd + ", reg_no=" + reg_no + ", reg_date=" + reg_date
				+ ", mod_no=" + mod_no + ", mod_date=" + mod_date + "]";
	}

	
}
