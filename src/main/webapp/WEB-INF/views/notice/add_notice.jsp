<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
	<%@ include file="../jspf/header.jspf"%>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="resources/css/style.css">
	<link rel="stylesheet" href="resources/css/custom.css">
	<link rel="stylesheet" type="text/css" href="css/custom.css">
</head>
<body>

	<%@ include file="../jspf/main_menu.jspf"%>


	<c:choose>
		<c:when test="${sessionScope.user == null}">
	You need to be logged in.
	</c:when>
		<c:otherwise>


			<h1>Wystaw Motocykl</h1>

			<form:form method="post" modelAttribute="notice"
			enctype="multipart/form-data">

				<p>Wybierz Marke :<form:select items="${brands}" path="brand" /></p>
				<p>Rok Produkcji :<form:input path="year"/></p><form:errors path="year"/>
				<p>Przebieg :<form:input path="mileage"/>[mh/km]</p><form:errors path="mileage"/>
				<p>Pojemność Silnika :<form:input path="capacity"/></p><form:errors path="capacity"/>
				<p>Wybierz typ silnika :<form:select items="${engine}" path="engineType" /></p>	
				<p>Cena :<form:input path="price"/></p><form:errors path="price"/>
				<p>Opis :<form:textarea  path="description"/></p><form:errors path="description"/>
				<p>Zdjęcie: (format .jpg lub .jpeg)<form:input type="file" path="fileUrl" name="file" />
							<form:errors path="description" />
							${errorMessage}
				<p><input type="submit" value="Dodaj" /></p>
	</form:form>

				
		</c:otherwise>
	</c:choose>

	<%@ include file="../jspf/footer.jspf"%>






</body>
</html>