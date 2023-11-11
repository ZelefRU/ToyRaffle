package org.example.Menu;

import org.example.Controller.Controller;
import org.example.Model.Toy;

import java.util.List;

import static org.example.Menu.View.*;
import static org.example.Model.Prizes.addPrize;
import static org.example.Model.Prizes.getPrizes;

public class MenuActions {

    /**
     * Действия меню
     *
     * @param userChoose Выбор пользователя
     */
    public static void menuAction(int userChoose) {
        switch (userChoose) {
            // Start game
            case 1 -> {
                if (firstView) {
                    setFirstView(false);
                    Controller.fillSlotMachineRandomToys();
                } else {
                    System.out.println("Already!");
                }
            }
            // Roll
            case 2 -> {
                if (firstView) {
                    System.out.println("Start game first!");
                } else {
//                    showToysInSlotMachine();
                    rollAction();
                }
            }
            // Show me my prizes
            case 3 -> {
                if (firstView) {
                    System.out.println("Start game first!");
                } else {
                    showPrizes();
                }
            }
            // View list of toys
            case 4 -> {
                if (firstView) {
                    System.out.println("Start game first!");
                } else {
                    showSplitMenuWithToysPannel();
                }
            }
            // Ask the manager to update the toys
            case 5 -> {
                if (firstView) {
                    System.out.println("Start game first!");
                } else {
                    Controller.fillSlotMachineRandomToys();
                    showSplitMenuWithToysPannel();
                }
            }
            // Collect ur prizes and leave
            case 6 -> {
                System.out.println("take prizes");;
            }
        }
    }


    public static void showPrizes() {
        List<Toy> prizes = getPrizes();
        System.out.println(YELLOW + "\n+-----------------PRIZES----------------+");
        for (Toy toy : prizes) {
            System.out.printf("|   %-2s %-18s %-5s %-8s|%n",
                    " ", toy.getName(), " ", toy.getChance() + "%");
        }
        System.out.println(YELLOW + "+---------------------------------------+\n");
    }
    // Запускает Ролл (прокрутку) колеса с призами
    public static void rollAction() {

        if (Controller.getToysTypeCount() < 3) {
            System.out.println(RED + "+---------------------------------------+ \n" +
                    "|           Too few toys left!          |\n" +
                    "|   ASK THE MANAGER TO UPDATE THE TOYS  |\n" +
                    "|           ** SLOT MACHINE **          |\n" +
                    "+---------------------------------------+ ");
        } else {
            addPrize(Controller.getNumberByChances());
        }
    }
}
