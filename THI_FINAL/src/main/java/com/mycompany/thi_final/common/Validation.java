package com.mycompany.thi_final.common;

import com.mycompany.thi_final.repository.IVehicleRepository;
import com.mycompany.thi_final.repository.VehicleRepositoryImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

/**
 * @author SyDV3
 * @birthday 2003_01_04
 * @date:
 */
public class Validation {
    private static IVehicleRepository vehicleRepository = new VehicleRepositoryImpl();


    public static Boolean isDuplicateVehicleID(String vehicleID) {
        List<String> vehicleIds = vehicleRepository.getAllVehicleID();
        if (vehicleIds.contains(vehicleID)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param number
     * @return
     * @author SyDV3
     * @birthday 2003_01_04
     */
    public static Boolean isValidNumber(String number) {
        String regexNumber = "^\\d+$";
        if (number.matches(regexNumber)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param email
     * @return
     * @author SyDV3
     * @birthday 2003_01_04
     */
    public static Boolean isValidEmail(String email) {
        String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        if (email.matches(regex)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param phoneNumber
     * @return
     * @author SyDV3
     * @birthday 2003_01_04
     */
    public static Boolean isValidPhoneNumberVN(String phoneNumber) {
        String regex = "(03|05|07|08|09|01[2|6|8|9])+([0-9]{8})";
        if (phoneNumber.matches(regex)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param date
     * @return
     * @author SyDV3
     * @birthday 2003_01_04
     */
    public static Boolean isValidDateVN(String date) {
        // DD/MM/yyyy
        String regex = "^([0-2][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$";
        if (date.matches(regex)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param date
     * @return
     * @author SyDV3
     * @birthday 2003_01_04
     */
    public static Boolean isValidDateWord(String date) {
        //regex MM/dd/yyyy: ^(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])/(\d{4})$

        //yyyy/MM/dd
        String regex = "^(\\d{4})/(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])$";
        if (date.matches(regex)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param value
     * @return
     * @author SyDV3
     * @birthday 2003_01_04
     */
    public static Boolean isValidStringUppCaseSpace(String value) {
        String regex = "^[A-Z][a-z]*( [A-Z][a-z]*)*$";
        if (value.matches(regex)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param value
     * @return
     * @author SyDV3
     * @birthday 2003_01_04
     */
    public static Boolean isValidLengString(String value) {
        if (value.length() > 50 || value.length() < 10) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * @param year
     * @return
     * @author SyDV3
     * @birthday 2003_01_04
     */
    public static Boolean isValidYear(String year) {
        Integer yearNow = LocalDate.now().getYear();
        Integer yearValue = Integer.valueOf(year);
        if (yearValue < yearNow) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param value
     * @return
     * @author SyDV3
     * @birthday 2003_01_04
     */
    public static Boolean isValidNumberAndString(String value) {
        String regex = "^[A-Za-z0-9]+$";
        if (value.matches(regex)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param value
     * @return
     * @author SyDV3
     * @birthday 2003_01_04
     */
    public static Boolean isStartWithAndNumber(String value) {
        String firstValue = value.substring(0, 2);
        String lastValue = value.substring(2, value.length());
        if (firstValue.equals("TL")) {
            if (isValidNumber(lastValue) && lastValue.length() == 6) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * @param value
     * @return
     * @author SyDV3
     * @birthday 2003_01_04
     */
    public static Float parseFloat(String value) {
        if (value == null) {
            return 0.0f;
        } else {
            return Float.parseFloat(value);
        }
    }

    /**
     * @param value
     * @return
     * @author SyDV3
     * @birthday 2003_01_04
     */
    public static Integer parseInteger(String value) {
        if (value == null) {
            return 0;
        } else {
            return Integer.parseInt(value);
        }
    }

    /**
     * @param value
     * @return
     * @author SyDV3
     * @birthday 2003_01_04
     */
    public static Double parseDouble(String value) {
        if (value == null) {
            return 0.0;
        } else {
            return Double.parseDouble(value);
        }
    }

    /**
     * @param value
     * @return
     * @author SyDV3
     * @birthday 2003_01_04
     */
    public static LocalDate parseLocalDate(String value) {
        if (value != null) {
            try {
                return LocalDate.parse(value, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            } catch (DateTimeParseException e) {
                throw new IllegalArgumentException("Định dạng ngày tháng không hợp lệ. Vui lòng sử dụng định dạng dd-MM-yyyy.");
            }
        } else {
            throw new IllegalArgumentException("Giá trị ngày tháng không được là null.");
        }
    }

    public static void main(String[] args) {
        System.out.println(parseLocalDate(null));
    }
}
