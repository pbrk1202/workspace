<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<!-- main -->
    <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4 py-4">

		<div class="container py-4">
		
	        <!-- title -->
	        <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
	            <h1 class="h2">그룹코드 등록</h1>
	        </div>
			
			<div class="form-row py-2">
	       		<div class="form-group col-md-12">
	            	그룹코드를 이용하여, 콘텐츠를 카테고리별로 구분 지어 제공할 수 있도록 합니다. 코드는 자동으로 등록되므로, 코드명을 작성하세요.
	            </div>
	        </div>
	        
			<form name="groupCodeEdit" method="post" action="edit" enctype="multipart/form-data">
			<input type="hidden" name="groupCd" value="${info.group_cd}">	
				
				<fieldset disabled> 
				<div class="form-row">
	                <div class="form-group col-md-12">
	                    <label for="inputGroupCode">그룹코드</label>
	                    <input type="text" class="form-control" id="inputGroupCode" value="${info.group_cd}">
	                </div>
	            </div>
	            </fieldset>
	            <div class="form-row">
	                <div class="form-group col-md-6">
	                    <label for="inputGroupCodeName">그룹코드명</label>
	                    <input type="text" class="form-control" id="inputGroupCodeName" name="groupCdNm" value="${info.group_cd_nm}">
	                </div>
	                <div class="form-group col-md-6">
						<c:choose>
							<c:when test="${info.group_del eq true}"> <c:set var="groupDel1" value="1" /> </c:when>
							<c:when test="${info.group_del eq false}"> <c:set var="groupDel1" value="0" /> </c:when>
							<c:otherwise> <c:set var="groupDel1" value="0" /> </c:otherwise>
						</c:choose>
	                    <label for="selectGroupDel">공통코드 삭제여부</label>
	                    <select id="selectGroupDel" class="form-control" name="groupDel">
							<c:forEach var="item" items="${delCodeList}">
				            <option value="${item.code_cd}" <c:if test="${item.code_cd eq groupDel1}">selected</c:if>>${item.code_nm}</option>
			                </c:forEach>
	                    </select>
	                </div>
	            </div>
				
				<div class="form-group py-4">
					<a class="btn btn-primary  btn-lg" href="list?p=${(empty param.p)?1:param.p}">목록</a>
		            <!-- <button type="submit" class="btn btn-secondary btn-lg">수정</button> -->
		            <a class="btn btn-secondary btn-lg" onClick="groupCodeEditSubmit()">수정</a>
		        </div>
	        </form>
	
		</div>

    </main>
    
    
    <!-- 중복 체크 -->
	<c:if test="${!empty param.overlap}">
    <script>
    	alert("작성하신 그룹코드가 이미 등록되어 있습니다. 다른 그룹코드로 등록해주세요.");
    </script>
    </c:if>
    
    <script>
    	function groupCodeEditSubmit() {
    		var form = document.groupCodeEdit;
    		
    		// 공백 체크 (값, 이름)
    		if(!checkExistData(form.groupCdNm.value,"그룹코드명"))
            	return false;
    

    		// 등록
            form.submit();
    	}
    	
    </script>
