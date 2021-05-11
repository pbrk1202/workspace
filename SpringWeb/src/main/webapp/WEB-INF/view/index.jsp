<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!doctype html>
<html lang="en">
    <head>
	    <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>PBOOKS</title>

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="/css/dist/bootstrap.min.css">

        <!-- Custom styles for this template -->
        <link href="/css/signin.css" rel="stylesheet">

    </head>

    <body class="text-center">
        <form method="post" action="/customer/main/login" class="form-signin">
            <img class="mb-4" src="/images/favicon/read_64.png" alt="" width="72" height="72">
            <h1 class="h3 mb-3 font-weight-normal">PBOOKS</h1>
            <label for="inputId" class="sr-only">아이디</label>
            <input type="text" id="inputId" name="memberId" class="form-control" placeholder="아이디" value="pbrk" required autofocus>
            <label for="inputPassword" class="sr-only">비밀번호</label>
            <input type="password" id="inputPassword" name="memberPwd" class="form-control" placeholder="비밀번호" value="0000" required>
            <!-- <div class="checkbox mb-3">
                <label>
                    <input type="checkbox" value="remember-me"> 아이디 저장
                </label>
            </div> -->
            
            <div class="py-4">
	            <button class="btn btn-lg btn-primary btn-block" type="submit">로그인</button>
	            <a class="btn btn-lg btn-primary btn-block" href="/customer/main/list">WEB 로그인</a>
	            <a class="btn btn-lg btn-primary btn-block" href="/admin/board/book/list">ADMIN 로그인</a>
	            <!-- <button class="btn btn-lg btn-primary btn-block" type="submit">로그인</button> -->
	            <p class="mt-5 mb-3 text-muted">&copy; 2021-2021</p>
			</div>
        </form>

        <!-- 파일 경로 : D:\Work\workspace2\SpringWeb\src\main\webapp\upload -->

        <script src="js/jquery-3.5.1.slim.min.js"></script>
        <script src="js/dist/bootstrap.bundle.min.js"></script>
           
        <!-- 값이 비어 있지 않은 경우 -->
		<c:if test="${!empty result}">
        <script>
        	alert("${result}");        
        </script>     
      	</c:if>
    </body>
</html>   
