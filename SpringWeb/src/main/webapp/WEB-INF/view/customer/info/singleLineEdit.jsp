<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<!-- main -->
	<!-- <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4"> -->
	<main role="main">
	<nav aria-label="breadcrumb">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="/customer/main/list">Home</a></li>
			<li class="breadcrumb-item"><a href="/customer/singleLine/list">내 한줄글</a></li>
			<li class="breadcrumb-item active" aria-current="page">내 한줄글 수정</li>
		</ol>
	</nav>
	
	<div class="container">	

        <!-- title -->
        <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
            <h1 class="h2">내 한줄글 수정</h1>
        </div>
		
		<div class="form-row py-2">
       		<div class="form-group col-md-12">
				로그인한 회원분들만 수정할 수 있으며, 본인이 등록한 한줄글만 수정할 수 있습니다.
            </div>
        </div>
        
        <form name="singleLineEdit" method="post" action="singleLineEdit" enctype="multipart/form-data">
    	<input type="hidden" name="snglLineNo" value="${info.sngl_line_no}">
		<input type="hidden" name="groupCd"    value="${groupCd}">

			<div class="form-row">
		       <div class="form-group col-md-6">
		           <label for="inputTitle">한줄글 제목</label>
		           <input type="text" class="form-control" id="inputTitle" name="snglLineTitle" value="${info.sngl_line_title}">
		       </div>             
		       <div class="form-group col-md-6">
		           <div class="form-group">
		               <label for="selectCodeCd">한줄글 타입</label>
		               <select class="form-control" id="selectCodeCd" name="codeCd">	
				        	<c:forEach var="item" items="${typeCodeList}">
				        	<option value="${item.code_cd}" <c:if test="${item.code_cd eq info.code_cd}">selected</c:if>>${item.code_nm}</option>
				        	</c:forEach>
				       </select>
		            </div>
		       </div> 
			</div>
		     
            <div class="form-group">
                <label for="inputContent">한줄글 내용</label>
                <textarea class="form-control" id="inputContent" rows="2" name="snglLineContent">${info.sngl_line_content}</textarea>
            </div>
			<div class="form-row">
				<div class="form-group col-md-12">
					<c:choose>
						<c:when test="${info.sngl_line_pub eq true}"> <c:set var="snglLinePub1" value="1" /> </c:when>
						<c:when test="${info.sngl_line_pub eq false}"> <c:set var="snglLinePub1" value="0" /> </c:when>
						<c:otherwise> <c:set var="snglLinePub1" value="0" /> </c:otherwise>
					</c:choose>
	                <label for="selectSnglLinePub">공개여부</label>
	                <select id="selectSnglLinePub" class="form-control" name="snglLinePub">
					<c:forEach var="item" items="${pubCodeList}">
	           			<option value="${item.code_cd}" <c:if test="${item.code_cd eq snglLinePub1}">selected</c:if>>${item.code_nm}</option>
	             	</c:forEach>
	                </select>
	             </div> 
            </div>
			
			<div class="form-group py-4">
				<a class="btn btn-primary  btn-lg" href="singleLineList?p=${(empty param.p)?1:param.p}">목록</a>
	   	        <!-- <button type="submit" class="btn btn-secondary btn-lg">수정</button> -->
	   	        <a class="btn btn-secondary btn-lg" onClick="singleLineEditSubmit()">수정</a>
	 	    </div>
	 	     
        </form>
	
	</div>
	
    </main>

    <script>
    	function singleLineEditSubmit() {
    		var form = document.singleLineEdit;
    		
    		// 공백 체크 (값, 이름)
    		if (!checkExistData(form.snglLineTitle.value,"한줄글 제목"))
                return false;
            else if(!checkExistData(form.snglLineContent.value,"한줄글 내용"))
            	return false;
			
    		
    		// 유효성 검사 (값, 타입, 이름)
    		/* if (!checkEffectiveness(form.snglLineTitle.value, "string", "singleLine")) {
    			alert("한줄글 제목은 한글만 입력해야합니다!");
    			form.snglLineTitle.value = "";
                form.snglLineTitle.focus();
                return false;
    		} else if(!checkEffectiveness(form.snglLineContent.value, "string", "singleLine")) {
    			alert("한줄글 내용은 한글만 입력해야합니다!");
    			form.snglLineContent.value = "";
                form.snglLineContent.focus();
                return false;
    		} */
    		    		
    		// 등록
            form.submit();
    	}
    </script>