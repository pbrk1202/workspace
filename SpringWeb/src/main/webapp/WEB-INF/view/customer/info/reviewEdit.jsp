<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<!-- main -->
	<!-- <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4"> -->
	<main role="main">
	<nav aria-label="breadcrumb">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="/customer/main/list">Home</a></li>
			<li class="breadcrumb-item"><a href="/customer/singleLine/list">내 리뷰</a></li>
			<li class="breadcrumb-item active" aria-current="page">내 리뷰 수정</li>
		</ol>
	</nav>
	
	<div class="container">	

        <!-- title -->
        <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
            <h1 class="h2">내 리뷰 수정</h1>
        </div>
		
		<div class="form-row py-2">
       		<div class="form-group col-md-12">
				로그인한 회원분들만 수정할 수 있으며, 본인이 등록한 리뷰만 수정할 수 있습니다.
            </div>
        </div>
        
        <form name="reviewEdit" method="post" action="reviewEdit" enctype="multipart/form-data">
    	<input type="hidden" name="bookReviewNo" value="${info.book_review_no}">
		<input type="hidden" name="groupCd"    value="${groupCd}">
		     
            <div class="form-group">
                <label for="inputContent">리뷰 내용</label>
                <textarea class="form-control" id="inputContent" rows="2" name="bookReviewContent">${info.book_review_content}</textarea>
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
			
			<div class="form-group py-4">
				<a class="btn btn-primary  btn-lg" href="reviewList?p=${(empty param.p)?1:param.p}">목록</a>
	   	        <!-- <button type="submit" class="btn btn-secondary btn-lg">수정</button> -->
	   	        <a class="btn btn-secondary btn-lg" onClick="reviewEditSubmit()">수정</a>
	 	    </div>
	 	     
        </form>
	
	</div>
	
    </main>

    <script>
    	function reviewEditSubmit() {
    		var form = document.reviewEdit;
    		
    		// 공백 체크 (값, 이름)
    		if (!checkExistData(form.bookReviewContent.value,"리뷰 내용"))
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