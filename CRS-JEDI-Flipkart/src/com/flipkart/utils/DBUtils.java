package com.flipkart.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Class for connection with DataBase
 */
public class DBUtils {
	
	/**
	 * Method to connect with SQL DataBase
	 * @return Connection object
	 */
	public static Connection getConnection() {
		Connection connection = null;
        if (connection != null)
            return connection;
        else 
        {
            try 
            {
            	
            	Properties prop = new Properties();
                InputStream inputStream = DBUtils.class.getClassLoader().getResourceAsStream("./config.properties");
                prop.load(inputStream);
                String url = prop.getProperty("url");
                String user = prop.getProperty("user");
                String password = prop.getProperty("password");
                connection = DriverManager.getConnection(url,user,password);
                
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return connection;
        }

    }
}