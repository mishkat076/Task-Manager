package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.TaskBean;
import dbconnection.ConnectionProvider;
import java.util.Date;

public class TaskDao {

    private final Connection conn;

    public TaskDao() {
        conn = ConnectionProvider.getConnection();
    }

    public void addTask(TaskBean taskBean) {
        try {
            String sql = "INSERT INTO tasks (taskName, taskDescription, dateCreated) VALUES (?, ?, now() )";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, taskBean.getTaskName());
            ps.setString(2, taskBean.getTaskDescription());
            ps.executeUpdate();

        } catch (SQLException e) {
        }
    }

    public void removeTask(int taskId) {
        try {
            String sql = "DELETE FROM tasks WHERE taskId=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, taskId);
            ps.executeUpdate();

        } catch (SQLException e) {
        }
    }

    public void editTask(TaskBean taskBean) {
        try {
            String sql = "UPDATE tasks SET taskName=?, taskDescription=?, dateUpdated=now() WHERE taskId=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, taskBean.getTaskName());
            ps.setString(2, taskBean.getTaskDescription());
            ps.setInt(3, taskBean.getTaskId());
            ps.executeUpdate();

        } catch (SQLException e) {
        }
    }

    public List getAllTasks() {
        List tasks = new ArrayList();
        try {
            String sql = "SELECT * FROM tasks";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TaskBean taskBean = new TaskBean();
                taskBean.setTaskId(rs.getInt("taskId"));
                taskBean.setTaskName(rs.getString("taskName"));
                taskBean.setTaskDescription(rs.getString("taskDescription"));
                taskBean.setDateCreated(rs.getDate("dateCreated") == null ? null : new Date(rs.getDate("dateCreated").getTime()));
                taskBean.setDateUpdated(rs.getDate("dateUpdated") == null ? null : new Date(rs.getDate("dateUpdated").getTime()));
                tasks.add(taskBean);
            }
        } catch (SQLException e) {
        }

        return tasks;
    }

    public TaskBean getTaskById(int taskId) {
        TaskBean taskBean = new TaskBean();
        try {
            String sql = "SELECT * FROM tasks WHERE taskId=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, taskId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                taskBean.setTaskId(rs.getInt("taskId"));
                taskBean.setTaskName(rs.getString("taskName"));
                taskBean.setTaskDescription(rs.getString("taskDescription"));
                taskBean.setDateCreated(rs.getDate("dateCreated") == null ? null : new Date(rs.getDate("dateCreated").getTime()));
                taskBean.setDateCreated(rs.getDate("dateUpdated") == null ? null : new Date(rs.getDate("dateUpdated").getTime()));
            }
        } catch (SQLException e) {
        }
        return taskBean;
    }
}
