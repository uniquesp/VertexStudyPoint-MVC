
 $(document).ready(function() {
	/** if (localStorage.getItem('userId') !== null) {
		getAllstudentDetails();
	}*/
	getAllstudentDetails();
});


function getAllstudentDetails() {
	$('#userTable').DataTable().destroy();
	$('#userTable').DataTable({
		"ajax": {
			"url": contextPath + "/student?method=display_student",
			"type": "POST",
			"dataType": "json",
			"dataSrc": "students",
		},
		"columns": [

			{ "data": null, "title": "#" },
			{ "data": "firstName" },
			{ "data": "email_id" },
			{ "data": "phone_no" },
			{ "data": "address" },
			{
				"data": "student_id",
				"render": function(data) {
					  return `
					    <div class="icon-container">
					      <a href="#" class="view" title="View" data-toggle="tooltip" onclick="viewStudent(${data})">
					        <i class="fas fa-eye blue-icon"></i>
					      </a>
					      <a href="#" class="delete" title="Delete" data-toggle="tooltip" onclick="deleteStudent(${data})">
					        <i class="fas fa-trash red-icon"></i>
					      </a>
					    </div>`;
				}
			}
		],
		"createdRow": function(row, data, dataIndex) {
			$('td:eq(0)', row).html(dataIndex + 1);
		}
	});
}

function viewStudent(student_id) {
	$.ajax({
		url: contextPath + "/student?method=get_student",
		type: 'POST',
		dataType: 'json',
		data: { student_id: student_id },
		success: function(response) {
			if (response.success) {
				var studentDetails = response.students[0];
				$("#first_name").val(studentDetails.firstName);
				$("#last_name").val(studentDetails.lastName);
				$("#user_email").val(studentDetails.email_id);
				$("#user_mobile").val(studentDetails.phone_no);
				$("#user_gender").val(studentDetails.gender);
				$("#user_address").val(studentDetails.address);
				$("#Birth_Date").val(studentDetails.dob);
				$("#study").val(studentDetails.study);
				$("#student_id").val(studentDetails.student_id);
				$("#manageuser").modal("show");
			} else {
				alert("Failed to fetch user details.");
			}
		},
		error: function(xhr, status, error) {
			alert("error: " + error + " status: " + status + " er:" + xhr.responseText);
		}
	});
}


function deleteStudent(student_id) {
	$.ajax({
		url: contextPath + "/student?method=delete_student",
		type: 'POST',
		dataType: 'json',
		data: { student_id: student_id },
		success: function(response) {
			if (response.success) {
				alert(response.message);
				getAllstudentDetails();
			} else {
				alert(response.message);
			}
		},
		error: function(xhr, status, error) {
			alert("error: " + error + " status: " + status + " er:" + xhr.responseText);
		}
	});
}

