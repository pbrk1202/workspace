<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<!-- main -->
	<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4 py-4">

		<div class="container py-4">

	        <!-- title -->
	        <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
	            <h1 class="h2">회원 수정</h1>
	        </div>
			
			<div class="form-row py-2">
	       		<div class="form-group col-md-12">
	            	회원을 수정 할 수 있습니다. 
	            </div>
	        </div>
	        
	        <form method="post" action="edit" enctype="multipart/form-data">
	        <input type="hidden" name="memberNo" value="${info.member_no}">
	        <input type="hidden" name="groupCd"  value="${info.group_cd}">
				
				<div class="form-row">
	                <div class="form-group col-md-12">
	                    <label for="inputId">아이디</label>
	                    <input type="text" class="form-control" id="inputId" name="memberId" value="${info.member_id}">
	                </div>
	                <div class="form-group col-md-12">
	                    <label for="inputPassword">비밀번호</label>
	                    <input type="password" class="form-control" id="inputPassword" name="memberPwd" value="${info.member_pwd}">
	                </div>
	                <div class="form-group col-md-12">
	                    <label for="inputName">이름</label>
	                    <input type="text" class="form-control" id="inputName" name="memberNm" value="${info.member_nm}">
	                </div>
	            </div>
	            <div class="form-row">
	                <div class="form-group col-md-6">
	                    <div class="form-group">
	                        <label for="inputGender">성별</label>
	                        <select class="form-control" id="selectCodeCd" name="memberGender">	
					        	<c:forEach var="item" items="${genderCodeList}">
					        	<option value="${item.code_cd}" <c:if test="${item.code_cd eq info.member_gender}">selected</c:if>>${item.code_nm}</option>
					       	 	</c:forEach>
					       	</select>
	                      </div>
	                </div>                
	                <div class="form-group col-md-6">
			           <div class="form-group">
			               <label for="selectCodeCd">회원 타입</label>
			               <select class="form-control" id="selectCodeCd" name="codeCd">	
					        	<c:forEach var="item" items="${typeCodeList}">
					        	<option value="${item.code_cd}" <c:if test="${item.code_cd eq info.code_cd}">selected</c:if>>${item.code_nm}</option>
					        	</c:forEach>
					       </select>
			            </div>
			       </div>	 
	            </div>
	            <div class="form-row">
	         	    <div class="form-group col-md-6">
	                    <label for="inputBth">생년월일</label>
	                    <input type="text" class="form-control" id="inputBth" name="memberBth" value="${info.member_bth}">
	                </div>
	                <div class="form-group col-md-6">
	                    <label for="inputPhone">전화번호</label>
	                    <input type="text" class="form-control" id="inputPhone" name="memberPhone" value="${info.member_phone}">
	                </div>
	            </div>
	            <div class="form-row">
	                <div class="form-group col-md-12">
	                    <label for="inputEmail">이메일</label>
	                    <input type="text" class="form-control" id="inputEmail" name="memberEmail" value="${info.member_email}">
	                </div>
	            </div>
	            <div class="form-row">
					 <div class="form-group col-md-12">
						<c:choose>
							<c:when test="${info.member_del eq true}"> <c:set var="memberDel1" value="1" /> </c:when>
							<c:when test="${info.member_del eq false}"> <c:set var="memberDel1" value="0" /> </c:when>
							<c:otherwise> <c:set var="memberDel1" value="0" /> </c:otherwise>
						</c:choose>
		                <label for="selectMemberDel">삭제여부</label>
		                <select id="selectMemberDel" class="form-control" name="memberDel">
						<c:forEach var="item" items="${delCodeList}">
		           			<option value="${item.code_cd}" <c:if test="${item.code_cd eq memberDel1}">selected</c:if>>${item.code_nm}</option>
		             	</c:forEach>
		                </select>
		             </div> 
	             </div>
							
				<div class="form-group py-4">
					<a class="btn btn-primary  btn-lg" href="list?p=${(empty param.p)?1:param.p}">목록</a>
		   	        <button type="submit" class="btn btn-secondary btn-lg">수정</button>
		 	    </div>
		 	     
	        </form>
		
		</div>
		
    </main>
