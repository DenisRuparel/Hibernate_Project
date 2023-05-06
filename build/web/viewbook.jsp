<%-- 
    Document   : viewbook
    Created on : 3 May, 2023, 2:35:40 PM
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
        <h1>View Book Here...!</h1>
        <form action="ViewBook" method="post">  
            ID:<input type="number" name="id"/><br/><br/>
            <input type="submit" value="View Book"/><br/><br/>
        </form>
        <form action="ViewAllBooks" method="post">  
            <input type="submit" value="View All Books"/><br/><br/>
        </form>
        <h3><a href="index.html">Back to Main Menu</a></h3>
    </body>
</html>
