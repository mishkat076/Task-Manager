<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Add New Task</title>
    </head>
    <body>
        <form method="POST" action='TaskHandler' name="frmAddTask"><input
                type="hidden" name="action" value="insert" />
            <p><b>Add New Task</b></p>
            <table>
                <tr>
                    <td>Task Name</td>
                    <td><input type="text" name="taskName" /></td>
                </tr>
                <tr>
                    <td>Task Description</td>
                    <td><input type="text" name="taskDescription" /></td>
                </tr>	
                <tr>
                    <td></td>
                    <td><input type="submit" value="Submit" /></td>
                </tr>
            </table>
        </form>
    </body>
</html>