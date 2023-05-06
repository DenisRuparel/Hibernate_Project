<%-- 
    Document   : delbook
    Created on : 3 May, 2023, 3:15:19 PM
    Author     : Denis Ruparel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Book</title>
    </head>
    <body>
         <h1>Delete Your Book Here...!</h1>
        <form action="DeleteBook" method="post">  
            ID:<input type="number" name="id"/><br/><br/>
            <input type="submit" value="Delete Book"/><br/><br/>
        </form>
        <h3><a href="index.html">Back to Main Menu</a></h3>
    </body>
</html>
