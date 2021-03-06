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
			<p>${msg}</p>

			<div class="row">
				<c:forEach items="${toObserve}" var="product">

					<div class="col-lg-4 col-md-6 mb-4">
						<div class="card h-100">
							<a
								href="http://localhost:8080/DirtBikeParking/${product.notice.id}"
								re><img class="card-img-top"
								src="${pageContext.request.contextPath}/resources/uploads/notice/${product.notice.fileUrl}"
								alt="image-of" /></a>
							<div class="card-body">
								<h4 class="card-title">
									<a href="http://localhost:8080/DirtBikeParking/${product.notice.id}">${product.notice.brand}
										${product.notice.capacity} ${product.notice.year}r</br>${product.notice.price}PLN-${product.toObserve.location}</a>
								</h4>

							</div>
							<div class="card-footer">
								<small class="text-muted">Dodano: ${product.notice.created}</small>
							</div>
						</div>
					</div>

				</c:forEach>

			</div>
		</div>
	</div>
</div>
</br>

<%@ include file="../jspf/footer.jspf"%>