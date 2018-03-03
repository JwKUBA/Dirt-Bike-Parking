<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


			<%@ include file="jspf/header.jspf"%>
			<%@ include file="jspf/main_menu.jspf"%>

	<div class="container">
	<div class=" justify-content-center">

				<h2>Zarejstruj sie!</h2>

				<form:form method="post" modelAttribute="user">
<div class="form-group col-4">Imie: <form:input path="name" placeholder="imie" cssClass="form-control"/>
		<form:errors path="name" /></div>
	<div class="form-group col-4 ">Nazwisko: <form:input path="surname" placeholder="nazwiko" cssClass="form-control"/>
		<form:errors path="surname" /></div>
			<div class="form-group col-4">Miejsce Zamieszkania: <form:input path="location" placeholder="miejscowość" cssClass="form-control"/>
		<form:errors path="location" /></div>
				<div class="form-group col-4">Nr tel: <form:input path="telNumber" placeholder="numer" cssClass="form-control"/>
		<form:errors path="telNumber" /></div>
 		<div class="form-group col-4">Nazwa użytkownika: <form:input path="username" placeholder="nazwa użytkownika" cssClass="form-control"/>
		<form:errors path="username" /></div>
 		<div class="form-group col-4">Email: <form:input path="email" placeholder="email" cssClass="form-control"/>
		<form:errors path="email" /></div>
 		<div class="form-group col-4">Hasło: <form:input path="password" placeholder="hasło" cssClass="form-control"/>
		<form:errors path="password" /></div>
					<input type="submit" class="btn btn-primary" value="Zarejstruj">	
				</form:form>

	
			</div>
		</div>
	</div>
<%@ include file="jspf/footer.jspf"%>
