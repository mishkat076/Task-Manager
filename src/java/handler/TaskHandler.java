package handler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TaskDao;
import bean.TaskBean;

public class TaskHandler extends HttpServlet {

    private static final String Insert = "/task.jsp";
    private static final String Edit = "/edit.jsp";
    private static final String TaskRecord = "/listTask.jsp";
    private final TaskDao dao;

    public TaskHandler() {
        super();
        dao = new TaskDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String redirect = "";
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("insert")) {
            TaskBean task = new TaskBean();
            task.setTaskName(request.getParameter("taskName"));
            task.setTaskDescription(request.getParameter("taskDescription"));
            dao.addTask(task);
            redirect = TaskRecord;
            request.setAttribute("tasks", dao.getAllTasks());
            System.out.println("Record Added Successfully");
        } else if (action.equalsIgnoreCase("delete")) {
            String tId = request.getParameter("taskId");
            int taskId = Integer.parseInt(tId);
            dao.removeTask(taskId);
            redirect = TaskRecord;
            request.setAttribute("tasks", dao.getAllTasks());
            System.out.println("Record Deleted Successfully");
        } else if (action.equalsIgnoreCase("editform")) {
            redirect = Edit;
        } else if (action.equalsIgnoreCase("edit")) {
            String tId = request.getParameter("taskId");
            int taskId = Integer.parseInt(tId);
            TaskBean task = new TaskBean();
            task.setTaskId(taskId);
            task.setTaskName(request.getParameter("taskName"));
            task.setTaskDescription(request.getParameter("taskDescription"));
            dao.editTask(task);
            request.setAttribute("task", task);
            redirect = TaskRecord;
            System.out.println("Record updated Successfully");
        } else if (action.equalsIgnoreCase("listTask")) {
            redirect = TaskRecord;
            request.setAttribute("tasks", dao.getAllTasks());
        } else {
            redirect = Insert;
        }

        RequestDispatcher rd = request.getRequestDispatcher(redirect);
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
