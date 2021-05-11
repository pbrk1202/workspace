<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	
	<main role="main">
        <nav aria-label="breadcrumb">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="/customer/main/list">Home</a></li>
				<li class="breadcrumb-item active" aria-current="page">내 리뷰</li>
			</ol>
		</nav>      
            
	    <div class="container">
	        	        	
			<c:set var="page" value="${(empty param.p)?1:param.p}" />
			<c:set var="startNum" value="${page-(page-1)%5}" />
			<c:set var="lastNum" value="${fn:substringBefore(Math.ceil(count/10), '.')}" />

	        <table class="table table-bordered">
	            <thead class="thead-dark">
	                <tr class="text-center">
	                    <th scope="col">No</th>
	                    <th scope="col">도서</th>
	                    <th scope="col">리뷰</th>
	                </tr>
	            </thead>
	            <tbody>
	            
	            <!-- 값이 비어 있는 경우 -->
	            <c:if test="${empty reviewList}">
	            	<tr>
		            	 <th scope="row" class="text-center" colspan="3">작성하신 리뷰가 없습니다.</th>
	            	</tr>
	            </c:if>
	            <c:forEach var="item" items="${reviewList}">
	            <tr>
	                 <th scope="row" class="text-center">${item.book_review_no}</th>
	                 <td>${item.book_title}</th>
	                 <td><a href="reviewEdit?bookNo=${item.book_no}&bookReviewNo=${item.book_review_no}&p=${param.p}">${item.book_review_content}</a></td>
	            </tr>
	            </c:forEach>
	            </tbody>
	        </table>
	       
	        		
	        <div class="row py-2">
			    <div class="col-auto mr-auto">${(empty param.p)?1:param.p} / ${lastNum} pages</div>
			</div>			    
			
			<!-- pageing -->
		  <nav aria-label="Page navigation example">
		      <ul class="pagination justify-content-center py-4">
		      	<c:if test="${startNum>1}">
					<li class="page-item">
					    <a class="page-link" href="?p=${startNum-1}&t=${param.t}&q=${param.q}">이전</a>
					</li>
				</c:if>
				<c:if test="${startNum<=1}"> 
					<li class="page-item disabled">
						<span class="page-link" tabindex="-1" aria-disabled="true" onclick="alert('이전 페이지가 없습니다.');">이전</a>
					</span>						
				</c:if>
					
				<c:forEach var="i" begin="0" end="4">					
					<c:if test="${(startNum+i) <= lastNum}">
					<li class="page-item"><a class="page-link" href="?p=${startNum+i}&t=${param.t}&f=${param.f}&q=${param.q}">${startNum+i}</a></li>
					</c:if>					
				</c:forEach>
				
				<c:if test="${startNum+4<lastNum}">
					<li class="page-item">
					    <a class="page-link" href="?p=${startNum+5}&t=${param.t}&q=${param.q}">다음</a>
					</li>
				</c:if>
				<c:if test="${startNum+4>=lastNum}">
					<li class="page-item disabled">
					    <span class="page-link" onclick="alert('다음 페이지가 없습니다.');">다음</span>
					</li>
				</c:if>
				</ul>
			</nav>
				  
	     </div>
	
	</main>
	