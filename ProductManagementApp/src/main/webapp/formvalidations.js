function validateForm(){
	var proId=document.getElementById('proId').value
	var proName=document.getElementById('proName').value
	var proPrice=document.getElementById('proPrice').value
	var proBrand=document.getElementById('proBrand').value
	var proMadeIn=document.getElementById('proMadeIn').value
	var proMfgDate=document.getElementById('proMfgDate').value
	var proExpDate=document.getElementById('proExpDate').value
	
	var proMfDate=new Date(proMfgDate)
	var proEpDate=new Date(proExpDate)
	
	if(proId.trim() ==="" || proName.trim() === "" || proPrice.trim() === "" || proBrand.trim() === "" || proMadeIn.trim() === ""){
		alert("fields must be filled!")
		return false
	}
	
	if(parseFloat(proPrice) <=0){
		alert("please enter Non-negative numbers")
		return false
	}
	if(proName.length >50 || proBrand.length >50){
		alert("product Name & Brand names must be less than 50 characters")
		return false
	}
	if(proMfDate > proEpDate){
		alert("Expiry date must be less than manufacturing date")
		return false
	}
	return true
}