<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags" %>
<template:layout>
	
	<div ng-app="app" ng-controller="HandleNgController" class="form">
	
		<div class="row">
			<div class="col-lg-12 col-md-12 col-xs-12">
				<h1>Hantera CV - {{cv.name}}</h1>
			</div>
		</div>
		<p>
			H�r kan du hantera ditt CV, l�gg till certifieringar, kurser, mm.
		</p>
		<h2>Utbildning</h2>
		...
		<h2>Kurser</h2>
		...
		<h2>Certifieringar</h2>
		...
		<h2>Kompetenser</h2>
		...
		<h2>Erfarenheter</h2>
		...
		<h2>�vriga erfarenheter</h2>
		...
	</div>
   	
	<!-- Scripts section  -->
	<script src="${pageContext.request.contextPath}/resources/js/cv/handleNgController.js"></script>

</template:layout>