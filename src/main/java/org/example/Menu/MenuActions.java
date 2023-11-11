package org.example.Menu;

import org.example.Controller.Controller;
import org.example.Model.Toy;

import java.util.List;

import static org.example.Menu.PrizeSaver.savePrizesInFile;
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
        if (userChoose == 1) {
            if (firstView) {
                setFirstView(false);
                Controller.fillSlotMachineRandomToys();
            }
        } else if (!firstView) {
            switch (userChoose) {
                // Roll
                case 2 -> rollAction();
                // Show me my prizes
                case 3 -> showPrizes();
                // View list of toys
                case 4 -> showSplitMenuWithToysPanel();
                // Ask the manager to update the toys
                case 5 -> {
                    Controller.fillSlotMachineRandomToys();
                    showSplitMenuWithToysPanel();
                }
                // Collect ur prizes and leave
                case 6 -> {
                    savePrizesInFile();
                    setWork(false);
                }
                default -> System.out.println("Invalid choice!");
            }
        } else {
            System.out.println("Start game first!");
        }
    }

    /**
     * Выводит список призов
     */
    public static void showPrizes() {
        List<Toy> prizes = getPrizes();
        System.out.println(YELLOW + "\n+-----------------PRIZES----------------+");
        for (Toy toy : prizes) {
            System.out.printf("|   %-2s %-18s %-5s %-8s|%n",
                    " ", toy.getName(), " ", toy.getChance() + "%");
        }
        System.out.println(YELLOW + "+---------------------------------------+\n");
    }

    /**
     * Запускает Ролл (прокрутку) колеса с призами
     */
    public static void rollAction() {
        if (Controller.getToysTypeCount() < 3) {
            System.out.println(RED +
                    "+---------------------------------------+\n" +
                    "|           Too few toys left!          |\n" +
                    "|   ASK THE MANAGER TO UPDATE THE TOYS  |\n" +
                    "|           ** SLOT MACHINE **          |\n" +
                    "+---------------------------------------+ ");
        } else {
            addPrize(Controller.getToyByChance());
        }
    }
}
