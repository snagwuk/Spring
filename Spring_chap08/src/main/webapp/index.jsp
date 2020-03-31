<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<body>
	<ul>
		<li>메시지 출력
			<ul>
				<li><a href="auth/login">/auth/login</a>: &it;spring:
					message&gt; 태그, IoginForm.jsp, LoginController</li>
			</ul>
		</li>

		<li>폼 및 에러 메시지:
			<ul>
				<li><a href="member/regist">/member/regist</a>: 폼,에러 메시지,
					registrationForm.jsp, RegistationController</li>
			</ul>
		</li>

		<li>커스텀 뷰:
			<ul>
				<li><a href="file/1">/file/1</a>: 파일 다운로드, DownLoadView,
					DownloadController.download()</li>
				<li><a href="pagestat/rank">/pagestat/rank</a>: 엑셀 다운로드,
					pageRankView, PageRankStatController.pageRank()</li>
				<li><a href="pagestat/rankreport">/pagestat/rankreport</a>: PDF
					다운로드, pageReport, PageRankStatController.pageRankReport()</li>
			</ul>
		</li>
	</ul>


</body>
</html>
