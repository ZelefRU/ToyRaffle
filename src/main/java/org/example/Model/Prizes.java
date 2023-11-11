package org.example.Model;

import java.util.Deque;
import java.util.LinkedList;

public class Prizes {
    private static Deque<Toy> prizesList;

    public static void initializePrizesList() {
        prizesList = new LinkedList<>();
    }

    public static void addPrize(Toy toy) {
        if (prizesList == null) {
            initializePrizesList();
        }
        Toy newPrizeToy = new Toy(1, toy.getChance(), toy.getName());
        prizesList.add(newPrizeToy);
        System.out.printf("Toy %s x%s has been added in Prizes\n", newPrizeToy.getName(), newPrizeToy.getCount());
    }

    public static void removePrize() {
        if (prizesList == null || prizesList.isEmpty()) {
            System.out.println("No prizes available.");
            return;
        }

        prizesList.removeLast();
        Toy tempToy = prizesList.getLast();
        System.out.printf("%-8s x%-4s was issued!", tempToy.getName(), tempToy.getCount());
    }

    public static void viewPrizes() {
        for (Toy toy : prizesList) {
            System.out.println(toy);
        }
    }
}
