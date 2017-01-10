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
public class FileService {
    private Connection conn = null;
    private PreparedStatement ptmt = null;
    private ResultSet rs = null;

    public void savefile(File file) {
        String sql = (" insert into tb_file(filename,filecontent) values(?,?)");
        try
        {   conn=Util.getConnection();
            ptmt = conn.prepareStatement(sql);
            ptmt.setString(1, file.getFname());
            ptmt.setBytes(2, file.getFcontent());
            ptmt.executeUpdate();
            
        }catch(SQLException e){ 
            e.printStackTrace();
            
        }finally{
            
            Util.closeAll(conn, ptmt, rs);
        }
    }
}
