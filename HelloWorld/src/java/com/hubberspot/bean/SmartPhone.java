

package com.hubberspot.bean;

import java.io.Serializable;


public class SmartPhone implements Serializable{

    
    public SmartPhone() {  }
    public int id;
    public int price;
    public String name;
    public String chracteristic;
    private String operatingSystem;

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public String getCPUproc() {
        return CPUproc;
    }

    public void setCPUproc(String CPUproc) {
        this.CPUproc = CPUproc;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public String getRAM() {
        return RAM;
    }

    public void setRAM(String RAM) {
        this.RAM = RAM;
    }

    public String getFlashMemory() {
        return flashMemory;
    }

    public void setFlashMemory(String flashMemory) {
        this.flashMemory = flashMemory;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    public String getScreenSolution() {
        return screenSolution;
    }

    public void setScreenSolution(String screenSolution) {
        this.screenSolution = screenSolution;
    }
    private String camera;
    private String CPUproc;
    private String battery;
    private String RAM;
    private String flashMemory;
    private String screenSize;
    private String screenSolution;
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
    
    @Override
    public String toString(){
        return id+" "+name+" "+price+" "+chracteristic+" "+operatingSystem+" "+screenSize+" "+CPUproc+" "+screenSolution+" "+RAM+" "+flashMemory+" "+camera+" "+battery;
    }
    
}
