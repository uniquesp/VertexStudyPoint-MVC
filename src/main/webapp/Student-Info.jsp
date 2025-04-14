<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="<%=request.getContextPath()%>/resources/css/styles.css"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/remixicon@2.5.0/fonts/remixicon.css"
	rel="stylesheet">
<link
  rel="stylesheet"
  href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"
  crossorigin="anonymous"
/>


<title>Admin</title>
</head>
<style>
/* styles.css */
.red-icon {
	color: red;
	margin-right: 20px;
}

.icon-container {
	/* Adjust the margin as per your preference */
	text-align: center;
}
</style>
<body class="body">

	<jsp:include page="/partials/Admin-Navbar.jsp" />

	<section class="main">
		<jsp:include page="/partials/Admin-Sidebar.jsp" />

		<div class="main--container">
			<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- Page Heading -->
					<div
						class="d-sm-flex align-items-center justify-content-between mb-4">
						<h1 class="h3 mb-0 text-gray-800">User Details</h1>
					</div>
					<!-- Begin Page Content -->
					<div class="container-fluid">
						<!-- DataTales Example -->
						<div class="card shadow mb-4">
							<div class="card-header py-3">
								<h6 class="m-0 font-weight-bold text-primary"></h6>
							</div>
							<div class="card-body">
								
							</div>
						</div>

					</div>
					<!-- /.container-fluid -->
			
		</div>
		</div>
	</section>
	
	<script src="<%=request.getContextPath()%>/resources/js/main.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
	<script src="https://cdn.datatables.net/2.0.1/js/dataTables.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
	<script type="text/javascript">
   			var contextPath = "<%=request.getContextPath()%>";
	</script>
	<script src="<%=request.getContextPath()%>/resources/pages/student/student-details.js"></script>
</body>
</html>