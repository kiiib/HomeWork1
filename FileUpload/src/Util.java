/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Jianbin Liu
 */
public class Util {
    public static  Connection getConnection(){
        String driverClassName="com.mysql.jdbc.Driver";
        String URL = "jdbc:mysql://localhost:3306/upload";
        String username = "root";
        String password = "admin";
        Connection conn=null;
            try {
                Class.forName(driverClassName);
                conn = DriverManager.getConnection(URL, username, password);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return conn;
    }

    public static  void closeAll( Connection conn, Statement stmt, ResultSet rs){
            try {
                if(conn!=null){
                    conn.close();
                }
                if(stmt!=null){
                    stmt.close();
                }if(rs!=null){
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

    }
	
    
}
