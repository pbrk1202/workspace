<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

	<!-- main -->
	<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4 py-4">
		
		<div class="container py-4">
		
	        <!-- title -->
	        <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
	            <h1 class="h2">도서 수정</h1>
	        </div>
			
			<div class="form-row py-2">
	       		<div class="form-group col-md-12">
	            	도서를 변경 할 수 있습니다.
	            </div>
	        </div>
	        
	        <form method="post" action="edit" enctype="multipart/form-data">
			<input type="hidden" name="bookNo" value="${info.book_no}">
	
				<div class="form-row">
			       <div class="form-group col-md-6">
			           <label for="inputTitle">도서 제목</label>
			           <input type="text" class="form-control" id="inputTitle" name="bookTitle" value="${info.book_title}">
			       </div>             
			       <div class="form-group col-md-6">
			           <div class="form-group">
			               <label for="selectCodeCd">도서 타입</label>
			               <select class="form-control" id="selectCodeCd" name="codeCd">	
					        	<c:forEach var="item" items="${typeCodeList}">
					        	<option value="${item.code_cd}" <c:if test="${item.code_cd eq info.code_cd}">selected</c:if>>${item.code_nm}</option>
					        	</c:forEach>
					       </select>
			            </div>
			       </div>	         
				 </div>
				 <div class="form-row">
			        <div class="form-group col-md-12">
			            <label for="inputImgUrl">도서 이미지 첨부</label>
			            <input type="file" class="form-control-file" id="inputImgUrl" name="file"">
			        </div>     
				 </div>  
				 
				 <div class="form-row">
					 <div class="form-group col-md-12">
						<c:choose>
							<c:when test="${info.book_pub eq true}"> <c:set var="bookPub1" value="1" /> </c:when>
							<c:when test="${info.book_pub eq false}"> <c:set var="bookPub1" value="0" /> </c:when>
							<c:otherwise> <c:set var="bookPub1" value="0" /> </c:otherwise>
						</c:choose>
		                <label for="selectBookPub">공개여부</label>
		                <select id="selectBookPub" class="form-control" name="bookPub">
						<c:forEach var="item" items="${pubCodeList}">
		           			<option value="${item.code_cd}" <c:if test="${item.code_cd eq bookPub1}">selected</c:if>>${item.code_nm}</option>
		             	</c:forEach>
		                </select>
		             </div> 
	             </div>
				   
			     <div class="form-row">
			        <div class="form-group col-md-6">
			            <label for="inputPublisher">출판사</label>
			            <input type="text" class="form-control" id="inputPublisher" name="bookPublisher" value="${info.book_publisher}">
			        </div>
			        <div class="form-group col-md-6">
			            <label for="inputPubDate">발행년도</label>
			            <input type="text" class="form-control" id="inputPubDate" name="bookPubDate" value="${info.book_pub_date}">
			        </div>
			     </div>           
		                  
		            <div class="form-group">
		               <label for="inputDesc">도서 소개</label>
		               <textarea class="form-control" id="inputDesc" rows="3" name="bookDesc">${info.book_desc}</textarea>
		            </div>
		            <div class="form-row">
		               <div class="form-group col-md-12">
		                   <label for="inputAuthor">저자</label>
		                   <input type="text" class="form-control" id="inputAuthor" name="bookAuthor" value="${info.book_author}">
		               </div>
		            </div>
		            <div class="form-group">
		               <label for="inputAuthorDesc">저자 소개</label>
		               <textarea class="form-control" id="inputAuthorDesc" rows="3" name="bookAuthorDesc">${info.book_author_desc}</textarea>
		            </div>
				
				 <div class="form-group py-4">
					<a class="btn btn-primary  btn-lg" href="list?p=${(empty param.p)?1:param.p}">목록</a>
		   	        <button type="submit" class="btn btn-secondary btn-lg">수정</button>
		 	     </div>
		 	     
	        </form>

       </div>

    </main>
