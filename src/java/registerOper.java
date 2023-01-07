/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pratham
 */
public class registerOper {

    public static int save(String name, String username, String email, String pass) throws ClassNotFoundException, SQLException {
        int status = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:2000/nohunger", "root", "root");
            System.out.println("Connected");

            PreparedStatement ps = con.prepareStatement("insert into ngoreg(name,username,email,password) values (?,?,?,?)");
            ps.setString(1, name);
            ps.setString(2, username);
            ps.setString(3, email);
            ps.setString(4, pass);
            status = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public static boolean validate(String name, String pass) {
        boolean status = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:2000/nohunger", "root", "root");

            PreparedStatement ps = con.prepareStatement(
                    "select * from ngoreg where username=? and password=?");
            ps.setString(1, name);
            ps.setString(2, pass);

            ResultSet rs = ps.executeQuery();
            status = rs.next();

        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }
    
    public static int savebus(String name, String username, String email, String pass) throws ClassNotFoundException, SQLException {
        int status = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:2000/nohunger", "root", "root");
            System.out.println("Connected");

            PreparedStatement ps = con.prepareStatement("insert into busreg(name,username,email,password) values (?,?,?,?)");
            ps.setString(1, name);
            ps.setString(2, username);
            ps.setString(3, email);
            ps.setString(4, pass);
            status = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
        
        
    }
        
    public static boolean validatebus(String name, String pass) {
        boolean status = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:2000/nohunger", "root", "root");

            PreparedStatement ps = con.prepareStatement(
                    "select * from busreg where username=? and password=?");
            ps.setString(1, name);
            ps.setString(2, pass);

            ResultSet rs = ps.executeQuery();
            status = rs.next();

        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }
    
    public static int savemeal(String name, String type, String feed, String time, String address) throws ClassNotFoundException, SQLException {
        int status = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:2000/nohunger", "root", "root");
            System.out.println("Connected");

            PreparedStatement ps = con.prepareStatement("insert into mealdetails(bname,mtype,pfeed,time,address) values (?,?,?,?,?)");
            ps.setString(1, name);
            ps.setString(2, type);
            ps.setString(3, feed);
            ps.setString(4, time);
            ps.setString(5, address);
            status = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
        
        
    }
    
    public static List<don> getAll(){
        List<don> list=new ArrayList<don>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:2000/nohunger", "root", "root");
            PreparedStatement ps = con.prepareStatement("select * from mealdetails;");
           
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                don e=new don();
                e.setId(rs.getInt(6));
                e.setName(rs.getString(1));
                e.setType(rs.getString(2));
                e.setFeed(rs.getString(3));
                e.setTime(rs.getString(4));
                e.setAddress(rs.getString(5));
                list.add(e);
            }
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    
     public static int delete(int id){
        int status=0;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:2000/nohunger", "root", "root");
            PreparedStatement ps=con.prepareStatement("delete from mealdetails where id=?");
            ps.setInt(1,id);
            
            status=ps.executeUpdate();
            con.close();
           
            
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return status;
    }


}
