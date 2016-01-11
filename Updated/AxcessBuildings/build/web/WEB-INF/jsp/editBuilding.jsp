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
               
                if(listvalue){
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
        <link href="<c:url value="/css/form-style.css"/>" type="text/css" rel="stylesheet" media="screen" />

    </head>
    <body onload="setTableDisplay('${buildingList}')">

    <header>
        <h1>
            A-Buildings Corporations
            <div id="searchbox">
                <f:form  action="find.htm" modelAttribute="search" >
                    <input id="search" type="text" name="keyword" placeholder="Search Buildings..."/>
                    <input type="submit" value="Search" onclick="setTableDisplay('${buildingList}')">
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
        <table width="100%" class="form-container">
          
        <f:form action = "update.htm" modelAttribute="building" class="form-container">
                <input type="hidden" name="id" value ="${editBuilding.id}"/>
                <tr><td width="25%" class="form-title">Name</td><td width="75%"><input class="form-field" type="text" name="name" value ="${editBuilding.name}" /></td></tr>

                <tr><td width="25%" class="form-title">Address</td><td width="75%"> <input class="form-field" type="text" name="addressline.address" value ="${editBuilding.addressline.address}"/></td></tr>
                <tr><td width="25%" class="form-title">City</td><td width="75%"> <input class="form-field" type="text" name="addressline.city"  value ="${editBuilding.addressline.city}"/></td></tr>         
                <tr><td width="25%" class="form-title">State</td><td width="75%"><input class="form-field" type="text" name="addressline.state" value ="${editBuilding.addressline.state}"/></td></tr>
                <tr><td width="25%" class="form-title">Zip</td><td width="75%"><input class="form-field" type="number"  name="addressline.zip" value ="${editBuilding.addressline.zip}"/></td></tr>
                <tr><td width="25%" class="form-title">Total Floor</td><td width="75%"><input class="form-field" type="number" min="1" id="totalFloor" value="${totalFloor}" onchange="updateFloorRows()"/></td></tr>
                
                    <c:forEach items="${editBuilding.floors}" var="fdetails" varStatus="status">
                        <tr> 
                        <td width="25%" class="form-title">Floor</td><td width="25%"><input class="form-field" type="number" readonly="readonly" name="floors[${status.index}].floorNumber" value ="${fdetails.floorNumber}"/></td>
                        <td width="25%" class="form-title">Rooms</td><td width="25%"><input class="form-field" type="number" min="1" name="floors[${status.index}].roomNumber" value ="${fdetails.roomNumber}"/></td>
                        </tr>
                     </c:forEach>
                    
                
                        <tr><td width="50%"><input class="submit-button" type="submit"/></td>
                            <td width="50%"><input type="button" value="Cancel" class="submit-button"/></td>
                        </tr>
            </f:form>
        </table>
        
    </section>



</body>

</html>

