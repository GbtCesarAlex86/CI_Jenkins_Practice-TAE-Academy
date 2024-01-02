package com.globant;

public class Main {
    public static void main(String[] args) {
        String variableValue;

        variableValue = System.getenv("MY_VARIABLE");

        System.out.println("The value of MY_VARIABLE is: " + variableValue);
    }
}