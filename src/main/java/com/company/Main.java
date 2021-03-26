package com.company;

public class Main {

    public static void main(String[] args) {
        try {
            System.out.println(Pokemon.getEfficiency("fire -> fire"));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
