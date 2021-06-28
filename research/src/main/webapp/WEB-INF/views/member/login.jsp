<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<div><h1>로그인</h1></div>
	<div>
		<form action="loginConfirm.do" method="post">
			<div>
				<table border="1">
					<tr>
						<th width="150">이메일</th>
						<td width="300">
							<input type="text" id="email" name="email">
						</td>
					</tr>
					<tr>
						<th width="150">패스워드</th>
						<td width="300">
							<input type="password" id="password" name="password">
						</td>
					</tr>
				</table>
			</div>
		</form>
	</div>
</div>
</body>
</html>