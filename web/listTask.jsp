<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="bean.TaskBean"%>
<%@ page import="dao.TaskDao"%>
<%@ page import="java.util.*"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Add/Update/Delete Task</title>
    </head>
    <body>
        <%
            TaskDao dao = new TaskDao();
            List<TaskBean> taskList = dao.getAllTasks();
        %>
        <p><b>Add/Update/Delete Task</b></p>
        <table border="1">
            <tr>
                <th>Task Id</th>
                <th>Task Name</th>
                <th>Task Description</th>
                <th>Date Created</th>
                <th>Date Updated</th>
            </tr>
            <%
                for (TaskBean task : taskList) {
            %>	
            <tr>     
                <td><%=task.getTaskId()%></td>
                <td><%=task.getTaskName()%></td>
                <td><%=task.getTaskDescription()%></td>
                <td><%=task.getDateCreated()%></td>
                <td><%=task.getDateUpdated()%></td>
                <td><a href="TaskHandler?action=editform&taskId=<%=task.getTaskId()%>">Update</a></td>
                <td><a href="TaskHandler?action=delete&taskId=<%=task.getTaskId()%>">Delete</a></td>

            </tr>
            <%
                }
            %>
        </table>
        <p><a href="task.jsp">Add Task</a></p>
    </body>
</html>