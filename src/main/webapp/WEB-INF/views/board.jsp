<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />">
<script src="<c:url value="/resources/js/jquery-3.2.1.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<title>Insert title here</title>
<link rel="shortcut icon" href="/favicon.ico"/>

</head>
<body>
<h1>${msg}</h1>
<a href="5/">5번 게시물 상세보기</a><br/>
<a href="4/">4번 게시물 상세보기</a><br/>
<a href="3/">3번 게시물 상세보기</a><br/>
<a href="2/">2번 게시물 상세보기</a><br/>
<a href="1/">1번 게시물 상세보기</a><br/>
<hr/>
<a href="insert">게시물 입력</a>
</body>
</html>