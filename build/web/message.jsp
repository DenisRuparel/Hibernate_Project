<%-- 
    Document   : message
    Created on : 3 May, 2023, 2:15:48 PM
    Author     : Denis Ruparel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String status = (String) session.getAttribute("status");
            if (status != null) {
                out.println("<h2>" + status + "</h2>");
            }
            String op = (String) session.getAttribute("op");
            if (op != null) {
                out.println(op);
            }
            session.invalidate();
        %>
        <br/><br/>
        <h3><a href="index.html">Back to Main Menu</a></h3>
    </body>
</html>
