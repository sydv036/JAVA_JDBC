package com.mycompany.thi_final.entity;

import java.util.List;

public abstract class Vehicle {
    private String vehicleID;
    private String vehicleType;
    private String vehicleName;
    private Float weight;
    private String color;
    private Float limitSpeed;
    private Boolean isController;

    abstract Boolean driver(Float speed);

    public Vehicle() {
    }

    public Vehicle(String vehicleID, String vehicleType, String vehicleName, Float weight, String color, Float limitSpeed, Boolean isController) {
        this.vehicleID = vehicleID;
        this.vehicleType = vehicleType;
        this.vehicleName = vehicleName;
        this.weight = weight;
        this.color = color;
        this.limitSpeed = limitSpeed;
        this.isController = isController;
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Float getLimitSpeed() {
        return limitSpeed;
    }

    public void setLimitSpeed(Float limitSpeed) {
        this.limitSpeed = limitSpeed;
    }

    public Boolean getController() {
        return isController;
    }

    public void setController(Boolean controller) {
        isController = controller;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleID='" + vehicleID + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", vehicleName='" + vehicleName + '\'' +
                ", weight=" + weight +
                ", color='" + color + '\'' +
                ", limitSpeed=" + limitSpeed +
                ", isController=" + isController +
                '}';
    }
}
