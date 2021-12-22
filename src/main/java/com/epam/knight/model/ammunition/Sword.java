package com.epam.knight.model.ammunition;

public class Sword implements Damage{
    private final int damage;
    private final int weight;
    private final int cost;

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public int getCost() {
        return cost;
    }

    public Sword(int damage, int weight, int cost) {
        this.damage = damage;
        this.weight = weight;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Sword{" +
                "damage=" + damage +
                ", weight=" + weight +
                ", cost=" + cost +
                '}';
    }
}
