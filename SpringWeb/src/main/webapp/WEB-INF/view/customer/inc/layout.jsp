<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
        
<!DOCTYPE html>
<html>
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Hello, world!</title>

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="/css/dist/bootstrap.min.css">
        
        <!-- google fonts -->
  		<link rel="preconnect" href="https://fonts.gstatic.com">
		<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;400&display=swap" rel="stylesheet">

        <link href="/css/index.css" rel="stylesheet">
        
        <style>
			* {
				font-family: 'Noto Sans KR', sans-serif;
			}
		</style>
    </head>

    <body>
        
        <!----------------------------- header ----------------------------->

	    <!-- header 부분 -->
		<tiles:insertAttribute name="header" />
	
	    <!----------------------------- main ------------------------------->
	
	    <tiles:insertAttribute name="main" />
	    
	    <!----------------------------- footer ----------------------------->
	
	    <tiles:insertAttribute name="footer" />
          
        <script src="/js/jquery-3.5.1.slim.min.js"></script>
        <script src="/js/dist/bootstrap.bundle.min.js"></script>
	    <script src="/js/common.js"></script>

        <script>
            $('.carousel').carousel({
                interval: 5000
            })
        </script>
    </body>
</html>