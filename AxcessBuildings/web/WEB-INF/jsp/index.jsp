<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body bgcolor="#E6E6FA">
        <a href="newBuilding.htm">New Buildings</a>
        <p>Buildings Program</p>
        <f:form action="find.htm" modelAttribute="search">

            <input type="text" name="keyword"/>
            <button type="submit">Search</button>
        </f:form>
        <table border="1">
            <tr>
                <th>Name</th>
                <th>Floors</th>
                <th>Room</th>
                <th>Address</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${buildingList}" var="building">
                <tr> 
                    <td>${building.name}</td>
                    <td>${building.floors}</td>
                    <td>${building.rooms}</td>
                    <td>${building.addressline.address},${building.addressline.city},${building.addressline.state},${building.addressline.zip}</td>
                    <td><a href="edit.htm?id=${building.id}">Edit</a>|<a href="delete.htm?id=${building.id}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
