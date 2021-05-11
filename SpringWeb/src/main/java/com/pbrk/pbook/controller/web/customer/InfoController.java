package com.pbrk.pbook.controller.web.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pbrk.pbook.entity.BookReview;
import com.pbrk.pbook.entity.BookReviewView2;
import com.pbrk.pbook.entity.CodeView;
import com.pbrk.pbook.entity.Member;
import com.pbrk.pbook.entity.MemberView;
import com.pbrk.pbook.entity.SingleLine;
import com.pbrk.pbook.entity.SingleLineView;
import com.pbrk.pbook.service.web.InfoService;

@Controller("infoController")
@RequestMapping("/customer/info/")
public class InfoController {

	@Autowired
	private InfoService service;
	
	
	/**
	 * 내정보 목록 조회
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("detail")
	public String infoMemberList(HttpServletRequest request, HttpSession session, Model model) {
		
		String memberId = (String)session.getAttribute("sessionUser"); // 회원 아이디
					
		int typeGroupCd   = 1;  // 회원타입 그룹코드
		int genderGroupCd = 11; // 성별 그룹코드
				
		// code (회원타입 코드 목록)를 요청할 때
		List<CodeView> typeCodeList = service.getCodeViewList(typeGroupCd);
		
		// code (성별 코드 목록)를 요청할 때
		List<CodeView> genderCodeList = service.getCodeViewList(genderGroupCd);	
				
		// 상세정보 조회
		MemberView info = service.getInfoMemberViewDetail(memberId);

		model.addAttribute("typeCodeList",typeCodeList);
		model.addAttribute("genderCodeList",genderCodeList);
		model.addAttribute("info",info);
		
		return "customer.info.detail";
	}	
	
	
	/**
	 * 내정보 수정
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="edit", method = RequestMethod.POST)
	public void postInfoMemberEdit(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
	
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
			modNo = service.getMemberNo(memberId_); // 수정자 번호
		
		
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
		int result = service.getInfoMemberUpdate(member);
		
		response.sendRedirect("detail");
	}
	
	
	/**
	 * 내리뷰 목록 조회
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("reviewList")
	public String infoBookReviewList(HttpServletRequest request, HttpSession session, Model model) {
		
		String page_    = request.getParameter("p");       // 현재 페이지
		
		String memberId = (String)session.getAttribute("sessionUser");
				
		int page = 1;
		if(page_ != null && !page_.equals(""))
			page = Integer.parseInt(page_);

		
		int memberNo = service.getMemberNo(memberId);
		
		// 목록 조회
		List<BookReviewView2> reviewList = service.getBookReviewViewList(page, memberNo);
		
		// 게시물 수 조회
		int count = service.getBookReviewCount(memberNo);
		
		model.addAttribute("reviewList",reviewList);		
		model.addAttribute("count",count);
		
		return "customer.info.reviewList";
	}
	
	
	/**
	 * 내리뷰 수정 페이지로 이동
	 * @return
	 */
	@RequestMapping(value="reviewEdit", method = RequestMethod.GET)
	public String getInfoBookReviewEdit(HttpServletRequest request, Model model) {
		
		String bookNo_       = request.getParameter("bookNo");       // 도서 번호
		String bookReviewNo_ = request.getParameter("bookReviewNo"); // 도서리뷰 번호
		
		int delGroupCd = 6; // 삭제여부 그룹코드
		int pubGroupCd = 7; // 공개여부 그룹코드
				
		int bookNo = 1;
		if(bookNo_ != null && !bookNo_.equals(""))
			bookNo = Integer.parseInt(bookNo_);
		
		int bookReviewNo = 1;
		if(bookReviewNo_ != null && !bookReviewNo_.equals(""))
			bookReviewNo = Integer.parseInt(bookReviewNo_);
		
		// code (공개여부 코드 목록)를 요청할 때
		List<CodeView> pubCodeList = service.getCodeViewList(pubGroupCd);	

		// code (삭제여부 코드 목록)를 요청할 때
		List<CodeView> delCodeList = service.getCodeViewList(delGroupCd);
		
		// 도서상세 정보 조회
		BookReviewView2 info = service.getInfoBookReviewViewDetail(bookReviewNo);
			
		model.addAttribute("delCodeList",delCodeList);
		model.addAttribute("pubCodeList",pubCodeList);
		
		model.addAttribute("info",info);
		
		return "customer.info.reviewEdit";
	}
		
