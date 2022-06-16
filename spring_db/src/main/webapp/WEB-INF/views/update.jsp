<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
fieldset {
	width: 80%;
	margin: 0 auto;
	text-align: center;
}
</style>
</head>
<body>
<h3>회원정보 업데이트</h3>
<form action="./updateProc" method="post">
	<fieldset>
		<input type="text" name="m_id" placeholder="아이디" value="${mem.m_id}" readonly="readonly"><br>
		<input type="text" name="m_name" placeholder="이름" value="${mem.m_name}" required><br>
		<input type="password" name="m_pwd" placeholder="비밀번호" value="${mem.m_pwd}" required><br>
		<input type="number" name="m_age" placeholder="나이" value="${mem.m_age}" required><br>
		<input type="text" name="m_addr" placeholder="주소" value="${mem.m_addr}" required><br>
		<input type="submit" value="정보수정하기">
	</fieldset>
</form>
</body>
</html>