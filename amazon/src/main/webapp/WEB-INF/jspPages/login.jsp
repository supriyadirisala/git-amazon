<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}

form {
	/* border: 1px solid black; */
	text-align: center;
}

input[type=text], input[type=password] {
	width: 30%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

button {
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 10%;
}

button:hover {
	opacity: 0.8;
}

.imgcontainer {
	text-align: center;
	margin: 24px 0 12px 0;
}

.container {
	padding: 16px;
}
</style>
</head>
<body>
	<div class="imgcontainer">
		<img src="/amazon/images/amazon.png" alt="Amazon" />
	</div>
	<form action="otpPage">
		<h3>Login</h3>
		<div class="container">
			<label for="customerName">Enter Name : </label> <input type="text"
				placeholder="Enter Name " name="custName" required><br>

			<label for="emailOrMobileNo">MobileNo :</label> <input type="text"
				placeholder="Enter MobileNo" name="mobileNo" required><br>

			<button type="submit">GetOTP</button>
		</div>
	</form>
</body>

<!-- <script >

function showgetotpDiv() {
	otpDiv.style.visibility='visible'
	alert()
}
</script> -->



</html>