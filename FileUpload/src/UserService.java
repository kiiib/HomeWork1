/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Jianbin Liu
 */
public class UserService {
    private PreparedStatement ptmt = null;
    private ResultSet rs = null;
    private Connection conn = null;
    
    public void Register(Users users) {
        String sql = "insert into tb_user(username,password) values(?,?)";
        try {
            conn = Util.getConnection();
            ptmt = conn.prepareStatement(sql);
            ptmt.setString(1, users.getUsername());
            ptmt.setString(2, users.getPassword());
            ptmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Util.closeAll(conn, ptmt, rs);
        }
    }

    public Boolean Login(Users users){
        String sql = "Select username,password from tb_user where username=? and password=? ";
        try {
            conn = Util.getConnection();
            ptmt = conn.prepareStatement(sql);
            ptmt.setString(1, users.getUsername());
            ptmt.setString(2, users.getPassword());
            rs = ptmt.executeQuery();
            if (rs.next()) {
                return true;
            } 
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Util.closeAll(conn, ptmt, rs);
        }
        return false;
    }
}
