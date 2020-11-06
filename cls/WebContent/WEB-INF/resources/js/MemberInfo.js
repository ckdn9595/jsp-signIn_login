$(document).ready(function(){
	$('#home').click(function(){
		$(location).attr('href','/cls/main.cls');
	});
	$('#edit').click(function(){
		$('#box').removeClass('w3-hide');
	});
	
	$('#out').click(function(){
		$(location).attr('href','/cls/member/joinout.cls');
	})
	$('#change').click(function(){
		// 할일
		// 데이터 읽어오고
		// 회원번호
		
		$.ajax({
			url: '/cls/member/memberEdit.cls',
			type: 'POST',
			dataType: 'text',
			data: {
//				mno: sno,
				mail: tmail,
				avt: tavt
			},
			success: function(obj){
				// obj 는 텍스트 문서이고 우리는 이 문서에 변경된 데이터갯수를 입력해두기로 하자.
				// 따라서 회원정보가 변경이 되면 "1" 이 문서에 기록되고 반대의 경우는 "0"이 기록될 것이다.
				if(obj == 1){
					// 이 경우는 수정에 성공한 경우
					$('#cMail').text(tmail);
					$('.infoAvtBox > img').eq(0).attr('src', '/cls/img/avatar' + imgsrc);
					$('.infoAvtBox > img').eq(0).attr('id', reid);
					
					// 수정창 안보이게 처리하고
					$('#frm').stop().slideUp(500);
				} else {
					// 문제 있는 경우
					// 함수실행을 즉시 종료하고 수정작업을 다시 해야된다.
					return;
				}
			},
			error: function(){
				alert('### 통신 실패 ###');
			}
		});
	});
});