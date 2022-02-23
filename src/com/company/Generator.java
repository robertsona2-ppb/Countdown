package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generator {

    public static final int MIN_SMALL_NUM = 1;
    public static final int MAX = 9;
    public List<Integer> numbers = new ArrayList<>();
    public List<Integer> largeNumbers = new ArrayList<>();
    private Random random = new Random();

    {
        largeNumbers.add(25);
        largeNumbers.add(50);
        largeNumbers.add(75);
        largeNumbers.add(100);
    }

    private int smallNumGenerator(){
        return random.nextInt(MAX + MIN_SMALL_NUM);
    }

    private int largeNumGenerator(){
        int index = random.nextInt(largeNumbers.size());
        int result = largeNumbers.get(index);
        largeNumbers.remove(index);
        return result;
    }


    public void smallNumSelections(int selections){
        for (int i = 0; i < selections; i++) {
            numbers.add(smallNumGenerator());
        }
    }
    
    public void largeNumSelections(int selections){
        for (int i = 0; i < (6 - selections); i++) {
            numbers.add(largeNumGenerator());
        }
    }


}
