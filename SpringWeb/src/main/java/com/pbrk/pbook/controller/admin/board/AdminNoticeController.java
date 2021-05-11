package com.pbrk.pbook.controller.admin.board;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pbrk.pbook.entity.CodeView;
import com.pbrk.pbook.entity.Notice;
import com.pbrk.pbook.entity.NoticeView;
import com.pbrk.pbook.service.admin.AdminNoticeService;
import com.pbrk.pbook.utils.FileUpload;

@MultipartConfig(
	fileSizeThreshold=1024*1024,
	maxFileSize=1024*1024*50,
	maxRequestSize=1024*1024*50*5
)
@Controller("adminNoticeController")
@RequestMapping("/admin/board/notice/")
public class AdminNoticeController {
	
	@Autowired
	private AdminNoticeService service;
	
	/**
	 * 공지사항 목록 조회
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("list")
	public String adminNoticelist(HttpServletRequest request, Model model) {
		
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
		List<CodeView> codeList = service.getAdminCodeViewList(groupCd);
				
		// 목록
		List<NoticeView> list = service.getAdminNoticeViewList(page, field, query, codeCd);
		
		// 게시물 수
		int count = service.getAdminNoticeCount(field, query, codeCd);
				
		model.addAttribute("codeList",codeList);
		model.addAttribute("list",list);
		model.addAttribute("count",count);
		
		return "admin.board.notice.list";
	}
	
	/**
	 * 공지사항 상제 정보 조회
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("detail")
	public String adminNoticeViewDetail(HttpServletRequest request, Model model) {
		
		String no_ = request.getParameter("no");
		
		int no = 1;
		if(no_ != null && !no_.equals(""))
			no = Integer.parseInt(no_);
	
		
		// 상세정보 조회
		NoticeView info = service.getAdminNoticeViewDetail(no);
		
		model.addAttribute("info",info);
		
		return "admin.board.notice.detail";
	}
	
	
	/**
	 * 공지사항 수정 페이지로 이동
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="edit", method = RequestMethod.GET)
	public String getaAdminNoticeEdit(HttpServletRequest request, Model model) {
		
		String noticeNo_ = request.getParameter("noticeNo");
		
		int typeGroupCd = 1; // 회원타입 그룹코드
		int pubGroupCd  = 7; // 공개여부 그룹코드
		
		int noticeNo = 0;
		if(noticeNo_ != null && !noticeNo_.equals(""))
			noticeNo = Integer.parseInt(noticeNo_);
		
		// code (회원타입 코드 목록)를 요청할 때
		List<CodeView> typeCodeList = service.getAdminCodeViewList(typeGroupCd);
		
		// code (공개여부 코드 목록)를 요청할 때
		List<CodeView> pubCodeList = service.getAdminCodeViewList(pubGroupCd);	
				
		// 상세정보 조회
		NoticeView info = service.getAdminNoticeViewDetail(noticeNo);
		
		model.addAttribute("groupCd",typeGroupCd);
		
		model.addAttribute("typeCodeList",typeCodeList);
		model.addAttribute("pubCodeList",pubCodeList);
		
		model.addAttribute("info",info);
		
		return "admin.board.notice.edit";
	}
	
	/**
	 * 공지사항 수정
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	@RequestMapping(value="edit", method = RequestMethod.POST)
	public void postAdminNoticeUpdate(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, ServletException {
		
		String noticeNo_      = request.getParameter("noticeNo");
		String noticeTitle_   = request.getParameter("noticeTitle");
		String noticeContent_ = request.getParameter("noticeContent");
		String noticePub_     = request.getParameter("noticePub");
		String groupCd_       = request.getParameter("groupCd");
		String codeCd_        = request.getParameter("codeCd");
		//String modNo_         = request.getParameter("modNo");
		
		String memberId_ = (String)session.getAttribute("sessionUser");
		int modNo = 2; // 임시 관리자 번호
		
		int noticeNo = 0;
		if(noticeNo_ != null && !noticeNo_.equals(""))
			noticeNo = Integer.parseInt(noticeNo_);
		
		String noticeTitle = null;
		if(noticeTitle_ != null && !noticeTitle_.equals(""))
			noticeTitle = noticeTitle_;
		
		String noticeContent = null;
		if(noticeContent_ != null && !noticeContent_.equals(""))
			noticeContent = noticeContent_;
		
		
		boolean noticePub = true; // 공개
		if(noticePub_ != null && !noticePub_.equals(""))
			if(noticePub_.equals("0"))
				noticePub = false;
		
		
		int groupCd = 1; // 공지타입
		if(groupCd_ != null && !groupCd_.equals(""))
			groupCd = Integer.parseInt(groupCd_);
		
		int codeCd = 1; // 공통코드
		if(codeCd_ != null && !codeCd_.equals(""))
			codeCd = Integer.parseInt(codeCd_);
		
		// 수정자 예외처리
		if(memberId_ != null && !memberId_.equals(""))
			modNo = service.getAdminMemberNo(memberId_); // 수정자 번호
		
		// -------------- 파일 첨부 ---------------------------
		Collection<Part> parts = request.getParts();
		StringBuilder builder = new StringBuilder();
		
		// 실제 경로
		String realPath = request.getServletContext().getRealPath("/upload");
		
		// 파일 첨부
		FileUpload file = new FileUpload();
		builder = file.FileInsert(parts, realPath);
		// ---------------------------------------------------
				
		Notice notice = new Notice();
		notice.setNotice_no(noticeNo);
		notice.setNotice_title(noticeTitle);
		notice.setNotice_content(noticeContent);
		notice.setNotice_pub(noticePub);
		notice.setNotice_files(builder.toString());
		notice.setGroup_cd(groupCd);
		notice.setCode_cd(codeCd);
		notice.setMod_no(modNo);
		
		// 수정
		int result = service.adminNoticeUpdate(notice);
		
		response.sendRedirect("list");
	}
	
	/**
	 * 공지사항 등록 페이지로 이동
	 * @return
	 */
	@RequestMapping(value="reg", method = RequestMethod.GET)
	public String getAdminNoticeReg(Model model) {
		
		int typeGroupCd = 1; // 회원타입 그룹코드
		
		// code (회원타입 코드 목록)를 요청할 때
		List<CodeView> typeCodeList = service.getAdminCodeViewList(typeGroupCd);
					
		model.addAttribute("groupCd",typeGroupCd);
		model.addAttribute("typeCodeList",typeCodeList);
		
		return "admin.board.notice.reg";
	}
	
	
	/**
	 * 공지사항 등록
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	@RequestMapping(value="reg", method = RequestMethod.POST)
	public void postAdminNoticeReg(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, ServletException {
		
		String noticeTitle_   = request.getParameter("noticeTitle");
		String noticeContent_ = request.getParameter("noticeContent");
		String groupCd_       = request.getParameter("groupCd");
		String codeCd_        = request.getParameter("codeCd");
		//String regNo_         = request.getParameter("regNo");
		
		String memberId_ = (String)session.getAttribute("sessionUser");
		int regNo = 2; // 임시 관리자 번호
				
		String noticeTitle = null;
		if(noticeTitle_ != null && !noticeTitle_.equals(""))
			noticeTitle = noticeTitle_;
		
		String noticeContent = null;
		if(noticeContent_ != null && !noticeContent_.equals(""))
			noticeContent = noticeContent_;
				
		int groupCd = 1; // 공지타입
		if(groupCd_ != null && !groupCd_.equals(""))
			groupCd = Integer.parseInt(groupCd_);
		
		int codeCd = 1; // 공통코드
		if(codeCd_ != null && !codeCd_.equals(""))
			codeCd = Integer.parseInt(codeCd_);
		
		// 작성자 예외처리
		if(memberId_ != null && !memberId_.equals(""))
			regNo = service.getAdminMemberNo(memberId_); // 작성자 번호
				
		
		// -------------- 파일 첨부 ---------------------------
		Collection<Part> parts = request.getParts();
		StringBuilder builder = new StringBuilder();
		
		// 실제 경로
		String realPath = request.getServletContext().getRealPath("/upload");
		
		// 파일 첨부
		FileUpload file = new FileUpload();
		builder = file.FileInsert(parts, realPath);
		// ---------------------------------------------------
				
		Notice notice = new Notice();
		notice.setNotice_title(noticeTitle);
		notice.setNotice_content(noticeContent);
		notice.setNotice_files(builder.toString());
		notice.setGroup_cd(groupCd);
		notice.setCode_cd(codeCd);
		notice.setReg_no(regNo);
		
		// 등록
		int result = service.adminNoticeInsert(notice);
		
		response.sendRedirect("list");
	}

}
