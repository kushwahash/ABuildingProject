<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add New Building Details</title>
    </head>

    <body bgcolor="#E6E6FA">
        <table border="1">
            <f:form action = "create.htm" modelAttribute="building">
                <tr><td>Name</td><td><input type="text" name="name" /></td></tr>
                <tr><td>Floor</td><td><input type="text" name="floors"/></td></tr>           
                <tr><td>Room</td><td><input type="text" name="rooms"/></td></tr>
                <tr><td>Address</td><td> <input type="text" name="addressline.address"/></td></tr>
                <tr><td>City</td><td> <input type="text" name="addressline.city"/></td></tr>         
                <tr><td>State</td><td><input type="text" name="addressline.state"/></td></tr>
                <tr><td>Zip</td><td><input type="text" name="addressline.zip"/></td></tr>
                <tr><td><input type="submit" value="Save"></td></tr>
              </f:form>
        </table>
    </body>
</html>
