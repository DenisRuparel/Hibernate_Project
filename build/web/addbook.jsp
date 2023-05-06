<%-- 
    Document   : addbook
    Created on : 3 May, 2023, 1:57:06 PM
    Author     : Denis Ruparel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Book</title>
    </head>
    <body>
        <h1>Add Your Book Here...!</h1>
        <form action="AddBook" method="post">  
            <!--ID:<input type="number" name="id"/><br/><br/>-->
            Book Title:<input type=text name="bname"/><br/><br/>
            Book Catagory:<input type="text" name="bcatagory"/><br/><br/>
            Book Author:<input type="text" name="bauthor"/><br/><br/>
            Book Price:<input type="number" name="bprice"/><br/><br/>
            <input type="submit" value="Add Book"/><br/><br/>
        </form>
        <h3><a href="index.html">Back to Main Menu</a></h3>
    </body>
</html>
