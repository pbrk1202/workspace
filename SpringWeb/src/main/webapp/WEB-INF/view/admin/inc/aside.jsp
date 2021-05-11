<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>    
   
	 <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
	     <div class="sidebar-sticky pt-3">
	         <ul class="nav flex-column">
	             <li class="nav-item">
	                 <span class="nav-link active">    
	                     CODE
	                 </span>
	             </li>
	             <li class="nav-item">
	                 <a class="nav-link" href="/admin/board/groupCode/list">
	                     <span data-feather="file"></span>
	                     그룹코드
	                 </a>
	             </li>
	             <li class="nav-item">
	                 <a class="nav-link" href="/admin/board/code/list">
	                     <span data-feather="shopping-cart"></span>
	                     공통코드
	                 </a>
	             </li>
	             <li class="nav-item">
	                 <a class="nav-link" href="/admin/board/member/list">
	                     <span data-feather="shopping-cart"></span>
	                     회원관리
	                 </a>
	             </li>
	         </ul>                    
	         <ul class="nav flex-column mb-2">
	             <li class="nav-item">
	                 <span class="nav-link active">
	                     MENU
	                 </span>
	             </li>
	             <li class="nav-item">
	                 <a class="nav-link" href="/admin/board/book/list">
	                     <span data-feather="file-text"></span>
	                     도서관리
	                 </a>
	             </li>
	             <li class="nav-item">
	                 <a class="nav-link" href="/admin/board/singleLine/list">
	                     <span data-feather="file-text"></span>
	                     한줄글
	                 </a>
	             </li>
	             <li class="nav-item">
	                 <a class="nav-link" href="/admin/board/notice/list">
	                     <span data-feather="file-text"></span>
	                     공지사항
	                 </a>
	             </li>
	             <li class="nav-item">
	                 <a class="nav-link" href="/admin/board/faq/list">
	                     <span data-feather="file-text"></span>
	                     FAQ
	                 </a>
	             </li>
	         </ul>
	     </div>
	 </nav>