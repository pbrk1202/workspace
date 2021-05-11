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
	        
			<form name="groupCodeReg" method="post" action="reg" enctype="multipart/form-data">
				
				<div class="form-row">
	                <div class="form-group col-md-12">
	                    <label for="inputGroupCode">그룹코드</label>
	                    <input type="text" class="form-control" id="inputGroupCode" name="groupCd" value="${param.groupCd}">
	                </div>
	            </div>
	            <div class="form-row">
	                <div class="form-group col-md-12">
	                    <label for="inputGroupCodeName">그룹코드명</label>
	                    <input type="text" class="form-control" id="inputGroupCodeName" name="groupCdNm" value="${param.groupCdNm}">
	                </div>
	            </div>
		
				<div class="form-group py-4">
					<a class="btn btn-primary  btn-lg" href="list?p=${(empty param.p)?1:param.p}">목록</a>
		            <!-- <button type="submit" class="btn btn-secondary btn-lg">등록</button> -->
   		            <a class="btn btn-secondary btn-lg" onClick="groupCodeRegSubmit()">등록</a>
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
    	function groupCodeRegSubmit() {
    		var form = document.groupCodeReg;
    		
    		// 공백 체크 (값, 이름)
    		if (!checkExistData(form.groupCd.value,"그룹코드"))
                return false;
            else if(!checkExistData(form.groupCdNm.value,"그룹코드명"))
            	return false;
			
    		
    		// 유효성 검사 (값, 타입, 이름)
    		if (!checkEffectiveness(form.groupCd.value, "int", "groupCd")) {
    			alert("그룹코드는 숫자 1~4자리로 입력해야합니다!");
    			form.groupCd.value = "";
                form.groupCd.focus();
                return false;
    		}
    		    		
    		// 등록
            form.submit();
    	}
    	
    </script>
    
    
