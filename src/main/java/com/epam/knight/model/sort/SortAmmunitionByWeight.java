package com.epam.knight.model.sort;

import com.epam.knight.model.ammunition.Ammunition;

import java.util.Comparator;

public class SortAmmunitionByWeight implements Comparator<Ammunition> {
    @Override
    public int compare(Ammunition o1, Ammunition o2) {
        return Integer.compare(o1.getWeight(), o2.getWeight());
    }
}
