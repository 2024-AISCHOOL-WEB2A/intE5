<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>testPay</title>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript"
	src="https://service.iamport.kr/js/iamport.payment-1.1.5.js"></script>

</head>
<body>
	<p>아임 서포트 결제 모듈 테스트 해보기</p>
	<button id="check_module" type="button">아임 서포트 결제 모듈 테스트 해보기</button>

	<script>
		$("#check_module").click(function() {
			var IMP = window.IMP; // 생략가능        
			IMP.init('imp05218310');
			IMP.request_pay({
				pg : 'html5_inicis',
				pay_method : 'card',
				merchant_uid : 'merchant_' + new Date().getTime(),
				name : '주문명:결제테스트',
				amount : 500,
				buyer_email : 'iamport@siot.do',
				buyer_name : '구매자이름',
				buyer_tel : '010-1234-5678',
				buyer_addr : '서울특별시 강남구 삼성동',
				buyer_postcode : '123-456',
				m_redirect_url : 'https://www.yourdomain.com/payments/complete'
			}, function(rsp) {
				console.log(rsp);
				if (rsp.success) {
					var msg = '결제가 완료되었습니다.';
					/* msg += '고유ID : ' + rsp.imp_uid; */
					/* msg += '상점 거래ID : ' + rsp.merchant_uid; */
					msg += '결제 금액 : ' + rsp.paid_amount;
					/* msg += '카드 승인번호 : ' + rsp.apply_num; */
				} else {
					var msg = '결제에 실패하였습니다.';
					msg += '에러내용 : ' + rsp.error_msg;
				}
				alert(msg);
			});
		});
	</script>
</body>

</html>