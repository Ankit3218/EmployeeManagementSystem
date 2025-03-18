 # Employee Management System(Using JDBC)

A simple Java-based Employee Management System using JDBC.

 How to Run the Project  
1.
Prerequisites  
Ensure you have the following installed on your system:  
Java JDK 17+** (Download from [Oracle](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html))  
MySQL Database** (Download from [MySQL](https://dev.mysql.com/downloads/installer/))  
Git (Optional for version control)** (Download from [Git](https://git-scm.com/downloads))  

Steps to Run  
 Clone the Repository (or Download ZIP)
```sh
git clone https://github.com/yourusername/your-repository.git
cd your-repository

2.
Configure Database
Open MySQL Command Line or MySQL Workbench.

Run the following SQL script to create the database and table

CREATE DATABASE EmployeeDB;
USE EmployeeDB;
CREATE TABLE Employees (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100)NOT NULL,
    age INT NOT NULL,
    department VARCHAR(50) NOT NULL,
    sallary DECIMAL(10,2) NOT NULL
);

3.
Update database connection details in DatabaseConfig.java

String url = "jdbc:mysql://localhost:3306/employee_db";
String user = "root";
String password = "your_password";

4.
Download MySQL Connector
Download MySQL Connector JAR and place it in the project folder

Compile & Run the Java Program
javac -cp ".;mysql-connector-java-8.0.23.jar" EmployeeManagement.java
java -cp ".;mysql-connector-java-8.0.23.jar" EmployeeManagement


Using an IDE (Eclipse/IntelliJ)
1.Open the project in your IDE.
2.Ensure MySQL Connector JAR is added to the classpath.
3.Run EmployeeManagement.java

Features
✅ Add Employee
✅ View Employee List
✅ Update Employee Details
✅ Delete Employee
✅ Exit


Feel free to fork and contribute!

📧 Contact: Ark17072002@gmail.com




