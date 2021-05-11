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
	            <h1 class="h2">도서 보기</h1>
	        </div>
			
			<div class="form-row py-2">
	       		<div class="form-group col-md-12">
	            	도서를 확인 할 수 있습니다.
	            </div>
	        </div>
	        
	        <form method="post" action="del" enctype="multipart/form-data">
				<input type="hidden" name="groupCd" value="${info.group_cd}">
				<input type="hidden" name="bookNo"  value="${info.book_no}">
		
				<!-- 이미지 파일이 있는 경우 -->
	            <c:if test="${!empty info.book_img_url}">
				<div class="form-row">
			       <div class="form-group col-md-2">
				        <img src="/upload/${info.book_img_url}" class="img-thumbnail" alt="...">
			       </div>        		       
				 </div>
				 <div class="form-row">
			        <div class="form-group col-md-6">
			        	<c:forTokens var="fileName" items="${info.book_img_url}" delims="," varStatus="st">
							<c:set var="style" value="" />
							<c:if test="${fn:endsWith(fileName, '.zip') }">
								<c:set var="style" value="font-weight: bold; color:red;" />
							</c:if>
							<a download href="/upload/${fileName}" style="${style}">${fn:toUpperCase(fileName)}</a>
							<%-- <a href="../../../upload/${fileName}" style="${style}">${fn:toUpperCase(fileName)}</a> --%>
							<c:if test="${!st.last}">
							/
							</c:if>
						</c:forTokens>
			        </div>     
				 </div>    
				 </c:if>
				 
				 <fieldset disabled>
				 <div class="form-row">
					 <div class="form-group col-md-12">
				        <label for="inputTitle">도서 제목</label>
				        <input type="text" class="form-control" id="inputTitle" value="${info.book_title}">
				     </div>     
			     </div>
			     
			     <div class="form-row">
				     <div class="form-group col-md-6">
				           <label for="inputCodeNm">도서 타입</label>
				           <input type="text" class="form-control" id="inputCodeNm" value="${info.code_nm}">
		  	         </div>   
		  	         <div class="form-group col-md-6">
				           <label for="inputPubNm">공개여부</label>
				           <input type="text" class="form-control" id="inputPubNm" value="${info.book_pub_nm}">
		  	         </div>
	  	         </div>
			     <div class="form-row">
			        <div class="form-group col-md-6">
			            <label for="inputPublisher">출판사</label>
			            <input type="text" class="form-control" id="inputPublisher" value="${info.book_publisher}">
			        </div>
			        <div class="form-group col-md-6">
			            <label for="inputPubDate">발행년도</label>
			            <input type="text" class="form-control" id="inputPubDate" value="${info.book_pub_date}">
			        </div>
			     </div>           
		                  
	             <div class="form-group">
	                <label for="inputDesc">도서 소개</label>
	                <textarea class="form-control" id="inputDesc" rows="3">${info.book_desc}</textarea>
	             </div>
	             <div class="form-row">
	                <div class="form-group col-md-12">
	                   <label for="inputAuthor">저자</label>
	                   <input type="text" class="form-control" id="inputAuthor" value="${info.book_author}">
	                </div>
	             </div>
	             <div class="form-group">
	                <label for="inputAuthorDesc">저자 소개</label>
	                <textarea class="form-control" id="inputAuthorDesc" rows="3">${info.book_author_desc}</textarea>
	             </div>
			 	 </fieldset>
				
		 	     <div class="row py-4">
				     <div class="col-auto mr-auto">
						<a class="btn btn-primary  btn-lg" href="list?p=${(empty param.p)?1:param.p}">목록</a>
			   	        <a class="btn btn-secondary  btn-lg" href="edit?p=${(empty param.p)?1:param.p}&bookNo=${info.book_no}">수정</a>
				     </div>
				     <div class="col-auto">
						 <a class="btn btn-secondary  btn-lg" href="/admin/board/bookReview/list?p=${(empty param.p)?1:param.p}&bookNo=${info.book_no}&bookTitle=${info.book_title}">리뷰</a>
					 </div>
				</div>	
		 	     
	        </form>
	
		</div>

    </main>
