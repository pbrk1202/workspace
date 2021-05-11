package com.pbrk.pbook.controller.web.customer;

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
import com.pbrk.pbook.service.web.FaqService;

@Controller("faqController")
@RequestMapping("/customer/faq/")
public class FaqController {

	@Autowired
	private FaqService service;
	
	/**
	 * 자주하는질문 목록 조회
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("list")
	public String faqList(HttpServletRequest request, Model model) {
		
		String field_ = request.getParameter("f"); // 검색필드 (title)
		String query_ = request.getParameter("q"); // input 검색 값
		String page_  = request.getParameter("p"); // 현재 페이지
			
		String field = "faq_title"; // 코드명
		if(field_ != null && !field_.equals(""))
			field = field_;
		
		String query = "";
		if(query_ != null && !query_.equals(""))
			query = query_;
		
		int page = 1;
		if(page_ != null && !page_.equals(""))
			page = Integer.parseInt(page_);
		
		// 목록 조회
		List<FaqView> list = service.getFaqViewList(page, field, query);	
		
		// 게시물 수 조회
		int count = service.getFaqCount(field, query);
		
		model.addAttribute("list",list);
		model.addAttribute("count",count);
				
		return "customer.faq.list";
	}
	
	/**
	 * 자주하는 질문 상세정보
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("detail")
	public String faqDetail(HttpServletRequest request, Model model) {
		
		String no_ = request.getParameter("no");
		
		int no = 1;
		if(no_ != null && !no_.equals(""))
			no = Integer.parseInt(no_);
		
		// 상세정보 조회
		FaqView info = service.getFaqViewDetail(no);
		
		model.addAttribute("info",info);
		
		return "customer.faq.detail";
	}
	
	/**
	 * 질문 등록 페이지로 이동
	 * @return
	 */
	@RequestMapping(value="reg", method = RequestMethod.GET)
	public String getFaqReg(Model model) {
		
		int groupCd = 3; // 질문 타입
		
		// code (view)를 요청할 때
		List<CodeView> codeList = service.getCodeViewList(groupCd);
				
		model.addAttribute("groupCd", groupCd);
		model.addAttribute("codeList",codeList);
		
		return "customer.faq.reg";
	}
	
	/**
	 * 질문 등록
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="reg", method = RequestMethod.POST)
	public void postAdminFaqReg(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
		
		String faqTitle_   = request.getParameter("faqTitle");   // 질문제목
		String faqContent_ = request.getParameter("faqContent"); // 질문내용
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
		
			
		int groupCd = 3; // 질문타입
		if(groupCd_ != null && !groupCd_.equals(""))
			groupCd = Integer.parseInt(groupCd_);
		
		int codeCd = 1; // 공통코드
		if(codeCd_ != null && !codeCd_.equals(""))
			codeCd = Integer.parseInt(codeCd_);
		
		// 작성자 예외처리
		if(memberId_ != null && !memberId_.equals(""))
			regNo = service.getMemberNo(memberId_); // 작성자 번호
		
		
		Faq faq = new Faq();
		faq.setFaq_title(faqTitle);
		faq.setFaq_content(faqContent);
		faq.setGroup_cd(groupCd);
		faq.setCode_cd(codeCd);
		faq.setReg_no(regNo);
		
		int result = service.getFaqInsert(faq);
		
		response.sendRedirect("list");
	}
}
