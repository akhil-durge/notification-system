function getNotif(limit){
	$.ajax({
		url: "http://localhost:8080/notification-api/notification",
		type: 'GET',
		data:"userId=4&noOfRecords="+limit,
		cache: false,
		error: function(jqXHR, textStatus, errorThrown){
			alert(textStatus+": "+errorThrown);
		},
		success: function(data) {
			$("#dropdown-menu").empty();
			$("#notif-count").empty();
			
			var ul = document.getElementById("dropdown-menu");

			//limit is sent as -1 to API when all notifications are to be fetched.
			//No need to populate 'notifications' li in that case.
			if(limit!=-1){
				populateNotifTag(ul);
			}
			$('#notif-count-2').append(data.unreadRecords);
			$('#notif-count').append(data.unreadRecords);
			var txt=null
			var span=null;
			var li = null;
			var o = null;
			for( var i = 0; i < data.notifications.length; i++ ) {
				o=data.notifications[i];
				li = document.createElement("li");
				var img = document.createElement("img");

				//set profile pic inside span
				img.setAttribute("src",o.fromUser.dpPath);
				img.setAttribute("class","profile-pic");
				span = document.createElement("div");
				span.setAttribute("class","commenterImage");
				span.appendChild(img);
				li.appendChild(span);

				//set notification inside div
				var div = document.createElement("div");
				div.setAttribute("class","commentText");

				//set user name in notification
				var p = document.createElement("p");
				txt = document.createTextNode(o.fromUser.firstName+" "+o.fromUser.lasteName);
				p.setAttribute("class","user-name");
				p.appendChild(txt);
				div.appendChild(p);

				//set actual message in notification
				p = document.createElement("p");
				txt = document.createTextNode(" "+o.message);
				p.appendChild(txt);
				div.appendChild(p);

				//set creationTime as sun-text in notification
				span=document.createElement("span");
				span.setAttribute("class","date sub-text");
				txt = document.createTextNode(o.creationTime);
				span.appendChild(txt);
				div.appendChild(span);
				li.appendChild(div);

				//set color of li depending on status
				if(o.status=='READ')
					li.setAttribute("class","read-notifications");
				else
					li.setAttribute("class","unread-notifications");
				ul.appendChild(li); 
			}
			
			//limit is sent as -1 to API when all notifications are to be fetched.
			//No need to populate 'show all notifications' li in that case.
			if(limit!=-1){
				li=document.createElement("li");
				txt = document.createTextNode("Show all notifications");
				li.appendChild(txt);
				li.setAttribute("onclick","location.href='showAllNotif.html';");
				li.setAttribute("class","show-all-notif");
				ul.appendChild(li);
			}
		}
	});
}

function populateNotifTag(ul){
	var li = document.createElement("li");
	li.setAttribute("class","notification-bar");
	li.appendChild(document.createTextNode("Notifications "));
			//set span for notification count
			var span = document.createElement("span");
			/*span.setAttribute("class","numberCircle notification-count");*/
			span.setAttribute("class","badge");
			span.setAttribute("data-role","notification-count");
			span.setAttribute("id","notif-count-2");
			li.appendChild(span);
			ul.appendChild(li);
		}