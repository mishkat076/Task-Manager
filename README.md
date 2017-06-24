* The project structure of the project can be found in ``` ./Project\ Structure.png ```
* The databse structure of the project can be found in ``` ./Database\ Structure.png ```

# The Project Structure:

* Only the part we need is kept

```
.
├── src
│   └── java
│       ├── bean
│       │   └── TaskBean.java
│       ├── dao
│       │   └── TaskDao.java
│       ├── dbconnection
│       │   └── ConnectionProvider.java
│       └── handler
│           └── TaskHandler.java
└── web
    ├── edit.jsp
    ├── listTask.jsp
    ├── task.jsp
    └── WEB-INF
        └── web.xml
```

## TaskBean.java: 
Simple POJO to hold task related informations (e.g. taskId, taskName, taskDescription, dateCreated, dateUpdated).

## TaskDao.java: 
DAO for the TaskHandler.java Servlet. It's purpose it to create an abstraction between the Servlet and the MySql Database.

## ConnectionProvide.java: 
Creates a connection with the MySql Database.

## TaskHander.java: 
Servlet to process the request from the TOMCAT Container and create a dynamic response.

## edit.jsp: 
JSP page where you can update an existing task.

## listTask.jsp: 
JSP page where you can add/update/delete task. This page is requested at the very beginning. 

## task.jsp: 
JSP page where you can add a new task.

## web.xml: 
Instructs the TOMCAT container on which servlet to use.

# The Database Structure:

```
CREATE TABLE tasks (
    taskId INT NOT NULL AUTO_INCREMENT,
    taskName VARCHAR(20) NOT NULL,
    taskDescription VARCHAR(100) DEFAULT NULL,
    dateCreated DATE NOT NULL,
    dateUpdated DATE DEFAULT NULL,
    PRIMARY KEY (taskID)
);
```
