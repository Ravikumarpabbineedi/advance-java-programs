/*let user="sathya"
let pass="ajay@123"
if(user==="sathya" && pass==="ajay@123"){
	alert("success")
}
else{
	alert("Fail")
}*/
/*let n1=parseInt(prompt("eneter firsr number"))
let n2=parseInt(prompt("enter second number"))

var res=n1+n2
document.write("result is  "+res)*/

/*for(i=1;i<101;i++){
	
	if(i%3===0 && i%5===0){
		document.writeln("FizzBuzz")
	}
	else if(i%5===0){
		document.writeln("Buzz")
	}
	else if(i%3===0){
		document.writeln("Fizz")
	}
	else{
		document.writeln(i)
	}	
}*/

/*let ratan_wieght=parseFloat(prompt("enter ratan weight"))
let anu_weight=parseFloat(prompt("enter anu weight"))
let ratan_height=parseFloat(prompt("enter ratan height"))
let anu_height=parseFloat(prompt("enter anu height"))

//coverting height from feets into meters to calculate BMI
ratan_height=ratan_height*.305
anu_height=anu_height*.305

let BMIRatan=ratan_wieght/(ratan_height*ratan_height)
let BMIAnu=anu_weight/(anu_height*anu_height)

console.log("Ratan Body mass index "+BMIRatan)
console.log("Anu body mass index "+BMIAnu)

document.writeln("Ratan Body Mass Index is ="+BMIRatan)
document.writeln("Anu Body Mass Index is ="+BMIAnu)

var RatanHigherBMI;
if(BMIRatan>BMIAnu){
	RatanHigherBMI=true
	}
else{
	RatanHigherBMI=false
}
	document.writeln("Ratan has higher BMI than Anu ="+RatanHigherBMI)
	console.log("Ratan has higher BMI than Anu ="+RatanHigherBMI)*/

/*function scoreDolphins(n1,n2,n3){
	return (n1+n2+n3)/3
}
function scoreKoalas(n1,n2,n3){
	return (n1+n2+n3)/3
}
d1=parseInt(prompt("enter the dolphin score"))
d2=parseInt(prompt("enter the dolphin score"))
d3=parseInt(prompt("enter the dolphin score"))
k4=parseInt(prompt("enter the koalas score"))
k5=parseInt(prompt("enter the koalas score"))
k6=parseInt(prompt("enter the koalas score"))
let avgOfDolphins=scoreDolphins(d1,d2,d3)
let avgOfKoalas=scoreKoalas(k4,k5,k6)
if(avgOfDolphins>=100 && avgOfKoalas>=100){
	if(avgOfDolphins>avgOfKoalas){
		console.log("Dolphins win the trophy with average of "+avgOfDolphins)
	}
	else if(avgOfDolphins===avgOfKoalas){
		console.log("Both win the trophy because averages are equal")
	}
	else{
		console.log("Koalas win the trophy with average of "+avgOfKoalas)
	}
}
else{
	console.log("avg of one of the team is below 100")
}
document.write("execution done successfully")*/

/*function fruitProcessor(apples,oranges){
	return `juice preparing with ${apples}-apples & ${oranges}-oranges`
}
document.write(fruitProcessor(8,6))*/

function cutFruits(fruits){
	return fruits*4
}
function fruitProcessor(apples,oranges){
	let cuts1=cutFruits(apples)
	let cuts2=cutFruits(oranges)
	return `Juice preparing with ${cuts1} applesPieces & ${cuts2}-orangesPieces`
}
document.write(fruitProcessor(8,6))
console.log(fruitProcessor(8,6))