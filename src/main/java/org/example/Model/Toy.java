package org.example.Model;

public class Toy {
    protected static int nextId = 1;

    private int count;
    protected int id;
    protected double chance;
    protected String name;

    public Toy(int count, double chance, String name) {
        this.count = count;
        this.chance = chance;
        this.name = name;
        this.id = nextId++;
    }

    public int getId() {
        return id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getChance() {
        return chance;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
//        return String.format("ID - %s, Name - %s, Chance - %s%%", id, name, chance);
        return String.format("%-3s %-18s %-4s %-6s", id, name, count, chance);
    }
}
