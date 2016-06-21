$(document).ready(function() {
	getNotif(-1);
	setInterval(function() {
		getNotif(-1);
	},15000);
});