<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<!-- main -->
	<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4 py-4">

		<div class="container py-4">

	        <!-- title -->
	        <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
	            <h1 class="h2">회원 등록</h1>
	        </div>
			
			<div class="form-row py-2">
	       		<div class="form-group col-md-12">
	            	회원을 등록 할 수 있습니다. 
	            </div>
	        </div>
	        
	        <form method="post" action="reg" enctype="multipart/form-data">
			<input type="hidden" name="groupCd" value="${groupCd}">
				
				<div class="form-row">
	                <div class="form-group col-md-12">
	                    <label for="inputId">아이디</label>
	                    <input type="text" class="form-control" id="inputId" name="memberId">
	                </div>
	                <div class="form-group col-md-12">
	                    <label for="inputPassword">비밀번호</label>
	                    <input type="password" class="form-control" id="inputPassword" name="memberPwd">
	                </div>
	                <div class="form-group col-md-12">
	                    <label for="inputName">이름</label>
	                    <input type="text" class="form-control" id="inputName" name="memberNm">
	                </div>
	            </div>
	            <div class="form-row">
	                <div class="form-group col-md-6">
	                    <div class="form-group">
	                        <label for="inputGender">성별</label>
	                        <select class="form-control" id="selectCodeCd" name="memberGender">	
					        	<c:forEach var="item" items="${genderCodeList}">
					        	<option value="${item.code_cd}">${item.code_nm}</option>
					       	 	</c:forEach>
					       	</select>
	                      </div>
	                </div>                
	                <div class="form-group col-md-6">
			           <div class="form-group">
			               <label for="selectCodeCd">회원 타입</label>
			               <select class="form-control" id="selectCodeCd" name="codeCd">	
					        	<c:forEach var="item" items="${typeCodeList}">
					        	<option value="${item.code_cd}">${item.code_nm}</option>
					        	</c:forEach>
					       </select>
			            </div>
			       </div>	 
	            </div>
	            <div class="form-row">
	         	    <div class="form-group col-md-6">
	                    <label for="inputBtn">생년월일</label>
	                    <input type="text" class="form-control" id="inputBtn" name="memberBtn">
	                </div>
	                <div class="form-group col-md-6">
	                    <label for="inputPhone">전화번호</label>
	                    <input type="text" class="form-control" id="inputPhone" name="memberPhone">
	                </div>
	            </div>
	            <div class="form-row">
	                <div class="form-group col-md-12">
	                    <label for="inputEmail">이메일</label>
	                    <input type="text" class="form-control" id="inputEmail" name="memberEmail">
	                </div>
	            </div>
							
				<div class="form-group py-4">
					<a class="btn btn-primary  btn-lg" href="list?p=${(empty param.p)?1:param.p}">목록</a>
		   	        <button type="submit" class="btn btn-secondary btn-lg">등록</button>
		 	    </div>
		 	     
	        </form>
	        
		</div>

    </main>
