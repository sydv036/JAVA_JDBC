package com.mycompany.thi_final.repository;

import com.mycompany.thi_final.entity.Vehicle;

import java.util.List;

/**
 * @author SyDV3
 * @birthday 2003_01_04
 * @date:
 */
public interface IVehicleRepository {
    /**
     * @param vehicle
     * @author SyDV3
     * @birthday 2003_01_04
     */
    void insert(Vehicle vehicle);

    /**
     * @param
     * @author SyDV3
     * @birthday 2003_01_04
     */
    List<String> getAllVehicleID();

    /**
     * @param vehicleID
     * @return
     * @author SyDV3
     * @birthday 2003_01_04
     */
    Boolean updateIsController(String vehicleID,Integer isController);

    /**
     * @return
     * @author SyDV3
     * @birthday 2003_01_04
     */
    List<Vehicle> getAllVehicle();
}
