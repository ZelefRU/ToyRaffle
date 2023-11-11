package org.example.Controller;

import org.example.Model.SlotMachine;
import org.example.Model.Toy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.example.Utils.AutoGenerate.*;

public class Controller {
    protected static int defaultCapacity = 40;
    protected static SlotMachine slotMachine = new SlotMachine();


    /**
     * Возвращает кол-во Типов игрушек
     * @return int
     */
    public static int getToysTypeCount() {
        return slotMachine.getToys().size();
    }

    /**
     * Заполняет автомат случайными игрушками со значениями по умолчанию
     */
    // TODO: 11/12/2023 Добавить возможность установки менеджером собственных значений.
    public static void fillSlotMachineRandomToys() {
        List<Toy> toyList = getListRandomToys(12, defaultCapacity, 10, true);
        slotMachine.setToys(toyList);
    }

    /**
     * Возвращает игрушки из игрового автомата
     * @return {@code List<Toy>}
     */
    public static List<Toy> getToysInSlotMachine() {
        return slotMachine.getToys();
    }

    /**
     * Возвращает игрушку с учётом шанса выпадения.
     * @return Toy
     */
    public static Toy getToyByChance() {
        List<Toy> toys = slotMachine.getToys();
        List<Integer> chancesInIntegers = new ArrayList<>();
        for (Toy toy : toys) {
            chancesInIntegers.add((int) (toy.getChance() * 10));
        }

        /*
        Использовал свою идею для получения игрушки с учётом шанса.
        Создаётся ArrayList и заполняется значениями ID то кол-во раз,
        которое указано в шансе, т.е., если шанс 12.9, то в ArrayList
        будет 129 раз добавлено ID, и так по каждой игрушке. Затем
        random выбирает случайное число из всего этого списка, тем самым,
        у тех ID что повторяются чаще больше шансов, за счёт чего и работает
        система с учётом шанса выпадения. Мне было немного лень придумывать
        что-то более красивое и оптимизированное в рамках этой программы.
         */
        ArrayList<Integer> chances = new ArrayList<>();
        int tempId = 0;
        for (Integer integer : chancesInIntegers) {
            for (int i = 0; i < integer; i++) {
                chances.add(tempId);
            }
            tempId++;
        }
        int prizeId = 0;
        try {
            prizeId = chances.get(new Random().nextInt(0, chances.size()));
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        slotMachine.removeToy(toys.get(prizeId), 1);
        return toys.get(prizeId);
    }
}
