package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Generator {

    public ArrayList<Integer> numbers = new ArrayList<Integer>();

    private int smallNumGenerator(){
        int min = 1;
        int max = 9;

        Random random = new Random();

        int value = random.nextInt(max + min) + min;
        return value;
    }

    public void smallNumSelections(int selections){
        for (int i = 0; i < selections; i++) {
            System.out.println("hello");
            numbers.add(smallNumGenerator());
        }
    }


}
