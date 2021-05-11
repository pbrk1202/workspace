<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<!-- main -->
    <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4 py-4">

		<div class="container py-4">
		
	        <!-- title -->
	        <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
	            <h1 class="h2">공통코드 등록</h1>
	        </div>
			
			<div class="form-row py-2">
	       		<div class="form-group col-md-12">
	            	공통코드를 이용하여, 콘텐츠를 카테고리별로 구분 지어 제공할 수 있도록 합니다. 공통코드를 등록하기 전에 그룹코드를 등록하세요 (그룹코드 > 공통코드)
	            </div>
	        </div>
	        
			<form name="codeReg" method="post" action="reg" enctype="multipart/form-data">
	
	            <div class="form-row">
	                <div class="form-group col-md-4">
	                    <label for="selectGroupCode">그룹코드</label>
	                    <select class="form-control" id="selectGroupCode" name="groupCd">	
		                	<c:forEach var="item" items="${groupCodeList}">
		                	<option value="${item.group_cd}" <c:if test="${item.group_cd eq param.groupCd}">selected</c:if>>${item.group_cd_nm}</option>
		                	</c:forEach>
			            </select>
	                </div>  
	                <div class="form-group col-md-4">
	                    <label for="inputCodeCd">공통코드</label>
	                    <input type="text" class="form-control" id="inputCodeCd" name="codeCd" value="${param.codeCd}">
	                </div>
	                <div class="form-group col-md-4">
	                    <label for="inputCodeName">공통코드명</label>
	                    <input type="text" class="form-control" id="inputCodeName" name="codeNm" value="${param.codeNm}">
	                </div>
	            </div>
				
				<div class="form-group py-4">
					<a class="btn btn-primary  btn-lg" href="list?p=${(empty param.p)?1:param.p}">목록</a>
	            	<!-- <button type="submit" class="btn btn-secondary btn-lg">등록</button> -->
	            	<a class="btn btn-secondary btn-lg" onClick="codeRegSubmit()">등록</a>
	            </div>
	            
	        </form>
	
		</div>

    </main>
    
    <!-- 중복 체크 -->
	<c:if test="${!empty param.overlap}">
    <script>
    	alert("작성하신 공통코드가 이미 등록되어 있습니다. 다른 그룹코드로 등록해주세요.");
    </script>
    </c:if>
    
    <script>
    	function codeRegSubmit() {
    		var form = document.codeReg;
    		
    		// 공백 체크 (값, 이름)
    		if (!checkExistData(form.codeCd.value,"공통코드"))
                return false;
            else if(!checkExistData(form.codeNm.value,"공통코드명"))
            	return false;
			
    		
    		// 유효성 검사 (값, 타입, 이름)
    		if (!checkEffectiveness(form.codeCd.value, "int", "codeCd")) {
    			alert("공통코드는 숫자 1~3자리로 입력해야합니다!");
    			form.codeCd.value = "";
                form.codeCd.focus();
                return false;
    		}
    		    		
    		// 등록
            form.submit();
    	}
    	
    </script>
