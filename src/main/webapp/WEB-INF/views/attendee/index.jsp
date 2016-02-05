<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="template" tagdir="/WEB-INF/tags" %>
<template:layout>
	<div class="row">
		<div class="col-md-3">
	        <p class="lead">Language</p>
	        <div class="list-group">
	            <a href="?lang=en">English</a>
	            <a href="?lang=es">Spanish</a>
	        </div>
	    </div>
	</div>
	
    <form:form commandName="attendee">
    	<div class="row">
			<form:errors path="*" cssClass="errorblock" element="div"></form:errors>
		</div>
		<div class="row">
			<div class="col-md-3">
				<label for="textinput1"><spring:message code="attendee.name" /></label>
			</div>
			<div class="col-md-3">
				<form:input path="name" cssErrorClass="error"/>
			</div>
			<div class="col-md-6">
				<form:errors path="name" cssClass="error" />
			</div>
		</div>

		<div class="row">
			<div class="col-md-3">
				<label for="textinput2"><spring:message code="attendee.email.address" /></label>
			</div>
			<div class="col-md-3">
				<form:input path="emailAddress" cssErrorClass="error"/>
			</div>
			<div class="col-md-6">
				<form:errors path="emailAddress" cssClass="error" />
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-3">
				<label for="textinput3"><spring:message code="attendee.phone" /></label>
			</div>
			<div class="col-md-3">
				<form:input path="phone" cssErrorClass="error"/>
			</div>
			<div class="col-md-6">
				<form:errors path="phone" cssClass="error" />
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-3">
			</div>
			<div class="col-md-3">
			<br />
				<input type="submit" class="btn pull-right" value="Enter Attendee" />
			</div>
		</div>
	</form:form>
	</div>
</template:layout>