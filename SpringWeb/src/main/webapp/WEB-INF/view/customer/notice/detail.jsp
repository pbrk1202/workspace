<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
    	<main role="main">
         	<nav aria-label="breadcrumb">
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="/customer/main/list">Home</a></li>
					<li class="breadcrumb-item"><a href="/customer/notice/list">공지</a></li>
					<li class="breadcrumb-item active" aria-current="page">상세정보</li>
				</ol>
			</nav>   
            <div class="container">              
		                
                <!-- title -->
		        <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
		            <h1 class="h2">공지 보기</h1>
		        </div>
               
                <ul class="list-group">
                    <li class="list-group-item">
                        <div class="form-group row">
                            <div class="col-sm-2">제목</div>
                            <div class="col-sm-10">${info.notice_title}</div>
                        </div>
                    </li>
                    <li class="list-group-item">
                        <div class="form-group row">
                            <div class="col-sm-2">파일</div>
                            <!-- 값이 비어 있지 않은 경우 -->
		               		<c:if test="${!empty info.notice_files}">
                            <c:forTokens var="fileName" items="${info.notice_files}" delims="," varStatus="st">
                            <div class="col-sm-5">
								<c:set var="style" value="" />
								<c:if test="${fn:endsWith(fileName, '.zip') }">
									<c:set var="style" value="font-weight: bold; color:red;" />
								</c:if>
								<a download href="/upload/${fileName}" style="${style}">${fn:toUpperCase(fileName)}</a>
								<%-- <a href="../../../upload/${fileName}" style="${style}">${fn:toUpperCase(fileName)}</a> --%>
								<c:if test="${!st.last}">
								<!-- / -->
								</c:if>
							</div>
							</c:forTokens>	
							</c:if>
							<!-- 값이 비어 있지 않은 경우 -->
	               			<c:if test="${empty info.notice_files}">
	               				<div class="col-sm-5">
	               					등록된 파일이 없습니다.
	               				</div>
	               			</c:if>
                        </div>
                    </li>
                    <li class="list-group-item">
                        <div class="form-group row">
                            <div class="col-sm-2">내용</div>
                            <div class="col-sm-10">${info.notice_content}</div>
                        </div>
                    </li>
                </ul>
                <div class="form-group py-4">
	                <a class="btn btn-primary btn-lg" href="list?p=${param.p}&t=${param.t}&q=${param.q}">목록</a>
                </div>
            </div>
    
		</main>	
	
	