<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.errors {
	color: red;
}
</style>
</head>
<body>

	<c:if test="${erreurs != null}">
		<ul class="errors">
			<c:forEach items="${erreurs}" var="err">
				<li>${err}</li>
			</c:forEach>
		</ul>
	</c:if>

	<form method="post" action="page4validation.htm">
		<input type="text" name="login" /> <input type="password"
			name="password" /> <input type="submit" />
	</form>

</body>
</html>