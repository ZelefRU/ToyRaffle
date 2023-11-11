//package org.example.View;
//
//import org.example.Controller.Controller;
//import org.example.Model.Toy;
//
//import java.util.List;
//import java.util.Scanner;
//
//import static org.example.Model.Prizes.*;
//
//public class ActionMenu {
//    // Набор цветов для форматирования
////    private static final String RESET = "\u001B[0;1m";
////    private static final String BLACK = "\u001B[30;1m";
////    private static final String RED = "\u001B[31;1m";
////    private static final String GREEN = "\u001B[32;1m";
////    private static final String YELLOW = "\u001B[33;1m";
////    private static final String BLUE = "\u001B[34;1m";
////    private static final String PURPLE = "\u001B[35;1m";
////    private static final String CYAN = "\u001B[36;1m";
////    private static final String WHITE = "\u001B[37;1m";
//
////    protected static boolean firstView = true;
////    protected static boolean work = true;
////
////    /**
////     * Вывод меню действий
////     */
////    public static void showMenu() {
////        while (work) {
////            if (firstView) {
////                System.out.print(BLUE + "Available actions:\n".toUpperCase() +
////                        GREEN + "  1. Start Game!\n".toUpperCase() +
////                        WHITE + "  x. Roll\n".toUpperCase() +
////                        WHITE + "  x. Show me my prizes\n".toUpperCase() +
////                        WHITE + "  x. View list of toys\n".toUpperCase() +
////                        WHITE + "  x. Ask the MANAGER to update the toys\n".toUpperCase() +
////                        WHITE + "  x. Collect your prizes and leave!\n".toUpperCase() +
////                        RED + "  0. Exit\n".toUpperCase());
////            } else {
////                showToysInSlotMachine();
////            }
////            // Получаем выбор пользователя с проверкой на число
////            int userChoose = numbersScanner(PURPLE + "[*] Input: ".toUpperCase(), "Number required!");
////            if (userChoose == 0) {
////                work = false;
////            } else if (userChoose > 0 && userChoose < 7) {
////                menuAction(userChoose);
////            } else {
////                System.out.print(RED + "+-------------------+\n" +
////                        "|   Wrong Action!   |\n" +
////                        "|     Try again.    |\n" +
////                        "+-------------------+\n");
////            }
////        }
////    }
//
//
////
////    /**
////     * Вывод игрушек в автомате
////     */
////    public static void showToysInSlotMachine() {
////        List<Toy> toys = Controller.getToysInSlotMachine();
////        StringBuilder result = new StringBuilder(YELLOW + "+-----------------ITEMS-----------------+" + BLUE + "        AVAILABLE ACTIONS:\n");
////        for (int i = 0; i < toys.size(); i++) {
////            result.append(YELLOW).append(String.format("|   %-2s %-18s %-5s %-8s|",
////                    toys.get(i).getId(), toys.get(i).getName(), toys.get(i).getCount(), toys.get(i).getChance() + "%"));
////            switch (i) {
////                case 0 -> result.append(WHITE).append("          x. START GAME!".toUpperCase());
////                case 1 -> result.append(GREEN).append("          2. ROLL".toUpperCase());
////                case 2 -> result.append(GREEN).append("          3. SHOW ME MY PRIZES".toUpperCase());
////                case 3 -> result.append(GREEN).append("          4. VIEW LIST OF TOYS".toUpperCase());
////                case 4 -> result.append(GREEN).append("          5. ASK THE MANAGER TO UPDATE THE TOYS".toUpperCase());
////                case 5 -> result.append(CYAN).append("          6. Collect your prizes and leave!".toUpperCase());
////                case 7 -> result.append(RED).append("          0. EXIT".toUpperCase());
////            }
////            result.append("\n");
////        }
////        result.append(YELLOW).append("+---------------------------------------+");
////        // Я знаю что тут дичь какая-то, главное что работает! А запариваться над красивым кодом здесь мне было уже лень
////        switch (toys.size()) {
////            case 1 -> {
////                result.append(" ".repeat(10));
////                result.append(YELLOW).append("2. ROLL\n");
////                result.append(" ".repeat(51)).append(GREEN).append("3. SHOW ME MY PRIZES\n");
////                result.append(" ".repeat(51)).append(GREEN).append("4. VIEW LIST OF TOYS\n");
////                result.append(" ".repeat(51)).append(GREEN).append("5. ASK THE MANAGER TO UPDATE THE TOYS\n");
////                result.append(" ".repeat(51)).append(CYAN).append("6. Collect your prizes and leave!\n");
////                result.append(" ".repeat(51)).append(RED).append("0. EXIT\n");
////            }
////            case 2 -> {
////                result.append(" ".repeat(10));
////                result.append(GREEN).append("3. SHOW ME MY PRIZES\n");
////                result.append(" ".repeat(51)).append(GREEN).append("4. VIEW LIST OF TOYS\n");
////                result.append(" ".repeat(51)).append(GREEN).append("5. ASK THE MANAGER TO UPDATE THE TOYS\n");
////                result.append(" ".repeat(51)).append(CYAN).append("6. Collect your prizes and leave!\n");
////                result.append(" ".repeat(51)).append(RED).append("0. EXIT\n");
////            }
////            case 3 -> {
////                result.append(" ".repeat(10)).append(GREEN).append("4. VIEW LIST OF TOYS\n");
////                result.append(" ".repeat(51)).append(GREEN).append("5. ASK THE MANAGER TO UPDATE THE TOYS\n");
////                result.append(" ".repeat(51)).append(CYAN).append("6. Collect your prizes and leave!\n");
////                result.append(" ".repeat(51)).append(RED).append("0. EXIT\n");
////            }
////            case 4 -> {
////                result.append(" ".repeat(10)).append(GREEN).append("5. ASK THE MANAGER TO UPDATE THE TOYS\n");
////                result.append(" ".repeat(51)).append(CYAN).append("6. Collect your prizes and leave!\n");
////                result.append(" ".repeat(51)).append(RED).append("0. EXIT\n");
////            }
////            case 5 -> {
////                result.append(" ".repeat(10)).append(CYAN).append("6. Collect your prizes and leave!\n");
////                result.append(" ".repeat(51)).append(RED).append("0. EXIT\n");
////            }
////            case 6, 7 -> {
////                result.append(" ".repeat(10)).append(RED).append("0. EXIT\n");
////            }
////        }
////        System.out.println(result);
////    }
////
////    /**
////     * Действия меню
////     *
////     * @param userChoose Выбор пользователя
////     */
////    public static void menuAction(int userChoose) {
////        switch (userChoose) {
////            case 1 -> {
////                if (firstView) {
////                    setFirstView(false);
////                    Controller.fillSlotMachineRandomToys();
//////                    showToysInSlotMachine();
////                } else {
////                    System.out.println("Already!");
////                }
////            }
////            case 2 -> {
////                if (firstView) {
////                    System.out.println("Start game first!");
////                } else {
//////                    showToysInSlotMachine();
////                    rollAction();
////                }
////            }
////            case 3 -> {
////                if (firstView) {
////                    System.out.println("Start game first!");
////                } else {
////                    List<Toy> prizes = getPrizes();
////                    System.out.println(YELLOW + "\n+-----------------PRIZES----------------+");
////                    for (Toy toy : prizes) {
////                        System.out.printf("|   %-2s %-18s %-5s %-8s|%n",
////                                " ", toy.getName(), " ", toy.getChance() + "%");
////                    }
////                    System.out.println(YELLOW + "+---------------------------------------+\n");
////                }
////            }
////            case 4 -> {
////                if (firstView) {
////                    System.out.println("Start game first!");
////                } else {
////                    showToysInSlotMachine();
////                }
////            }
////            case 5 -> {
////                if (firstView) {
////                    System.out.println("Start game first!");
////                } else {
////                    Controller.fillSlotMachineRandomToys();
////                    showToysInSlotMachine();
////                }
////            }
////            case 6 -> {
////                System.out.println("take prizes");;
////            }
////        }
////    }
////
////    /**
////     * Получает от пользователя ввод и проверяет на то, является ли оно числом.
////     *
////     * @param requestMessage Сообщение запроса ввода
////     * @param failMessage    Сообщение верного ввода
////     * @return int
////     */
////    public static int numbersScanner(String requestMessage, String failMessage) {
////        Scanner scanner = new Scanner(System.in);
////        int number = 0;
////        boolean validNumber = false;
////        while (!validNumber) {
////            try {
////                System.out.print("\u001B[32m" + requestMessage);
////                number = scanner.nextInt();
////                if (number < 0) {
////                    number *= -1;
////                } // Преобразуем отрицательное в положительное
////                validNumber = true;
////            } catch (Exception e) {
////                System.out.println("\u001B[31m" + failMessage);
////                scanner.nextLine();
////            }
////        }
////        return number;
////    }
//
////    // Запускает Ролл (прокрутку) колеса с призами
////    public static void rollAction() {
////
////        if (Controller.getToysTypeCount() < 3) {
////            System.out.println(RED + "+---------------------------------------+ \n" +
////                                     "|           Too few toys left!          |\n" +
////                                     "|   ASK THE MANAGER TO UPDATE THE TOYS  |\n" +
////                                     "|           ** SLOT MACHINE **          |\n" +
////                                     "+---------------------------------------+ ");
////        } else {
////            addPrize(Controller.getNumberByChances());
////        }
////    }
//
////    public static void setFirstView(boolean firstView) {
////        ActionMenu.firstView = firstView;
////    }
//}
