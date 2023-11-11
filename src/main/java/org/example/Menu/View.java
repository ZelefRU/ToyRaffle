package org.example.Menu;

import org.example.Controller.Controller;
import org.example.Model.Toy;

import java.util.List;

import static org.example.Menu.MenuActions.menuAction;
import static org.example.Menu.Validation.numbersScanner;

public class View {
    protected static final String RESET = "\u001B[0;1m";
    protected static final String BLACK = "\u001B[30;1m";
    protected static final String RED = "\u001B[31;1m";
    protected static final String GREEN = "\u001B[32;1m";
    protected static final String YELLOW = "\u001B[33;1m";
    protected static final String BLUE = "\u001B[34;1m";
    protected static final String PURPLE = "\u001B[35;1m";
    protected static final String CYAN = "\u001B[36;1m";
    protected static final String WHITE = "\u001B[37;1m";

    protected static boolean firstView = true;
    protected static boolean work = true;

    public static void setFirstView(boolean firstView) {
        View.firstView = firstView;
    }

    public static void setWork(boolean work) {
        View.work = work;
    }

    /**
     * Вывод меню действий
     */
    public static void showMenu() {
        while (work) {
            if (firstView) {
                System.out.print(BLUE + "Available actions:\n".toUpperCase() +
                        GREEN + "  1. Start Game!\n".toUpperCase() +
                        WHITE + "  x. Roll\n".toUpperCase() +
                        WHITE + "  x. Show me my prizes\n".toUpperCase() +
                        WHITE + "  x. View list of toys\n".toUpperCase() +
                        WHITE + "  x. Ask the MANAGER to update the toys\n".toUpperCase() +
                        WHITE + "  x. Collect your prizes and leave!\n".toUpperCase() +
                        RED + "  0. Exit\n".toUpperCase());
            } else {
                showSplitMenuWithToysPanel();
            }
            // Получаем выбор пользователя с проверкой на число
            int userChoose = numbersScanner(PURPLE + "[*] Input: ".toUpperCase(), "Number required!");
            if (userChoose == 0) {
                work = false;
            } else if (userChoose > 0 && userChoose < 7) {
                menuAction(userChoose);
            } else {
                System.out.print(RED +
                        "+---------------------------------------+\n" +
                        "|             Wrong Action!             |\n" +
                        "|               Try again               |\n" +
                        "+---------------------------------------+\n");
            }
        }
    }


    /**
     * Вывод меню совместно с содержимым автомата. Сделано исключительно для удобства навигации.
     */
    public static void showSplitMenuWithToysPanel() {
        List<Toy> toys = Controller.getToysInSlotMachine();
        StringBuilder result = new StringBuilder();
        int toySize = toys.size();

        // Список с действиями меню
        String[] actions = {WHITE + "x. START GAME!",
                GREEN + "2. ROLL",
                GREEN + "3. SHOW ME MY PRIZES",
                GREEN + "4. VIEW LIST OF TOYS",
                GREEN + "5. ASK THE MANAGER TO UPDATE THE TOYS",
                CYAN + "6. COLLECT YOUR PRIZES AND LEAVE!",
                RED + "0. EXIT"};

        result.append(YELLOW).append("+-----------------ITEMS-----------------+");
        result.append(BLUE).append(space(8)).append("AVAILABLE ACTIONS:\n");

        // Цикл добавления игрушек в StringBuilder для вывода
        for (int i = 0; i < toySize; i++) {
            result.append(YELLOW);
            result.append(String.format("|   %-2s %-18s %-5s %-8s|",
                    toys.get(i).getId(), toys.get(i).getName(), toys.get(i).getCount(), toys.get(i).getChance() + "%"));

            // Условие для добавления пунктов меню с правой стороны
            if (i < 7) {
                result.append(space(10)).append(actions[i]).append("\n");
            } else {
                result.append("\n");
            }
        }
        result.append(YELLOW).append("+---------------------------------------+");

        // Условие, которое срабатывает если в Автомате меньше 7 типов игрушек.
        // Необходимо для выравнивания текста по условной левой границе текста меню.
        if (toySize > 0 && toySize < 7) {
            result.append(space(10)).append(actions[toySize]).append("\n");
            for (int i = toySize + 1; i < actions.length; i++) {
                result.append(space(51)).append(actions[i]).append("\n");
            }
        }
        System.out.println(result);
    }

    /**
     * Просто потому что мне лень
     *
     * @param count Число пробелов
     * @return String
     */
    public static String space(int count) {
        return " ".repeat(count);
    }
}
