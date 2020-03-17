<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="chap07.event.EventType" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>이벤트 생성</title>
</head>
<body>

<form:form commandName="eventForm" action="${pageContext.request.contextPath}/newevent/done">

<label>이벤트 명</label>: <c:out value="${eventForm.name}" /> <br>
<label>타입</label>: ${eventForm.type} <br>

<label>이벤트 기간</label>: 
<c:if test="${eventForm.beginDate != null}">
<fmt:formatDate value="${eventForm.beginDate}" pattern="yyyyMMdd"/>부터
</c:if>
<c:if test="${eventForm.endDate != null}">
<fmt:formatDate value="${eventForm.endDate}" />까지 
</c:if>
<br>

<label>적용 회원 등급</label>: ${eventForm.target == 'all' ? '모든 회원' : '프리미엄 회원' }
<br>

<a href="${pageContext.request.contextPath}/newevent/step2">[이전 단계로]</a>
<input type="submit" value="이벤트 생성 완료" />
</form:form>

세션 존재 여부: <%= session.getAttribute("eventForm") != null ? "존재" : "없음" %>
</body>
</html>