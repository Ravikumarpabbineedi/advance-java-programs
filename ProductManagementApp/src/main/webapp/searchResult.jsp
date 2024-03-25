<%@page import="com.sathya.application.ProductDao" import="java.util.Base64" %>
<%@ page language="java" contentType="text/html" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j" %>
<html>
<head>
	<title> Products List </title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"/>
	<link rel="stylesheets" type="text/css" href="Style.css"/>
	 <script src="formvalidations.js"></script>
</head>
<body>
	<%
		String input=request.getParameter("ch");
	%>  
	
	<h2 style="color: red;text-align: center"> Search results are... </h2>
	
	<div class="form-group">
			<a href="productsList.jsp" class="btn btn-success"> List of Products </a>
	</div>
	
	<table class="table table-bordered table-striped">
		<thead class="thead-dark">
			<tr>
				<th> Product ID </th>
				<th> Product NAME </th>
				<th> Product PRICE </th>
				<th> BRAND </th>
				<th> MADE-IN </th>
				<th> MANUFACTURE DATE</th>
				<th> EXPIRY DATE </th>
				<th> IMAGE </th>
				<th> AUDIO </th>
				<th> VIDEO </th>
			</tr>
		</thead>
		<tbody>
				<j:forEach var="product" items="<%=new ProductDao().searchByInput(input) %>">
					<tr>
						<td>${product.proId}</td>
						<td>${product.proName}</td>
						<td>${product.proPrice}</td>
						<td>${product.proBrand}</td>
						<td>${product.proMadeIn}</td>
						<td>${product.proMfgDate}</td>
						<td>${product.proExpDate}</td>
						<td >
							<img src="data:image/jpeg;base64,${Base64.getEncoder().encodeToString(product.proImage)}" alt="ProductImage" style="max-width: 200px;max-height: 200px;" />
						</td>
						<td >
							<audio controls>
								<source  src="data:audio/mp3;base64,${Base64.getEncoder().encodeToString(product.proAudio)}" type="audio/mp3">
							</audio>	
						</td>
						<td >
							<video controls width="320" height="240">
								<source  src="data:video/mp4;base64,${Base64.getEncoder().encodeToString(product.proVideo)}" type="video/mp4" >
							</video>
						</td>
					</tr>
				</j:forEach>
		</tbody>
	</table>
</body>
</html>