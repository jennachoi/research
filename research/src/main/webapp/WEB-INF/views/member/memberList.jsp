<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멤버목록보기</title>
<script>
	function fileDown(path, file) {
		frm.filePath.value = path;
		frm.fileName.value = file;
		frm.submit();
	}
</script>
</head>
<body>
	<div align="center">
		<div>
			<H1>회원목록</H1>
		</div>
		<div>
			<form id="frm" action="fileDown.do" method="post">
				<table border="1">
					<tr>
						<th width="100">이메일</th>
						<th width="100">이름</th>
						<th width="100">사진</th>
						<th width="100">첨부파일</th>
					</tr>
					<c:forEach var="member" items="${members }">
						<tr onmouseover="this.style.background='lightgrey'"
							onmouseout="this.style.background='white'">
							<td>${member.email }</td>
							<td>${member.name }</td>
							<td>${member.fileName }</td>
							<td align="center">
								<c:if test="${!empty member.fileUuid }">
									<img src="https://image.flaticon.com/icons/png/512/1388/1388902.png"
										width="20" onclick="fileDown('${member.fileUuid}', '${member.fileName }')">
								</c:if>
							</td>
						</tr>
					</c:forEach>
				</table>
				<input type="hidden" id="filePath" name="filePath">
				<input type="hidden" id="fileName" name="fileName">
			</form>
		</div>
	</div>
</body>
</html>