package com.mycompany.thi_final.controller;

import com.mycompany.thi_final.service.IVehicleService;
import com.mycompany.thi_final.service.VehicleServiceImpl;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author SyDV3
 * @birthday 2003_01_04
 * @date:
 */
public class MainController {
    private static final Scanner scanner = new Scanner(System.in);
    private static IVehicleService vehicleService = new VehicleServiceImpl();

    public static void main(String[] args) {
    /*
        so sanh cach trien khai driver va cach thuc di chuyen cua cac phuong tien
        *cach thuc di chuyen:
            fly: có thể bay ở trên trời
            car: có thể di ở trên đường phố
            fly: có thể chạy trên nước
       * cach trien khai driver:
            Phai xac dinh ro doi tuong phuong tien la ai: la fly, car hay ship,
                roi moi lay ra được limitSpeed của từng loại để mà check điều kiện
        * cach trien khai dong loat >< cach trien khai nay
            *cach trien khai nay
               Với method abtract thì cần triển khai lai
               Method đồng loạt không cần triển khai lại
               Vì phải xác định rõ đối tưởng abstract cụ thể lai ai
            *cach trien khai dong loat
                Không cần triển khai lại
       *neu cho sua lai code
         Thi em sẽ tránh trường hợp duplicate code, viết 1 method và dùng nhiều nơi,clean Code hơn
     */
        try {
            menu();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Program have a unexpected error occurred ");
        }
    }

    /**
     * @author SyDV3
     * @birthday 2003_01_04
     */
    public static void menu() throws IOException {
        while (true) {
            System.out.println("=========================MENU=======================");
            System.out.println("1. Insert file");
            System.out.println("2. Dieu khien ");
            System.out.println("3. Display Vehicle");
            System.out.println("0. Exist");
            System.out.println("=========================MENU=======================");
            System.out.print("Please enter a function: ");
            String valueSelect = scanner.nextLine();
            switch (valueSelect) {
                case "1" -> vehicleService.insert();
                case "2" -> {
                    vehicleService.drive();
                    vehicleService.getAllVehicleOrderBy();
                }
                case "3" -> vehicleService.getAllVehicle();
                case "0" -> {
                    return;
                }
                default -> System.out.println("Dose not exist a function");
            }
        }
    }
}
