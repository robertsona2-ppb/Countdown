package com.company;

import java.util.Scanner;

public class Main {

    static Generator generator = new Generator();

    public static void callGenerator(int selections){
        generator.smallNumSelections(selections);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of small numbers you want!");

        Integer selections = Integer.valueOf(in.nextLine());

        callGenerator(selections);
        System.out.println(generator.numbers);

    }
}
