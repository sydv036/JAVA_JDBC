package com.mycompany.thi_final.entity;

import java.util.List;

/**
 * @author SyDV3
 * @birthday 2003_01_04
 * @date:
 */
public class Car extends Vehicle {

    public Car() {
    }

    public Car(String vehicleID, String vehicleType, String vehicleName, Float weight, String color, Float limitSpeed, Boolean isController) {
        super(vehicleID, vehicleType, vehicleName, weight, color, limitSpeed, isController);
    }

    /**
     * @author SyDV3
     * @birthday 2003_01_04
     */
    public void run() {
        System.out.println("I can run on the street");
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public Boolean driver(Float speed) {
        if (speed <= super.getLimitSpeed()) {
            run();
            return true;
        } else {
            return false;
        }
    }


}
