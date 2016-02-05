<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<template:layout>
	<form:form commandName="event">
			<form:errors path="*" cssClass="errorblock" element="div"></form:errors>
			<label for="textinput1">Enter Minutes:</label>
			<form:input path="name" cssErrorClass="error"/>
			<form:errors path="name" cssClass="error" />
			<br />
			<input type="submit" class="btn" value="Enter Event" />
		</form:form>
</template:layout>
