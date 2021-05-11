<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<!-- main -->
	<!-- <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4"> -->
	<main role="main">
	
	<div class="container">	
        <!-- title -->
        <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
            <h1 class="h2">질문 등록</h1>
        </div>
		
		<div class="form-row py-2">
       		<div class="form-group col-md-12">
				로그인한 회원분들만 작성할 수 있으며, 한번 등록된 질문은 삭제되지 않습니다. 자신의 질문만 볼 수 있습니다.
            </div>
        </div>
        
        <form name="faqReg" method="post" action="reg" enctype="multipart/form-data">
    	
			<div class="form-row">
		       <div class="form-group col-md-6">
		           <label for="inputTitle">질문 제목</label>
		           <input type="text" class="form-control" id="inputTitle" name="faqTitle" value="${param.faqTitle}">
		       </div>             
		       <div class="form-group col-md-6">
		           <div class="form-group">
		               <label for="selectCodeCd">질문 타입</label>
		               <select class="form-control" id="selectCodeCd" name="codeCd">	
				        	<c:forEach var="item" items="${codeList}">
				        	<option value="${item.code_cd}" <c:if test="${item.group_cd eq param.groupCd}">selected</c:if>>${item.code_nm}</option>
				        	</c:forEach>
				       </select>
		            </div>
		       </div> 
			</div>
		     
            <div class="form-group">
                <label for="inputContent">질문 내용</label>
                <textarea class="form-control" id="inputContent" rows="2" name="faqContent" value="${param.faqContent}"></textarea>
            </div>
						
			<div class="form-group py-4">
				<a class="btn btn-primary  btn-lg" href="list?p=${(empty param.p)?1:param.p}">목록</a>
	   	        <!-- <button type="submit" class="btn btn-secondary btn-lg">등록</button> -->
	   	        <a class="btn btn-secondary btn-lg" onClick="faqRegSubmit()">등록</a>
	 	    </div>
	 	     
        </form>

	</div>
	
    </main>
    
    <script>
    	function faqRegSubmit() {
    		var form = document.faqReg;
    		
    		// 공백 체크 (값, 이름)
    		if (!checkExistData(form.faqTitle.value,"질문 제목"))
                return false;
            else if(!checkExistData(form.faqContent.value,"질문 내용"))
            	return false;
			
    		    		
    		// 등록
            form.submit();
    	}
    </script>
