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

import com.pbrk.pbook.entity.Book;
import com.pbrk.pbook.entity.BookView;
import com.pbrk.pbook.entity.CodeView;
import com.pbrk.pbook.entity.GroupCodeView;
import com.pbrk.pbook.service.admin.AdminBookService;
import com.pbrk.pbook.utils.FileUpload;


@MultipartConfig(
	fileSizeThreshold=1024*1024,
	maxFileSize=1024*1024*50,
	maxRequestSize=1024*1024*50*5
)
@Controller("adminBookController")
@RequestMapping("/admin/board/book/")
public class AdminBookController {

	@Autowired
	private AdminBookService service;
	
	
	/**
	 * 도서 목록 조회
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("list") // list, detail, edit, reg
	public String adminBookList(HttpServletRequest request, Model model) {
		
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
		List<CodeView> codeList = service.getAdminCodeViewList(groupCd);
				
		// 목록 조회
		List<BookView> list = service.getAdminBookViewList(page, field, query, codeCd);
		
		// 게시물 수 조회
		int count = service.getAdminBookCount(field, query, codeCd);
		
		model.addAttribute("codeList",codeList);
		model.addAttribute("list",list);
		model.addAttribute("count",count);
		
		return "admin.board.book.list";
	}
	
	
	/**
	 * 도서 상세정보 조회
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("detail")
	public String adminBookDetail(HttpServletRequest request, Model model) {
		
		String no_ = request.getParameter("no"); // 도서번호
		
		int no = 1;
		if(no_ != null && !no_.equals(""))
			no = Integer.parseInt(no_);
		
		// 도서상세 정보 조회
		Book info = service.getAdminBookViewDetail(no);
		
		model.addAttribute("info",info);
		
		return "admin.board.book.detail";
	}
	
	
	/**
	 * 도서 등록 페이지로 이동
	 * @return
	 */
	@RequestMapping(value="reg", method = RequestMethod.GET)
	public String getAdminBookReg(Model model) {
		
		int groupCd = 2; // 도서 타입
		
		// code (view)를 요청할 때
		List<CodeView> codeList = service.getAdminCodeViewList(groupCd);
				
		model.addAttribute("groupCd", groupCd);
		model.addAttribute("codeList",codeList);
		
		return "admin.board.book.reg";
	}
		
	/**
	 * 도서 등록
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	@RequestMapping(value="reg", method = RequestMethod.POST)
	public void postAdminBookReg(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, ServletException {
		
		String bookTitle_      = request.getParameter("bookTitle");      // 제목
		String bookDesc_       = request.getParameter("bookDesc");       // 소개
		String bookAuthor_     = request.getParameter("bookAuthor");     // 저자
		String bookAuthorDesc_ = request.getParameter("bookAuthorDesc"); // 저자 소개
		String bookPublisher_  = request.getParameter("bookPublisher");  // 출판사
		String bookPubDate_    = request.getParameter("bookPubDate");    // 발행 일자	
		String groupCd_        = request.getParameter("groupCd");        // 그룹코드 (도서타입)
		String codeCd_         = request.getParameter("codeCd");         // 공통코드
		//String regNo_          = request.getParameter("regNo");          // 작성자
		
		String memberId_ = (String)session.getAttribute("sessionUser");
		int regNo = 2; // 임시 관리자 번호
		
		String bookTitle = null;
		if(bookTitle_ != null && !bookTitle_.equals(""))
			bookTitle = bookTitle_;
		
		String bookDesc = null;
		if(bookDesc_ != null && !bookDesc_.equals(""))
			bookDesc = bookDesc_;
		
		String bookAuthor = null;
		if(bookAuthor_ != null && !bookAuthor_.equals(""))
			bookAuthor = bookAuthor_;
		
		String bookAuthorDesc = null;
		if(bookAuthorDesc_ != null && !bookAuthorDesc_.equals(""))
			bookAuthorDesc = bookAuthorDesc_;
		
		String bookPublisher = null;
		if(bookPublisher_ != null && !bookPublisher_.equals(""))
			bookPublisher = bookPublisher_;
		
		String bookPubDate = null;
		if(bookPubDate_ != null && !bookPubDate_.equals(""))
			bookPubDate = bookPubDate_;
			
		int groupCd = 2; // 도서타입
		if(groupCd_ != null && !groupCd_.equals(""))
			groupCd = Integer.parseInt(groupCd_);
		
		int codeCd = 1; // 공통코드
		if(codeCd_ != null && !codeCd_.equals(""))
			codeCd = Integer.parseInt(codeCd_);
		
		// 작성자 예외처리
		if(memberId_ != null && !memberId_.equals(""))
			regNo = service.getAdminMemberNo(memberId_); // 작성자 번호
		
	
		/// -----------------------------------------------------------
		
		Collection<Part> parts = request.getParts();
		StringBuilder builder = new StringBuilder();
		
		// 실제 경로
		String realPath = request.getServletContext().getRealPath("/upload");
		
		// 파일 첨부
		FileUpload file = new FileUpload();
		builder = file.FileInsert(parts, realPath);
				
		/// -----------------------------------------------------------
		
//		Collection<Part> parts = request.getParts();
//		StringBuilder builder = new StringBuilder();
//		
//		for(Part p : parts) {
//			if(!p.getName().equals("file")) continue;
//			if(p.getSize() == 0) continue;
//			
////			Part filePart = request.getPart("file");
//			Part filePart = p;
//			String fileName = filePart.getSubmittedFileName();
//			builder.append(fileName);
//			builder.append(",");
//						
//			InputStream fis = filePart.getInputStream();
//			
//			String realPath = request.getServletContext().getRealPath("/upload");
//			System.out.println(realPath);
//			
//			File path = new File(realPath);
//			if(!path.exists())
//				path.mkdir();
//			
//			// mkdir : getRealPath("/upload")
//			// mkdirs : getRealPath("/member/upload"); 부모 경로까지 만들어줌			
//
//			String filePath = realPath + File.separator + fileName;
//			FileOutputStream fos = new FileOutputStream(filePath);
//			
//			byte[] buf = new byte[1024];
//			int size = 0;
//			while((size = fis.read(buf)) != -1) {
//				fos.write(buf, 0, size);
//			}
//
//			fos.close();
//			fis.close();
//		}
//		
//		if(builder.length() != 0)
//			builder.delete(builder.length()-1, builder.length());
//		
		/// -----------------------------------------------------------
			
		Book book = new Book();
		book.setBook_title(bookTitle);
		book.setBook_desc(bookDesc);
		book.setBook_author(bookAuthor);
		book.setBook_author_desc(bookAuthorDesc);
		book.setBook_publisher(bookPublisher);
		book.setBook_pub_date(bookPubDate);
		book.setBook_img_url(builder.toString());
		book.setGroup_cd(groupCd);
		book.setCode_cd(codeCd);
		book.setReg_no(regNo);
						
		// 도서 등록
		int result = service.adminBookInsert(book);
		
		response.sendRedirect("list");
	}
	
	/**
	 * 도서 수정 페이지로 이동
	 * @return
	 */
	@RequestMapping(value="edit", method = RequestMethod.GET)
	public String getAdminBookEdit(HttpServletRequest request, Model model) {
		
		String bookNo_ = request.getParameter("bookNo"); // 도서번호

		int typeGroupCd = 2; // 도서타입 그룹코드
		int pubGroupCd  = 7; // 공개여부 그룹코드
				
		int bookNo = 1;
		if(bookNo_ != null && !bookNo_.equals(""))
			bookNo = Integer.parseInt(bookNo_);
		
		// code (도서타입 코드 목록)를 요청할 때
		List<CodeView> typeCodeList = service.getAdminCodeViewList(typeGroupCd);
		
		// code (공개여부 코드 목록)를 요청할 때
		List<CodeView> pubCodeList = service.getAdminCodeViewList(pubGroupCd);	
				
		// 도서상세 정보 조회
		Book info = service.getAdminBookViewDetail(bookNo);
		
		model.addAttribute("typeCodeList",typeCodeList);
		model.addAttribute("pubCodeList",pubCodeList);
		model.addAttribute("info",info);
		
		return "admin.board.book.edit";
	}
	
