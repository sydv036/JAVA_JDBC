package com.mycompany.thi_final.service;

import com.mycompany.thi_final.common.FileCommon;
import com.mycompany.thi_final.common.Validation;
import com.mycompany.thi_final.entity.Car;
import com.mycompany.thi_final.entity.Fly;
import com.mycompany.thi_final.entity.Ship;
import com.mycompany.thi_final.entity.Vehicle;
import com.mycompany.thi_final.repository.IVehicleRepository;
import com.mycompany.thi_final.repository.VehicleRepositoryImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VehicleServiceImpl implements IVehicleService {
    private IVehicleRepository vehicleRepository = new VehicleRepositoryImpl();

    /**
     * @author SyDV3
     * @birthday 2003_01_04
     */
    @Override
    public void insert() throws IOException {
        try {
            List<String> vehiclesError = new ArrayList<>();
            List<String> stringList = FileCommon.readFile("data.csv");
            for (int i = 0; i < stringList.size(); i++) {
                if (i == 0) {
                    continue;
                }
                String[] lines = stringList.get(i).split(",");
                String vehicleID = lines[0];
                String vehicleType = lines[1];
                String vehicleName = lines[2];
                String weight = lines[3];
                String color = lines[4];
                String limitSpeed = lines[5];
                String isController = lines[6];
                if (!Validation.isValidNumber(weight)) {
                    vehiclesError.add("Row " + i + ": " + " Input " + weight + " mismatch data!!!");
                }
                if (!Validation.isValidNumber(limitSpeed)) {
                    vehiclesError.add("Row " + i + ": " + " Input " + limitSpeed + " mismatch data!!!");
                }
                if (Validation.isDuplicateVehicleID(vehicleID)) {
                    vehiclesError.add("Row " + i + ": " + " Vehicle " + vehicleName + " has duplicate ID!!!");
                }
                try {
                    if (!Validation.isValidNumber(weight)) {
                        throw new Exception("Input " + weight + " mismatch data!!!");
                    }
                    if (!Validation.isValidNumber(limitSpeed)) {
                        throw new Exception("Input " + limitSpeed + " mismatch data!!!");
                    }
                    if (Validation.isDuplicateVehicleID(vehicleID)) {
                        throw new Exception("Vehicle " + vehicleName + " has duplicate ID!!!");
                    }

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    continue;
                }
                Vehicle vehicle = new Car(vehicleID, vehicleType, vehicleName, Validation.parseFloat(weight), color, Validation.parseFloat(limitSpeed), isController.equals("False") ? false : true);
                vehicleRepository.insert(vehicle);
            }
            if (vehiclesError.size() > 0) {
                FileCommon.writerFile(vehiclesError);
            }
            System.out.println("insert file Success");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Program have a unexpected error occurred ");
        }

    }

    private static Integer randomSpeed() {
        return (int) Math.floor((Math.random() * 1000) + 1);
    }

    public static void main(String[] args) {
        System.out.println(randomSpeed());
    }

    public void checkDrive(Boolean check, String vehicleID) {
        if (check == true) {
            vehicleRepository.updateIsController(vehicleID, 1);
        } else {
            vehicleRepository.updateIsController(vehicleID, 0);
            System.out.println("You can't driver me at such a greate speed!!!");
        }
    }

    /**
     * @author SyDV3
     * @birthday 2003_01_04
     */
    @Override
    public void drive() throws IOException {
        try {
            List<String> stringList = FileCommon.readFile("data.csv");
            for (int i = 0; i < stringList.size(); i++) {
                if (i == 0) {
                    continue;
                }
                String[] lines = stringList.get(i).split(",");
                String vehicleID = lines[0];
                String vehicleType = lines[1];
                String vehicleName = lines[2];
                String weight = lines[3];
                String color = lines[4];
                String limitSpeed = lines[5];
                String isController = lines[6];
                Vehicle vehicle = null;
                Integer randomSpedd = randomSpeed();

                try {
                    if (!Validation.isValidNumber(weight)) {
                        throw new Exception("Input " + weight + " mismatch data!!!");
                    }
                    if (!Validation.isValidNumber(limitSpeed)) {
                        throw new Exception("Input " + limitSpeed + " mismatch data!!!");
                    }


                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    continue;
                }
                if (vehicleType.equals("Car")) {
                    vehicle = new Car(vehicleID, vehicleType, vehicleName, Validation.parseFloat(weight), color, Validation.parseFloat(limitSpeed), isController.equals("False") ? false : true);
                    System.out.println("VehicleName " + vehicleName + " speed: " + randomSpedd);
                    Boolean check = ((Car) vehicle).driver(Validation.parseFloat(String.valueOf(randomSpedd)));
                    checkDrive(check, vehicle.getVehicleID());
                } else if (vehicleType.equals("Airplance")) {
                    vehicle = new Fly(vehicleID, vehicleType, vehicleName, Validation.parseFloat(weight), color, Validation.parseFloat(limitSpeed), isController.equals("False") ? false : true);
                    System.out.println("VehicleName " + vehicleName + " speed: " + randomSpedd);
                    Boolean check = ((Fly) vehicle).driver(Validation.parseFloat(String.valueOf(randomSpedd)));
                    checkDrive(check, vehicle.getVehicleID());
                } else {
                    vehicle = new Ship(vehicleID, vehicleType, vehicleName, Validation.parseFloat(weight), color, Validation.parseFloat(limitSpeed), isController.equals("False") ? false : true);
                    System.out.println("VehicleName " + vehicleName + " speed: " + randomSpedd);
                    Boolean check = ((Ship) vehicle).driver(Validation.parseFloat(String.valueOf(randomSpedd)));
                    checkDrive(check, vehicle.getVehicleID());
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void movingIntroduction(List<Vehicle> vehicleList) {
        String vehicleName = null;
        for (Vehicle vehicle : vehicleList) {
            if (vehicle instanceof Ship) {
                ((Ship) vehicle).runOnWater();
                vehicleName = "Ship";
            } else if (vehicle instanceof Car) {
                ((Car) vehicle).run();
                vehicleName = "Car";
            } else {
                ((Fly) vehicle).flys();
                vehicleName = "Fly";
            }
            System.out.println(vehicleName + "{" +
                    "vehicleID='" + vehicle.getVehicleID() + '\'' +
                    ", vehicleType='" + vehicle.getVehicleType() + '\'' +
                    ", vehicleName='" + vehicle.getVehicleName() + '\'' +
                    ", weight=" + vehicle.getWeight() +
                    ", color='" + vehicle.getColor() + '\'' +
                    ", limitSpeed=" + vehicle.getLimitSpeed() +
                    ", isController=" + vehicle.getController() +
                    '}');
        }
    }

    /**
     * @author SyDV3
     * @birthday 2003_01_04
     */
    @Override
    public void getAllVehicleOrderBy() {
        List<Vehicle> vehicleList = vehicleRepository.getAllVehicle();
        Collections.sort(vehicleList, (o1, o2) -> {
            Integer check = o1.getController().compareTo(o2.getController());
            if (check != 0) {
                return check;
            }
            return o1.getVehicleName().compareTo(o2.getVehicleName());
        });
        for (Vehicle vehicle : vehicleList) {
            System.out.println(vehicle.toString());
        }
    }

    /**
     * @author SyDV3
     * @birthday 2003_01_04
     */
    @Override
    public void getAllVehicle() {
        List<Vehicle> vehicleList = vehicleRepository.getAllVehicle();
        movingIntroduction(vehicleList);

    }

}
