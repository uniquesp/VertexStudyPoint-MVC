<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="<%=request.getContextPath()%>/resources/css/styles.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/chart.js@3.9.1/dist/chart.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/remixicon@2.5.0/fonts/remixicon.css"
	rel="stylesheet">
<title>Admin</title>
</head>
<body class="body">

	<jsp:include page="/partials/Admin-Navbar.jsp" />

	<section class="main">
		<jsp:include page="/partials/Admin-Sidebar.jsp" />

		<div class="main--container">
			<div class="section--title">
				<h3 class="title">Welcome back!</h3>
			</div>
			<br>
			<div class="cards">
				<div class="card card-1">
					<div class="card--title">
						<span class="card--icon icon"><i
							class="ri-shopping-bag-2-line"></i></span> <span>Sales</span>
					</div>
					<h3 class="card--value">
						$432,576.34 <i class="ri-arrow-up-circle-fill up"></i>
					</h3>
					<h5 class="more">4,234 more than usual</h5>
					<div class="chart">
						<canvas id="sales"></canvas>
					</div>
				</div>
				<div class="card card-2">
					<div class="card--title">
						<span class="card--icon icon"><i class="ri-gift-line"></i></span>
						<span>Orders</span>
					</div>
					<h3 class="card--value">
						2,567 <i class="ri-arrow-down-circle-fill down"></i>
					</h3>
					<h5 class="less">234 less than usual</h5>
					<div class="chart">
						<canvas id="orders"></canvas>
					</div>
				</div>
				<div class="card card-3">
					<div class="card--title">
						<span class="card--icon icon"><i class="ri-handbag-line"></i></span>
						<span>Products</span>
					</div>
					<h3 class="card--value">
						587 <i class="ri-arrow-up-circle-fill up"></i>
					</h3>
					<h5 class="more">23 more than usual</h5>
					<div class="chart">
						<canvas id="products"></canvas>
					</div>
				</div>
				<div class="card card-4">
					<div class="card--title">
						<span class="card--icon icon"><i class="ri-user-line"></i></span>
						<span>Customers</span>
					</div>
					<h3 class="card--value">
						4,300 <i class="ri-arrow-down-circle-fill down"></i>
					</h3>
					<h5 class="less">34 less than usual</h5>
					<div class="chart">
						<canvas id="customers"></canvas>
					</div>
				</div>
			</div>
		</div>
	</section>
	
	<script type="text/javascript">
   var contextPath = "<%=request.getContextPath()%>";
	</script>
	<script src="<%=request.getContextPath()%>/resources/js/main.js"></script>
</body>
</html>