Test assignment for Ataccama Inc. Interview completed by Pavel Pratasevich

API documentation for each tasks 1 & 2 is provided in Task1API.md and Task2API.md respectively.

Database Vendor Selected - MariaDB

Note: Before deployment, please change DB connection settings in the application.properties file

spring.datasource.url=jdbc:mariadb://localhost/dbName
spring.datasource.username=user
spring.datasource.password=password

Storage table is created when the app is started and destroyed when it stops. To change this behavior, 
modify the following property value:

spring.jpa.hibernate.ddl-auto=create-drop

Possible values: create, create-drop, validate, update

*****************************************************************************************************

Task Description:

TLDR: This task is about implementing of web based database browser (similar to desktop
application DBeaver) with basic functionality and for single database vendor only. Browser
should be able to register multiple database connections and browse their data and structure.
The result should be RESTful service with its own database.
This task should be implemented in Java. Database for persistence of data is your choice. If no
other information about technology specified, you can use whatever technologies/frameworks
you like.
Non-functional requirements:
● Use spring-boot (Spring MVC)
● Use git and send us your repository with a solution

Task 1:
Implement backend for saving, updating, listing and deleting connection details to you favourite
relational database.
E.g. If you choose the MySQL database, you should persist at least the following properties:
● name - custom name of the database instance
● hostname - hostname of the database
● port - port where the database runs
● databaseName - name of the database
● username - username for connecting to the database
● password - password for connecting to the database
Connection details themselves should be stored in database of your choice.

Task 2:
Design and implement REST API for browsing structure and data using your stored database
connections from Task 1. Your API should support the following operations:
● Listing schemas (if your selected database supports them)
● Listing tables
● Listing columns
● Data preview of the table
Resources should contain as much information you can find (data type, if it is primary key, etc.).

Bonus tasks:
Design and implement REST API endpoints for statistics:
● Single endpoint for statistics about each column: min, max, avg, median value of the
column.
● Single endpoint for statistics about each table: number of records, number of attributes.
● Document this REST API