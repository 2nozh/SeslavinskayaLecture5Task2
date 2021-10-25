package ru.dataart.academy.java;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Calculator {
    /**
     * @param zipFilePath -  path to zip archive with text files
     * @param character   - character to find
     * @return - how many times character is in files
     */
    public Integer getNumberOfChar(String zipFilePath, char character) {
        //Task implementation
        Integer output = 0;
        try {
            //method unzip returns file paths from zip
            for (String file : unzip(zipFilePath)) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                int symbol;
                while ((symbol = bufferedReader.read()) != -1) {
                    if (symbol == character) {
                        output++;
                    }
                }
                bufferedReader.close();
            }

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return output;
    }

    /**
     * @param zipFilePath - path to zip archive with text files
     * @return - max length
     */

    public Integer getMaxWordLength(String zipFilePath) {
        //Task implementation
        Integer output = 0;
        try {
            //method unzip returns file paths from zip
            for (String file : unzip(zipFilePath)) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    String[] words = line.split(" ");
                    for (String word : words) {
                        if (output < word.length()) {
                            output = word.length();
                        }
                    }
                }
                bufferedReader.close();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return output;
    }

    //method for unzipping files,returns array of work-ready paths
    private ArrayList<String> unzip(String zipFilePath) {
        ArrayList<String> resultPath = new ArrayList<>();
        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zipFilePath))) {
            ZipEntry entry;
            while ((entry = zipInputStream.getNextEntry()) != null) {
                FileOutputStream fileOutputStream = new FileOutputStream(Main.path + entry.getName());
                for (int symbol = zipInputStream.read(); symbol != -1; symbol = zipInputStream.read()) {
                    fileOutputStream.write(symbol);
                }
                fileOutputStream.flush();
                zipInputStream.closeEntry();
                fileOutputStream.close();
                zipInputStream.closeEntry();
                resultPath.add(Main.path + entry.getName());
            }
        } catch (Exception exception) {

            System.out.println(exception.getMessage());
        }
        return resultPath;
    }

}
