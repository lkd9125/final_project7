<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin 로그인폼</title>
<style type="text/css">
fieldset {
	width: 80%;
	margin: 0 auto;
	text-align: center;
}
</style>
<script type="text/javascript">
	var msg = "${msg}";
	if(msg != ""){
		alert(msg);
	}
</script>
</head>
<body>

<h2>AdminLogin</h2>
<form action="adminlogin" method="post">
<fieldset>
	<input type="text" name="m_id" placeholder="id" required><br>
	<input type="password" name="m_pwd" placeholder="password" required><br>
	<input type="submit" value="Login">
	<input type="reset" value="cancel">
</fieldset>
</form>


</body>
</html>