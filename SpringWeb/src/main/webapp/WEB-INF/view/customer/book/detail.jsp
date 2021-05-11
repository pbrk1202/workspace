<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	
	<main role="main">
	    <nav aria-label="breadcrumb">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="/customer/main/list">Home</a></li>
				<li class="breadcrumb-item"><a href="/customer/book/list">도서</a></li>
				<li class="breadcrumb-item active" aria-current="page">상세정보</li>
			</ol>
		</nav>
	          
		<div class="container">
		    
		    <div class="card text-center">
				<div class="card-header">
			   		${info.book_title} ( ${info.book_author} )
			    </div>
			    <div class="card-body">
			    	<div id="book-detail-img-mob" class="row justify-content-md-center">
			    	<div class="card h-100">
	      		    	<!-- 값이 비어 있지 않은 경우 -->
	               		<c:if test="${!empty info.book_img_url}">
		            	<img src="/upload/${info.book_img_url}" class="card-img-top" alt="...">
		            	</c:if>
		            	<!-- 값이 비어 있는 경우 -->
	               		<c:if test="${empty info.book_img_url}">
	               		<img src="/images/img_00.jpg" class="card-img-top" alt="...">
	               		</c:if>
              		</div>
              		</div>
			    </div>
			    <div class="card-body">
			    	<h5 class="card-title">${info.book_title} 상세 페이지 입니다.</h5>
			    	<p class="card-text">${info.book_title} 리뷰 작성을 원하시면 버튼을 클릭해주세요.</p>
			    	<a href="review?no=${info.book_no}" class="btn btn-primary">리뷰 작성하기</a>
			  	</div>
			</div>

		</div>
		<div class="container py-4">
		   
	        <ul class="nav nav-tabs" id="myTab" role="tablist">
	            <li class="nav-item" role="presentation">
	                <a class="nav-link active" id="home-tab" data-toggle="tab" href="#book" role="tab" aria-controls="book" aria-selected="true">도서</a>
	            </li>
	            <li class="nav-item" role="presentation">
	                <a class="nav-link" id="profile-tab" data-toggle="tab" href="#author" role="tab" aria-controls="author" aria-selected="false">저자</a>
	            </li>
	            <li class="nav-item" role="presentation">
	                <a class="nav-link" id="contact-tab" data-toggle="tab" href="#review" role="tab" aria-controls="review" aria-selected="false">리뷰</a>
	            </li>
	        </ul>
	        
	        <div class="tab-content py-4" id="myTabContent">
	            <div class="tab-pane fade show active" id="book" role="tabpanel" aria-labelledby="home-tab">${info.book_desc}</div>
	            <div class="tab-pane fade" id="author" role="tabpanel" aria-labelledby="profile-tab">${info.book_author_desc}</div>
	            <div class="tab-pane fade" id="review" role="tabpanel" aria-labelledby="contact-tab">
					<div class="list-group">
						<c:if test="${!empty reviewList}">
					<c:forEach var="item" items="${reviewList}">
					   <a href="#" class="list-group-item list-group-item-action">
					       <div class="d-flex w-100 justify-content-between">
					           <h5 class="mb-1">${info.book_title}</h5>
					           <small><fmt:formatDate pattern="yyyy-MM-dd" value="${item.reg_date}" /></small>
					       </div>
					       <p class="mb-1">${item.book_review_content}</p>
					       <small>${item.reg_nm} 독자분이 작성해주신 리뷰 입니다.</small>
					   </a>
					   </c:forEach>
					   </c:if>
					   <c:if test="${empty reviewList}">
					    데이터가 존재하지 않습니다.
					   </c:if>
					</div>
	     		</div>	  	
			</div>    
  		</div>
 
	</main>
	
	<!-- 중복 체크 -->
	<c:if test="${!empty param.overlap}">
    <script>
    	alert("리뷰가 정상적으로 등록되었습니다.");
    </script>
    </c:if>
    