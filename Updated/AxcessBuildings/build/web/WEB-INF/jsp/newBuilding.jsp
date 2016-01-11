<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript">
            function updateFloorRows(){
                var floors = parseInt(document.getElementById("totalFloor").value);
                var floorDiv = document.getElementById("floorDiv").childElementCount;
               var table = document.getElementById("bTable");
                //alert(table.rows.length);
                var totalRows = table.rows.length - 1;
                //add condtion
               // if(floors > totalRows){
                   // alert(document.getElementById("totalFloor").value);
                   // alert(table.rows.length);
                    var loopvalue = (table.rows.length - 1) + parseInt(document.getElementById("totalFloor").value);
                   // loopvalue= loopvalue + document.getElementById("totalFloor").value;
                  //  alert(loopvalue);
                   var counter = 0;
                    for(var i=6;i<floors+6;i++){
                                // Create an empty <tr> element and add it to the 1st position of the table:
                       var row = table.insertRow(i);

                       // Insert new cells (<td> elements) at the 1st and 2nd position of the "new" <tr> element:
                       var cell1 = row.insertCell(0);
                       var cell2 = row.insertCell(1);
                       var cell3  =row.insertCell(2);
                       var cell4 = row.insertCell(3);
                      
                       // Add some text to the new cells:
                       cell1.innerHTML = "Floor";
                       cell2.innerHTML = "<input class='form-field' type='number' readonly='readonly' value="+(counter+1)+" name='floors["+(counter)+"].floorNumber' />";
                       cell3.innerHTML= "Rooms";
                       cell4.innerHTML= "<input class='form-field' type='number' min='1' name='floors["+(counter)+"].roomNumber' />";
                       counter = counter + 1;
                       //alert(counter);
                    }
               // }
               
               
            }
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
        <table width="100%" class="form-container" id="bTable">
          
        <f:form action = "create.htm" modelAttribute="building" class="form-container">
                <tr><td width="25%" class="form-title">Name</td><td width="75%"><input class="form-field" type="text" name="name"/></td></tr>

                <tr><td width="25%" class="form-title">Address</td><td width="75%"> <input class="form-field" type="text" name="addressline.address" /></td></tr>
                <tr><td width="25%" class="form-title">City</td><td width="75%"> <input class="form-field" type="text" name="addressline.city"/></td></tr>         
                <tr><td width="25%" class="form-title">State</td><td width="75%"><input class="form-field" type="text" name="addressline.state"/></td></tr>
                <tr><td width="25%" class="form-title">Zip</td><td width="75%"><input class="form-field" type="number"  name="addressline.zip"/></td></tr>
                <tr><td width="25%" class="form-title">Total Floor</td><td width="75%"><input class="form-field" type="number" min="1" id="totalFloor"  onchange="updateFloorRows()"/></td></tr>
                <div id="floorDiv">
                    <c:forEach items="${building.floors}" var="fdetails" varStatus="status">
                        <tr>
                        <td width="25%" class="form-title">Floor</td><td width="25%"><input class="form-field" type="number" readonly="readonly" name="fdetails[${status.index}].floorNumber" /></td>
                        <td width="25%" class="form-title">Rooms</td><td width="25%"><input class="form-field" type="number" min="1" name="fdetails[${status.index}].roomNumber" /></td>
                        </tr>
                     </c:forEach>
                </div>    
                
                        <tr><td width="50%"><input class="submit-button" type="submit"/></td>
                            <td width="50%"><input type="button" value="Cancel" class="submit-button"/></td>
                        </tr>
            </f:form>
        </table>
        
    </section>



</body>

</html>

