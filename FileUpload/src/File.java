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
public class File implements  Serializable {
    private int fid;
    private String fname;
    private byte[] fcontent;
    public int getFid() {
            return fid;
    }
    public void setFid(int fid) {
            this.fid = fid;
    }
    public String getFname() {
            return fname;
    }
    public void setFname(String fname) {
            this.fname = fname;
    }
    public byte[] getFcontent() {
            return fcontent;
    }
    public void setFcontent(byte[] focntent) {
            this.fcontent = fcontent;
    }
    public File(int fid, String fname, byte[] fcontent) {
            this.fid = fid;
            this.fname = fname;
            this.fcontent = fcontent;
    }
    public File(String fname,byte[] fcontent){
            this.fname = fname;
            this.fcontent = fcontent;
    }
}
