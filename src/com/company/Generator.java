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

    private int smallNumGenerator() {
        return random.nextInt(MAX) + MIN_SMALL_NUM;
    }

    private int largeNumGenerator() {
        int index = random.nextInt(largeNumbers.size());
        int result = largeNumbers.get(index);
        largeNumbers.remove(index);
        return result;
    }


    public void smallNumSelections(int selections) {
        for (int i = 0; i < selections; i++) {
            numbers.add(smallNumGenerator());
        }
    }

    public void largeNumSelections(int selections) {
        for (int i = 0; i < (6 - selections); i++) {
            numbers.add(largeNumGenerator());
        }
    }

    public int generateBigNumber(List<Integer> numbers) {
        int current = 1001;
        while (current > 1000 || current < 0) {
            current = numbers.get(0);
            for (int i = 0; i < 5; i++) {
                current = arithmeticSwitchWithDiv(current, i);
            }
            System.out.println(current);
            System.out.println("/n/n");
        }
        return current;
    }

    public int arithmeticSwitchWithDiv(int current, int index) {
        int arithmetic = random.nextInt(4);
        System.out.println(arithmetic);
        switch (arithmetic) {
            case 0:
                current += numbers.get(index + 1);
                break;
            case 1:
                current -= numbers.get(index + 1);
                break;
            case 2:
                current = current * numbers.get(index + 1);
                break;
            case 3:
                if (current % numbers.get(index + 1) == 0) {
                    current = current / numbers.get(index + 1);
                } else {
                    current = arithmeticSwitchWithoutDiv(current, index);
                }
                break;
        }
        return current;
    }

    public int arithmeticSwitchWithoutDiv(int current, int index) {
        int arithmetic = random.nextInt(4);
        switch (arithmetic) {
            case 0:
                current += numbers.get(index + 1);
                break;
            case 1:
                current -= numbers.get(index + 1);
                break;
            case 2:
                current = current * numbers.get(index + 1);
                break;
        }
        return current;
    }
}
