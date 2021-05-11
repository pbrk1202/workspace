<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<!-- main -->
	<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4 py-4">

		<div class="container py-4">
	
	        <!-- title -->
	        <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
	            <h1 class="h2">자주하는질문 등록</h1>
	        </div>
			
			<div class="form-row py-2">
	       		<div class="form-group col-md-12">
	            	자주하는질문을 수정 할 수 있습니다. 
	            </div>
	        </div>
	        
	        <form method="post" action="edit" enctype="multipart/form-data">
	   		<input type="hidden" name="faqNo"   value="${info.faq_no}">
			<input type="hidden" name="groupCd" value="${info.group_cd}">
	
				<div class="form-row">
			       <div class="form-group col-md-6">
			           <label for="inputTitle">질문 제목</label>
			           <input type="text" class="form-control" id="inputTitle" name="faqTitle" value="${info.faq_title}">
			       </div>             
			       <div class="form-group col-md-6">
			           <div class="form-group">
			               <label for="selectCodeCd">질문 타입</label>
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
						<c:choose>
							<c:when test="${info.faq_pub eq true}"> <c:set var="faqPub1" value="1" /> </c:when>
							<c:when test="${info.faq_pub eq false}"> <c:set var="faqPub1" value="0" /> </c:when>
							<c:otherwise> <c:set var="bookPub1" value="0" /> </c:otherwise>
						</c:choose>
		                <label for="selectBookPub">공개여부</label>
		                <select id="selectBookPub" class="form-control" name="faqPub">
						<c:forEach var="item" items="${pubCodeList}">
		           			<option value="${item.code_cd}" <c:if test="${item.code_cd eq faqPub1}">selected</c:if>>${item.code_nm}</option>
		             	</c:forEach>
		                </select>
		             </div> 
	            </div>
	            <div class="form-group">
	                <label for="inputContent">질문 내용</label>
	                <textarea class="form-control" id="inputContent" rows="3" name="faqContent">${info.faq_content}</textarea>
	            </div>
	            <div class="form-group">
	                <label for="inputAuthorAnswer">질문 답변</label>
	                <textarea class="form-control" id="inputAnswer" rows="3" name="faqAnswer">${info.faq_answer}</textarea>
	            </div>
				
				<div class="form-group py-4">
					<a class="btn btn-primary  btn-lg" href="list?p=${(empty param.p)?1:param.p}">목록</a>
		   	        <button type="submit" class="btn btn-secondary btn-lg">등록</button>
		 	    </div>
		 	     
	        </form>
	
		</div>
		
    </main>
