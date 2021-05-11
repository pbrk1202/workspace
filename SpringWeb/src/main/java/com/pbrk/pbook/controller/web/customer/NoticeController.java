package com.pbrk.pbook.controller.web.customer;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pbrk.pbook.entity.CodeView;
import com.pbrk.pbook.entity.NoticeView;
import com.pbrk.pbook.service.web.NoticeService;

@Controller("noticeController")
@RequestMapping("/customer/notice/")
public class NoticeController {

	@Autowired
	private NoticeService service;
	
	@RequestMapping("list")
	public String noticeList(HttpServletRequest request, Model model) {
				
		String groupCd_ = request.getParameter("groupCd"); // 그룹코드
		String codeCd_  = request.getParameter("t");       // 도서타입 코드
		String field_   = request.getParameter("f");   	   // 검색필드 (title)
		String query_   = request.getParameter("q");   	   // input 검색 값
		String page_    = request.getParameter("p");   	   // 현재 페이지
		
		int groupCd = 1; // 그룹코드
		if(groupCd_ != null && !groupCd_.equals(""))
			groupCd = Integer.parseInt(groupCd_);
		
		int codeCd = 0; // 회원 타입 ( 0 : 전체 )
		if(codeCd_ != null && !codeCd_.equals(""))
			codeCd = Integer.parseInt(codeCd_);
		
		
		String field = "notice_title"; // 공지사항 제목
		if(field_ != null && !field_.equals(""))
			field = field_;
		
		String query = "";
		if(query_ != null && !query_.equals(""))
			query = query_;
		
		int page = 1;
		if(page_ != null && !page_.equals(""))
			page = Integer.parseInt(page_);
		
		// code (view)를 요청할 때
		List<CodeView> codeList = service.getCodeViewList(groupCd);
		
		// 목록
		List<NoticeView> list = service.getNoticeViewList(page, field, query, codeCd);
		
		// 게시물 수
		int count = service.getNoticeCount(field, query, codeCd);
				
		model.addAttribute("codeList",codeList);
		model.addAttribute("list",list);
		model.addAttribute("count",count);
		
		return "customer.notice.list";
	}
	
	@RequestMapping("detail")
	public String noticeDetail(HttpServletRequest request, Model model) {
	
		String no_ = request.getParameter("no");
		
		int no = 1;
		if(no_ != null && !no_.equals(""))
			no = Integer.parseInt(no_);
	
		
		// 상세정보 조회
		NoticeView info = service.getNoticeViewDetail(no);
		
		model.addAttribute("info",info);
		
		return "customer.notice.detail";
	}
	
}
