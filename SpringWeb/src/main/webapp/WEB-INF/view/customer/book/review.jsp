<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	
	<main role="main">
	    <nav aria-label="breadcrumb">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="/customer/main/list">Home</a></li>
				<li class="breadcrumb-item"><a href="/customer/book/list">도서</a></li>
				<li class="breadcrumb-item active" aria-current="page">리뷰</li>
			</ol>
		</nav>
		    
		<div class="container">
		    
		    <!-- title -->
	        <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
	            <h1 class="h2">리뷰 작성</h1>
	        </div>
		    
		    <div class="form-row py-2">
	       		<div class="form-group col-md-12">
					도서의 리뷰를 작성할 수 있습니다.
	            </div>
	        </div>
	        
	        <form name="reviewReg" method="post" action="reviewReg" enctype="multipart/form-data">
	    	<input type="hidden" name="bookNo"    value="${param.no}">
	    				     
	            <div class="form-group">
	                <label for="inputContent">리뷰 내용</label>
	                <textarea class="form-control" id="inputContent" rows="2" name="bookReviewContent"></textarea>
	            </div>
							
				<div class="form-group py-4">
					<a class="btn btn-primary  btn-lg" href="detail?p=${(empty param.p)?1:param.p}&no=${param.no}">목록</a>
		   	        <!-- <button type="submit" class="btn btn-secondary btn-lg">등록</button> -->
		   	        <a class="btn btn-secondary btn-lg" onClick="reviewRegSubmit()">등록</a>
		 	    </div>
		 	     
	        </form>
	
		</div>
		   
		    
		    <div class="container">
                
                <!-- 값이 비어 있지 않은 경우 -->
                <c:if test="${!empty reviewList}">
					<div class="tab-content py-4" id="myTabContent">                   
	                    <div class="list-group">
	 	                    <c:forEach var="item" items="${reviewList}">
	                        <a href="#" class="list-group-item list-group-item-action">
	                            <div class="d-flex w-100 justify-content-between">
	                                <h5 class="mb-1">${info.book_title}</h5>
	                                <small><fmt:formatDate pattern="yyyy-MM-dd" value="${item.reg_date}" /></small>
	                            </div>
	                            <p class="mb-1">${item.book_review_content}</p>
	                            <small>${item.reg_nm} 독자님께서 작성해주신 리뷰 입니다.</small>
	                        </a>
	                        </c:forEach>
	                    </div>
	                    
	                </div>
					
	   			    
		            <c:set var="page" value="${(empty param.p)?1:param.p}" />
					<c:set var="startNum" value="${page-(page-1)%5}" />
					<c:set var="lastNum" value="${fn:substringBefore(Math.ceil(count/10), '.')}" />
				    
				    <div class="row py-2">
					    <div class="col-auto mr-auto">
						    ${(empty param.p)?1:param.p} / ${lastNum} pages
					    </div>
				    </div>
	
				    <!-- pageing -->
			        <nav aria-label="Page navigation example">
			            <ul class="pagination justify-content-center py-4">
				            <c:if test="${startNum>1}">
			                <li class="page-item disabled">
			                    <a class="page-link" href="?p=${startNum-1}&t=${param.t}&q=${param.q}" tabindex="-1" aria-disabled="true">이전</a>
			                </li>
		  	                </c:if>
		  	                <li class="page-item disabled">
		  	                	<span class="page-link" tabindex="-1" aria-disabled="true" onclick="alert('이전 페이지가 없습니다.');">이전</a>
		  	                </span>
			                <c:if test="${startNum<=1}">  
			                </c:if>
							
							<c:forEach var="i" begin="0" end="4">
							<c:if test="${(startNum+i) <= lastNum}">
								<li class="page-item"><a class="page-link" href="?p=${startNum+i}&t=${param.t}&f=${param.f}&q=${param.q}&no=${param.no}">${startNum+i}</a></li>
							</c:if>
			                
			                </c:forEach>
			                
			                <c:if test="${startNum+4<lastNum}">
			                <li class="page-item">
			                    <a class="page-link" href="?p=${startNum+5}&t=${param.t}&q=${param.q}">다음</a>
			                </li>
			                </c:if>
			                <c:if test="${startNum+4>=lastNum}">
			                <li class="page-item">
			                    <span class="page-link" onclick="alert('다음 페이지가 없습니다.');">다음</span>
			                </li>
			                </c:if>
			            </ul>
			        </nav>
				</c:if>
				
				<!-- 값이 비어 있을 경우 -->
				<c:if test="${empty reviewList}">
					<p class="py-4">
						데이터가 존재하지 않습니다.
					</p>				
				</c:if>
                
                  
            </div>
        	
    	</div>    
 
	</main>
		
	<script>
    	function reviewRegSubmit() {
    		var form = document.reviewReg;
    		
    		// 공백 체크 (값, 이름)
    		if (!checkExistData(form.bookReviewContent.value,"리뷰 내용"))
                return false;
    		    		
    		// 등록
            form.submit();
    	}
    </script>