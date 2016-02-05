<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags" %>
<template:layout>
	
	<div ng-app="app" ng-controller="EditNgController" class="form">

		<div class="row">
			<div class="col-lg-12 col-md-12 col-xs-12">
				<h1>Redigera CV - {{cv.name}}</h1>
			</div>
		</div>
		
		<div class="form-group">
			<label for="name">Namn:</label>
			<input type="text" ng-model="cv.name" class="form-control input10" autofocus=""/>
		</div>
		
		<div class="form-group">
			<label for="travelability">Resbarhet:</label>
			<label class="radio-inline"> <input type="radio" name="travelbility" ng-model="cv.travelability" value="1"> Ja</label>
			<label class="radio-inline"> <input type="radio" name="travelbility" ng-model="cv.travelability" value="0"> Nej</label>
		</div>
		
		<div class="form-group">
			<label for="availability">Tillgänglighet:</label>
			<input type="number" ng-model="cv.availability" min="0" max="100" placeholder="0 - 100" class="form-control input10"/>
		</div>
		
		<div class="form-group">
			<label for="language">Språk:</label>
			<select data-ng-options="o.code for o in languages track by o.id" data-ng-model="cv.language" class="form-control input10"></select>
		</div>
		
		<div class="form-group">
	        <label for="background">Bakgrund:</label>
	        <textarea id="background" placeholder="Background" ng-model="cv.background" class="form-control"></textarea>
	    </div>
		

	  	<div class="row">
	   		<div class="col-lg-offset-10 col-lg-2 col-md-offset-8 col-md-4 col-xs-offset-6 col-xs-6">
	   			<button ng-click="save()" class="btn btn-primary pull-right" >Spara</button><button onclick="location= '/cvportal';" class="btn btn-default pull-right btn-margin-right">Avbryt</button>
	   		</div>
	   	</div>

	</div>
   	
	<!-- Scripts section  -->
	<script src="${pageContext.request.contextPath}/resources/js/cv/editNgController.js"></script>

</template:layout>