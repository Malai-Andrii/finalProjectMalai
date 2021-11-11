package com.timeacc.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

public class DBManager {
    public static final Logger logger = Logger.getLogger("");

    private static DBManager dbManager;
    private static final Properties prop = new Properties();


    private DBManager() {
        try (FileInputStream fis = new FileInputStream("src\\main\\resources\\application.properties")) {
            prop.load(fis);
        } catch (IOException e) {
            logger.severe(e.getMessage());
        }
    }

    public static DBManager getInstance() {
        if (dbManager == null) {
            dbManager = new DBManager();
        }
        return dbManager;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(prop.getProperty("url"));
    }
}
