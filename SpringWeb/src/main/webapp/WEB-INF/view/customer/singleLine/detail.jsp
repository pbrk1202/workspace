<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
    <main role="main">
    	<nav aria-label="breadcrumb">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="/customer/main/list">Home</a></li>
				<li class="breadcrumb-item"><a href="/customer/singleLine/list">한줄글</a></li>
				<li class="breadcrumb-item active" aria-current="page">상세정보</li>
			</ol>
		</nav>
        
        <div class="container">
	        <!-- title -->
	        <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
	            <h1 class="h2">한줄글 보기</h1>
	        </div>
             
			<div class="card">
				<div class="card-header">
					<fmt:formatDate pattern="yyyy-MM-dd" value="${info.reg_date}" />
			</div>
			<div class="card-body">
				<blockquote class="blockquote mb-0">
					<p>${info.sngl_line_content}</p>
				<footer class="blockquote-footer">${info.sngl_line_title} <cite title="Source Title">${info.code_nm}</cite></footer>
				</blockquote>
			</div>
		</div>

		<div class="form-group py-4">
			<a class="btn btn-primary btn-lg" href="list?p=${param.p}&t=${param.t}&q=${param.q}">목록</a>
		    <a class="btn btn-secondary  btn-lg" href="edit?p=${(empty param.p)?1:param.p}&snglLineNo=${info.sngl_line_no}">수정</a>
		</div>
		            
		</div>
    
	</main>	
	
	