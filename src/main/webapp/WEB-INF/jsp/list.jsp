<%@page import="java.util.*,java.text.*"%>
<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title></title>
</head>
<body>
 	 <h1 style="text-align: center;">wr_ssm图书预约系统</h1>
     <table border="1" align="center" width="80%">
     	<tr>
				<td>书名</td>
				<td>数量</td>
				<td></td>
				<td></td>
		</tr>
		<c:forEach items="${list}" var="book">
			<tr>
				<td>${book.name}</td>
				<td>${book.number}</td>
				<td><div style="color: blue;" onclick="detail(${book.bookId})">查看详情</div></td>
				<td><div style="color: blue;" onclick="appoint(${book.bookId})">预约</div></td>
			</tr>
    	</c:forEach>
    </table>
</body>
</html>
<script type="text/javascript">
	function detail(bookId){
	    alert(bookId)
	}
	function appoint(){
		alert(bookId)
	}
</script>