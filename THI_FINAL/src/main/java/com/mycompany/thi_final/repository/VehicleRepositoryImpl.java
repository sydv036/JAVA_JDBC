package com.mycompany.thi_final.repository;

import com.mycompany.thi_final.entity.Car;
import com.mycompany.thi_final.entity.Fly;
import com.mycompany.thi_final.entity.Ship;
import com.mycompany.thi_final.entity.Vehicle;
import com.mycompany.thi_final.util.DBContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author SyDV3
 * @birthday 2003_01_04
 * @date:
 */
public class VehicleRepositoryImpl implements IVehicleRepository {
    private static final String SQL_INSERT = "INSERT INTO THI_FINAL_JAVA.dbo.vehicle\n" +
            "(vehicleID, vehicleType, vehicleName, weight, color, limitSpeed, isController)\n" +
            "VALUES(?, ?, ?, ?, ?, ?, ?);\n";
    private static final String SQL_UPDATE = "UPDATE THI_FINAL_JAVA.dbo.vehicle\n" +
            "SET  isController=? \n" +
            "WHERE vehicleID=?;\n";
    private static final String SQL_SELECT = "SELECT *  FROM vehicle v ";

    /**
     * @param vehicle
     * @author SyDV3
     * @birthday 2003_01_04
     */
    @Override
    public void insert(Vehicle vehicle) {
        try (Connection connection = DBContext.getConnection()) {
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT);
            statement.setString(1, vehicle.getVehicleID());
            statement.setString(2, vehicle.getVehicleType());
            statement.setString(3, vehicle.getVehicleName());
            statement.setFloat(4, vehicle.getWeight());
            statement.setString(5, vehicle.getColor());
            statement.setFloat(6, vehicle.getLimitSpeed());
            statement.setBoolean(7, vehicle.getController());
            statement.addBatch();
            statement.executeBatch();
            connection.commit();
            connection.setAutoCommit(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @author SyDV3
     * @birthday 2003_01_04
     */
    @Override
    public List<String> getAllVehicleID() {
        try (Connection connection = DBContext.getConnection()) {
            List<String> listVehicleID = new ArrayList<String>();
            PreparedStatement statement = connection.prepareStatement("SELECT v.vehicleID  FROM vehicle v ");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                listVehicleID.add(resultSet.getString(1));
            }
            return listVehicleID;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @param vehicleID
     * @return
     * @author SyDV3
     * @birthday 2003_01_04
     */
    @Override
    public Boolean updateIsController(String vehicleID, Integer isController) {
        try (Connection connection = DBContext.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SQL_UPDATE);
            statement.setInt(1, isController);
            statement.setString(2, vehicleID);
            Integer result = statement.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @return
     * @author SyDV3
     * @birthday 2003_01_04
     */
    @Override
    public List<Vehicle> getAllVehicle() {
        try (Connection connection = DBContext.getConnection()) {
            List<Vehicle> listVehicle = new ArrayList<>();
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                listVehicle.add(mapVehicle(resultSet));
            }
            return listVehicle;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private Vehicle mapVehicle(ResultSet resultSet) throws SQLException {
        String vehicleID = resultSet.getString(1);
        String vehicleType = resultSet.getString(2);
        String vehicleName = resultSet.getString(3);
        Float weight = resultSet.getFloat(4);
        String color = resultSet.getString(5);
        Float limitSpeed = resultSet.getFloat(6);
        Integer isController = resultSet.getInt(7);
        Vehicle vehicle = null;
        if (vehicleType.equals("Airplance")) {
            vehicle = new Fly(vehicleID, vehicleType, vehicleName, weight, color, limitSpeed, isController.equals(1) ? true : false);
        } else if (vehicleType.equals("Car")) {
            vehicle = new Car(vehicleID, vehicleType, vehicleName, weight, color, limitSpeed, isController.equals(1) ? true : false);
        } else {
            vehicle = new Ship(vehicleID, vehicleType, vehicleName, weight, color, limitSpeed, isController.equals(1) ? true : false);
        }
        return vehicle;
    }
}