	/**
	 * 도서 수정
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	@RequestMapping(value="edit", method = RequestMethod.POST)
	public void postAdminBookEdit(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, ServletException {
		
		String bookNo_         = request.getParameter("bookNo");         // 도서 번호
		String bookTitle_      = request.getParameter("bookTitle");      // 도서 제목
		String bookDesc_       = request.getParameter("bookDesc");       // 도서 소개
		String bookAuthor_     = request.getParameter("bookAuthor");     // 저자
		String bookAuthorDesc_ = request.getParameter("bookAuthorDesc"); // 저자 소개
		String bookPublisher_  = request.getParameter("bookPublisher");  // 출판사
		String bookPubDate_    = request.getParameter("bookPubDate");    // 발행 일자	
		String groupCd_        = request.getParameter("groupCd");        // 그룹코드 (도서타입)
		String codeCd_         = request.getParameter("codeCd");         // 공통코드
		//String modNo_          = request.getParameter("modNo");          // 수정자
		
		String memberId_ = (String)session.getAttribute("sessionUser");
		int modNo = 2; // 임시 관리자 번호
		
		int bookNo = 0; // 도서타입
		if(bookNo_ != null && !bookNo_.equals(""))
			bookNo = Integer.parseInt(bookNo_);
		
		String bookTitle = null;
		if(bookTitle_ != null && !bookTitle_.equals(""))
			bookTitle = bookTitle_;
		
		String bookDesc = null;
		if(bookDesc_ != null && !bookDesc_.equals(""))
			bookDesc = bookDesc_;
		
		String bookAuthor = null;
		if(bookAuthor_ != null && !bookAuthor_.equals(""))
			bookAuthor = bookAuthor_;
		
		String bookAuthorDesc = null;
		if(bookAuthorDesc_ != null && !bookAuthorDesc_.equals(""))
			bookAuthorDesc = bookAuthorDesc_;
		
		String bookPublisher = null;
		if(bookPublisher_ != null && !bookPublisher_.equals(""))
			bookPublisher = bookPublisher_;
		
		String bookPubDate = null;
		if(bookPubDate_ != null && !bookPubDate_.equals(""))
			bookPubDate = bookPubDate_;
			
		int groupCd = 2; // 도서타입
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
		
			
		Book book = new Book();
		book.setBook_no(bookNo);
		book.setBook_title(bookTitle);
		book.setBook_desc(bookDesc);
		book.setBook_author(bookAuthor);
		book.setBook_author_desc(bookAuthorDesc);
		book.setBook_publisher(bookPublisher);
		book.setBook_pub_date(bookPubDate);
		book.setBook_img_url(builder.toString());
		book.setGroup_cd(groupCd);
		book.setCode_cd(codeCd);
		book.setMod_no(modNo);
								
		
		// 도서 수정
		int result = service.adminBookUpdate(book);
		
		response.sendRedirect("list");
	}
}
