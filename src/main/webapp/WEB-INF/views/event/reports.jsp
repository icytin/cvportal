<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags" %>
<template:layout>
	<!-- Angular section  -->
	<div ng-app="app" ng-controller="ReportsNgController">
		I have {{events.length}} events!
		
		<ul class="events-container">
			<li ng-repeat="event in events">
				{{event.name}}
				<ul>
					<li ng-repeat="attendee in event.attendees">
						{{attendee.name}}
					</li>
				</ul>
			</li>
		</ul>
	</div>

	<!-- Scripts section  -->
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/event/reportsNgController.js"></script>
</template:layout>