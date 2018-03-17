<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" isErrorPage="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="../jspf/header.jspf"%>
<%@ include file="../jspf/main_menu.jspf"%>

<div class="container">

	<div class="row">
		<%@ include file="../jspf/brands.jspf"%>

		<div class="col-lg-9">

			<div class="card mt-4">
				<img class="card-img-top img-fluid"
					src="${pageContext.request.contextPath}/resources/uploads/notice/${details.fileUrl}"
					alt="image-of-${details.brand}" />



				<div class="card-header text-white"
					style="background-color: #437070;">Dane Techniczne:</div>
				<div class="card-body">
					<a>Marka: ${details.brand}</a></br> <a>Rocznik: ${details.year}</a></br> <a>Przebieg:
						${details.mileage}MH</a></br> <a>Pojemość: ${details.capacity}cmm3</a></br> <a>Silnik:
						${details.engineType}</a></br>
					<h2>
						<a>Cena: ${details.price}PLN</a>
					</h2>
				</div>
				<div class="card-header text-white"
					style="background-color: #437070;">Opis:</div>
				<p class="card-text">${details.description}</p>
				<div class="card-header text-white"
					style="background-color: #437070;">Kontakt:</div>
				<div class="card-body">
					<a>Własciciel: ${details.user.name} ${details.user.surname}</a></br> <a>Motocykl
						do obejrzenia w: ${details.user.location}</a><br> <a>Telefon:
							${details.user.telNumber} Email: ${details.user.email} </a><br>
				</div>
			</div>

			<c:choose>
				<c:when test="${sessionScope.user.id!=details.user.id}">


					<c:choose>
						<c:when test="${details.toObserve!=true}">

							<p>
								<a
									href="http://localhost:8080/DirtBikeParking/toObserve/${details.id}"
									type="button" class="btn btn-secondary btn-lg btn-block">Dodaj
									do obserwowanych</a>

							</p>
						</c:when>
						<c:when test="${details.toObserve==true}">

							<p>
								<a
									href="http://localhost:8080/DirtBikeParking/toObserve/${details.id}"
									type="button" class="btn btn-secondary btn-lg btn-block">Usuń
									z obserwowanych</a>

							</p>
							</c:when>
					</c:choose>

				</c:when>
			</c:choose>


			<c:choose>
				<c:when test="${sessionScope.user.id==details.user.id}">
					<p>
						<a
							href="http://localhost:8080/DirtBikeParking/notice/edit/${details.id}"
							type="button" class="btn btn-secondary btn-lg">Edytuj
							ogłoszenie</a> <a
							href="http://localhost:8080/DirtBikeParking/notice/delete/${details.id}"
							type="button" class="btn btn-secondary btn-lg">Usuń
							ogłoszenie</a>
					</p>

				</c:when>
			</c:choose>

		</div>
	</div>
</div>
</br>

<%@ include file="../jspf/footer.jspf"%>