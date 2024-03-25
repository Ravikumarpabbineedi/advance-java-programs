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
	<div>
			<h1 class="text-center text-success"> List of Available Products </h1>
	</div>
	<div class="form-group">
			<a class="btn btn-success" href="addProducts.html">Save Product</a>
	</div>
	
	<div class="form-group">
			<form method="get" action="searchResult.jsp">
				<input type="search" name="ch" placeholder="search here" aria-label="Search"/>
				<button type="submit">SEARCH</button>
			</form>
	</div>
	<div class="form-group">
			<j:if test="${saveResult==1}">
				<h2 class="text-center text-danger">Data Inserted Successfully.... </h2>
			</j:if>
	</div>
	<div class="form-group">
			<j:if test="${deleteResult==1}">
				<h2 class="text-center text-danger">Data Deleted Successfully.... </h2>
			</j:if>
	</div>
	<div class="form-group">
			<j:if test="${deleteResult==0}">
				<h2 class="text-center text-danger">Data Deletion Failed.... </h2>
			</j:if>
	</div>
	
	<div class="form-group">
			<j:if test="${result==1}">
				<h2 class="text-center text-danger">Data Updated Successfully.... </h2>
			</j:if>
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
				<th> ACTIONS </th>
			</tr>
		</thead>
		<tbody>
				<j:forEach var="product" items="<%=new ProductDao().findAll() %>">
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
								<source  src="data:audio/mp3;base64,${Base64.getEncoder().encodeToString(product.proAudio)}" type="audio/mp3" />
							</audio>	
						</td>
						
						<td >
							<video controls width="200" height="200">
								<source  src="data:video/mp4;base64,${Base64.getEncoder().encodeToString(product.proVideo)}" type="video/mp4" /> 
							</video>
						</td>
							
						<td>
						
							<a class="btn btn-danger form-group" href="DeleteProductServlet?proId=${product.proId}">Delete</a>
							<a class="btn btn-primary" href="EditProductServlet?proId=${product.proId}">Edit</a>
						</td>
					</tr>
				</j:forEach>
		</tbody>
	</table>
</body>
</html>