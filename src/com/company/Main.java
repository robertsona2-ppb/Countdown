package com.company;

import java.util.Scanner;

public class Main {

    static Generator generator = new Generator();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of small numbers you want!");

        Integer numOfSmallPicks = Integer.valueOf(in.nextLine());

        callGenerator(numOfSmallPicks);
        System.out.println(generator.selectedNumbers);

    }

    public static void callGenerator(int selections){
        generator.smallNumSelections(selections);
        generator.largeNumSelections(selections);
        int bigNum = generator.generateBigNumber(generator.selectedNumbers);
        System.out.println(bigNum);
    }
}
