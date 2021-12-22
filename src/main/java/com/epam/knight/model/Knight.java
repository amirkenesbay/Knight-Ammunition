package com.epam.knight.model;

import com.epam.knight.model.ammunition.Ammunition;
import com.epam.knight.model.ammunition.Damage;
import com.epam.knight.model.ammunition.Protection;
import com.epam.knight.model.sort.SortAmmunitionByCost;
import com.epam.knight.model.sort.SortAmmunitionByWeight;

import java.util.ArrayList;
import java.util.List;

public class Knight {

    private List<Ammunition> ammunitionList;

    public List<Ammunition> getAmmunition() {
        return ammunitionList;
    }

    public Knight() {
        ammunitionList = new ArrayList<>();
    }

    /**
     * Add new ammunition element to knight
     *
     * @param element that should be equipped to the knight
     */
    public void equip(Ammunition element) {
        ammunitionList.add(element);
    }

    public int calculateAmmunitionCost() {
        int sumCost = 0;
        for (Ammunition value : ammunitionList) {
            sumCost += value.getCost();
        }
        return sumCost;
    }

    public int calculateAmmunitionWeight() {
        int sumWeight = 0;
        for (Ammunition value : ammunitionList) {
            sumWeight += value.getWeight();
        }
        return sumWeight;
    }

    public int calculateAmmunitionDamage() {
        int sumDamage = 0;
        for (Ammunition value : ammunitionList) {
            if(value instanceof Damage){
                sumDamage += ((Damage)value).getDamage();
            }
        }
        return sumDamage;
    }

    public int calculateAmmunitionProtection() {
        int sumProtection = 0;
        for (Ammunition value : ammunitionList) {
            if(value instanceof Protection){
                sumProtection += ((Protection)value).getProtection();
            }
        }
        return sumProtection;
    }

    public void sortAmmunitionByCost(){
        ammunitionList.sort(new SortAmmunitionByCost());
        for (Ammunition ammunition : ammunitionList) {
            System.out.println(ammunition);
        }
    }

    public void sortAmmunitionByWeight(){
        ammunitionList.sort(new SortAmmunitionByWeight());
        for (Ammunition ammunition : ammunitionList) {
            System.out.println(ammunition);
        }
    }

    public void searchAmmunitionByCost(int start, int end){
        for (Ammunition ammunition : ammunitionList) {
            if(ammunition.getCost() >= start && ammunition.getCost() <= end){
                System.out.println(ammunition);
            }
        }
    }

    public void searchAmmunitionByWeight(int start, int end){
        for (Ammunition ammunition : ammunitionList) {
            if(ammunition.getWeight() >= start && ammunition.getWeight() <= end){
                System.out.println(ammunition);
            }
        }
    }

}