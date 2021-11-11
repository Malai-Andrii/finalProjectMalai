package com.timeacc;

import com.timeacc.model.DBManager;
import com.timeacc.model.dao.ActivCategoryDAO;
import com.timeacc.model.entity.ActivCategory;
import org.junit.*;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ActivCategoryDAOTest {
    private static final String JDBC_DRIVER = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:~/tester";
    private static final String URL_CONNECTION = "jdbc:h2:~/tester;user=root;password=root;";
    private static final String USER = "root";
    private static final String PASS = "root";

    private static DBManager dbManager;


    @BeforeClass
    public static void beforeTest() throws SQLException, ClassNotFoundException {
        Class.forName(JDBC_DRIVER);

        try (OutputStream output = new FileOutputStream("src\\main\\resources\\application.properties")) {
            Properties prop = new Properties();
            prop.setProperty("url", URL_CONNECTION);
            prop.store(output, null);
        } catch (IOException io) {
            io.printStackTrace();
        }

        dbManager = DBManager.getInstance();

        try (Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement statement = con.createStatement()) {
            String dropSql = "DROP TABLE IF EXISTS activ_categories;";
            String sql = "CREATE TABLE IF NOT EXISTS activ_categories (\n" +
                    "  activ_categoryID INTEGER(11) NOT NULL AUTO_INCREMENT,\n" +
                    " activ_category_name_ua VARCHAR(32) NOT NULL, \n" +
                    " activ_category_name_en VARCHAR(32) NOT NULL, \n" +
                    "  PRIMARY KEY (activ_categoryID));";
            statement.executeUpdate(dropSql);
            statement.executeUpdate(sql);
        }
    }

    @AfterClass
    public static void afterTest() throws SQLException, ClassNotFoundException {
        try (OutputStream output = new FileOutputStream("src\\main\\resources\\application.properties")) {
            Properties prop = new Properties();
            prop.setProperty("url", "jdbc:mysql://localhost:3306/timeacc?user=root&password=root&serverTimezone=UTC");
            prop.store(output, null);
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    @Test
    public void insertActivCategoryWithGetsTest() {
        ActivCategoryDAO activCategoryDAO = new ActivCategoryDAO();
        ActivCategory activCategory = new ActivCategory();
        activCategory.setId(1);
        activCategory.setActivCategoryNameUa("українська");
        activCategory.setActivCategoryNameEn("english");
        activCategoryDAO.insertActivCategory(activCategory);
        ActivCategory activCategoryAfter1 = activCategoryDAO.getActivCategoryById(1);
        ActivCategory activCategoryAfter2 = activCategoryDAO.getActivCategoryByName("english");
        Assert.assertEquals(activCategory.toString(), activCategoryAfter1.toString(), activCategoryAfter2.toString());
    }
}
