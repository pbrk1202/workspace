package com.pbrk.pbook.controller.admin.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pbrk.pbook.entity.CodeView;
import com.pbrk.pbook.entity.Member;
import com.pbrk.pbook.entity.MemberView;
import com.pbrk.pbook.service.admin.AdminMemberService;

@Controller("adminMemberController")
@RequestMapping("/admin/board/member/")
public class AdminMemberController {

	@Autowired
	private AdminMemberService service;
	
	/**
	 * 회원 목록 조회
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("list")
	public String adminMemberList(HttpServletRequest request, Model model) {
		
		String groupCd_ = request.getParameter("groupCd"); // 그룹코드
		String codeCd_  = request.getParameter("t");	   // 도서타입 코드
		String field_   = request.getParameter("f");       // 검색필드 (title)
		String query_   = request.getParameter("q");       // input 검색 값
		String page_    = request.getParameter("p");       // 현재 페이지
			
		int groupCd = 1; // 그룹코드
		if(groupCd_ != null && !groupCd_.equals(""))
			groupCd = Integer.parseInt(groupCd_);
		
		int codeCd = 0; // 도서 타입 ( 0 : 전체 )
		if(codeCd_ != null && !codeCd_.equals(""))
			codeCd = Integer.parseInt(codeCd_);
		
		
		String field = "member_id"; // 코드명
		if(field_ != null && !field_.equals(""))
			field = field_;
		
		String query = "";
		if(query_ != null && !query_.equals(""))
			query = query_;
		
		int page = 1;
		if(page_ != null && !page_.equals(""))
			page = Integer.parseInt(page_);
				
		
		// code (view)를 요청할 때
		List<CodeView> codeList = service.getAdminCodeViewList(groupCd);
		
		// 목록 조회		
		List<MemberView> list = service.getAdminMemberViewList(page, field, query, codeCd);	
		
		// 게시물 수 조회
		int count = service.getAdminMemberCount(field, query, codeCd);
		
		model.addAttribute("codeList",codeList);
		model.addAttribute("list",list);
		model.addAttribute("count",count);
				
		return "admin.board.member.list";
	}
	
	/**
	 * 회원 상세정보 조회
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("detail")
	public String adminMemberDetail(HttpServletRequest request, Model model) {
		
		String memberNo_ = request.getParameter("memberNo"); // 회원번호
		
		int memberNo = 1; // 회원번호 명
		if(memberNo_ != null && !memberNo_.equals(""))
			memberNo = Integer.parseInt(memberNo_);

		
		// 상세정보 조회
		MemberView info = service.getAdminMemberViewDetail(memberNo);
		
		model.addAttribute("info",info);
		
		return "admin.board.member.detail";
	}
	
	/**
	 * 회원 등록 페이지로 이동
	 * @return
	 */
	@RequestMapping(value="reg", method = RequestMethod.GET)
	public String getAdminMemberReg(Model model) {
		
		int typeGroupCd   = 1;  // 회원타입 그룹코드
		int genderGroupCd = 11; // 성별 그룹코드
		
		// code (회원타입 코드 목록)를 요청할 때
		List<CodeView> typeCodeList = service.getAdminCodeViewList(typeGroupCd);
		
		// code (성별 코드 목록)를 요청할 때
		List<CodeView> genderCodeList = service.getAdminCodeViewList(genderGroupCd);	
			
		model.addAttribute("typeCodeList",typeCodeList);
		model.addAttribute("genderCodeList",genderCodeList);
		
		return "admin.board.member.reg";
	}
	
