package com.pbrk.pbook.controller.admin.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pbrk.pbook.entity.Book;
import com.pbrk.pbook.entity.BookReview;
import com.pbrk.pbook.entity.BookReviewView;
import com.pbrk.pbook.entity.CodeView;
import com.pbrk.pbook.service.admin.AdminBookReviewService;


@MultipartConfig(
	fileSizeThreshold=1024*1024,
	maxFileSize=1024*1024*50,
	maxRequestSize=1024*1024*50*5
)
@Controller("adminBookReviewController")
@RequestMapping("/admin/board/bookReview/")
public class AdminBookReviewController {

	@Autowired
	private AdminBookReviewService service;
	
	/**
	 * 도서 리뷰 목록 조회
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("list")
	public String adminBookReviewList(HttpServletRequest request, Model model) {
		
		String bookNo_ = request.getParameter("bookNo"); // 도서 번호		
		String field_  = request.getParameter("f");      // 검색필드 (title)
		String query_  = request.getParameter("q");      // input 검색 값
		String page_   = request.getParameter("p");      // 현재 페이지
				
		int bookNo = 0;
		if(bookNo_ != null && !bookNo_.equals(""))
			bookNo = Integer.parseInt(bookNo_);

		
		String field = "book_title";
		if(field_ != null && !field_.equals(""))
			field = field_;
		
		String query = "";
		if(query_ != null && !query_.equals(""))
			query = query_;
		
		int page = 1;
		if(page_ != null && !page_.equals(""))
			page = Integer.parseInt(page_);
		
		// 목록 조회
		List<BookReviewView> list = service.getAdminBookReviewViewList(bookNo, page, field, query);
		
		// 게시물 수 조회
		int count = service.getAdminBookReviewCount(bookNo, field, query);
		
		model.addAttribute("list",list);
		model.addAttribute("count",count);
		
		return "admin.board.bookReview.list";
	}
	
	
	/**
	 * 도서리뷰 수정 페이지로 이동
	 * @return
	 */
	@RequestMapping(value="edit", method = RequestMethod.GET)
	public String getAdminReviewBookEdit(HttpServletRequest request, Model model) {
		
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
		List<CodeView> pubCodeList = service.getAdminCodeViewList(pubGroupCd);	

		// code (삭제여부 코드 목록)를 요청할 때
		List<CodeView> delCodeList = service.getAdminCodeViewList(delGroupCd);
		
		// 도서상세 정보 조회
		BookReviewView info = service.getAdminBookReviewViewDetail(bookReviewNo);
			
		model.addAttribute("delCodeList",delCodeList);
		model.addAttribute("pubCodeList",pubCodeList);
		
		model.addAttribute("info",info);
		
		return "admin.board.bookReview.edit";
	}
		
	/**
	 * 도서리뷰 수정
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	@RequestMapping(value="edit", method = RequestMethod.POST)
	public String postAdminBookReviewEdit(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, ServletException {
		
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
			modNo = service.getAdminMemberNo(memberId_); // 수정자 번호
	
		
		BookReview bookReview = new BookReview();
		bookReview.setBook_review_no(bookReviewNo);
		bookReview.setBook_score(bookScore);
		bookReview.setBook_review_content(bookReviewContent);
		bookReview.setBook_review_pub(bookReviewPub);
		bookReview.setBook_review_del(bookReviewDel);
		bookReview.setMod_no(modNo);	
						
		// 도서 등록
		int result = service.adminBookReviewUpdate(bookReview);

		//response.sendRedirect("list");
		return "redirect:/admin/board/bookReview/list?bookNo=" + bookNo;
		
	}
	
}
