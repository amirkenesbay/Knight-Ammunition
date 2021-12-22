package com.epam.knight.controller;

import com.epam.knight.model.Knight;
import com.epam.knight.model.ammunition.Helmet;
import com.epam.knight.model.ammunition.Sword;

public class KnightGenerator {

    public static Knight generateKnight() {
        Knight knight = new Knight();
        Sword sword = new Sword(10, 20, 30);
        Helmet helmet = new Helmet(30, 10, 20);
        knight.equip(sword);
        knight.equip(helmet);
        return knight;
    }
}
