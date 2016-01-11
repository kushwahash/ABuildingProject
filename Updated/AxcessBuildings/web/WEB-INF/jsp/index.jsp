<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript">
            function setTableDisplay(listvalue){
                var d = new Date();
                document.getElementById("userdate").innerHTML = d.toDateString();
                
                if(listvalue == 1){
                   document.getElementsByClassName("CSSTableGenerator")[0].style.display="block";                     
               }
                else{
                   document.getElementsByClassName("CSSTableGenerator")[0].style.display="none";                                     
               }
            }            
        </script>
        <style>
            html,body  {
                height: 100%;
                width:100%;
                background-image: url("<c:url value="/building-image/beauty_buildings.jpg"/>");

            }
        </style>
        <link href="<c:url value="/css/building-style.css"/>" type="text/css" rel="stylesheet" media="screen" />
         <link href="<c:url value="/css/table.css"/>" type="text/css" rel="stylesheet" media="screen" />

    </head>
    <body onload="setTableDisplay('${buildingResult}')">

    <header>
        <h1>
            A-Buildings Corporations
            <div id="searchbox">
                <f:form  action="find.htm" modelAttribute="search" >
                    <input id="search" type="text" name="keyword" placeholder="Search Buildings..."/>
                    <input type="submit" id="searchbutton" value="Search" onclick="setTableDisplay('${buildingList}')">
                </f:form> 
            </div>
                     <div><a href='newBuilding.htm' class='button'>New Building</a></div>
        </h1>
    </header>
    <div id="blankdiv"><p></p></div>
    
    <nav>
        <ui><img style="border-radius: 75px;" align="middle" src="<c:url value="/building-image/login_user.jpg"/>" width="250px" height="200px"/></ui><br/><br/>
        <ui>Hello Shailesh!</ui><br/>
        <ui><p id="userdate"></p></ui>
    </nav>
    
    <section>
        <div class="CSSTableGenerator">
        
            <table border="1">
            <tr>
                <td>Name</td>
                <td>Floor Details</td>
                <td>Address</td>
                <td>Action</td>
            </tr>
            <c:forEach items="${buildingList}" var="building">
                <tr> 
                    <td>${building.name}</td>
                    <td>
                        <c:forEach items="${building.floors}" var="fdetails">
                            Floor:${fdetails.floorNumber}&nbsp;&nbsp; Rooms::${fdetails.roomNumber} <br/>
                        </c:forEach>
                       
                    </td>
                    <td>${building.addressline.address},${building.addressline.city},${building.addressline.state},${building.addressline.zip}</td>
                    <td><a title="Edit" href="edit.htm?id=${building.id}"><img alt="Edit" src="<c:url value="/building-image/edit.jpg"/>" width="35" height="35"/></a>&nbsp;&nbsp;&nbsp;&nbsp;<a alt="Delete" href="delete.htm?id=${building.id}"> <img title="Delete" src="<c:url value="/building-image/delete.jpg"/>" width="35" height="35"/></a></td>
                </tr>
            </c:forEach>
        </table>
        
         </div>     
    </section>



</body>

</html>

