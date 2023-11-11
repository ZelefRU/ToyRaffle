package org.example.Controller;

import org.example.Model.SlotMachine;
import org.example.Model.Toy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.example.Model.AutoGenerate.*;

public class Controller {
    protected static int defaultCapacity = 30;
    protected static SlotMachine slotMachine = new SlotMachine();


    public static int getToysCount() {
        return slotMachine.getTotalToysCount();
    }

    public static int getToysTypeCount() {
        return slotMachine.getToys().size();
    }

    public static void fillSlotMachineRandomToys() {
        List<Toy> toyList = getListRandomToys(5, defaultCapacity, 10, true);
        slotMachine.setToys(toyList);
    }

    public static List<Toy> getToysInSlotMachine() {
        return slotMachine.getToys();
    }

    public static Toy getNumberByChances() {
        List<Toy> toys = slotMachine.getToys();
        List<Integer> chancesInIntegers = new ArrayList<>();
        for (Toy toy : toys) {
            chancesInIntegers.add((int) (toy.getChance() * 10));
        }

        List<Integer> chances = new ArrayList<>();
        int tempId = 0;
        for (Integer integer : chancesInIntegers) {
            for (int i = 0; i < integer; i++) {
                chances.add(tempId);
            }
            tempId++;
        }
        int prizeId = 0;
        try {
            prizeId = chances.get(new Random().nextInt(0, chances.size()));
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }

//        System.out.println("PrizeId " + prizeId);
//        System.out.println("Toys size - " + toys.size());
//        System.out.println("Chance size - " + chances.size());
//
//        for (Integer integer : chances) {
//            System.out.print(integer);
//        }
//        System.out.println();
        Toy toy = toys.get(prizeId);
        slotMachine.removeToy(toys.get(prizeId), 1);
        return toy;
    }
}
