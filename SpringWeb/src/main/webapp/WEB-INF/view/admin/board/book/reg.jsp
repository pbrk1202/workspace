<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<!-- main -->
	<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4 py-4">
		
		<div class="container py-4">
		
	        <!-- title -->
	        <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
	            <h1 class="h2">도서 등록</h1>
	        </div>
			
			<div class="form-row py-2">
	       		<div class="form-group col-md-12">
	            	도서를 등록 할 수 있습니다. 도서 이미지 첨부 시, 확장자를 확인하세요. ( gif, png, jpg, jpeg ) 
	            </div>
	        </div>
	        
	        <form method="post" action="reg" enctype="multipart/form-data">
			<input type="hidden" name="groupCd" value="${groupCd}">
	
				<div class="form-row">
			       <div class="form-group col-md-6">
			           <label for="inputTitle">도서 제목</label>
			           <input type="text" class="form-control" id="inputTitle" name="bookTitle">
			       </div>             
			       <div class="form-group col-md-6">
			           <div class="form-group">
			               <label for="selectCodeCd">도서 타입</label>
			               <select class="form-control" id="selectCodeCd" name="codeCd">	
					        	<c:forEach var="item" items="${codeList}">
					        	<option value="${item.code_cd}">${item.code_nm}</option>
					        	</c:forEach>
					       </select>
			            </div>
			       </div>	         
				 </div>
				 <div class="form-row">
			        <div class="form-group col-md-12">
			            <label for="inputImg">도서 이미지 첨부</label>
			            <input type="file" class="form-control-file" id="inputImg" name="file">
			        </div>     
				 </div>    
			     <div class="form-row">
			        <div class="form-group col-md-6">
			            <label for="inputPublisher">출판사</label>
			            <input type="text" class="form-control" id="inputPublisher" name="bookPublisher">
			        </div>
			        <div class="form-group col-md-6">
			            <label for="inputPubDate">발행년도</label>
			            <input type="text" class="form-control" id="inputPubDate" name="bookPubDate">
			        </div>
			     </div>           
		                  
		            <div class="form-group">
		               <label for="inputDesc">도서 소개</label>
		               <textarea class="form-control" id="inputDesc" rows="3" name="bookDesc"></textarea>
		            </div>
		            <div class="form-row">
		               <div class="form-group col-md-12">
		                   <label for="inputAuthor">저자</label>
		                   <input type="text" class="form-control" id="inputAuthor" name="bookAuthor">
		               </div>
		            </div>
		            <div class="form-group">
		               <label for="inputAuthorDesc">저자 소개</label>
		               <textarea class="form-control" id="inputAuthorDesc" rows="3" name="bookAuthorDesc"></textarea>
		            </div>
				
				 <div class="form-group py-4">
					<a class="btn btn-primary  btn-lg" href="list?p=${(empty param.p)?1:param.p}">목록</a>
		   	        <button type="submit" class="btn btn-secondary btn-lg">등록</button>
		 	     </div>
		 	     
	        </form>
	
	   </div>

    </main>
