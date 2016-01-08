<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Building Details</title>
    </head>

    <body bgcolor="#E6E6FA">
        <table border="1">
            <f:form action = "update.htm" modelAttribute="building">
                <input type="hidden" name="id" value ="${editBuilding.id}"/>
                <tr><td>Name</td><td><input type="text" name="name" value ="${editBuilding.name}" /></td></tr>
                <tr><td>Floor</td><td><input type="text" name="floors"  value ="${editBuilding.floors}"/></td></tr>           
                <tr><td>Room</td><td><input type="text" name="rooms" value ="${editBuilding.rooms}"/></td></tr>
                <tr><td>Address</td><td> <input type="text" name="addressline.address" value ="${editBuilding.addressline.address}"/></td></tr>
                <tr><td>City</td><td> <input type="text" name="addressline.city"  value ="${editBuilding.addressline.city}"/></td></tr>         
                <tr><td>State</td><td><input type="text" name="addressline.state" value ="${editBuilding.addressline.state}"/></td></tr>
                <tr><td>Zip</td><td><input type="text" name="addressline.zip" value ="${editBuilding.addressline.zip}"/></td></tr>
                <tr><td><input type="submit" value="Save"></td></tr>
            </f:form>
        </table>
    </body>
</html>
