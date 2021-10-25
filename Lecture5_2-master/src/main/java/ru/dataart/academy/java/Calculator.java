package ru.dataart.academy.java;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
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
        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zipFilePath))) {
            ZipEntry entry;
            while ((entry = zipInputStream.getNextEntry()) != null) {
                FileOutputStream fout = new FileOutputStream(Main.path + entry.getName());
                for (int c = zipInputStream.read(); c != -1; c = zipInputStream.read()) {
                    fout.write(c);
                }
                fout.flush();
                zipInputStream.closeEntry();
                fout.close();
                zipInputStream.closeEntry();

                BufferedReader br = new BufferedReader(new FileReader(Main.path + entry.getName()));
                int c;
                while ((c = br.read()) != -1) {
                    if (c == character) {
                        output++;
                    }
                }
                br.close();

            }
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
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
        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zipFilePath))) {
            ZipEntry entry;
            while ((entry = zipInputStream.getNextEntry()) != null) {
                FileOutputStream fout = new FileOutputStream(Main.path + entry.getName());
                for (int c = zipInputStream.read(); c != -1; c = zipInputStream.read()) {
                    fout.write(c);
                }
                fout.flush();
                zipInputStream.closeEntry();
                fout.close();
                zipInputStream.closeEntry();

                BufferedReader br = new BufferedReader(new FileReader(Main.path + entry.getName()));
                String line = null;
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(" ");
                    for (String str : values) {
                        if (output<str.length()){
                            output=str.length();
                        }
                    }
                }
                br.close();

            }
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
        return output;
    }

}
