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
import com.pbrk.pbook.entity.Faq;
import com.pbrk.pbook.entity.FaqView;
import com.pbrk.pbook.service.admin.AdminFaqService;

@Controller("adminFaqController")
@RequestMapping("/admin/board/faq/")
public class AdminFaqController {
	
	@Autowired
	private AdminFaqService service;
	
	/**
	 * 자주하는질문 목록 조회
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("list")
	public String adminFaqList(HttpServletRequest request, Model model) {
		
		String groupCd_ = request.getParameter("groupCd"); // 그룹코드
		String codeCd_  = request.getParameter("t");	   // 도서타입 코드
		String field_   = request.getParameter("f");       // 검색필드 (title)
		String query_   = request.getParameter("q");       // input 검색 값
		String page_    = request.getParameter("p");       // 현재 페이지
			
		int groupCd = 3; // 그룹코드
		if(groupCd_ != null && !groupCd_.equals(""))
			groupCd = Integer.parseInt(groupCd_);
		
		int codeCd = 0; // 도서 타입 ( 0 : 전체 )
		if(codeCd_ != null && !codeCd_.equals(""))
			codeCd = Integer.parseInt(codeCd_);
		
		String field = "faq_title"; // 코드명
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
		List<FaqView> list = service.getAdminFaqViewList(page, field, query, codeCd);	
		
		// 게시물 수 조회
		int count = service.getAdminFaqCount(field, query, codeCd);
		
		model.addAttribute("codeList",codeList);
		model.addAttribute("list",list);
		model.addAttribute("count",count);
				
		return "admin.board.faq.list";
	}
	
	
	/**
	 * 자주하는 질문 등록 페이지로 이동
	 * @return
	 */
	@RequestMapping(value="reg", method = RequestMethod.GET)
	public String getAdminFaqReg(Model model) {
		
		int groupCd = 3; // 질문 타입
		
		// code (view)를 요청할 때
		List<CodeView> codeList = service.getAdminCodeViewList(groupCd);
				
		model.addAttribute("groupCd", groupCd);
		model.addAttribute("codeList",codeList);
		
		return "admin.board.faq.reg";
	}
	
	
	/**
	 * 자주하는 질문 등록
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="reg", method = RequestMethod.POST)
	public void postAdminFaqReg(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
		
		String faqTitle_   = request.getParameter("faqTitle");   // 질문제목
		String faqContent_ = request.getParameter("faqContent"); // 질문내용
		String faqAnswer_  = request.getParameter("faqAnswer");  // 답변
		String groupCd_    = request.getParameter("groupCd");    // 질문타입
		String codeCd_     = request.getParameter("codeCd");     // 공통코드
		//String regNo_      = request.getParameter("regNo");      // 사용자
		
		String memberId_ = (String)session.getAttribute("sessionUser");
		int regNo = 2; // 임시 관리자 번호
		
		String faqTitle = null;
		if(faqTitle_ != null && !faqTitle_.equals(""))
			faqTitle = faqTitle_;
		
		String faqContent = null;
		if(faqContent_ != null && !faqContent_.equals(""))
			faqContent = faqContent_;
		
		String faqAnswer = null;
		if(faqAnswer_ != null && !faqAnswer_.equals(""))
			faqAnswer = faqAnswer_;
			
		int groupCd = 3; // 질문타입
		if(groupCd_ != null && !groupCd_.equals(""))
			groupCd = Integer.parseInt(groupCd_);
		
		int codeCd = 1; // 공통코드
		if(codeCd_ != null && !codeCd_.equals(""))
			codeCd = Integer.parseInt(codeCd_);
		
		// 작성자 예외처리
		if(memberId_ != null && !memberId_.equals(""))
			regNo = service.getAdminMemberNo(memberId_); // 작성자 번호
				
		
		Faq faq = new Faq();
		faq.setFaq_title(faqTitle);
		faq.setFaq_content(faqContent);
		faq.setFaq_answer(faqAnswer);
		faq.setGroup_cd(groupCd);
		faq.setCode_cd(codeCd);
		faq.setReg_no(regNo);
		
		int result = service.adminFaqInsert(faq);
		
		response.sendRedirect("list");
	}
	
	/**
	 * 자주하는 질문 수정 페이지로 이동
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="edit", method = RequestMethod.GET)
	public String getAdminFaqEdit(HttpServletRequest request, Model model) {
		
		String no_ = request.getParameter("no");
		
		int typeGroupCd = 3; // 도서타입 그룹코드
		int pubGroupCd  = 7; // 공개여부 그룹코드
		
		int no = 1;
		if(no_ != null && !no_.equals(""))
			no = Integer.parseInt(no_);
		
		
		// code (도서타입 코드 목록)를 요청할 때
		List<CodeView> typeCodeList = service.getAdminCodeViewList(typeGroupCd);
		
		// code (공개여부 코드 목록)를 요청할 때
		List<CodeView> pubCodeList = service.getAdminCodeViewList(pubGroupCd);	
		
		// 상세 정보 조회
		FaqView info = service.getAdminFaqViewDetail(no);
		
		model.addAttribute("typeCodeList",typeCodeList);
		model.addAttribute("pubCodeList",pubCodeList);
		model.addAttribute("info",info);
		
		return "admin.board.faq.edit";
	}
	
	/**
	 * 자주하는 질문 수정
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="edit", method = RequestMethod.POST)
	public void postAdminFaqEdit(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
		
		String faqNo_      = request.getParameter("faqNo");
		String faqTitle_   = request.getParameter("faqTitle");
		String faqContent_ = request.getParameter("faqContent");
		String faqAnswer_  = request.getParameter("faqAnswer");
		String faqPub_     = request.getParameter("faqPub");
		String groupCd_    = request.getParameter("groupCd");
		String codeCd_     = request.getParameter("codeCd");
		//String modNo_      = request.getParameter("modNo");
		
		String memberId_ = (String)session.getAttribute("sessionUser");
		int modNo = 2; // 임시 관리자 번호
	
		int faqNo = 0;
		if(faqNo_ != null && !faqNo_.equals(""))
			faqNo = Integer.parseInt(faqNo_);
		
		String faqTitle = null;
		if(faqTitle_ != null && !faqTitle_.equals(""))
			faqTitle = faqTitle_;
		
		String faqContent = null;
		if(faqContent_ != null && !faqContent_.equals(""))
			faqContent = faqContent_;
		
		String faqAnswer = null;
		if(faqAnswer_ != null && !faqAnswer_.equals(""))
			faqAnswer = faqAnswer_;
		
		
		boolean faqPub = true; // 공개
		if(faqPub_ != null && !faqPub_.equals(""))
			if(faqPub_.equals("0"))
				faqPub = false;
	
		
		int groupCd = 3; // 질문타입
		if(groupCd_ != null && !groupCd_.equals(""))
			groupCd = Integer.parseInt(groupCd_);
		
		int codeCd = 1; // 공통코드
		if(codeCd_ != null && !codeCd_.equals(""))
			codeCd = Integer.parseInt(codeCd_);
		
		// 수정자 예외처리
		if(memberId_ != null && !memberId_.equals(""))
			modNo = service.getAdminMemberNo(memberId_); // 수정자 번호

		
		Faq faq = new Faq();
		faq.setFaq_no(faqNo);
		faq.setFaq_title(faqTitle);
		faq.setFaq_content(faqContent);
		faq.setFaq_answer(faqAnswer);
		faq.setFaq_pub(faqPub);
		faq.setGroup_cd(groupCd);
		faq.setCode_cd(codeCd);
		faq.setMod_no(modNo);
		
		// 수정
		int result = service.adminFaqUpdate(faq);
		
		response.sendRedirect("list");
	}


}
