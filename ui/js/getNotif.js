$(document).ready(function() {
	getNotif(10);
	setInterval(function() {
		getNotif(10);
	},15000);
});