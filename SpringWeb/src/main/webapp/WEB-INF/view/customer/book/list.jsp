<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	
	<main role="main">
	    <nav aria-label="breadcrumb">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="/customer/main/list">Home</a></li>
				<li class="breadcrumb-item active" aria-current="page">도서</li>
			</ol>
		</nav> 
		    
		<div class="container">
		    
		    <form method="get" action="list">
		        <div class="form-group">
		            <div class="container">
		                <div class="row justify-content-md-end">
		                    <div class="col col-lg-2 px-1 py-2">
		                        <select id="inputState" name="t" class="form-control">
                                    <option value="0" <c:if test="${0 eq param.t}">selected</c:if>>전체</option>						
			                        <c:forEach var="item" items="${codeList}">
			                        <option value="${item.code_cd}" <c:if test="${item.code_cd eq param.t}">selected</c:if>>${item.code_nm}</option>
			                        </c:forEach>
                                </select>
		                    </div>
		                    <div class="col-md-auto px-1 py-2">
		                        <input type="text" class="form-control" id="inputZip" name="q" value="${param.q}">
		                    </div>
		                    <div class="col col-lg-1 px-1 py-2">
		                        <button type="submit" class="btn btn-primary btn-sg btn-block">검색</button>
		                    </div>
		                </div>
		            </div>
		        </div>
		    </form>
		    		
		    <div class="row row-cols-1 row-cols-md-3">
		    	<c:forEach var="item" items="${list}">
		        <div class="col mb-4">
		            <div class="card h-100">
       		    	<a href="detail?no=${item.book_no}">
       		    		<!-- 값이 비어 있지 않은 경우 -->
	               		<c:if test="${!empty item.book_img_url}">
		            	<img src="/upload/${item.book_img_url}" class="card-img-top" alt="...">
		            	</c:if>
		            	<!-- 값이 비어 있는 경우 -->
	               		<c:if test="${empty item.book_img_url}">
	               		<img src="/images/img_00.jpg" class="card-img-top" alt="...">
	               		</c:if>
		            </a>
		            <div class="card-body">
		                <h5 class="card-title">${item.book_title}</h5>
		                <p class="card-text">${item.book_desc}</p>
		            </div>
		            </div>
		        </div>
		        </c:forEach>
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