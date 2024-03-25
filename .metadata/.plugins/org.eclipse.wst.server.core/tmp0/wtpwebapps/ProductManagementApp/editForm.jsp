<%@page import="com.sathya.application.ProductDao" import="java.util.Base64" %>
<%@ page language="java" contentType="text/html;"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j" %>
<html>
	<head>
		<title>EDIT FORM</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"/>
  		<script src="formvalidations.js"></script>
</head>
<body style="background-color: rgb(150, 200, 165);">
	<div class="container mt-5 text-center">
		<h2 class="text-center font-italic mb-1"> EDIT FORM </h2>
		<form method="post" action="./UpdateProductServlet" enctype="multipart/form-data" onsubmit="return validateForm()">
			 <div class="form-group">
					<label class="font-italic font-weight-bold" for="proId"> Product ID : </label>	
					<input type="text" class="form-control-sm" id="proId" name="proId" value="${existingProduct.proId}" required/>
			 </div>
			 
			 <div class="form-group">
					<label class="font-italic font-weight-bold" for="proName"> Product Name : </label>	
					<input type="text" class="form-control-sm" id="proName" name="proName" value="${existingProduct.proName}" required />
			 </div>
			 
			 <div class="form-group">
					<label class="font-italic font-weight-bold" for="proPrice"> Product Price : </label>	
					<input type="number" class="form-control-sm" id="proPrice" name="proPrice" value="${existingProduct.proPrice}" required />
			 </div>
			 
			 <div class="form-group">
					<label class="font-italic font-weight-bold" for="proBrand"> Product Brand : </label>	
					<input type="text" class="form-control-sm" id="proBrand" name="proBrand" value="${existingProduct.proBrand}" required />
			 </div>
			 
			 <div class="form-group">
					<label class="font-italic font-weight-bold" for="proMadeIn"> Product MadeIn : </label>	
					<input type="text" class="form-control-sm" id="proMadeIn" name="proMadeIn" value="${existingProduct.proMadeIn}" required />
			 </div>
			 
			 <div class="form-group">
					<label class="font-italic font-weight-bold" for="proMfgDate"> Product MfgDate : </label>	
					<input type="date" class="form-control-sm" id="proMfgDate" name="proMfgDate" value="${existingProduct.proMfgDate}" required />
			 </div>
			 
			 <div class="form-group">
					<label class="font-italic font-weight-bold" for="proExpDate"> Product ExpDate : </label>	
					<input type="date" class="form-control-sm" id="proExpDate" name="proExpDate" value="${existingProduct.proExpDate}" required />
			 </div>
			 
			 <div class="form-group">
			 		<label class="font-italic font-weight-bold" for="existingProImage"> Current Product Image :</label>
			 		<img id="existingProImage" src="data:image/jpeg;base64,${Base64.getEncoder().encodeToString(existingProduct.proImage)}" alt="Current Product Image" style="max-width: 200px;max-height: 200px;" />
					<input type="hidden" id="existingProImage" name="existingProImage" value="${Base64.getEncoder().encodeToString(existingProduct.proImage)}"/>
			 </div>
			 
			 <div class="form-group">
			 		<label class="font-italic font-weight-bold" for="newProImage"> New Product Image :</label>
					<input type="file" class="form-control-file-sm" id="newProImage" name="newProImage" accept="image/*"/>
			 </div>
			 		 
			 <div>
					<input type="submit" class="btn btn-success" value="UPDATE PRODUCT" />
			 </div>
			 
		</form>
	</div>
</body>
</html>