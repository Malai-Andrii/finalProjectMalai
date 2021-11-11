package com.timeacc.model.dao;

import com.timeacc.model.entity.Activity;
import com.timeacc.model.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.timeacc.model.DBManager.*;

public class UsersActivitiesDAO extends AbstractDAO {
    public List<User> getUsersByActivityId(int activityId) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<User> userList = new ArrayList<>();
        UserDAO userDAO = new UserDAO();
        try {
            con = getInstance().getConnection();
            ps = con.prepareStatement("SELECT userID FROM users_activities WHERE activityID=?");
            ps.setInt(1, activityId);
            rs = ps.executeQuery();
            while (rs.next()) {
                userList.add(userDAO.getPlainUserById(rs.getInt(1)));
            }
        }
        catch (SQLException e) {
            logger.severe(e.getMessage());
        }
        finally {
            close(con);
            close(ps);
            close(rs);
        }
        return userList;
    }

    public List<Activity> getActivitiesByUserId(int userId) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Activity> activityList = new ArrayList<>();
        ActivityDAO activityDAO = new ActivityDAO();
        try {
            con = getInstance().getConnection();
            ps = con.prepareStatement("SELECT activityID FROM users_activities WHERE userID=?");
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            while (rs.next()) {
                activityList.add(activityDAO.getPlainActivityById(rs.getInt(1)));
            }
        }
        catch (SQLException e) {
            logger.severe(e.getMessage());
        }
        finally {
            close(con);
            close(ps);
            close(rs);
        }
        return activityList;
    }
}
