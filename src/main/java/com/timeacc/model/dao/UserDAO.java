package com.timeacc.model.dao;

import com.timeacc.model.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static com.timeacc.model.DBManager.*;

public class UserDAO extends AbstractDAO {
    private static final Logger logger = Logger.getLogger("com.timeacc.model.dao.UserDAO");

    public void insertUser(User user) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = getInstance().getConnection();
            ps = con.prepareStatement("INSERT INTO users(email, user_name, password)" +
                    "VALUES (?, ?, ?)");
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getName());
            ps.setString(3, user.getPassword());
            ps.executeUpdate();
        }
        catch (SQLException e) {
            logger.severe(e.getMessage());
        }
        finally {
            close(con);
            close(ps);
        }
    };
    public User getUserWithActivities(String email) {
        User user = null;
        UsersActivitiesDAO usersActivitiesDAO = new UsersActivitiesDAO();
        user = getPlainUserByEmail(email);
        user.setActivities(usersActivitiesDAO.getActivitiesByUserId(user.getId()));
        return user;
    };

    public User getPlainUserByEmail(String email) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        try {
            con = getInstance().getConnection();
            ps = con.prepareStatement("SELECT * FROM users WHERE email=?");
            ps.setString(1, email);
            rs = ps.executeQuery();
            rs.next();
            user = new User();
            user.setId(rs.getInt(1));
            user.setEmail(rs.getString(2));
            user.setName(rs.getString(3));
            user.setPassword(rs.getString(4));}
        catch (SQLException e) {
            logger.severe(e.getMessage());
        }
        finally {
            close(con);
            close(ps);
            close(rs);
        }
        return user;
    }

    public User getPlainUserById(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        try {
            con = getInstance().getConnection();
            ps = con.prepareStatement("SELECT * FROM users WHERE userID=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            user = new User();
            user.setId(rs.getInt(1));
            user.setEmail(rs.getString(2));
            user.setName(rs.getString(3));
            user.setPassword(rs.getString(4));}
        catch (SQLException e) {
            logger.severe(e.getMessage());
        }
        finally {
            close(con);
            close(ps);
            close(rs);
        }
        return user;
    }

    public List<User> getAllUsers() {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        User user = null;
        List<User> userList = new ArrayList<>();
        try {
            con = getInstance().getConnection();
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt(1));
                user.setEmail(rs.getString(2));
                user.setName(rs.getString(3));
                user.setPassword(rs.getString(4));
                userList.add(user);
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
        return userList;
    }

    public void deleteUserByEmail(String email) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = getInstance().getConnection();
            ps = con.prepareStatement("DELETE FROM users WHERE email=?");
            ps.setString(1, email);
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
