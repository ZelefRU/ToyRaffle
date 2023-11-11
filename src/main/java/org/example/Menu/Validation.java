package org.example.Menu;

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
        int number = 0;
        boolean validNumber = false;
        while (!validNumber) {
            try {
                System.out.print(YELLOW + requestMessage);
                number = scanner.nextInt();
                if (number < 0) {
                    number *= -1;
                } // Преобразуем отрицательное в положительное
                validNumber = true;
            } catch (Exception e) {
                System.out.println(RED + failMessage);
                scanner.nextLine();
            }
        }
        return number;
    }
}
