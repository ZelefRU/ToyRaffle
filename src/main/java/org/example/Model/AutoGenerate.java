package org.example.Model;

import org.example.Model.Enums.ToyNames;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class AutoGenerate {

    /**
     * Создает и возвращает список строк на основе значений перечисления.
     *
     * @param enums Массив значений перечисления.
     * @return Список строк, содержащий имена элементов перечисления.
     */
    public static List<String> fillEnumsList(Enum[] enums) {
        List<String> result = new ArrayList<>();
        for (Enum anEnum : enums) result.add(anEnum.name());
        return result;
    }

    /**
     * Возвращает случайное имя из списка.
     *
     * @param list Список строк, из которого выбирается случайное имя.
     * @return Случайное имя.
     */
    public static String randomFromList(List<String> list) {
        return list.get(new Random().nextInt(list.size()));
    }

    /**
     * Просто возвращает случайное число в формате double от 1 до 100 включительно
     * @return double
     */
    public static double getRandomChance() {
        return new Random().nextDouble(1, 101);
    }

    /**
     * Возвращает случайную Игрушку с установленным количеством
     * @param count Количество
     * @return Toy
     */
    public static Toy getRandomToy(int count) {
        List<String> toysNames = fillEnumsList(ToyNames.values());
        return new Toy(count, getRandomChance(), randomFromList(toysNames));
    }

    /**
     * Возвращает случайную Игрушку с установленным количеством и шансом
     * @param count Количество
     * @param chance Шанс
     * @return Toy
     */
    public static Toy getRandomToy(int count, double chance) {
        List<String> toysNames = fillEnumsList(ToyNames.values());
        return new Toy(count, chance, randomFromList(toysNames));
    }

    /**
     * Возвращает список случайных Игрушек с заданным количеством видов (или типов) игрушек
     * максимальным общим числом и границей количества в одном виде (типе) игрушки
     * @param toyTypeCount Число видов (типов) игрушек
     * @param totalToysCountLimit Максимальное общее число игрушек
     * @param maxCountInToyTypeLimit Лимит количества игрушек в одном виде (типе)
     * @param full Нужно ли заполнять автомат полностью
     * @return {@code List<Toy>}
     */
    public static List<Toy> getListRandomToys(int toyTypeCount, int totalToysCountLimit, int maxCountInToyTypeLimit, boolean full) {
        Random random = new Random();
        List<Toy> result = new ArrayList<>();
        // Генерируем случайные шансы на основе количества типов игрушек
        ArrayList<Double> randomChanceList = getRandomChanceList(toyTypeCount);

        int currentToysCount = 0;
        // Создаём игрушки с проверкой на допустимое кол-во
        for (int i = 0; i < toyTypeCount; i++) {
            Toy tempToy = getRandomToy(random.nextInt(1, maxCountInToyTypeLimit + 1), randomChanceList.get(i));
            /* Если число сгенерированное в указанных пределах оказывается больше, чем
             максимально допустимое количество для каждого типа игрушек, то оно подставляется
             в количество вместо максимального. Максимально допустимое количество игрушек для
             каждого типа вычисляется по формуле с расчётом на то, чтобы всем типам хватило
             слотов, даже если будет выпадать максимальное число раз за разом
            */
            int currentMaxCountPerToy = (totalToysCountLimit - currentToysCount) / (toyTypeCount - i);
            if (currentMaxCountPerToy < tempToy.getCount()) {
                tempToy.setCount(currentMaxCountPerToy);
            }

            if (full && i == toyTypeCount -1) {
                tempToy.setCount(totalToysCountLimit - currentToysCount);
            }
            result.add(tempToy);
            currentToysCount += tempToy.getCount();
        }

        return result;
    }


    public static ArrayList<Double> getRandomChanceList(int count) {
        double total = 100;
        Random random = new Random();

        ArrayList<Double> result = new ArrayList<>();
        int multiply = 3;

        // Определение формата с одной десятой
        DecimalFormat df = new DecimalFormat("#.#");

        for (int i = 0; i < count - 1; i++) {
            if (count - i == multiply) {
                multiply--;
            }
            double bound = total / (count - i) * multiply;
            double chance = random.nextDouble(bound);
            total -= chance;

            // Форматирование и добавление в список
            result.add(Double.valueOf(df.format(chance)));
        }
        result.add(Double.valueOf(df.format(total)));
        return result;
    }
}
