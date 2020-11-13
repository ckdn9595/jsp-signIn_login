$(document).ready(function(){
//	서베이인포jsp
	$('.sibtn').click(function(){
		var tid = $(this).attr('id');
		
		$('#sno').val(tid);
		
		$('#frm').submit();
		
		
	});
	$('.srbtn').click(function(){
	//	$(location).attr('href','/cls/survey/surveyResult.cls');
		var tno = $(this).attr('id').substring(1);
		$('#sno').val(tno);
		$('#sfrm').attr('action','/cls/survey/surveyResult.cls');
		$('#sfrm').submit();
	
	});
//	서베이jsp
	$('#hbtn').click(function(){
		$(location).attr('href','/cls/main.cls');
	});
	$('#sbtn').click(function(){
		var sno = $('#cnt').val();
		var tno = $('input:checked').length;
		if(sno != tno){
			return;
		}
		$('#sfrm').attr('method','POST');
		$('#sfrm').attr('action','/cls/survey/surveyProc.cls');
		$('#sfrm').submit();
	});
	$('#sibtn').click(function(){
		$(location).attr('href','/cls/survey/surveyInfo.cls')
	})
});
