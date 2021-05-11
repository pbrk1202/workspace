package com.pbrk.pbook.entity;

import java.util.Date;


public class MemberView extends Member {
	
	private String member_del_nm;    // 회원 삭제여부 명
	private String member_gender_nm; //회원 성별 명
	private String group_nm;         // 그룹코드 명	 
	private String code_nm;		     // 공통코드 명
	private String reg_nm;	         // 작성자 명
	private String mod_nm;           // 수정자 명
	
	public MemberView() {
		// TODO Auto-generated constructor stub
	}

	public MemberView(int member_no, String member_id, String member_pwd, String member_nm, int member_gender,
			String member_bth, String member_phone, String member_email, boolean member_del, int group_cd, int code_cd,
			int reg_no, Date reg_date, int mod_no, Date mod_date,
			String member_del_nm, String member_gender_nm, String group_nm, String code_nm, String reg_nm, String mod_nm) {
		super(member_no, member_id, member_pwd, member_nm, member_gender, member_bth, member_phone, member_email, member_del,
				group_cd, code_cd, reg_no, reg_date, mod_no, mod_date);

		this.member_del_nm = member_del_nm;
		this.member_gender_nm = member_gender_nm;
		this.group_nm = group_nm;
		this.code_nm = code_nm;
		this.reg_nm = reg_nm;
		this.mod_nm = mod_nm;
	}

	public String getMember_del_nm() {
		return member_del_nm;
	}

	public void setMember_del_nm(String member_del_nm) {
		this.member_del_nm = member_del_nm;
	}

	public String getMember_gender_nm() {
		return member_gender_nm;
	}

	public void setMember_gender_nm(String member_gender_nm) {
		this.member_gender_nm = member_gender_nm;
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
		return "MemberView [member_del_nm=" + member_del_nm + ", member_gender_nm=" + member_gender_nm + ", group_nm="
				+ group_nm + ", code_nm=" + code_nm + ", reg_nm=" + reg_nm + ", mod_nm=" + mod_nm + ", getMember_no()="
				+ getMember_no() + ", getMember_id()=" + getMember_id() + ", getMember_pwd()=" + getMember_pwd()
				+ ", getMember_nm()=" + getMember_nm() + ", getMember_gender()=" + getMember_gender()
				+ ", getMember_bth()=" + getMember_bth() + ", getMember_phone()=" + getMember_phone()
				+ ", getMember_email()=" + getMember_email() + ", isMember_del()=" + isMember_del() + ", getGroup_cd()="
				+ getGroup_cd() + ", getCode_cd()=" + getCode_cd() + ", getReg_no()=" + getReg_no() + ", getReg_date()="
				+ getReg_date() + ", getMod_no()=" + getMod_no() + ", getMod_date()=" + getMod_date() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
}
