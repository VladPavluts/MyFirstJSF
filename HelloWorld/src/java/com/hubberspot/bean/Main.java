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

   
    private ArrayList<SmartPhone> smartphones = new ArrayList<>();

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
            smartphones.clear();
            while (resultSet.next()) {
                SmartPhone smartPh = new SmartPhone();
                smartPh.setId(resultSet.getInt("id"));
                smartPh.setName(resultSet.getString("name"));
                smartPh.setPrice(resultSet.getInt("price"));
                smartPh.setChracteristic(resultSet.getString("characteristic"));
                smartPh.setOperatingSystem(resultSet.getString("operatingSystem"));
                smartPh.setScreenSize(resultSet.getString("screenSize"));
                smartPh.setCPUproc(resultSet.getString("CPUproc"));
                smartPh.setScreenSolution(resultSet.getString("screenSolution"));
                smartPh.setRAM(resultSet.getString("RAM"));
                smartPh.setFlashMemory(resultSet.getString("flashMemory"));
                smartPh.setCamera(resultSet.getString("camera"));
                smartPh.setBattery(resultSet.getString("battery"));
                
                smartphones.add(smartPh);
            }
            for (int i = 0; i < smartphones.size(); i++) {
                System.out.println(smartphones.get(i).toString());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "display";
    }


    public ArrayList<SmartPhone> getSmartphones() throws SQLException {
        return smartphones;
    }

    
}
