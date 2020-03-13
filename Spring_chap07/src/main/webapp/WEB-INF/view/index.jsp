<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring_Index</title>
</head>
<body>
	<img src="images/spring1.png">
	<ul>
		<li>헬로우월드:
			<ul>
				<li><a href="hello.do">/hello.do</a>: 스프링MVC 일단 해 보기
					HelloController.hello()</li>
				<li><a href="hello-raw.do">/hello-wra.do</a>: void 리턴 타입 컨트롤러
					메서드 HelloController.hello(HttpServletResponse)</li>
			</ul>
		</li>
		<li>모델:
			<ul>
				<li><a href="event/list">/event.list</a>: Model 예시,
					EventController.list()</li>
				<li><a href="event/list2">/event.list2</a>: ModelAndView 예시,
					EventController.list2()</li>
			</ul>
		</li>
		<li>@RequestMapping, @PathVariable:
			<ul>
				<li><a href="member/regist">/member/regist</a>: GET/POST 예시,
					RegistrationController</li>
				<li><a href="members">/members</a>: @PathVariable 사용 위한 목록 출력,
					MemberController.members()</li>
				<li><a href="members/m2">/members/m2</a>: @PathVariable 예,
					MemberController.memberDetail()</li>
				<li><a href="members/m2/orders">/members/m2/orders</a>:
					@PathVariable 예, MemberController.memberOrders</li>
				<li><a href="members/m2/orders/1">/members/m2/orders/1</a>:
					@PathVariable 예, MemberController.memberOrderDetail()</li>
				<li><a href="members/m2/orders/1a">/members/m2/orders/1a</a>:
					@PathVariable 400 응답 예, MemberController.memberOrderDetail()</li>
			</ul>
		</li>
		<li>요청 파라미터 처리:
			<ul>
				<li><a href="event/detail?id=1">event/detail?id=1</a>:
					HttpServletRequest을 이용한 파라미터 구하기, EventController.detail()</li>
				<li><a href="event/detail2?id=1">event/detail2?id=1</a>:
					@RequestParam을 이용한 파라미터 구하기, EventController.detail2()</li>
				<li><a href="event/detail2">event/detail2</a>: @RequestParam 필수
					파라미터 400 에러, EventController.detail2()</li>
				<li><a href="search">search</a>: @RequestParam 필수 아님 설정,
					SearchController.search()</li>
			</ul>
		</li>
		<li>커맨드 객체, @ModelAttribute:
			<ul>
				<li><a href="member/regist">/member/regist</a>: 커맨드 객체,
					@ModeAttribute로 커맨드 객체 이름 지정, RegistrationController</li>
				<li><a href="acl/list">/acl/list</a>: 커맨드 객체 리스트 처리,
					AclController
					<ul>
						<li>로그인 기능 수행 후, 실행</li>
						<li>또는, sample.xml이나 SampleConfig.java에서 핸들러 인터셉서 설정을 주석 처리 후
							실행</li>
					</ul></li>
				<li><a href="member/modify?mid=m1">/member/modify?mid=m1</a>:
					GET/POST에서 동일 타입 커맨드 객체 사용하기, MemberModificationController</li>
				<li><a href="event/list">/event/list</a>: @ModelAttribute를 이용한
					공통 모델, EventController.recommend()</li>
			</ul>
		</li>


	</ul>
</body>
</html>