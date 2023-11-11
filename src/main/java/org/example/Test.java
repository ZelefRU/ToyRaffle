package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        int a = 397;
        int b = 129;
        int c = 307;
        int d = 27;
        int e = 140;

        List<Integer> integerList = List.of(a, b, c, d, e);

        List<Integer> chances = new ArrayList<>();
        int tempId = 0;
        for (Integer integer : integerList) {
            for (int i = 0; i < integer; i++) {
                chances.add(tempId);
            }
            tempId++;
        }

        Random random = new Random();
        int randomNumber = random.nextInt(1, 1001);

        if (randomNumber < chances.size()) {
            System.out.println(chances.get(randomNumber));
        } else {
            System.out.println("Random number exceeds the size of chances list.");
        }
    }
}
