package org.example.Menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import static org.example.Menu.View.RED;
import static org.example.Menu.View.YELLOW;

public class Validation {

    /**
     * Получает от пользователя ввод и проверяет на то, является ли оно числом.
     *
     * @param requestMessage Сообщение запроса ввода
     * @param failMessage    Сообщение верного ввода
     * @return int
     */
    public static int numbersScanner(String requestMessage, String failMessage) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print(YELLOW + requestMessage);
                return  Math.abs(scanner.nextInt());
            } catch (InputMismatchException e) {
                System.out.println(RED + failMessage);
                scanner.nextLine();
            }
        }
    }
}
