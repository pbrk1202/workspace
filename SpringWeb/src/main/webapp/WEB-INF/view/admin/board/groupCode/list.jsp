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
	            <h1 class="h2">그룹코드 관리</h1>
	        </div>
	        
	        <!-- table -->
	        <table class="table table-bordered">
	            <thead>
	                <tr>
	                    <th scope="col">코드</th>
	                    <th scope="col">그룹코드명</th>          
	                    <th scope="col">삭제여부</th>
	                    <th scope="col" class="table-mob-hidden">작성일</th>
	                </tr>               
	            </thead>
	            <tbody>
		            <c:forEach var="item" items="${list}">
	                <tr>
	                    <th scope="row"><a href="detail?groupCd=${item.group_cd}">${item.group_cd}</a></th>
	                    <td><a href="edit?groupCd=${item.group_cd}">${item.group_cd_nm}</th>
	                    <td>${item.group_del_nm}</td>
	                    <td class="table-mob-hidden"><fmt:formatDate pattern="yyyy-MM-dd" value="${item.reg_date}" /></td>
	                </tr>
	                </c:forEach>
	            </tbody>
	        </table>
	               
	        <c:set var="page" value="${(empty param.p)?1:param.p}" />
			<c:set var="startNum" value="${page-(page-1)%5}" />
			<c:set var="lastNum" value="${fn:substringBefore(Math.ceil(count/10), '.')}" />
		    
		    <div class="row py-2">
			    <div class="col-auto mr-auto">${(empty param.p)?1:param.p} / ${lastNum} pages</div>
			    <div class="col-auto">
					<a class="btn btn-primary  btn-lg" href="reg?p=${(empty param.p)?1:param.p}">등록</a>
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
