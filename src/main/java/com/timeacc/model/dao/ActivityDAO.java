package com.timeacc.model.dao;

import com.timeacc.model.entity.ActivCategory;
import com.timeacc.model.entity.Activity;
import com.timeacc.model.entity.ActivityState;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static com.timeacc.model.DBManager.*;

public class ActivityDAO extends AbstractDAO {
    private static final Logger logger = Logger.getLogger("com.timeacc.model.dao.ActivityDAO");
    ActivCategoryDAO activCategoryDAO = new ActivCategoryDAO();

    public void insertActivity(Activity activity) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = getInstance().getConnection();
            ps = con.prepareStatement("INSERT INTO activities(activity_name_ua, activity_name_en, init_date, end_date, activ_categoryID, activity_state)" +
                    "VALUES (?, ?, ?, ?, ?, ?)");
            ps.setString(1, activity.getActivityNameUa());
            ps.setString(2, activity.getActivityNameEn());
            ps.setTimestamp(3, activity.getInitDate());
            ps.setTimestamp(4, activity.getEndDate());
            ps.setInt(5, activity.getActivCategory().getId());
            ps.setString(6, activity.getActivityState().toString());
            ps.executeUpdate();
        }
        catch (SQLException e) {
            logger.severe(e.getMessage());
        }
        finally {
            close(con);
            close(ps);
        }
    }
    public Activity getPlainActivityByName(String name) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Activity activity = null;
        try {
            con = getInstance().getConnection();
            ps = con.prepareStatement("SELECT * FROM activities " +
                    "WHERE activity_name_ua=? OR activity_name_en=?");
            ps.setString(1, name);
            ps.setString(2, name);
            rs = ps.executeQuery();
            rs.next();
            activity = new Activity();
            activity.setId(rs.getInt(1));
            activity.setActivityNameUa(rs.getString(2));
            activity.setActivityNameEn(rs.getString(3));
            activity.setInitDate(rs.getTimestamp(4));
            activity.setEndDate(rs.getTimestamp(5));
            switch (rs.getString(6)) {
                case "NOTSTARTED" : activity.setActivityState(ActivityState.NOTSTARTED);
                break;
                case "PROCESS" : activity.setActivityState(ActivityState.PROCESS);
                break;
                case "FAILED" : activity.setActivityState(ActivityState.FAILED);
                break;
                default : throw new SQLException();
            }
            ActivCategory activCategory = activCategoryDAO.getActivCategoryById(rs.getInt(7));
            activity.setActivCategory(activCategory);
        }
        catch (SQLException e) {
            logger.severe(e.getMessage());
        }
        finally {
            close(con);
            close(ps);
            close(rs);
        }
        return activity;
    }

    public Activity getPlainActivityById(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Activity activity = null;
        try {
            con = getInstance().getConnection();
            ps = con.prepareStatement("SELECT * FROM activities " +
                    "WHERE activityID=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            activity = new Activity();
            activity.setId(rs.getInt(1));
            activity.setActivityNameUa(rs.getString(2));
            activity.setActivityNameEn(rs.getString(3));
            activity.setInitDate(rs.getTimestamp(4));
            activity.setEndDate(rs.getTimestamp(5));
            switch (rs.getString(6)) {
                case "NOTSTARTED" : activity.setActivityState(ActivityState.NOTSTARTED);
                    break;
                case "PROCESS" : activity.setActivityState(ActivityState.PROCESS);
                    break;
                case "FAILED" : activity.setActivityState(ActivityState.FAILED);
                    break;
                default : throw new SQLException();
            }
            ActivCategory activCategory = activCategoryDAO.getActivCategoryById(rs.getInt(7));
            activity.setActivCategory(activCategory);
        }
        catch (SQLException e) {
            logger.severe(e.getMessage());
        }
        finally {
            close(con);
            close(ps);
            close(rs);
        }
        return activity;
    }
    
    public Activity getActivityWithUsers(String name) {
        Activity activity = null;
        UsersActivitiesDAO usersActivitiesDAO = new UsersActivitiesDAO();
        activity = getPlainActivityByName(name);
        activity.setUsers(usersActivitiesDAO.getUsersByActivityId(activity.getId()));
        return activity;
    }

    public List<Activity> getAllActivities() {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        Activity activity = null;
        ActivCategory activCategory = null;
        List<Activity> activityList = new ArrayList<>();
        try {
            con = getInstance().getConnection();
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM activities");
            while (rs.next()) {
                activity = new Activity();
                activity.setId(rs.getInt(1));
                activity.setActivityNameUa(rs.getString(2));
                activity.setActivityNameEn(rs.getString(3));
                activity.setInitDate(rs.getTimestamp(4));
                activity.setEndDate(rs.getTimestamp(5));
                switch (rs.getString(6)) {
                    case "NOTSTARTED" : activity.setActivityState(ActivityState.NOTSTARTED);
                        break;
                    case "PROCESS" : activity.setActivityState(ActivityState.PROCESS);
                        break;
                    case "FAILED" : activity.setActivityState(ActivityState.FAILED);
                        break;
                    default : throw new SQLException();
                }
                activCategory = activCategoryDAO.getActivCategoryById(rs.getInt(7));
                activity.setActivCategory(activCategory);
                activityList.add(activity);
            }
        }
        catch (SQLException e) {
            logger.severe(e.getMessage());
        }
        finally {
            close(con);
            close(st);
            close(rs);
        }
        return activityList;
    }
    
    public void deleteActivity(String name) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = getInstance().getConnection();
            ps = con.prepareStatement("DELETE FROM activities WHERE activity_name_ua=? OR activity_name_en=?");
            ps.setString(1, name);
            ps.setString(2, name);
            ps.executeUpdate();
        }
        catch (SQLException e) {
            logger.severe(e.getMessage());
        }
        finally {
            close(con);
            close(ps);
        }
    }
}
