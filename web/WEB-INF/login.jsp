<%@page contentType="text/html" pageEncoding="utf-8"%>        
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ct" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="sait" uri="/WEB-INF/tlds/sait.tld" %>
<c:import url="header.html" />   

<sait:debug>
	Remote Host: ${pageContext.request.remoteHost}<br />
	Session ID: ${pageContext.session.id}
</sait:debug>
<ct:login userName="${dasuser}${cookie.username.value}" pass="${daspass}" messageIt="${message}"/>
    
    
<c:import url="footer.html" />