$(document).ready(function(){
	$('#home').click(function(){
		$(location).attr('href','/cls/main.cls');
	});
	$('#edit').click(function(){
		$('#editf').removeClass('w3-hide');
	});
});