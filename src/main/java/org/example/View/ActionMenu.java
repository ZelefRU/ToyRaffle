package org.example.View;

import org.example.Controller.Controller;
import org.example.Model.Toy;

import java.util.List;
import java.util.Scanner;

public class ActionMenu {
    private static final String RESET = "\u001B[0;1m";
    private static final String BLACK = "\u001B[30;1m";
    private static final String RED = "\u001B[31;1m";
    private static final String GREEN = "\u001B[32;1m";
    private static final String YELLOW = "\u001B[33;1m";
    private static final String BLUE = "\u001B[34;1m";
    private static final String PURPLE = "\u001B[35;1m";
    private static final String CYAN = "\u001B[36;1m";
    private static final String WHITE = "\u001B[37;1m";

    protected static boolean firstView = true;
    protected static boolean work = true;

    public static void showMenu() {
        while (work) {
            if (firstView) {
                System.out.print(BLUE + "Available actions:\n".toUpperCase() +
                        GREEN + "  1. Start Game!\n".toUpperCase() +
                        WHITE + "  x. Continue Game!\n".toUpperCase() +
                        WHITE + "  x. Show me my prizes\n".toUpperCase() +
                        GREEN + "  4. View list of toys\n".toUpperCase() +
                        GREEN + "  5. Ask the Administrator to update the toys\n".toUpperCase() +
                        PURPLE + "  6. Help!\n".toUpperCase() +
                        RED + "  0. Exit\n".toUpperCase());
            } else {
                System.out.print(BLUE + "Available actions:\n".toUpperCase() +
                        WHITE + "  x. Start Game!\n".toUpperCase() +
                        GREEN + "  2. Continue Game!\n".toUpperCase() +
                        GREEN + "  3. Show me my prizes\n".toUpperCase() +
                        GREEN + "  4. View list of toys\n".toUpperCase() +
                        GREEN + "  5. Ask the Administrator to update the toys\n".toUpperCase() +
                        PURPLE + "  6. Help!\n".toUpperCase() +
                        RED + "  0. Exit\n".toUpperCase());
            }
            int userChoose = numbersScanner(YELLOW + "\n[*] Input: ".toUpperCase(), "Number required!");
            if (userChoose == 0) {
                work = false;
            } else if (firstView && userChoose > 0 && userChoose < 7) {
                menuAction(userChoose);
            } else {
                System.out.print(RED + "+-------------------+\n" +
                        "|   Wrong Action!   |\n" +
                        "|     Try again.    |\n" +
                        "+-------------------+\n");
            }
        }
    }

    public static void showHelp() {

    }

    public static void setFirstView(boolean firstView) {
        ActionMenu.firstView = firstView;
    }

    public static void setWork(boolean work) {
        ActionMenu.work = work;
    }

    public static void showToysInSlotMachine() {
        List<Toy> toys = Controller.getToysInSlotMachine();
        System.out.println("+--------------------------+");
        for (Toy toy : toys) {
            System.out.printf("|   %-10s %-5s %-6s|%n", toy.getName(), toy.getCount(), toy.getChance());
        }
        System.out.println("+--------------------------+");
    }

    public static void menuAction(int userChoose) {
        switch (userChoose) {
            case 1 -> {
                if (firstView) {
                    System.out.println("Start game!");
                    setFirstView(false);
                    Controller.fillSlotMachineRandomToys();
                    showToysInSlotMachine();
                } else {
                    System.out.println("u already");
                }
            }
            case 2 -> {
                if (firstView) {
                    System.out.println("Start game first!");
                } else {
                    System.out.println("continuing game");
                }
            }
            case 3 -> {
                if (firstView) {
                    System.out.println("Start game first!");
                } else {
                    System.out.println("show prizes");
                }
            }
            case 4 -> {
                System.out.println("Show list");
            }
            case 5 -> {
                System.out.println("change toys");
            }
            case 6 -> {showHelp();}
        }
    }

    public static int numbersScanner(String requestMessage, String failMessage) {
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        boolean validNumber = false;
        while (!validNumber) {
            try {
                System.out.print("\u001B[32m" + requestMessage);
                number = scanner.nextInt();
                if (number < 0) {
                    number *= -1;
                } // Преобразуем отрицательное в положительное
                validNumber = true;
            } catch (Exception e) {
                System.out.println("\u001B[31m" + failMessage);
                scanner.nextLine();
            }
        }
        return number;
    }
}
