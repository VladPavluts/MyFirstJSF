

package com.hubberspot.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SmartPhone implements Serializable{

    
    public SmartPhone() {  }
    public int id;
    public int price;
    public String name;
    public String chracteristic;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getChracteristic() {
        return chracteristic;
    }

    public void setChracteristic(String chracteristic) {
        this.chracteristic = chracteristic;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public SmartPhone (int id,String name,int price,String characteristic)
    {  
        this.id=id;
        this.name=name;
        this.price=price;
        this.chracteristic=characteristic;
        
    }
    @Override
    public String toString(){
        return id+" "+name+" "+price+" "+chracteristic;
    }
    
}
