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
	
	<form:form method="post" modelAttribute="user">
	Imie: <form:input path="name"/><br />
	Nazwisko: <form:input path="surname"/><br />
			Miejsce zamieszkania: <form:input path="location"/>[format: 606567489]<br />
				Nr telefonu: <form:input path="telNumber"/><br />
 		Nazwa użytkownika: <form:input path="username"/><br />
 		Email: <form:input path="email"/><br />
 		Hasło: <form:password path="password"/><br />
 		 <input type="submit" value="Zarejstruj">
 	<form:errors></form:errors>
	
	<%@ include file="jspf/footer.jspf"%>
	</form:form>
	
	



</body>
</html>