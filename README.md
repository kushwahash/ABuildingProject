# ABuildingProject
Simple Spring MVC + Hibernate Project with MYSQL, JSP is used for view layer

In this project, I am providing a very simple GUI for creating,editing,delete a building details. I have used NetBeans as IDE.
MYSQL is used as database with only one table Buildings.


Step to Run the project on your own machine.
1. Create a database buildings_schema
2. Create table buildings.

CREATE TABLE Buildings
(
B_Id int NOT NULL AUTO_INCREMENT,
Name varchar(255) NOT NULL,
Address varchar(50),
City varchar(30),
State varchar(25),
Zip int,
Floors int NOT NULL,
Rooms int NOT NULL, 
PRIMARY KEY (B_Id,Name)
);

3. Setup the MYSQL connection details with connection URL,username and password in the hibernate.cfg.xml file.

4. Create the war and deploy it in your server, I am using Tomcat for it.

5. You can also import the project, do the database changes and try to run it directly from the IDE.

6. Please note, I have not done any JavaScrpt validation till now on the forms. So the project can throw exception. Also, the search functionality work based on the name of the buildings.

7. I will improve the project during the weekend.

 


