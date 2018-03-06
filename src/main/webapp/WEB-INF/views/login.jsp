<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="jspf/header.jspf"%>
<%@ include file="jspf/main_menu.jspf"%>

<div class="container">

	<div class="justify-content-center">


		<h2>Zaloguj sie!</h2>

		<p>
			<class="error">${msg}
		</p>

		<form:form method="post" modelAttribute="loginData">

			<div class="form-group col-4">
				Email:
				<form:input path="email" placeholder="Enter email"
					cssClass="form-control" />
				<form:errors path="email" />
			</div>
			<div class="form-group col-4">
				Password:
				<form:password path="password" placeholder="Password"
					cssClass="form-control" />
				<form:errors path="password" />
			</div>
			<input type="submit" class="btn btn-primary" value="Zaloguj">
		</form:form>





	</div>
</div>
</div>


