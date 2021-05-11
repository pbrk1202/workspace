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
	            <h1 class="h2">공지사항 보기</h1>
	        </div>
			
			<div class="form-row py-2">
	       		<div class="form-group col-md-12">
	            	공지사항을 보기 페이지 입니다. 파일을 다운받을 수 있습니다.
	            </div>
	        </div>
	        
	        <form method="post" action="reg" enctype="multipart/form-data">
	        <input type="hidden" name="noticeNo"  value="${info.notice_no}">
			<input type="hidden" name="groupCd" value="${info.group_cd}">
	
				<fieldset disabled>
				<div class="form-row">
			       <div class="form-group col-md-12">
			           <label for="inputTitle">공지제목 제목</label>
			           <input type="text" class="form-control" id="inputTitle" value="${info.notice_title}">
			       </div>   
			    </div>
			    <div class="form-row">
			       <div class="form-group col-md-12">
			           <label for="inputCodeNm">공지 타입</label>
			           <input type="text" class="form-control" id="inputCodeNm" value="${info.code_nm}">
			       </div>   
			    </div>
			    </fieldset>
			    
				 <!-- 이미지 파일이 있는 경우 -->
	             <c:if test="${!empty info.notice_files}">
	             	<div class="form-row">
				       <div class="form-group col-md-12">
				           파일 첨부
				       </div>   
				    </div>
		 		    <div class="form-row">
				        <div class="form-group col-md-6">
				        	<c:forTokens var="fileName" items="${info.notice_files}" delims="," varStatus="st">
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
	             <div class="form-group">
	                <label for="inputContent">공지 내용</label>
	                <textarea class="form-control" id="inputContent" rows="3">${info.notice_content}</textarea>
	             </div>
		         </fieldset>
				
				 <div class="form-group py-4">
					<a class="btn btn-primary  btn-lg" href="list?p=${(empty param.p)?1:param.p}">목록</a>
					<a class="btn btn-secondary  btn-lg" href="edit?p=${(empty param.p)?1:param.p}&noticeNo=${info.notice_no}">수정</a>
		 	     </div>
		 	     
	        </form>
	
		</div>
		
    </main>
	    