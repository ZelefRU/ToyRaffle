package org.example.Model;

public class Toy {
    protected static int nextId = 1;

    protected int id;
    private int count;
    private double chance;
    private String name;

    public Toy(int count, double chance, String name) {
        this.count = count;
        this.chance = chance;
        this.name = name;
        this.id = nextId++;
    }

    public Toy() {
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

    public void setChance(double chance) {
        this.chance = chance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
//        return String.format("ID - %s, Name - %s, Chance - %s%%", id, name, chance);
        return String.format("%-3s %-18s %-4s %-6s", id, name, count, chance);
    }
}
