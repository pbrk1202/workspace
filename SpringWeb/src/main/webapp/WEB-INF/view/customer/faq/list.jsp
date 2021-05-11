<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	
	<main role="main">
        <nav aria-label="breadcrumb">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="/customer/main/list">Home</a></li>
				<li class="breadcrumb-item active" aria-current="page">FAQ</li>
			</ol>
		</nav>      
            
	    <div class="container">
			<div class="card text-center">
				<div class="card-header">
			   		자주하는 질문
			    </div>
			    <div class="card-body">
			    	<h5 class="card-title">자주하는 질문 페이지 입니다.</h5>
			    	<p class="card-text">원하시는 질문이 없는 경우 다음 페이지로 이동해주세요.</p>
			    	<a href="reg" class="btn btn-primary">질문하기</a>
			  	</div>
			</div>
	
		        
	        <div class="accordion my-4 py-4" id="accordionExample">
	        	<c:forEach var="item" items="${list}" varStatus="status">
	            	<div class="card">
		                <div class="card-header" id="heading${status.count}">
		                <h2 class="mb-0">
		                    <a class="btn btn-link btn-block text-left" type="button" data-toggle="collapse" data-target="#collapse${status.count}" aria-expanded="true" aria-controls="collapse${status.count}">
		                    ${item.faq_title}
		                    </a>
		                </h2>
	               		</div>
	              
		                <div id="collapse${status.count}" class="collapse" aria-labelledby="heading${status.count}" data-parent="#accordionExample">
		                	<div class="card-body">
		                    	${item.faq_content}
		                    </div>
		                </div>
	              	</div>
	             </c:forEach>
	         </div>				  
	     </div>
	
	</main>
	