<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 관리</title>
<link rel="stylesheet" type="text/css" href="css/shopping.css"></link>
<script type="text/javascript" src="script/product.js"></script>
</head>
<body>
<div id="wrap" align="center">
<h1>상품 리스트 -관리자 페이지 </h1>
<table class="list">
	<tr>
	<td colspan="5" style="border: white; text-align:right" >
	<a href="ProductAddHandler">상품 등록</a>
	</td>
	</tr>
	
	<tr><th>번호</th><th>이름</th><th>가격</th><th>수정</th><th>삭제</th></tr>
	
	<c:forEach var="product" items="${list}">
	<tr class="record">
		<td>${product.code }</td>
		<td>${product.name }</td>
		<td>${product.price} 원</td>
		
		<td>
			<a href="ProductUpdateHandler?code=${product.code}">상품 수정</a>
		</td>
		<td>
			<a href="ProductDeleteHandler?code=${product.code}">상품 삭제</a>
		</td>
	
	</c:forEach>
</table>
</div>
</body>
</html>