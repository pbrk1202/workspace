<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>    
   
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>PBOOK 관리자</title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/css/dist/bootstrap.min.css">
    
    <!-- google fonts -->
    <link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;400&display=swap" rel="stylesheet">

    <!-- 관리자 -->
    <link href="/css/admin/dashboard.css" rel="stylesheet">

	<style>
	
		* {
			font-family: 'Noto Sans KR', sans-serif;
		}
		
		
		@media screen and (max-width: 768px) { 
			.table-mob-hidden {
				display: none;
			}
		
		}
	</style>
</head>
<body>
    
    <!-- header 부분 -->
	<tiles:insertAttribute name="header" />
		
    <!-- menu -->
    <div class="container-fluid">
        <div class="row">	
        
			<tiles:insertAttribute name="aside" />
	      
	        <!-- --------------------------- main --------------------------------------- -->
			<tiles:insertAttribute name="main" />

        </div>

    </div>

    <script src="/js/jquery-3.5.1.slim.min.js"></script>
    <script src="/js/dist/bootstrap.bundle.min.js"></script>
    <script src="/js/common.js"></script>
  
    </body>
</html>