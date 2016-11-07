<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<head>
<link href="<c:url value="/resources/css/Lobby.css" />"
	rel="stylesheet">

</head>
<body>


<div class="messageholder">
<c:if test="${not empty error}">
        			<div class="RegistryError">${error.getMessage()}</div>
        		</c:if>
        		<c:if test="${not empty Accepted}">
        			<div class="accepted">${Accepted.getMessage()}</div>
        		</c:if>

        		<a href="${pageContext.request.contextPath}/recruitment/login">Home</a>
</div>


</body>
</html>