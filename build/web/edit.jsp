<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="bean.TaskBean"%>
<%@ page import="dao.TaskDao"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Update Task</title>
    </head>
    <body>
        <%
            TaskBean task = new TaskBean();
        %>
        <%
            TaskDao dao = new TaskDao();
        %>
        <form method="POST" action='TaskHandler' name="frmEditTask">
            <input type="hidden" name="action" value="edit" /> 
            <%
                String tid = request.getParameter("taskId");
                if (!((tid) == null)) {
                    int taskId = Integer.parseInt(tid);
                    task = dao.getTaskById(taskId);
            %>
            <input type="hidden" name="taskId" value="<%=task.getTaskId()%>">
            <p><b>Update Task</b></p>
            <table>
                <tr>
                    <td>Task Name</td>
                    <td><input type="text" name="taskName" value="<%=task.getTaskName()%>"/></td>
                </tr>
                <tr>
                    <td>Task Description</td>
                    <td><input type="text" name="taskDescription" value="<%=task.getTaskDescription()%>"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Update" /></td>
                </tr>
            </table>
            <%
                } else
                    out.println("ID Not Found");
            %>
        </form>
    </body>
</html>