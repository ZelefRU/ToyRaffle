package org.example.Model;

import org.example.Exceptions.SlotMachineSizeException;

import java.util.List;

public class SlotMachine {
    private List<Toy> toys;
    private int capacity;
    private int totalToysCount;

    public SlotMachine() {}
    public SlotMachine(List<Toy> toys, int capacity) throws SlotMachineSizeException {
        int totalToysCount = 0;
        for (Toy toy : toys) {
            totalToysCount += toy.getCount();
        }
        if (totalToysCount > capacity) {
            throw new SlotMachineSizeException("Total toys count more than capacity");
        }
        this.totalToysCount = totalToysCount;
        this.toys = toys;
        this.capacity = capacity;
    }

    public SlotMachine(int capacity) {
        this.capacity = capacity;
    }

    public List<Toy> getToys() {
        return toys;
    }

    public void setToys(List<Toy> toys) {
        this.toys = toys;
        updateTotalToysCount();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getTotalToysCount() {
        return totalToysCount;
    }

    public void addToy(Toy toy) {
        int toysCount = toy.getCount();
        if (totalToysCount + toysCount > capacity) {
            System.out.println("Not enough space!");
        } else {
            toys.add(toy);
            totalToysCount += toysCount;
            System.out.printf("""
                            Toy with this settings has been added:\s
                            Name - %s
                            ID - %s
                            Count - %s
                            Chance - %s%%
                            """,
                    toy.getName(), toy.getId(), toy.getCount(), toy.getChance());
        }
    }

    public void updateTotalToysCount() {
        int tempCount = 0;
        for (Toy toy : toys) {
            tempCount += toy.getCount();
        }
        totalToysCount = tempCount;
    }

    public void removeToy(Toy toy, int count) {
        // Если игрушка есть в автомате
        if (toys.contains(toy)) {
            int toyCount = toy.getCount();
            // Если игрушек больше, чем хотим удалить
            if (toyCount > count) {
                // Получаем игрушку(ки) и изменяем число
                Toy tempToy = toys.get(toys.indexOf(toy));
                tempToy.setCount(tempToy.getCount() - count);
                toys.set(toys.indexOf(toy), tempToy);
                System.out.printf("Toy %s with ID %s has been removed. The are left %s toys in the machine\n",
                        toy.getName(), toy.getId(), tempToy.getCount());
            } else if (toyCount == count) {
                toys.remove(toy);
                System.out.printf("Toy %s with ID %s has been removed", toy.getName(), toy.getId());
            } else {
                System.out.println("Too much!");
            }
        } else {
            System.out.println("Toy not found in machine!");
        }
        updateTotalToysCount();
    }
}
