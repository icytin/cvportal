<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags" %>
<template:layout>
	
	<div class="row">
		<div class="col-lg-12 col-md-12 col-xs-12">
			<h1>Mina CV</h1>
		</div>
	</div>
	
	<div ng-app="app" ng-controller="IndexNgController">
		<table class="table">
	        <thead>
	          <tr>
	            <th>#</th>
	            <th>Namn</th>
	            <th>Resbarhet</th>
	            <th>Bakgrund</th>
	            <th>Språk</th>
	            <th></th>
	          </tr>
	        </thead>
	        <tbody>
	          <tr ng-repeat="cv in cvs">
	            <th scope="row">{{$index + 1}}</th>
	            <td><a href="cv/handle/{{cv.id}}">{{cv.name}}</a></td>
	            <td>{{ {true: 'Ja', false: 'Nej'}[cv.travelability] }}</td>
	            <td>{{ {true: cv.background.substring(0, 30) + {true: '...', false: ''}[cv.background.length > 30], false: '-'}[cv.background != null && cv.background != ""] }}</td>
	            <td>{{ cv.language.code }}</td>
	            <td><a href="cv/edit/{{cv.id}}"><i class="glyphicon glyphicon-pencil" href="cv/edit/{{cv.id}}"></i></a></td>
	          </tr>
	        </tbody>
    	</table>
    	<div class="row">
    		<div class="col-lg-offset-10 col-lg-2 col-md-offset-8 col-md-4 col-xs-offset-6 col-xs-6">
    			<button class="btn btn-primary pull-right" onclick="location = '/cvportal/cv/create'">Lägg till</button>
    		</div>
    	</div>
	</div>

	<!-- Scripts section  -->
	<script src="${pageContext.request.contextPath}/resources/js/cv/indexNgController.js"></script>
	
</template:layout>