	/**
	 * 회원 등록
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="reg", method = RequestMethod.POST)
	public void postAdminMemberReg(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
		
		String memberId_     = request.getParameter("memberId");     // 회원아이디
		String memberPwd_    = request.getParameter("memberPwd");    // 회원비밀번호 
		String memberNm_     = request.getParameter("memberNm");     // 회원명
	    String memberGender_ = request.getParameter("memberGender"); // 회원성별
	    String memberBth_    = request.getParameter("memberBth");    // 회원 생년월일 
		String memberPhone_  = request.getParameter("memberPhone");  // 회원 전화번호
	    String memberEmail_  = request.getParameter("memberEmail");  // 회원 이메일
		String groupCd_      = request.getParameter("groupCd");      // 그룹코드
		String codeCd_       = request.getParameter("codeCd");       // 공통코드
		//String regNo_        = request.getParameter("regNo");        // 작성자
				
		String memberSessionId_ = (String)session.getAttribute("sessionUser");
		int regNo = 2; // 임시 관리자 번호
		
		String memberId = null; // 회원 아이디
		if(memberId_ != null && !memberId_.equals(""))
			memberId = memberId_;
		
		String memberPwd = null; // 회원 비밀번호
		if(memberPwd_ != null && !memberPwd_.equals(""))
			memberPwd = memberPwd_;
		
		String memberNm = null; // 회원명
		if(memberNm_ != null && !memberNm_.equals(""))
			memberNm = memberNm_;
				
		int memberGender = 0; // 회원성별
		if(memberGender_ != null && !memberGender_.equals(""))
			memberGender = Integer.parseInt(memberGender_);
	
		String memberBth = null; // 회원생년월일
		if(memberBth_ != null && !memberBth_.equals(""))
			memberBth = memberBth_;
		
		String memberPhone = null; // 회원전화번호
		if(memberPhone_ != null && !memberPhone_.equals(""))
			memberPhone = memberPhone_;
		
		String memberEmail = null; // 회원이메일
		if(memberEmail_ != null && !memberEmail_.equals(""))
			memberEmail = memberEmail_;
						
		int groupCd = 0; // 그룹코드 명
		if(groupCd_ != null && !groupCd_.equals(""))
			groupCd = Integer.parseInt(groupCd_);
			
		int codeCd = 0; // 공통코드
		if(codeCd_ != null && !codeCd_.equals(""))
			codeCd = Integer.parseInt(codeCd_);
					
		// 작성자 예외처리
		if(memberSessionId_ != null && !memberSessionId_.equals(""))
			regNo = service.getAdminMemberNo(memberSessionId_); // 작성자 번호
		
		
		Member member = new Member();
		member.setMember_id(memberId);
		member.setMember_pwd(memberPwd);
		member.setMember_nm(memberNm);
		member.setMember_gender(memberGender);
		member.setMember_bth(memberBth);
		member.setMember_phone(memberPhone);
		member.setMember_email(memberEmail);
		member.setGroup_cd(groupCd);
		member.setCode_cd(codeCd);
		member.setReg_no(regNo);
		
		
		// 공통코드 등록
		int result = service.adminMemberInsert(member);
		
		response.sendRedirect("list");
	}
	
	/**
	 * 회원 수정 페이지로 이동
	 * @return
	 */
	@RequestMapping(value="edit", method = RequestMethod.GET)
	public String getAdminMemberEdit(HttpServletRequest request, Model model) {
		
		String memberNo_ = request.getParameter("no"); // 회원번호
		
		int typeGroupCd   = 1;  // 회원타입 그룹코드
		int genderGroupCd = 11; // 성별 그룹코드
		int delGroupCd    = 6;  // 삭제 여부
		
		int memberNo = 0; // 회원번호 명
		if(memberNo_ != null && !memberNo_.equals(""))
			memberNo = Integer.parseInt(memberNo_);
		
		// code (회원타입 코드 목록)를 요청할 때
		List<CodeView> typeCodeList = service.getAdminCodeViewList(typeGroupCd);
		
		// code (성별 코드 목록)를 요청할 때
		List<CodeView> genderCodeList = service.getAdminCodeViewList(genderGroupCd);	
				
		// code (삭제 코드 목록)를 요청할 때
		List<CodeView> delCodeList = service.getAdminCodeViewList(delGroupCd);	
						
				
		// 상세정보 조회
		MemberView info = service.getAdminMemberViewDetail(memberNo);
				
		model.addAttribute("typeCodeList",typeCodeList);
		model.addAttribute("genderCodeList",genderCodeList);
		model.addAttribute("delCodeList",delCodeList);
		
		model.addAttribute("info",info);
		
		return "admin.board.member.edit";
	}
	
	/**
	 * 회원정보 수정
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="edit", method = RequestMethod.POST)
	public void postAdminMemberEdit(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
	
		String memberNo_     = request.getParameter("memberNo");     // 회원번호
		String memberPwd_    = request.getParameter("memberPwd");    // 회원비밀번호 
		String memberNm_     = request.getParameter("memberNm");     // 회원명
	    String memberGender_ = request.getParameter("memberGender"); // 회원성별
	    String memberBth_    = request.getParameter("memberBth");    // 회원 생년월일 
		String memberPhone_  = request.getParameter("memberPhone");  // 회원 전화번호
	    String memberEmail_  = request.getParameter("memberEmail");  // 회원 이메일
		String groupCd_      = request.getParameter("groupCd");      // 그룹코드
		String codeCd_       = request.getParameter("codeCd");       // 공통코드
		//String modNo_        = request.getParameter("modNo");        // 작성자
		
		String memberId_ = (String)session.getAttribute("sessionUser");
		int modNo = 2; // 임시 관리자 번호
		
		int memberNo = 0; // 회원번호
		if(memberNo_ != null && !memberNo_.equals(""))
			memberNo = Integer.parseInt(memberNo_);
		
		String memberPwd = null; // 회원비밀번호
		if(memberPwd_ != null && !memberPwd_.equals(""))
			memberPwd = memberPwd_;
		
		String memberNm = null; // 회원명
		if(memberNm_ != null && !memberNm_.equals(""))
			memberNm = memberNm_;
				
		int memberGender = 0; // 회원성별
		if(memberGender_ != null && !memberGender_.equals(""))
			memberGender = Integer.parseInt(memberGender_);
	
		String memberBth = "0000-00-00"; // 회원생년월일
		if(memberBth_ != null && !memberBth_.equals(""))
			memberBth = memberBth_;
		
		String memberPhone = "010-0000-0000"; // 회원전화번호
		if(memberPhone_ != null && !memberPhone_.equals(""))
			memberPhone = memberPhone_;
		
		String memberEmail = null; // 회원이메일
		if(memberEmail_ != null && !memberEmail_.equals(""))
			memberEmail = memberEmail_;
						
		int groupCd = 0; // 그룹코드 명
		if(groupCd_ != null && !groupCd_.equals(""))
			groupCd = Integer.parseInt(groupCd_);
			
		int codeCd = 0; // 공통코드
		if(codeCd_ != null && !codeCd_.equals(""))
			codeCd = Integer.parseInt(codeCd_);
					
		// 수정자 예외처리
		if(memberId_ != null && !memberId_.equals(""))
			modNo = service.getAdminMemberNo(memberId_); // 수정자 번호
		
		
		Member member = new Member();
		member.setMember_no(memberNo);
		member.setMember_pwd(memberPwd);
		member.setMember_nm(memberNm);
		member.setMember_gender(memberGender);
		member.setMember_bth(memberBth);
		member.setMember_phone(memberPhone);
		member.setMember_email(memberEmail);
		member.setGroup_cd(groupCd);
		member.setCode_cd(codeCd);
		member.setMod_no(modNo);
		
		// 공통코드 수정
		int result = service.adminMemberUpdate(member);
		
		response.sendRedirect("list");
	}
		
}
