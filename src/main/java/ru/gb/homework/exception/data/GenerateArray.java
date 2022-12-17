package ru.gb.homework.exception.data;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class GenerateArray {
    private final List<Integer> integerList;
    private final Random random;

    public GenerateArray() {
        this.integerList = new ArrayList<>();
        this.random = new Random();
    }

    public List<Integer> createArray(Integer size) {
        for (int i = 0; i < size; i++) {
            boolean choice = random.nextBoolean();
            if (choice) {
                integerList.add(random.nextInt(10));
            } else {
                integerList.add(null);
            }
        }
        return integerList;
    }
}
