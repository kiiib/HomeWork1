/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.Serializable;
/**
 *
 * @author Jianbin Liu
 */
public class Users implements Serializable{
    private int id;
    private String username;
    private String password;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Users(int id, String username, String password) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
    }
    public Users(){

    }
}
