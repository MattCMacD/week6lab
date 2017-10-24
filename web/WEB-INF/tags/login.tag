<%-- 
    Document   : login
    Created on : Oct 24, 2017, 1:29:28 PM
    Author     : 728918
--%>

<%@tag description="contains body of login jsp" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="userName"%>
<%@attribute name="pass"%>
<%@attribute name="messageIt"%>

<%-- any content can be specified here e.g.: --%>


<form action="login" method="post">
        <h1>Login</h1><br>
        Username: <input type="textfield" name="uname" value="${userName}"><br>
        Password: <input type="password" name="psswrd" value="${pass}"><br>
        <input type="submit" value="Login">
        <br><input type="checkbox" name="rememberme" value="1">Remember me
        <br>${messageIt}
    </form>