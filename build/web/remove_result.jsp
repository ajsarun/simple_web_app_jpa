<%-- 
    Document   : remove_result
    Created on : Nov 22, 2020, 4:54:47 PM
    Author     : sarun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Remove Result</title>
    </head>
    <body>
       <h1><%= request.getAttribute("rowDeleted") + " row deleted " %> </h1>
        </br>
        <jsp:include page="show_employee.jsp" flush="true" />
    </body>
</html>
