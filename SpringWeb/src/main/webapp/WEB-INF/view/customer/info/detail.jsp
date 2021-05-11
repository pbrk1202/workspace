<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	
	<main role="main">
	    <nav aria-label="breadcrumb">
		    <ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="/customer/main/list">Home</a></li>
				<li class="breadcrumb-item active" aria-current="page">내 정보</li>
			</ol>
		</nav>
	          
		<div class="container">
		    
		    <div class="card text-center">
				<div class="card-header">
			   		${info.member_nm} ( ${info.member_id} )
			    </div>
			    <div class="card-body">
			    	<div id="book-detail-img-mob" class="row justify-content-md-center">
			    	<div class="card h-100">
	               		<img src="/images/favicon/read2_128.png" class="card-img-top" alt="...">
              		</div>
              		</div>
			    </div>
			    <div class="card-body">
			    	<h5 class="card-title">내 정보를 변경할 수 있습니다.</h5>
			  	</div>
			</div>

		</div>
		
		<div class="container py-4">
		
			<form name="infoEdit" method="post" action="edit" enctype="multipart/form-data">
	        <input type="hidden" name="memberNo" value="${info.member_no}">
	        <input type="hidden" name="groupCd"  value="${info.group_cd}">
				
				<div class="form-row">
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
	            
							
				<div class="form-group py-4">
					<a class="btn btn-primary  btn-lg" href="/customer/main/list">목록</a>
		   	        <a class="btn btn-secondary btn-lg" onClick="infoEditSubmit()">수정</a>
		   	        <!-- <button type="submit" class="btn btn-secondary btn-lg">수정</button> -->
		 	    </div>
		 	     
	        </form>
		
  		</div>
 
	</main>
	    
    <script>
    	function infoEditSubmit() {
    		var form = document.infoEdit;
    		
    		// 공백 체크 (값, 이름)
    		if (!checkExistData(form.memberPwd.value,"비밀번호"))
                return false;
    		else if (!checkExistData(form.memberNm.value,"이름"))
				return false;
    		else if (!checkExistData(form.memberPhone.value,"전화번호"))
    			return false;
    			
    		
    		// 등록
            form.submit();
    	}
   	</script>
    