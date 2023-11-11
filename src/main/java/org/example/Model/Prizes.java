package org.example.Model;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Prizes {
    private static Deque<Toy> prizesList;

    public static void initializePrizesList() {
        prizesList = new LinkedList<>();
    }

    /**
     * Добавление игрушки в список призов
     * @param toy Игрушка
     */
    public static void addPrize(Toy toy) {
        if (prizesList == null) {
            initializePrizesList();
        }
        Toy newPrizeToy = new Toy(1, toy.getChance(), toy.getName());
        prizesList.add(newPrizeToy);
        System.out.printf("[+] Toy %s x%s has been added in Prizes\n", newPrizeToy.getName(), newPrizeToy.getCount());
    }

    public static void removePrize() {
        if (prizesList == null || prizesList.isEmpty()) {
            System.out.println("[x] No prizes available.");
            return;
        }

        prizesList.removeLast();
        Toy tempToy = prizesList.getLast();
        System.out.printf("%-8s x%-4s was issued!", tempToy.getName(), tempToy.getCount());
    }

    public static List<Toy> getPrizes() {
        return new ArrayList<>(prizesList);
    }
}
