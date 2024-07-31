package com.mycompany.thi_final.entity;

import java.util.List;

/**
 * @author SyDV3
 * @birthday 2003_01_04
 * @date:
 */
public class Ship extends Vehicle {

    public Ship(String vehicleID, String vehicleType, String vehicleName, Float weight, String color, Float limitSpeed, Boolean isController) {
        super(vehicleID, vehicleType, vehicleName, weight, color, limitSpeed, isController);
    }

    /**
     * @author SyDV3
     * @birthday 2003_01_04
     */
    public void runOnWater() {
        System.out.println("I can run on the water");
    }

    @Override
    public Boolean driver(Float speed) {
        if (speed <= super.getLimitSpeed()) {
            runOnWater();
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
