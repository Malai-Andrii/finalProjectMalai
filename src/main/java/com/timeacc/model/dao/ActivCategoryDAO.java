package com.timeacc.model.dao;

import com.timeacc.model.entity.ActivCategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import static com.timeacc.model.DBManager.*;

public class ActivCategoryDAO extends AbstractDAO {
    private static final Logger logger = Logger.getLogger("com.timeacc.model.dao.ActivCategoryDAO");

    public void insertActivCategory(ActivCategory activCategory) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = getInstance().getConnection();
            ps = con.prepareStatement("INSERT INTO activ_categories (activ_category_name_ua, " +
                    "activ_category_name_en) VALUES (?, ?)");
            ps.setString(1, activCategory.getActivCategoryNameUa());
            ps.setString(2, activCategory.getActivCategoryNameEn());
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

    public ActivCategory getActivCategoryByName(String name) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ActivCategory activCategory = null;
        try {
            con = getInstance().getConnection();
            ps = con.prepareStatement("SELECT * FROM activ_categories " +
                    "WHERE activ_category_name_ua=? OR activ_category_name_en=?");
            ps.setString(1, name);
            ps.setString(2, name);
            rs = ps.executeQuery();
            rs.next();
            activCategory = new ActivCategory();
            activCategory.setId(rs.getInt(1));
            activCategory.setActivCategoryNameUa(rs.getString(2));
            activCategory.setActivCategoryNameEn(rs.getString(3));
        }
        catch (SQLException e) {
            logger.severe(e.getMessage());
        }
        finally {
            close(con);
            close(ps);
            close(rs);
        }
        return activCategory;
    }

    public ActivCategory getActivCategoryById(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ActivCategory activCategory = null;
        try {
            con = getInstance().getConnection();
            ps = con.prepareStatement("SELECT activ_category_name_ua, activ_category_name_en " +
                    "FROM activ_categories " +
                    "WHERE activ_categoryID=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            activCategory = new ActivCategory();
            activCategory.setId(id);
            activCategory.setActivCategoryNameUa(rs.getString(1));
            activCategory.setActivCategoryNameEn(rs.getString(2));
        }
        catch (SQLException e) {
            logger.severe(e.getMessage());
        }
        finally {
            close(con);
            close(ps);
            close(rs);
        }
        return activCategory;
    }
}
