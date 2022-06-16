<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin 로그인성공화면</title>
<style type="text/css">
h1 {
	text-align: center;
}
table{
	border: 1px solid;
	margin : 0 auto;
}
</style>
<script type="text/javascript">
	var msg = "${msg}";
	if (msg != "") {
		alert(msg);
	}
</script>
</head>
<body>
	<h1>Admin 환영합니다</h1>
	<table>
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>AGE</th>
			<th>ADDRESS</th>
			<th>ACTION</th>
		</tr>
		<tr>
			<c:if test="${empty list}">
				<td colspan="4">데이터없음</td>
			</c:if>
		</tr>
		<tr>
			<c:if test="${!empty list}">
				<c:forEach var="item" items="${list}">
					<td>${item.m_id}</td>
					<td>${item.m_name}</td>
					<td>${item.m_age}</td>
					<td>${item.m_addr}</td>
					<td><a href="adminupdateFrm?m_id=${item.m_id}">[수정]</a><a href="">[삭제]</a></td>
				</c:forEach>
			</c:if>
		</tr>
	</table>

</body>
</html>