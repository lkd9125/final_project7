<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 화면</title>
<script type="text/javascript">
	var msg = "${msg}";
	if(msg != ""){
		alert(msg);
	}
	
	var id ="${id}";
	if(id == ""){ //t세션에 아이디가 없음 
		alert("잘못된접근입니당.");
		location.href="./";
	}
</script>
</head>
<body>
<h2>로그인 성공 시 보입니다.</h2>
<p>${id} 님 반갑습니다:) <a href="logout">[로그아웃]</a></p>
<h3>회원정보</h3>
<p>ID : ${mem.m_id}</p>
<p>PASSWORD : ${mem.m_pwd}</p>
<p>NAME : ${mem.m_name}</p>
<p>AGE : ${mem.m_age}</p>
<p>ADDRESS : ${mem.m_addr}</p>

<p>
<button onclick="updateMember()">수정</button>
<button onclick="delMember()">탈퇴</button>
</p>

</body>
<script type="text/javascript">


function updateMember() {
	location.href="update";
}

function delMember() {
	location.href="delete";
}
</script>
</html>