package com.epam.knight.model.ammunition;

public class Helmet implements Protection{
    private final int protection;
    private final int weight;
    private final int cost;

    public Helmet(int protection, int weight, int cost) {
        this.protection = protection;
        this.weight = weight;
        this.cost = cost;
    }

    @Override
    public int getProtection() {
        return protection;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Helmet{" +
                "protection=" + protection +
                ", weight=" + weight +
                ", cost=" + cost +
                '}';
    }
}
