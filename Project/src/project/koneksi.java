/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
/**
 *
 * @author Acer
 */
public class koneksi {
    public static Connection con;
    public static Statement stm;
    public static Runnable res;
    public static ResultSet rs;
    
    
    
public void koneksimysql(){
    try{
        String url="jdbc:mysql://localhost/koswijayanti";
        String user="root";
        String pass="";
        Class.forName("com.mysql.jdbc.Driver");
        con = (Connection) DriverManager.getConnection(url, user, pass);
        stm = (Statement) con.createStatement();
    }catch (Exception e){
        System.err.println("koneksi Gagal"+e.getMessage());
    }
}
    public static void main(String[] args) {
        koneksi test = new koneksi();
        test.koneksimysql();
        System.exit(0);
    }
}