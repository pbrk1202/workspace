<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<!-- main -->
	<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4 py-4">
		
		<div class="container py-4">
		
	        <!-- title -->
	        <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
	            <h1 class="h2">리뷰 수정</h1>
	        </div>
			
			<div class="form-row py-2">
	       		<div class="form-group col-md-12">
	            	도서 리뷰를 수정 할 수 있습니다. 
	            </div>
	        </div>
	        
	        <form method="post" action="edit" enctype="multipart/form-data">
	   		<input type="hidden" name="bookNo"       value="${info.book_no}">
	   		<input type="hidden" name="bookReviewNo" value="${info.book_review_no}">
	
				<div class="form-row">
			       <div class="form-group col-md-12">
			           <label for="inputScore">점수</label>
			           <input type="text" class="form-control" id="inputScore" name="bookScore" value="${info.book_score}">
			       </div>             
			    </div>
			    <div class="form-row">
					<div class="form-group col-md-12">
						<c:choose>
							<c:when test="${info.book_review_pub eq true}"> <c:set var="bookReviewPub1" value="1" /> </c:when>
							<c:when test="${info.book_review_pub eq false}"> <c:set var="bookReviewPub1" value="0" /> </c:when>
							<c:otherwise> <c:set var="bookReviewPub1" value="0" /> </c:otherwise>
						</c:choose>
		                <label for="selectBookReviewPub">공개여부</label>
		                <select id="selectBookReviewPub" class="form-control" name="bookReviewPub">
						<c:forEach var="item" items="${pubCodeList}">
		           			<option value="${item.code_cd}" <c:if test="${item.code_cd eq bookReviewPub1}">selected</c:if>>${item.code_nm}</option>
		             	</c:forEach>
		                </select>
		             </div> 
	            </div>
	            <div class="form-row">
					<div class="form-group col-md-12">
						<c:choose>
							<c:when test="${info.book_review_del eq true}"> <c:set var="bookReviewDel1" value="1" /> </c:when>
							<c:when test="${info.book_review_del eq false}"> <c:set var="bookReviewDel1" value="0" /> </c:when>
							<c:otherwise> <c:set var="bookReviewDel1" value="0" /> </c:otherwise>
						</c:choose>
		                <label for="selectBookReviewDel">삭제여부</label>
		                <select id="selectBookReviewDel" class="form-control" name="bookReviewDel">
						<c:forEach var="item" items="${delCodeList}">
		           			<option value="${item.code_cd}" <c:if test="${item.code_cd eq bookReviewDel1}">selected</c:if>>${item.code_nm}</option>
		             	</c:forEach>
		                </select>
		             </div> 
	            </div>
	            <div class="form-group">
	                <label for="inputContent">리뷰 내용</label>
	                <textarea class="form-control" id="inputContent" rows="3" name="bookReviewContent">${info.book_review_content}</textarea>
	            </div>
	 			
				<div class="form-group py-4">
					<a class="btn btn-primary  btn-lg" href="list?p=${(empty param.p)?1:param.p}&bookNo=${info.book_no}">목록</a>
		   	        <button type="submit" class="btn btn-secondary btn-lg">수정</button>
		 	    </div>
		 	     
	        </form>
	
		</div>

    </main>
