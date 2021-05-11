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
import com.pbrk.pbook.entity.FaqView;
import com.pbrk.pbook.entity.SingleLine;
import com.pbrk.pbook.entity.SingleLineView;
import com.pbrk.pbook.service.admin.AdminSingleLineService;

@Controller("adminSingleLineController")
@RequestMapping("/admin/board/singleLine/")
public class AdminSingleLineController {
	
	@Autowired
	private AdminSingleLineService service;
	
	/**
	 * 한줄글 목록 조회
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("list")
	public String adminSingleLineList(HttpServletRequest request, Model model) {
		
		String groupCd_ = request.getParameter("groupCd"); // 그룹코드
		String codeCd_  = request.getParameter("t");	   // 도서타입 코드
		String field_   = request.getParameter("f");       // 검색필드 (title)
		String query_   = request.getParameter("q");       // input 검색 값
		String page_    = request.getParameter("p");       // 현재 페이지
			
		int groupCd = 5; // 그룹코드
		if(groupCd_ != null && !groupCd_.equals(""))
			groupCd = Integer.parseInt(groupCd_);
		
		int codeCd = 0; // 도서 타입 ( 0 : 전체 )
		if(codeCd_ != null && !codeCd_.equals(""))
			codeCd = Integer.parseInt(codeCd_);
				
		String field = "sngl_line_title"; // 한줄글 제목
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
		List<SingleLineView> list = service.getAdminSingleLineViewList(page, field, query, codeCd);	
		
		// 게시물 수 조회
		int count = service.getAdminSingleLineCount(field, query, codeCd);
		
		model.addAttribute("codeList",codeList);
		model.addAttribute("list",list);
		model.addAttribute("count",count);
				
		return "admin.board.singleLine.list";
	}
	
	
	/**
	 * 한줄글 수정 페이지로 이동
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="edit", method = RequestMethod.GET)
	public String getAdminSingleLineEdit(HttpServletRequest request, Model model) {
		
		String snglLineNo_ = request.getParameter("no");
		
		int typeGroupCd = 5; // 한줄글 타입 그룹코드
		int pubGroupCd  = 7; // 공개여부 그룹코드
		
		int snglLineNo = 1;
		if(snglLineNo_ != null && !snglLineNo_.equals(""))
			snglLineNo = Integer.parseInt(snglLineNo_);
		
		// code (한줄글 타입 코드 목록)를 요청할 때
		List<CodeView> typeCodeList = service.getAdminCodeViewList(typeGroupCd);
		
		// code (공개여부 코드 목록)를 요청할 때
		List<CodeView> pubCodeList = service.getAdminCodeViewList(pubGroupCd);	
				
		// 상세 정보 조회
		SingleLineView info = service.getAdminSingleLineViewDetail(snglLineNo);
		
		model.addAttribute("typeCodeList",typeCodeList);
		model.addAttribute("pubCodeList",pubCodeList);
		
		model.addAttribute("info",info);
		
		return "admin.board.singleLine.edit";
	}
	
	/**
	 * 한줄글 질문 수정
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="edit", method = RequestMethod.POST)
	public void postAdminSingleLineEdit(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
						
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
		
		
		int groupCd = 3; // 질문타입
		if(groupCd_ != null && !groupCd_.equals(""))
			groupCd = Integer.parseInt(groupCd_);
		
		int codeCd = 1; // 공통코드
		if(codeCd_ != null && !codeCd_.equals(""))
			codeCd = Integer.parseInt(codeCd_);
		
		// 수정자 예외처리
		if(memberId_ != null && !memberId_.equals(""))
			modNo = service.getAdminMemberNo(memberId_); // 수정자 번호
		
		
		SingleLine singleLine = new SingleLine();
		singleLine.setSngl_line_no(snglLineNo);
		singleLine.setSngl_line_title(snglLineTitle);
		singleLine.setSngl_line_content(snglLineContent);
		singleLine.setSngl_line_pub(snglLinePub);
		singleLine.setGroup_cd(groupCd);
		singleLine.setCode_cd(codeCd);
		singleLine.setMod_no(modNo);
		
		
		// 수정
		int result = service.adminSingleLineUpdate(singleLine);
		
		response.sendRedirect("list");
	}

}
