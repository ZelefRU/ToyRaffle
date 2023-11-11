package org.example.Controller;

import org.example.Model.SlotMachine;
import org.example.Model.Toy;

import java.util.List;

import static org.example.Model.AutoGenerate.*;

public class Controller {
    protected static int defaultCapacity = 30;
    private static SlotMachine slotMachine = new SlotMachine();

    public static void fillSlotMachineRandomToys() {
        slotMachine.setToys(getListRandomToys(5, defaultCapacity, 10, true));
    }

    public static List<Toy> getToysInSlotMachine() {
        return slotMachine.getToys();
    }
}
