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

import com.pbrk.pbook.entity.Code;
import com.pbrk.pbook.entity.CodeView;
import com.pbrk.pbook.entity.GroupCodeView;
import com.pbrk.pbook.service.admin.AdminCodeService;

@Controller("adminCodeController")
@RequestMapping("/admin/board/code/")
public class AdminCodeController {

	@Autowired
	private AdminCodeService service;
	
	
	/**
	 * 공통코드 목록 조회
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("list")
	public String adminCodeList(HttpServletRequest request, Model model) {
				
		String groupCd_ = request.getParameter("t"); // 그룹코드
		String field_   = request.getParameter("f"); // 검색필드 (title)
		String query_   = request.getParameter("q"); // input 검색 값
		String page_    = request.getParameter("p"); // 현재 페이지
			
		int groupCd = 0; // 그룹코드 ( 0 : 전체 )
		if(groupCd_ != null && !groupCd_.equals(""))
			groupCd = Integer.parseInt(groupCd_);
				
		String field = "code_nm"; // 코드명
		if(field_ != null && !field_.equals(""))
			field = field_;
		
		String query = "";
		if(query_ != null && !query_.equals(""))
			query = query_;
		
		int page = 1;
		if(page_ != null && !page_.equals(""))
			page = Integer.parseInt(page_);
				
		// code (view)를 요청할 때
		List<GroupCodeView> groupCodeList = service.getAdminGroupCodeViewList();
		
		// 목록 조회		
		List<CodeView> list = service.getAdminCodeViewList(page, field, query, groupCd);	
		
		// 게시물 수 조회
		int count = service.getAdminCodeCount(field, query, groupCd);
		
		model.addAttribute("groupCodeList",groupCodeList);
		model.addAttribute("list",list);
		model.addAttribute("count",count);
				
		return "admin.board.code.list";
	}
	
	
	/**
	 * 공통코드 상세정보 조회
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("detail")
	public String adminCodeDetail(HttpServletRequest request, Model model) {
		
		String groupCd_ = request.getParameter("groupCd"); // 그룹코드
		String codeCd_  = request.getParameter("codeCd");  // 공통코드
		
		int groupCd = 1; // 그룹코드 명
		if(groupCd_ != null && !groupCd_.equals(""))
			groupCd = Integer.parseInt(groupCd_);
		
		
		int codeCd = 1; // 공통코드 명
		if(codeCd_ != null && !codeCd_.equals(""))
			codeCd = Integer.parseInt(codeCd_);
		
		
		// 상세정보 조회
		CodeView info = service.getAdminCodeViewDetail(groupCd, codeCd);
		
		model.addAttribute("info",info);
		
		return "admin.board.code.detail";
	}
	
	
	/**
	 * 공통코드 등록 페이지로 이동
	 * @return
	 */
	@RequestMapping(value="reg", method = RequestMethod.GET)
	public String getAdminCodeReg(Model model) {
				
		// code (view)를 요청할 때
		List<GroupCodeView> groupCodeList = service.getAdminGroupCodeViewList();
		
		model.addAttribute("groupCodeList",groupCodeList);
		
		return "admin.board.code.reg";
	}
	
	
	/**
	 * 공통코드 등록
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="reg", method = RequestMethod.POST)
	public String postAdminCodeReg(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
		
		String groupCd_ = request.getParameter("groupCd"); // 그룹코드
		String codeCd_  = request.getParameter("codeCd");  // 공통코드
		String codeNm_  = request.getParameter("codeNm");  // 공통코드 명
		String regNo_   = request.getParameter("regNo");   // 작성자
			
		String memberId_ = (String)session.getAttribute("sessionUser");
		int regNo = 2; // 임시 관리자 번호
		
		int groupCd = 0; // 그룹코드 명
		if(groupCd_ != null && !groupCd_.equals(""))
			groupCd = Integer.parseInt(groupCd_);
				
		int codeCd = 0; // 공통코드
		if(codeCd_ != null && !codeCd_.equals(""))
			codeCd = Integer.parseInt(codeCd_);
				
		String codeNm = null; // 공통코드 명
		if(codeNm_ != null && !codeNm_.equals(""))
			codeNm = codeNm_;
		
		//-------------------- 그룹 코드 중복 체크 ----------------------------
		int chk = service.getAdminCodeCheck(groupCd, codeCd);
			
		// 기존에 등록되어 있는 그룹코드가 있는 경우
		if(chk != 0) {
			//System.out.println("Code 공통코드 중복 : " + chk + "(중복된 공통코드가 있으므로 등록페이지로 이동)");
			return "redirect:/admin/board/code/reg?groupCd="+groupCd+"&codeCd="+codeCd+"&codeNm="+codeNm+"&overlap=1";
		}
		//-----------------------------------------------------------------
		
		// 작성자 예외처리
		if(memberId_ != null && !memberId_.equals(""))
			regNo = service.getAdminMemberNo(memberId_); // 작성자 번호	
		
		
		Code code = new Code();
		code.setGroup_cd(groupCd);
		code.setCode_cd(codeCd);
		code.setCode_nm(codeNm);
		code.setReg_no(regNo);
				
		
		// 공통코드 등록
		int result = service.adminCodeInsert(code);		
		
		//response.sendRedirect("list");
		return "redirect:/admin/board/code/list";
	}
	
	
	/**
	 * 공통코드 수정 페이지로 이동
	 * @return
	 */
	@RequestMapping(value="edit", method = RequestMethod.GET)
	public String getAdminCodeEdit(HttpServletRequest request, Model model) {
		
		String groupCd_ = request.getParameter("groupCd"); // 그룹코드
		String codeCd_  = request.getParameter("codeCd");  // 공통코드
		
		int delGroupCd = 6; // 삭제여부 코드
		
		int groupCd = 0; // 그룹코드 명
		if(groupCd_ != null && !groupCd_.equals(""))
			groupCd = Integer.parseInt(groupCd_);
		
		
		int codeCd = 0; // 공통코드 명
		if(codeCd_ != null && !codeCd_.equals(""))
			codeCd = Integer.parseInt(codeCd_);
		
		
		// code (view)를 요청할 때
		List<GroupCodeView> groupCodeList = service.getAdminGroupCodeViewList();
				
		// code (삭제여부 코드 목록)를 요청할 때
		List<CodeView> delCodeList = service.getAdminCodeViewList(1, "", "", delGroupCd);
		
		// 상세정보 조회
		CodeView info = service.getAdminCodeViewDetail(groupCd, codeCd);
		
		model.addAttribute("delCodeList",delCodeList);
		model.addAttribute("groupCodeList",groupCodeList);
		model.addAttribute("info",info);
		
		return "admin.board.code.edit";
	}
	
	
	/**
	 * 공통코드 수정
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="edit", method = RequestMethod.POST)
	public void postAdminCodeEdit(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
	
		String groupCd_ = request.getParameter("groupCd"); // 그룹코드
		String codeCd_  = request.getParameter("codeCd");  // 공통코드
		String codeNm_  = request.getParameter("codeNm");  // 공통코드 명
		String codeDel_ = request.getParameter("codeDel"); // 삭제여부
		//String modNo_   = request.getParameter("modNo");   // 수정자
		
		String memberId_ = (String)session.getAttribute("sessionUser");
		int modNo = 2; // 임시 관리자 번호
		
		int groupCd = 0; // 그룹코드 명
		if(groupCd_ != null && !groupCd_.equals(""))
			groupCd = Integer.parseInt(groupCd_);
		
		int codeCd = 0; // 공통코드
		if(codeCd_ != null && !codeCd_.equals(""))
			codeCd = Integer.parseInt(codeCd_);
		
		String codeNm = null; // 공통코드 명
		if(codeNm_ != null && !codeNm_.equals(""))
			codeNm = codeNm_;
		
		boolean codeDel = true; // 사용
		if(codeDel_ != null && !codeDel_.equals(""))
			if(codeDel_.equals("0"))
				codeDel = false;
	
		
		// 수정자 예외처리
		if(memberId_ != null && !memberId_.equals(""))
			modNo = service.getAdminMemberNo(memberId_); // 수정자 번호
		
				
		Code code = new Code();
		code.setGroup_cd(groupCd);
		code.setCode_cd(codeCd);
		code.setCode_nm(codeNm);
		code.setCode_del(codeDel);
		code.setMod_no(modNo);
		
		// 공통코드 수정
		int result = service.adminCodeUpdate(code);
		
		response.sendRedirect("list");
	}
		
	
	/**
	 * 공통코드 삭제
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="del", method = RequestMethod.POST)
	public void postAdminCodeDel(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
	
		String groupCd_ = request.getParameter("groupCd"); // 그룹코드
		String codeCd_  = request.getParameter("codeCd");  // 공통코드
		String modNo_   = request.getParameter("modNo");   // 수정자
		
		String memberId_ = (String)session.getAttribute("sessionUser");
		int modNo = 2; // 임시 관리자 번호
		
		int groupCd = 0; // 그룹코드 명
		if(groupCd_ != null && !groupCd_.equals(""))
			groupCd = Integer.parseInt(groupCd_);
					
		int codeCd = 0; // 공통코드
		if(codeCd_ != null && !codeCd_.equals(""))
			codeCd = Integer.parseInt(codeCd_);
		
		
		// 수정자 예외처리
		if(memberId_ != null && !memberId_.equals(""))
			modNo = service.getAdminMemberNo(memberId_); // 수정자 번호
		
		Code code = new Code();
		code.setGroup_cd(groupCd);
		code.setCode_cd(codeCd);
		code.setMod_no(modNo);
		
		
		// 공통코드 삭제
		int result = service.adminCodeDelete(code);
		
		response.sendRedirect("list");
	}
}
