package com.mycompany.thi_final.common;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author SyDV3
 * @birthday 2003_01_04
 * @date:
 */
public class FileCommon {
    /**
     * @param path
     * @return
     * @throws IOException
     * @author SyDV3
     * @birthday 2003_01_04
     */
    public static List<String> readFile(String path) throws IOException {
        try {
            List<String> stringList = Files.readAllLines(Paths.get(path));
            return stringList;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * @param stringList
     * @author SyDV3
     * @birthday 2003_01_04
     */
    public static void writerFile(List<String> stringList) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Error.txt"))) {
            for (String line : stringList) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
