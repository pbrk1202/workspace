package com.pbrk.pbook.controller.web.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pbrk.pbook.entity.BookView;
import com.pbrk.pbook.entity.Faq;
import com.pbrk.pbook.entity.Member;
import com.pbrk.pbook.entity.SingleLineView;
import com.pbrk.pbook.service.web.MainService;

@Controller("mainController")
@RequestMapping("/customer/main/")
public class MainController {

	@Autowired
	private MainService service;
	
	/**
	 * 메인 목록 조회
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("list")
	public String mainList(HttpServletRequest request, Model model) {
		
		int maxLine = 3; // 최대 조회 게시물 수		

		// session.getAttribute("sessionUser")
		
		// 도서 목록 조회
		List<BookView> bookList = service.getAdminBookViewListMaxLine(maxLine);
			
		// 한줄평 목록 조회
		List<SingleLineView> singleLineList = service.getSingleLineViewListMaxLine(maxLine);	

		
		model.addAttribute("bookList",bookList);
		model.addAttribute("singleLineList",singleLineList);
				
		return "customer.main.index";
	}
	
	/**
	 * 로그인 페이지 이동
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="login", method = RequestMethod.GET)
	public String getLogin(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) {
		
		session.removeAttribute("sessionUser");
					
		return "customer/login";
	}
	
	
	/**
	 * 로그인
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="login", method = RequestMethod.POST)
	public String postLogin(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) throws IOException {
		
		String memberId_  = request.getParameter("memberId");  // 질문제목
		String memberPwd_ = request.getParameter("memberPwd"); // 질문내용
		
		int maxLine = 3; // 최대 조회 게시물 수
		
		String memberId = null;
		if(memberId_ != null && !memberId_.equals(""))
			memberId = memberId_;
		
		String memberPwd = null;
		if(memberPwd_ != null && !memberPwd_.equals(""))
			memberPwd = memberPwd_;
		
		Member member = new Member();
		member.setMember_id(memberId);
		member.setMember_pwd(memberPwd);
	
		int result = service.getLoginConfirm(member);
		
		// 로그인 실패 시
		if(0 == result) {
			return "customer/login";			
		}
		
		
		// 도서 목록 조회
		List<BookView> bookList = service.getAdminBookViewListMaxLine(maxLine);
			
		// 한줄평 목록 조회
		List<SingleLineView> singleLineList = service.getSingleLineViewListMaxLine(maxLine);	

		session.setAttribute("sessionUser", memberId);
		model.addAttribute("bookList",bookList);
		model.addAttribute("singleLineList",singleLineList);
		
		return "customer.main.index";
	
	}
	
}
