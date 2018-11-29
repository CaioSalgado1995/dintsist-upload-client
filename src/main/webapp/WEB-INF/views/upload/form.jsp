<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" href="<c:url value='/resources/css/bootstrap-grid.css'/>" rel="stylesheet">
<link type="text/css" href="<c:url value='/resources/css/bootstrap-grid.min.css'/>" rel="stylesheet">
<link type="text/css" href="<c:url value='/resources/css/bootstrap-reboot.css'/>" rel="stylesheet">
<link type="text/css" href="<c:url value='/resources/css/bootstrap-reboot.min.css'/>" rel="stylesheet">
<link type="text/css" href="<c:url value='/resources/css/bootstrap.css'/>" rel="stylesheet">
<link type="text/css" href="<c:url value='/resources/css/bootstrap.min.css'/>" rel="stylesheet">
<title>Upload de arquivos</title>
</head>
<body>
	<div class="container">
		<div class="">
			<h1 class="">Upload de arquivos</h1>
		</div>
		<form:form action="${s:mvcUrl('UC#upload').build()}" method="post" commandName="sinal" enctype="multipart/form-data">
			
			<div class="form-group">
				<label for="constant">Constante para aumentar sinal:</label>
				<input type="number" class="form-control" id="constant" name="constant">
			</div>
			
			<div class="form-group">
				<label for="arquivo">Arquivo:</label>
				<input type="file" class="form-control" id="arquivo" name="arquivo">
			</div>
			
			<button type="submit" class="btn btn-primary">Upload</button>
		</form:form>
	</div>
</body>
</html>