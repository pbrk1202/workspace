<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 	
 	<main role="main">
	    <nav aria-label="breadcrumb">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="/customer/main/list">Home</a></li>
				<li class="breadcrumb-item active" aria-current="page">공지</li>
			</ol>
		</nav>      
	    
		<div class="container">
			        
	        <!-- /.intro-info-wrapper -->    
		    
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
		
	       
		    <!-- table -->
	        <table class="table table-bordered">
	            <thead class="thead-dark">
	                <tr class="text-center">
	                    <th scope="col">No</th>
    					<th scope="col" class="table-mob-hidden">카테고리</th>
	                    <th scope="col">제목</th>
	                    <th scope="col" class="table-mob-hidden">첨부</th>
	                    <th scope="col">일자</th>
	                </tr>               
	            </thead>
	            <tbody>
		            <c:forEach var="item" items="${list}">
	                <tr>
	                    <th scope="row" class="text-center">${item.notice_no}</th>
	                    <td class="table-mob-hidden">${item.code_nm}</td>
	                    <td class="text-left"><a href="detail?no=${item.notice_no}">${item.notice_title}</a></td>	                    
	                    <td class="table-mob-hidden">
		                <c:if test="${!empty item.notice_files}">
	                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-image" viewBox="0 0 16 16">
							  <path d="M6.002 5.5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0z"/>
							  <path d="M2.002 1a2 2 0 0 0-2 2v10a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V3a2 2 0 0 0-2-2h-12zm12 1a1 1 0 0 1 1 1v6.5l-3.777-1.947a.5.5 0 0 0-.577.093l-3.71 3.71-2.66-1.772a.5.5 0 0 0-.63.062L1.002 12V3a1 1 0 0 1 1-1h12z"/>
							</svg>
						</c:if>
						</td>                  
	                    <td class="text-center"><fmt:formatDate pattern="yyyy-MM-dd" value="${item.reg_date}" /></td>    
	                </tr>
	                </c:forEach>
	            </tbody>
	        </table>
	       
	               
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
 	
 	