package ru.dataart.academy.java;

public class Main {

    public static String path="D:\\vrn-java-06 (2)\\src\\test\\resources\\";
    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        System.out.println("Calculator get number of 1: " +
                calculator.getNumberOfChar(path+"test.zip", '1'));

        System.out.println("Calculator get max length: " +
                calculator.getMaxWordLength(path+"test1.zip"));
    }
}