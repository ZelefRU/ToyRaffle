// Bo'o 'o' wau'ah
package org.example;

import org.example.Model.SlotMachine;
import org.example.Model.Toy;

import java.lang.reflect.Array;
import java.nio.DoubleBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

import static org.example.Model.AutoGenerate.*;
import static org.example.View.ActionMenu.showMenu;

public class Main {
    public static void main(String[] args) {
//        Toy toy = getRandomToy(1);
//        Toy toy2 = getRandomToy(1);
//        Toy toy3 = getRandomToy(1);
//        System.out.println(toy);
//        System.out.println(toy2);
//        System.out.println(toy3);

        List<Toy> toys = getListRandomToys(7, 40, 12, false);
//        System.out.println(Arrays.toString(toys.toArray()));

        for (Toy toy : toys) {
            System.out.printf("Toy - %-10s ID - %-3s Count - %-5s Chance - %-7s\n",
                    toy.getName(), toy.getId(), toy.getCount(), toy.getChance());
        }
        SlotMachine slotMachine = new SlotMachine(40);
        slotMachine.setToys(toys);
        System.out.printf("%s / %s\n",slotMachine.getTotalToysCount(), slotMachine.getCapacity());

        showMenu();
    }

}