<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
	<%@ include file="jspf/header.jspf"%>
	<%@ include file="jspf/main_menu.jspf"%>


	<h3>Profil użytkownika: ${user.username}</h3>
<p>Adres e-mail: ${user.email}</p>

<c:choose>
	<c:when test="${sessionScope.user.username==user.username}">
		<p>
			<a
				href="//localhost:8080/DirtBikeParking/user/edit/${user.id}">Edytuj
				swoje dane</a>
		</p>
		<p>
			<a href="//localhost:8080/DirtBikeParking/user/delete">Usuń
				konto</a>
		</p>
	</c:when>
</c:choose>

<c:choose>
	<c:when test="${sessionScope.user.admin==true}">
		<p>
		<a href="http://localhost:8080/DirtBikeParking/user/delete/${user.id}">Usuń
			użytkownika</a>
		</p>
	</c:when>
</c:choose>

	
	<%@ include file="jspf/footer.jspf"%>

</body>
</html>