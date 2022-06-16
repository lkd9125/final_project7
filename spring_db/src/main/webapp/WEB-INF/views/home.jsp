<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<title>Home</title>
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
<h1>
	Hello world!  
</h1>
<P>  The time on the server is ${serverTime}. </P>
<p><a href="./joinFrm">Join</a></p>
<h2>Login</h2>
<form action="./login" method="post">
<fieldset>
	<input type="text" name="m_id" placeholder="id" required><br>
	<input type="password" name="m_pwd" placeholder="password" required><br>
	<input type="submit" value="Login">
	<input type="reset" value="cancel">
</fieldset>
</form>
</body>
</html>
