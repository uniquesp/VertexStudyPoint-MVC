 $('#registration_form').submit(function(event) {
	event.preventDefault();

	$.post($(this).attr('action'), $(this).serialize())
		.done(function(data) {
			try {
				/*data = JSON.parse(data);*/
				if (data && data.success) {
					window.location.href = "student-login.jsp";
					alert(data.message);
				} else {
					alert(data.message);
				}
			} catch (e) {
				console.error("Error parsing JSON:", e);
			}
		})
		.fail(function(xhr, status, error) {
			alert("error: " + error + " status: " + status + " er:" + xhr.responseText);
		});
});