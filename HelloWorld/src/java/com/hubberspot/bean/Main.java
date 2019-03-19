package com.hubberspot.bean;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Main implements Serializable {

//    private static final String URL="jdbc:mysql://localhost:3306/mydb"+"?verifyServerCertificate=false"+
//                    "&useSSL=false"+
//                    "&requireSSL=false"+
//                    "&useLegacyDatetimeCode=false"+
//                    "&amp"+
//                    "&serverTimezone=UTC";
//    private static final  String USERNAME="root";
//    private static final String PASSWORD="password";    
    private ArrayList<SmartPhone> beans1 = new ArrayList<>();

    //@PostConstruct
    public String func() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mydb?useUnicode=true&"
                + "useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                "root", "password")) {
            Statement statement = null;
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM zerotable");
            beans1.clear();
            while (resultSet.next()) {
                SmartPhone user = new SmartPhone();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setPrice(resultSet.getInt("price"));
                user.setChracteristic(resultSet.getString("characteristic"));
                beans1.add(user);
            }
            for (int i = 0; i < beans1.size(); i++) {
                System.out.println(beans1.get(i).toString());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "display";
    }

//    public String func() throws SQLException {           
//            
//            Connection conn=null;
//            conn=DriverManager.getConnection(URL,USERNAME,PASSWORD);
//            Statement statement=conn.createStatement();
//            ResultSet resultSet=statement.executeQuery("select * from zerotable");
//            while(resultSet.next()){
//                SmartPhone user=new SmartPhone();
//                user.setId(resultSet.getInt("id"));
//                user.setName(resultSet.getString("name"));
//                user.setPrice(resultSet.getInt("price"));
//                user.setChracteristic(resultSet.getString("characteristic"));
//                beans1.add(user);
//            }
//            return "display";
//            
//    }
    public ArrayList<SmartPhone> getBeans1() throws SQLException {
        return beans1;
    }

    public static void main(String[] args) throws SQLException {
        Main obj = new Main();
        obj.func();
        ArrayList<SmartPhone> kkk = obj.getBeans1();
        for (int i = 0; i < kkk.size(); i++) {
            System.out.println(kkk.get(i).toString());
        }

    }
}
