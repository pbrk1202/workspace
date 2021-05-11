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
	            <h1 class="h2">공지사항 등록</h1>
	        </div>
			
			<div class="form-row py-2">
	       		<div class="form-group col-md-12">
	            	공지사항을 등록 할 수 있습니다. 파일첨부는 최대 2개까지 가능하고 300mb까지 저장됩니다.
	            </div>
	        </div>
	        
	        <form method="post" action="reg" enctype="multipart/form-data">
			<input type="hidden" name="groupCd" value="${groupCd}">
	
				<div class="form-row">
			       <div class="form-group col-md-12">
			           <label for="inputTitle">공지제목 제목</label>
			           <input type="text" class="form-control" id="inputTitle" name="noticeTitle">
			       </div>   
			    </div>
			    <div class="form-row">          
			       <div class="form-group col-md-12">
			           <div class="form-group">
			               <label for="selectCodeCd">공지 타입</label>
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
			            <label for="inputImg1">파일첨부</label>
			            <input type="file" class="form-control-file" id="inputImg1" name="file">
			        </div>   
			        <div class="form-group col-md-6">
			        	<label for="inputImg2">파일첨부</label>
			            <input type="file" class="form-control-file" id="inputImg2" name="file">
			        </div>   
				 </div>    
			     
	             <div class="form-group">
	                <label for="inputContent">공지 내용</label>
	                <textarea class="form-control" id="inputContent" rows="3" name="noticeContent"></textarea>
	             </div>
		           
				
				 <div class="form-group py-4">
					<a class="btn btn-primary  btn-lg" href="list?p=${(empty param.p)?1:param.p}">목록</a>
		   	        <button type="submit" class="btn btn-secondary btn-lg">등록</button>
		 	     </div>
		 	     
	        </form>
		
		</div>
		
    </main>
	    