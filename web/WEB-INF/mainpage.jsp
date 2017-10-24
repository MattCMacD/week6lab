<%@page contentType="text/html" pageEncoding="utf-8"%>        
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="header.html" />
<sait:debug>
	Remote Host: ${pageContext.request.remoteHost}<br />
	Session ID: ${pageContext.session.id}
</sait:debug>

<h1>Main Page</h1><br>
               Hello, ${dasuser} <a href="login?logout=true">Logout</a>

<c:import url="footer.html" />