	/**
	 * 도서리뷰 수정
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	@RequestMapping(value="reviewEdit", method = RequestMethod.POST)
	public String postInfoBookReviewEdit(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, ServletException {
		
		String bookNo_			  = request.getParameter("bookNo");            // 도서번호
		String bookReviewNo_      = request.getParameter("bookReviewNo");      // 리뷰번호
		String bookScore_         = request.getParameter("bookScore");         // 점수
		String bookReviewContent_ = request.getParameter("bookReviewContent"); // 리뷰
		String bookReviewPub_     = request.getParameter("bookReviewPub");     // 공개여부
		String bookReviewDel_     = request.getParameter("bookReviewDel");     // 삭제여부
		//String modNo_             = request.getParameter("modNo");             // 수정자
			
		String memberId_ = (String)session.getAttribute("sessionUser");
		int modNo = 2; // 임시 관리자 번호
		
		int bookNo = 1;
		if(bookNo_ != null && !bookNo_.equals(""))
			bookNo = Integer.parseInt(bookNo_);
		
		int bookReviewNo = 1;
		if(bookReviewNo_ != null && !bookReviewNo_.equals(""))
			bookReviewNo = Integer.parseInt(bookReviewNo_);

		
		int bookScore = 0;
		if(bookScore_ != null && !bookScore_.equals(""))
			bookScore = Integer.parseInt(bookScore_);
		
		String bookReviewContent = null;
		if(bookReviewContent_ != null && !bookReviewContent_.equals(""))
			bookReviewContent = bookReviewContent_;
		
		boolean bookReviewPub = true; // 공개
		if(bookReviewPub_ != null && !bookReviewPub_.equals(""))
			if(bookReviewPub_.equals("0"))
				bookReviewPub = false;
		

		boolean bookReviewDel = true; // 사용
		if(bookReviewDel_ != null && !bookReviewDel_.equals(""))
			if(bookReviewDel_.equals("0"))
				bookReviewDel = false;
		
		
		// 수정자 예외처리
		if(memberId_ != null && !memberId_.equals(""))
			modNo = service.getMemberNo(memberId_); // 수정자 번호
	
		
		BookReview bookReview = new BookReview();
		bookReview.setBook_review_no(bookReviewNo);
		bookReview.setBook_score(bookScore);
		bookReview.setBook_review_content(bookReviewContent);
		bookReview.setBook_review_pub(bookReviewPub);
		bookReview.setBook_review_del(bookReviewDel);
		bookReview.setMod_no(modNo);	
						
		// 도서 등록
		int result = service.getInfoBookReviewUpdate(bookReview);

		//response.sendRedirect("list");
		return "redirect:/customer/info/reviewList";
		
	}
	
	
	/**
	 * 내한줄글 목록
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("singleLineList")
	public String infoSingleLineList(HttpServletRequest request, HttpSession session, Model model) {
		
		String page_    = request.getParameter("p");       // 현재 페이지	
		String memberId = (String)session.getAttribute("sessionUser");
	
		int page = 1;
		if(page_ != null && !page_.equals(""))
			page = Integer.parseInt(page_);
						
		int memberNo = service.getMemberNo(memberId);
		
		// 목록 조회
		List<SingleLineView> list = service.getInfoSingleLineViewList(page, memberNo);	
		
		// 게시물 수 조회
		int count = service.getInfoSingleLineCount(memberNo);
				
		model.addAttribute("list",list);
		model.addAttribute("count",count);
		
		return "customer.info.singleLineList";
	}
	
	
	/**
	 * 내 한줄글 수정 페이지로 이동
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="singleLineEdit", method = RequestMethod.GET)
	public String getInfoSingleLineEdit(HttpServletRequest request, Model model) {
		
		String snglLineNo_ = request.getParameter("snglLineNo");
		
		int typeGroupCd = 5; // 한줄글 타입 그룹코드
		int pubGroupCd  = 7; // 공개여부 그룹코드
		
		int snglLineNo = 1;
		if(snglLineNo_ != null && !snglLineNo_.equals(""))
			snglLineNo = Integer.parseInt(snglLineNo_);
		
		// code (한줄글 타입 코드 목록)를 요청할 때
		List<CodeView> typeCodeList = service.getCodeViewList(typeGroupCd);
		
		// code (공개여부 코드 목록)를 요청할 때
		List<CodeView> pubCodeList = service.getCodeViewList(pubGroupCd);	
				
		// 상세 정보 조회
		SingleLineView info = service.getSingleLineViewDetail(snglLineNo);
		
		model.addAttribute("typeCodeList",typeCodeList);
		model.addAttribute("pubCodeList",pubCodeList);
		
		model.addAttribute("info",info);
		
		return "customer.info.singleLineEdit";
	}
	
	/**
	 * 내 한줄글 질문 수정
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="singleLineEdit", method = RequestMethod.POST)
	public String postInfoSingleLineEdit(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
						
		String snglLineNo_      = request.getParameter("snglLineNo");
		String snglLineTitle_   = request.getParameter("snglLineTitle");
		String snglLineContent_ = request.getParameter("snglLineContent");
		String snglLinePub_     = request.getParameter("snglLinePub");
		String groupCd_         = request.getParameter("groupCd");
		String codeCd_          = request.getParameter("codeCd");
		//String modNo_           = request.getParameter("modNo");
		
		String memberId_ = (String)session.getAttribute("sessionUser");
		int modNo = 2; // 임시 관리자 번호
		
		int snglLineNo = 0;
		if(snglLineNo_ != null && !snglLineNo_.equals(""))
			snglLineNo = Integer.parseInt(snglLineNo_);

		
		String snglLineTitle = null;
		if(snglLineTitle_ != null && !snglLineTitle_.equals(""))
			snglLineTitle = snglLineTitle_;
		
		String snglLineContent = null;
		if(snglLineContent_ != null && !snglLineContent_.equals(""))
			snglLineContent = snglLineContent_;
			
		
		boolean snglLinePub = true; // 공개
		if(snglLinePub_ != null && !snglLinePub_.equals(""))
			if(snglLinePub_.equals("0"))
				snglLinePub = false;
		
		
		int groupCd = 5; // 한줄글타입
		if(groupCd_ != null && !groupCd_.equals(""))
			groupCd = Integer.parseInt(groupCd_);
		
		int codeCd = 1; // 공통코드
		if(codeCd_ != null && !codeCd_.equals(""))
			codeCd = Integer.parseInt(codeCd_);
		
		// 수정자 예외처리
		if(memberId_ != null && !memberId_.equals(""))
			modNo = service.getMemberNo(memberId_); // 수정자 번호
		
		
		SingleLine singleLine = new SingleLine();
		singleLine.setSngl_line_no(snglLineNo);
		singleLine.setSngl_line_title(snglLineTitle);
		singleLine.setSngl_line_content(snglLineContent);
		singleLine.setSngl_line_pub(snglLinePub);
		singleLine.setGroup_cd(groupCd);
		singleLine.setCode_cd(codeCd);
		singleLine.setMod_no(modNo);
		
		
		// 수정
		int result = service.getInfoSingleLineUpdate(singleLine);
		
		return "redirect:/customer/info/singleLineList";
	}
}
