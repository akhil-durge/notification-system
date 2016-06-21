function updateNotif() {
	//update notifications in DB only when there are UNREAD notifications
	if($('#notif-count')[0].innerText!=0){
		$.ajax({
			url: "http://localhost:8080/notification-api/notification/4",
			type: 'PUT',
			error: function(jqXHR, textStatus, errorThrown){
				alert(textStatus+": "+errorThrown);
			},
			success: function(data) {
				setTimeout(function(){
					getNotif(10);
				}, 5000);
			}
		});	
	}
}