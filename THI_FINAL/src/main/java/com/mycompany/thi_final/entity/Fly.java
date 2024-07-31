package com.mycompany.thi_final.entity;

import java.util.List;
/**
 * @author SyDV3
 * @birthday 2003_01_04
 * @date:
 */
public class Fly extends Vehicle {

    public Fly(String vehicleID, String vehicleType, String vehicleName, Float weight, String color, Float limitSpeed, Boolean isController) {
        super(vehicleID, vehicleType, vehicleName, weight, color, limitSpeed, isController);
    }

    /**
     * @author SyDV3
     * @birthday 2003_01_04
     */
    public void flys() {
        System.out.println("I can fly in the  sky");
    }

    @Override
    public Boolean driver(Float speed) {
        if (speed <= super.getLimitSpeed()) {
            flys();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
