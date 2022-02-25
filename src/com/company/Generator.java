package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Generator {

    public static final int MIN_SMALL_NUM = 1;
    public static final int MAX_SMALL_NUM = 9;
    public List<Integer> selectedNumbers = new ArrayList<>();
    public List<Integer> largeNumbers = Stream.of(25, 50, 75, 100).collect(Collectors.toList());

    private Random random = new Random();

    private int smallNumGenerator() {
        return random.nextInt(MIN_SMALL_NUM, MAX_SMALL_NUM + MIN_SMALL_NUM);
    }

    private int largeNumGenerator() {
        int index = random.nextInt(largeNumbers.size());
        return largeNumbers.remove(index);
    }


    public void smallNumSelections(int selections) {
        for (int i = 0; i < selections; i++) {
            selectedNumbers.add(smallNumGenerator());
        }
    }

    public void largeNumSelections(int selections) {
        for (int i = 0; i < (6 - selections); i++) {
            selectedNumbers.add(largeNumGenerator());
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

    public int arithmeticSwitchWithDiv (int current, int index){
        final int arithmetic = random.nextInt(4);
        switch (arithmetic) {
            case 0:
            case 1:
            case 2:
                return arithmeticSwitchWithoutDiv(current, index, arithmetic);
            case 3:
                return (current % selectedNumbers.get(index + 1) == 0) ? current / selectedNumbers.get(index + 1)
                                                                       : arithmeticSwitchWithoutDiv(current,
                                                                                            index,
                                                                                            random.nextInt(3));
            default:
                throw new IllegalStateException(String.format("No case for arithmetic: ", arithmetic));
        }
    }

    private int arithmeticSwitchWithoutDiv ( int current, int index, int arithmetic){
        switch (arithmetic) {
            case 0:
                return current + selectedNumbers.get(index + 1);
            case 1:
                return current - selectedNumbers.get(index + 1);
            case 2:
                return current * selectedNumbers.get(index + 1);
            default:
                throw new IllegalStateException(String.format("No case for arithmetic: ", arithmetic));
        }
    }
}
