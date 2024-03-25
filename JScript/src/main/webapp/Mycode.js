/*function reverseName(){
	var str=document.getElementById('Name').value
	var rstr=""
	for(var i=0;i<str.length;i++){
		rstr=str[i]+rstr
	}
	if(rstr===str){
		document.getElementById('reverse').value="yes"
	}
	else{
		document.getElementById('reverse').value="no"
	}
}*/

function palindrome(){
	var n=document.getElementById('num').value
	var temp=n
	var rem
	var rev=0
	while(temp>0){
		rem=temp%10
		rev=rev*10+rem
		temp/=10
	}
	if(n===rev){
		document.getElementById('reverse').value=rev
	}
	else{
		document.getElementById('reverse').value=rev
	}
}