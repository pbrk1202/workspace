<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

	<!-- main -->
    <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4 py-4">

		<div class="container py-4">
		
	        <!-- title -->
	        <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
	            <h1 class="h2">공통코드 보기</h1>
	        </div>
	        
	        <div class="form-row py-2">
	       		<div class="form-group col-md-12">
	            	공통코드를 삭제한 경우, 수정 페이지에서 복구할 수 있습니다.
	            </div>
	        </div>
	
			<form method="post" action="del" enctype="multipart/form-data">
			<input type="hidden" name="groupCd" value="${info.group_cd}">
			<input type="hidden" name="codeCd"  value="${info.code_cd}">
			
				<fieldset disabled>
	        	<div class="form-row">
	                <div class="form-group col-md-6">
	                    <label for="groupCode">그룹코드</label>
	                    <input type="text" class="form-control" id="groupCode" value="${info.group_cd}">
	                </div> 
	                <div class="form-group col-md-6">
	                    <label for="groupName">그룹코드명</label>
	                    <input type="text" class="form-control" id="groupName" value="${info.group_nm}">
	                </div> 
	            </div>
	            
	            <div class="form-row">
	                <div class="form-group col-md-6">
	                    <label for="codeCd">공통코드</label>
	                    <input type="text" class="form-control" id="codeCode" value="${info.code_cd}">
	                </div>
	                <div class="form-group col-md-6">
	                    <label for="codeName">공통코드명</label>
	                    <input type="text" class="form-control" id="codeName" value="${info.code_nm}">
	                </div>
	        	</div>
	            <div class="form-row">
					<div class="form-group col-md-12">
	                    <label for="codeDel">공통코드 삭제여부</label>
	                    <input type="text" class="form-control" id="codeDelNm" value="${info.code_del_nm}">
	                </div> 
	            </div>        	        	
				</fieldset>
				
				<div class="form-row py-4">
					<div class="form-group col-md-12">
					<a class="btn btn-primary  btn-lg" href="list?p=${(empty param.p)?1:param.p}">목록</a>
		            <a class="btn btn-secondary  btn-lg" href="edit?no=${(empty param.p)?1:param.p}&groupCd=${info.group_cd}&codeCd=${info.code_cd}">수정</a>
		        
		            <button type="submit" class="btn btn-secondary btn-lg">삭제</button>
	 	            </div>
		        </div>
	
	        </form>
	        
		</div>

    </main>