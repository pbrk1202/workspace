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
	            <h1 class="h2">공통코드 수정</h1>
	        </div>
	
			<form name="codeEdit" method="post" action="edit" enctype="multipart/form-data">
			<input type="hidden" name="groupCd" value="${info.group_cd}">
			<input type="hidden" name="codeCd" value="${info.code_cd}">
	
	            <%-- <div class="form-row">
	                <div class="form-group col-md-12">
	                    <label for="selectGroupCode">그룹코드</label>
	                    <select id="selectGroupCode" class="form-control" name="groupCd">
							<c:forEach var="item" items="${groupCodeList}">
				            <option value="${item.group_cd}" <c:if test="${item.group_cd eq info.group_cd}">selected</c:if>>${item.group_cd_nm}</option>
			                </c:forEach>
	                    </select>
	                </div>  
	            </div> --%>     
	            <fieldset disabled>       
	            <div class="form-row">
	                <div class="form-group col-md-6">
	                    <label for="inputGroupCode">그룹코드</label>
	                    <input type="text" class="form-control" id="inputGroupCode" value="${info.group_cd}">
	                </div>
	                <div class="form-group col-md-6">
	                    <label for="inputGroupCodeName">그룹코드명</label>
	                    <input type="text" class="form-control" id="inputGroupCodeName" value="${info.group_nm}">
	                </div>
	            </div>  
	            <div class="form-row">
	                <div class="form-group col-md-12">
	                    <label for="inputCode">공통코드</label>
	                    <input type="text" class="form-control" id="inputCode" name="codeCd" value="${info.code_cd}">
	                </div>
	            </div>
	            </fieldset>
	            <div class="form-row">
	                <div class="form-group col-md-6">
	                    <label for="inputName">공통코드명</label>
	                    <input type="text" class="form-control" id="inputName" name="codeNm" value="${info.code_nm}">
	                </div>
					<div class="form-group col-md-6">
						<c:choose>
							<c:when test="${info.code_del eq true}"> <c:set var="codeDel1" value="1" /> </c:when>
							<c:when test="${info.code_del eq false}"> <c:set var="codeDel1" value="0" /> </c:when>
							<c:otherwise> <c:set var="codeDel1" value="0" /> </c:otherwise>
						</c:choose>
	                    <label for="selectCodeDel">공통코드 삭제여부</label>
	                    <select id="selectCodeDel" class="form-control" name="codeDel">
							<c:forEach var="item" items="${delCodeList}">
				            <option value="${item.code_cd}" <c:if test="${item.code_cd eq codeDel1}">selected</c:if>>${item.code_nm}</option>
			                </c:forEach>
	                    </select>
	                </div> 
	            </div> 
			
				<div class="form-row py-4">
					<div class="form-group col-md-12">
						<a class="btn btn-primary  btn-lg" href="list?p=${(empty param.p)?1:param.p}">목록</a>
	    	    	    <!-- <button type="submit" class="btn btn-secondary btn-lg">수정</button> -->
	   		            <a class="btn btn-secondary btn-lg" onClick="codeEditSubmit()">수정</a>
		            </div>
	            </div>
	        </form>
	
		</div>

    </main>
    
    <script>
    	function codeEditSubmit() {
    		var form = document.codeEdit;
    		
    		// 공백 체크 (값, 이름)
    		if(!checkExistData(form.codeNm.value,"공통코드명"))
            	return false;
			    		
    		    		
    		// 등록
            form.submit();
    	}
    	
    </script>
	