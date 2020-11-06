$(document).ready(function(){
	$('.btnBox').click(function(){
		var tid = $(this).attr('id');
		var target = '/cls/main.cls';
		switch(tid){
			case 'hbtn':
			
			break;
			case 'lbtn':
			target = '/cls/member/login.cls'
			break;
			case 'jbtn':
			
			target = '/cls/member/join.cls'
			break;
			case 'obtn':
			
				target = '/cls/member/logout.cls'
			break;
			case 'rbtn':
				$('#body').val('');
			return;
			case 'wbtn':
			var txt = $('#body').val();
			if(!txt){
				$('#body').focus();
				return;
			}
				$('#frm3').submit();
			return;
			break;
		}
		$(location).attr('href',target);
	})
});