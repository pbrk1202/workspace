<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
   
	<main role="main">
		<nav aria-label="breadcrumb">
			<ol class="breadcrumb">
				<li class="breadcrumb-item active" aria-current="page">Home</li>
			</ol>
		</nav>
        	
      	<div class="container">
      
           <div id="carouselExampleCaptions" class="carousel slide my-4" data-ride="carousel">
           
               <div class="rounded carousel-inner">
                   <div class="carousel-item active">
                       <img src="/images/slide06.jpg" class="d-block w-100" alt="...">
                       <div class="carousel-caption d-none d-md-block">
                           <h5 class="py-4"><span class="slide-text-2">도서</span></h5>
                           <p>관심있는 도서를 찾아서 리뷰를 작성해주세요.</p>
                       </div>
                   </div>
                   <div class="carousel-item">
                       <img src="/images/slide07.jpg" class="d-block w-100" alt="...">
                       <div class="carousel-caption d-none d-md-block">
                           <h5 class="py-4"><span class="slide-text-3">한 줄 글</span></h5>
                           <p>자신에게 글을 남기고, 매일 확인하세요.</p>
                       </div>
                   </div>
                   <div class="carousel-item">
                       <img src="/images/slide08.jpg" class="d-block w-100" alt="...">
                       <div class="carousel-caption d-none d-md-block">
                           <h5 class="py-4"><span class="slide-text-2">공지</span></h5>
                           <p>업데이트 사항 및 사이트에 대해 확인하세요.</p>
                       </div>
                   </div>
               </div>
               <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
                   <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                   <span class="sr-only">이전</span>
               </a>
               <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
                   <span class="carousel-control-next-icon" aria-hidden="true"></span>
                   <span class="sr-only">다음</span>
               </a>
         	</div>
      	</div>
        <div class="container pt-0">
           <!-- /.slide -->
           <div class="alert alert-primary my-4" role="alert">
               인기도서 │ <a href="/customer/book/list" class="alert-link">바로가기</a>
           </div>
	
           <div class="card-deck">
	           <c:forEach var="item" items="${bookList}">
               <div class="card">
               	   <!-- 값이 비어 있지 않은 경우 -->
             	   <c:if test="${!empty item.book_img_url}">
                   <img src="/upload/${item.book_img_url}" class="card-img-top" alt="...">
                   </c:if>
                   <!-- 값이 비어 있는 경우 -->
             	   <c:if test="${empty item.book_img_url}">
             	   <img src="/images/img_00.jpg" class="card-img-top" alt="...">
             	   </c:if>
                   <div class="card-body">
                       <h5 class="card-title">${item.book_title}</h5>
                       <p class="card-text">${item.book_desc} </p>
                       <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
                   </div>
               </div>
               </c:forEach>
           </div>
           <!-- /.인기도서 -->

           <div class="alert alert-primary my-4" role="alert">
               한줄평 │ <a href="/customer/singleLine/list" class="alert-link">바로가기</a>
           </div>

           <div class="accordion my-4" id="accordionExample">
	           <c:forEach var="item" items="${singleLineList}" varStatus="status">
               <div class="card">
                   <div class="card-header" id="heading${status.count}">
                   <h2 class="mb-0">
                       <a class="btn btn-link btn-block text-left" type="button" data-toggle="collapse" data-target="#collapse${status.count}" aria-expanded="true" aria-controls="collapse${status.count}">
                       ${item.sngl_line_title}
                       </a>
                   </h2>
                   </div>
               
                   <div id="collapse${status.count}" class="collapse" aria-labelledby="heading${status.count}" data-parent="#accordionExample">
                       <div class="card-body">
                           ${item.sngl_line_content}
                       </div>
                   </div>
               </div>
               </c:forEach>
           </div>
           <!-- /.도서리뷰 -->
    	</div>
    
	</main>