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
import com.pbrk.pbook.entity.GroupCode;
import com.pbrk.pbook.entity.GroupCodeView;
import com.pbrk.pbook.service.admin.AdminGroupCodeService;

@Controller("adminGroupCodeController")
@RequestMapping("/admin/board/groupCode/")
public class AdminGroupCodeController {

	@Autowired
	private AdminGroupCodeService service;
	
	
	/**
	 * 그룹코드 목록 조회
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("list")
	public String adminGroupCodeList(HttpServletRequest request, Model model) {
		
		String page_ = request.getParameter("p");  // 현재 페이지

		int page = 1;
		if(page_ != null && !page_.equals(""))
			page = Integer.parseInt(page_);
				
		// 목록 조회		
		List<GroupCodeView> list = service.getAdminGroupCodeViewList(page);	
		
		// 게시물 수 조회
		int count = service.getAdminGroupCodeCount();
		
		model.addAttribute("list",list);
		model.addAttribute("count",count);
				
		return "admin.board.groupCode.list";
	}
	
	
	/**
	 * 그룹코드 등록 페이지로 이동
	 * @return
	 */
	@RequestMapping(value="reg", method = RequestMethod.GET)
	public String getAdminGroupCodeReg() {
		
		return "admin.board.groupCode.reg";
	}
	
	
	/**
	 * 그룹코드 등록
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="reg", method = RequestMethod.POST)
	public String postAdminGroupCodeReg(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
		
		String groupCd_   = request.getParameter("groupCd");   // 그룹코드
		String groupCdNm_ = request.getParameter("groupCdNm"); // 그룹코드 명
		//String regNo_     = request.getParameter("regNo");     // 작성자
		
		String memberId_ = (String)session.getAttribute("sessionUser");
		int regNo = 2; // 임시 관리자 번호
		
		int groupCd = 0; // 그룹코드 명
		if(groupCd_ != null && !groupCd_.equals(""))
			groupCd = Integer.parseInt(groupCd_);
		
		String groupCdNm = "미작성"; // 그룹코드 명
		if(groupCdNm_ != null && !groupCdNm_.equals(""))
			groupCdNm = groupCdNm_;

		
		//------------ 그룹코드 중복체크 --------------------------
		int chk = service.getAdminGroupCodeRegCheck(groupCd);
		
		// 기존에 등록되어 있는 그룹코드가 있는 경우
		if(chk != 0) {
			return "redirect:/admin/board/groupCode/reg?groupCd="+groupCd+"&groupCdNm="+groupCdNm+"&overlap=1";
		}
		//-----------------------------------------------------
		
		// 작성자 예외처리
		if(memberId_ != null && !memberId_.equals(""))
			regNo = service.getAdminMemberNo(memberId_); // 작성자 번호
		
		
		GroupCode groupCode = new GroupCode();
		groupCode.setGroup_cd(groupCd);
		groupCode.setGroup_cd_nm(groupCdNm);
		groupCode.setReg_no(regNo);
		
				
		// 그룹코드 등록
		int result = service.adminGroupCodeInsert(groupCode);
		
		//response.sendRedirect("list");
		return "redirect:/admin/board/groupCode/list";
	}
	
	
	/**
	 * 그룹코드 수정 페이지로 이동
	 * @return
	 */
	@RequestMapping(value="edit", method = RequestMethod.GET)
	public String getAdminGroupCodeEdit(HttpServletRequest request, Model model) {
		
		String groupCd_ = request.getParameter("groupCd"); // 그룹코드
		
		int delCodeCd = 6; // 삭제여부 코드
		
		int groupCd = 1; // 그룹코드 명
		if(groupCd_ != null && !groupCd_.equals(""))
			groupCd = Integer.parseInt(groupCd_);
		
		
		// code (삭제여부 코드 목록)를 요청할 때
		List<CodeView> delCodeList = service.getAdminCodeViewList(delCodeCd);
		
				
		// 상세정보 조회
		GroupCodeView info = service.getAdminGroupCodeViewDetail(groupCd);
		
		model.addAttribute("delCodeList",delCodeList);
		model.addAttribute("info",info);
		
		return "admin.board.groupCode.edit";
	}
	
	
	/**
	 * 그룹코드 수정
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="edit", method = RequestMethod.POST)
	public void postAdminGroupCodeEdit(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
		
		String groupCd_   = request.getParameter("groupCd");   // 그룹코드
		String groupCdNm_ = request.getParameter("groupCdNm"); // 공통코드 명
		String groupDel_  = request.getParameter("groupDel");  // 삭제여부
		//String modNo_     = request.getParameter("modNo");     // 수정자
		
		String memberId_ = (String)session.getAttribute("sessionUser");
		int modNo = 2; // 임시 관리자 번호
		
		int groupCd = 1; // 그룹코드 명
		if(groupCd_ != null && !groupCd_.equals(""))
			groupCd = Integer.parseInt(groupCd_);	
		
		String groupCdNm = null; // 공통코드 명
		if(groupCdNm_ != null && !groupCdNm_.equals(""))
			groupCdNm = groupCdNm_;
				
		boolean groupDel = true; // 사용
		if(groupDel_ != null && !groupDel_.equals(""))
			if(groupDel_.equals("0"))
				groupDel = false;

		
		// 수정자 예외처리
		if(memberId_ != null && !memberId_.equals(""))
			modNo = service.getAdminMemberNo(memberId_); // 수정자 번호
		
		
		GroupCode groupCode = new GroupCode();
		groupCode.setGroup_cd(groupCd);
		groupCode.setGroup_cd_nm(groupCdNm);
		groupCode.setGroup_del(groupDel);
		groupCode.setMod_no(modNo);
		
		
		// 공통코드 수정
		int result = service.adminGroupCodeUpdate(groupCode);
		
		response.sendRedirect("list");
	}
		
}
