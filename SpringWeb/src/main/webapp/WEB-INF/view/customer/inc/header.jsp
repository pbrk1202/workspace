<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
	<header class="bg-primary">            
	    <div class="container">
	
	        <!-- nav1 -->
	        <nav class="navbar navbar-light">
	            <a class="navbar-brand text-white mx-0" href="/customer/main/list"><h2>PBOOKS</h2></a>
	            <form class="form-inline">
	                <!-- <button type="button" class="btn btn-light mx-1 my-2 my-sm-0">회원가입</button> -->
	                <div class="login-box-text">
	                	
						<c:if test="${empty sessionScope.sessionUser}">
							<!-- 비회원 -->
			                <a type="button" class="btn btn-outline-light mx-1 my-2 my-sm-0" href="/customer/main/login">
			                	<span class="web-login-button">로그인</span> 
			                </a>
			            </c:if>
			            <c:if test="${!empty sessionScope.sessionUser}">
							<!-- 회원 -->
			                <!-- <a type="button" class="btn btn-outline-light mx-1 my-2 my-sm-0" href="/customer/main/login">
			                	<span class="web-login-button">로그아웃</span> 
			                </a> -->
			                 <div class="btn-group">
	 			                <a type="button" href="/customer/main/login" class="btn btn-outline-light">로그아웃</a>
							 	<!-- <button type="button" class="btn btn-outline-light">로그아웃</button> -->
							    <button type="button" class="btn btn-outline-light dropdown-toggle dropdown-toggle-split" id="dropdownMenuReference" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" data-reference="parent">
							    	<span class="sr-only">메뉴</span>
							    </button>
							    <div class="dropdown-menu" aria-labelledby="dropdownMenuReference">
							    	<a class="dropdown-item" href="/customer/info/detail">내정보</a>
							    	<a class="dropdown-item" href="/customer/info/reviewList">리뷰</a>
							    	<a class="dropdown-item" href="/customer/info/singleLineList">한줄글</a>
							    	<div class="dropdown-divider"></div>
							    	<a class="dropdown-item" href="/customer/main/login">로그아웃</a>
							    </div>
							  </div>
							</div>
						</c:if>
	                </div>
	            </form>
	        </nav>
	
	        <!-- nav2 -->
	       	<div class="nav-scroller bg-primary shadow-sm">
	            <nav class="nav nav-underline justify-content-center">
	                <a class="text-white nav-link active" href="/customer/main/list">홈</a>                
	                <a class="text-white nav-link" href="/customer/book/list">도서</a>
	                <a class="text-white nav-link" href="/customer/singleLine/list">한줄글</a>
	                <a class="text-white nav-link" href="/customer/notice/list">공지</a>
	                <a class="text-white nav-link" href="/customer/faq/list">FAQ</a>
	            </nav>
	        </div>
	 
	   
	    </div>
	    <!-- /.container -->
	</header>