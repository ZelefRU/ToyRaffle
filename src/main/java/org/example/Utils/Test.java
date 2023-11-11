package org.example.Utils;

import org.example.Model.SlotMachine;
import org.example.Model.Toy;

import static org.example.Utils.AutoGenerate.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Test {
    public static void main(String[] args) {
        SlotMachine slotMachine = new SlotMachine(40);
        List<Toy> toys = getListRandomToys(5, 30, 5, true);
        slotMachine.setToys(toys);

        System.out.println(getNumberByChances(slotMachine.getToys()));
    }

    public static int getNumberByChances(List<Toy> toys) {

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
        return chances.get(new Random().nextInt(1, 1001));
    }
}
