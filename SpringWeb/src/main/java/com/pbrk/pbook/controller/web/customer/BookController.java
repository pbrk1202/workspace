package com.pbrk.pbook.controller.web.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pbrk.pbook.entity.BookReview;
import com.pbrk.pbook.entity.BookReviewView;
import com.pbrk.pbook.entity.BookView;
import com.pbrk.pbook.entity.CodeView;
import com.pbrk.pbook.entity.Faq;
import com.pbrk.pbook.service.web.BookService;

@Controller("bookController")
@RequestMapping("/customer/book/")
public class BookController {

	@Autowired
	private BookService service;
			
	/**
	 * 도서 목록 조회
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("list")
	public String bookList(HttpServletRequest request, Model model) {
		
		String groupCd_ = request.getParameter("groupCd"); // 그룹코드
		String codeCd_  = request.getParameter("t");	   // 도서타입 코드
		String field_   = request.getParameter("f");       // 검색필드 (title)
		String query_   = request.getParameter("q");       // input 검색 값
		String page_    = request.getParameter("p");       // 현재 페이지
		
		int groupCd = 2; // 그룹코드
		if(groupCd_ != null && !groupCd_.equals(""))
			groupCd = Integer.parseInt(groupCd_);
		
		int codeCd = 0; // 도서 타입 ( 0 : 전체 )
		if(codeCd_ != null && !codeCd_.equals(""))
			codeCd = Integer.parseInt(codeCd_);
		
		String field = "book_title";
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
		
		// 목록 조회
		List<BookView> list = service.getBookViewList(page, field, query, codeCd);
		
		// 게시물 수 조회
		int count = service.getBookCount(field, query, codeCd);
	
		model.addAttribute("codeList",codeList);
		model.addAttribute("list",list);
		model.addAttribute("count",count);
		
		return "customer.book.list";
	}
	
	
	/**
	 * 도서 상세 정보
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("detail") // list, detail, edit, reg
	public String bookDetail(HttpServletRequest request, Model model) {
	
		String groupNo_ = request.getParameter("groupNo"); // 그룹코드
		String no_      = request.getParameter("no");      // 도서번호
		
		int maxLine = 3; // 최대 리뷰 조회 게시물 수
		
		int groupNo = 1;
		if(groupNo_ != null && !groupNo_.equals(""))
			groupNo = Integer.parseInt(groupNo_);
		
		
		int no = 1;
		if(no_ != null && !no_.equals(""))
			no = Integer.parseInt(no_);
		
		
		// code (view)를 요청할 때
		List<CodeView> codeList = service.getCodeViewList(groupNo);
		
		// 도서상세 정보 조회
		BookView info = service.getBookViewDetail(no);
		
		// 목록 조회
		List<BookReviewView> reviewList = service.getBookReviewViewListMaxLine(no, maxLine);
		
		model.addAttribute("codeList",codeList);
		model.addAttribute("info",info);
		
		model.addAttribute("reviewList",reviewList);
		
		return "customer.book.detail";
	}
	
	/**
	 * 도서 리뷰 목록 조회
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("review")
	public String bookReviewList(HttpServletRequest request, Model model) {
		
		String groupNo_ = request.getParameter("groupNo"); // 그룹코드
		String no_      = request.getParameter("no");      // 도서번호
		String field_   = request.getParameter("f");       // 검색필드 (title)
		String query_   = request.getParameter("q");       // input 검색 값
		String page_    = request.getParameter("p");       // 현재 페이지
				
		
		int groupNo = 1;
		if(groupNo_ != null && !groupNo_.equals(""))
			groupNo = Integer.parseInt(groupNo_);
		
		
		int bookNo = 0;
		if(no_ != null && !no_.equals(""))
			bookNo = Integer.parseInt(no_);
		
		String field = "book_title";
		if(field_ != null && !field_.equals(""))
			field = field_;
		
		String query = "";
		if(query_ != null && !query_.equals(""))
			query = query_;
		
		int page = 1;
		if(page_ != null && !page_.equals(""))
			page = Integer.parseInt(page_);
					
		// 도서상세 정보 조회
		BookView info = service.getBookViewDetail(bookNo);
				
		// 목록 조회
		List<BookReviewView> reviewList = service.getBookReviewViewList(bookNo, page, field, query);
		
		// 게시물 수 조회
		int count = service.getBookReviewCount(bookNo, field, query);
		
		model.addAttribute("info",info);				
		model.addAttribute("reviewList",reviewList);		
		model.addAttribute("count",count);
		
		return "customer.book.review";
	}
	
	/**
	 * 리뷰 등록
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="reviewReg", method = RequestMethod.POST)
	public String postAdminFaqReg(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String bookNo_            = request.getParameter("bookNo");            // 도서번호
		String bookReivewContent_ = request.getParameter("bookReviewContent"); // 리뷰내용
		String regNo_             = request.getParameter("regNo");             // 작성자
				
		int bookNo = 0;
		if(bookNo_ != null && !bookNo_.equals(""))
			bookNo = Integer.parseInt(bookNo_);
		
		String bookReivewContent = null;
		if(bookReivewContent_ != null && !bookReivewContent_.equals(""))
			bookReivewContent = bookReivewContent_;
		
			
		int regNo = 2; // 관리자 번호
		if(regNo_ != null && !regNo_.equals(""))
			regNo = Integer.parseInt(regNo_);
		
		BookReview bookReview = new BookReview();
		bookReview.setBook_no(bookNo);
		bookReview.setBook_review_content(bookReivewContent);
		bookReview.setReg_no(regNo);
		
		int result = service.getBookReviewInsert(bookReview);
		
		//response.sendRedirect("list");
		return "redirect:/customer/book/detail?no=" + bookNo+"&overlap=1";
	}
}
