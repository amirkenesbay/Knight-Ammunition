package com.epam.knight.view;

import com.epam.knight.controller.Controller;
import com.epam.knight.model.Knight;
import com.epam.knight.model.ammunition.Ammunition;
import com.epam.knight.model.ammunition.Helmet;
import com.epam.knight.model.ammunition.Sword;

import java.util.List;

public class ConsoleView {
    private static final String MAIN_MENU = "Main menu:";
    private static final String MENU_ITEM_1 = "1. Print knight status";
    private static final String MENU_ITEM_2 = "2. Show ammunition";
    private static final String MENU_ITEM_3 = "3. Equip ammunition";
    private static final String MENU_ITEM_4 = "4. Sort ammunition";
    private static final String MENU_ITEM_5 = "5. Search ammunition";
    private static final String MENU_ITEM_6 = "6. Exit";
    private static final String CHOSE_OPTION = "Choose option:";
    private static final String WHAT_KNIGHT_OF_AMMUNITION = "What kind of ammunition do you want to equip? \n 1. Sword \n 2. Helmet";
    private static final String SORT_AMMUNITION = "Choose sort type:\n 1. Cost\n 2. Weight";
    private static final String SEARCH_AMMUNITION = "Choose search field:\n 1. Cost\n 2. Weight";
    private static final String AMMUNITION_NOT_FOUND = "Ammunition not found!";
    private static final String FIREWALL = "Bye!";
    private static final String INPUT_SWORD = "Input sword ";
    private static final String INPUT_HELMET = "Input helmet ";
    private static final String INPUT_MINIMUM = "Input minimum ";
    private static final String INPUT_MAXIMUM = "Input maximum ";
    private static final String COST = "cost:";
    private static final String DAMAGE = "damage:";
    private static final String WEIGHT = "weight:";
    private static final String PROTECTION = "protection:";
    private static final String AMMUNITION = "Ammunition ";
    private static final String SPACE = " ";

    public void showMenu(Knight knight, Controller controller) {
        UserInputs userInputs;
        do {
            System.out.println(MAIN_MENU);
            System.out.println(MENU_ITEM_1);
            System.out.println(MENU_ITEM_2);
            System.out.println(MENU_ITEM_3);
            System.out.println(MENU_ITEM_4);
            System.out.println(MENU_ITEM_5);
            System.out.println(MENU_ITEM_6);
            System.out.println(CHOSE_OPTION);

            int inputNumbers = controller.inputNumber(1, 6);
            userInputs = UserInputs.values()[inputNumbers - 1];
            switch (userInputs) {
                case PRINT_KNIGHT_STATS:
                    showAmmunitionStats(knight);
                    break;
                case SHOW_AMMUNITION:
                    showAmmunition(knight.getAmmunition());
                    break;
                case EQUIP_AMMUNITION:
                    equipAmmunition(knight, controller);
                    break;
                case SORT_AMMUNITION:
                    sortAmmunition(knight, controller);
                    break;
                case SEARCH_AMMUNITION:
                    searchAmmunition(knight, controller);
                    break;
                case EXIT:
                    System.out.println(FIREWALL);
                    break;
            }
        } while (userInputs != UserInputs.EXIT);
    }

    public void showAmmunitionStats(Knight knight) {
        System.out.println(AMMUNITION + COST + SPACE + knight.calculateAmmunitionCost());
        System.out.println(AMMUNITION + WEIGHT + SPACE + knight.calculateAmmunitionWeight());
        System.out.println(AMMUNITION + DAMAGE + SPACE + knight.calculateAmmunitionDamage());
        System.out.println(AMMUNITION + PROTECTION + SPACE + knight.calculateAmmunitionProtection());
    }

    public void showAmmunition(List<Ammunition> ammunitionList) {
        for (Ammunition value : ammunitionList) {
            System.out.println(value);
        }
    }

    public Sword equipSwordToAmmunition(Controller controller) {
        System.out.println(INPUT_SWORD + WEIGHT);
        int swordWeight = controller.inputNumber(0, Integer.MAX_VALUE);
        System.out.println(INPUT_SWORD + COST);
        int swordCost = controller.inputNumber(0, Integer.MAX_VALUE);
        System.out.println(INPUT_SWORD + DAMAGE);
        int swordDamage = controller.inputNumber(0, Integer.MAX_VALUE);
        return new Sword(swordDamage, swordWeight, swordCost);
    }

    public Helmet equipHelmetToAmmunition(Controller controller) {
        System.out.println(INPUT_HELMET + WEIGHT);
        int helmetWeight = controller.inputNumber(0, Integer.MAX_VALUE);
        System.out.println(INPUT_HELMET + COST);
        int helmetCost = controller.inputNumber(0, Integer.MAX_VALUE);
        System.out.println(INPUT_HELMET + DAMAGE);
        int helmetProtection = controller.inputNumber(0, Integer.MAX_VALUE);
        return new Helmet(helmetProtection, helmetWeight, helmetCost);
    }

    public void equipAmmunition(Knight knight, Controller controller) {
        System.out.println(WHAT_KNIGHT_OF_AMMUNITION);
        System.out.println(CHOSE_OPTION);
        int inputNumber = controller.inputNumber(1, 2);
        switch (inputNumber) {
            case 1:
                knight.equip(equipSwordToAmmunition(controller));
                break;
            case 2:
                knight.equip(equipHelmetToAmmunition(controller));
                break;
        }
    }

    public void sortAmmunition(Knight knight, Controller controller) {
        System.out.println(SORT_AMMUNITION);
        System.out.println(CHOSE_OPTION);
        int inputNumber = controller.inputNumber(1, 2);
        switch (inputNumber) {
            case 1:
                knight.sortAmmunitionByCost();
                break;
            case 2:
                knight.sortAmmunitionByWeight();
                break;
        }
    }

    public void searchAmmunition(Knight knight, Controller controller) {
        System.out.println(SEARCH_AMMUNITION);
        System.out.println(CHOSE_OPTION);
        int inputNumber = controller.inputNumber(1, 2);
        switch (inputNumber) {
            case 1:
                System.out.println(INPUT_MINIMUM);
                int minimumCost = controller.inputNumber(0, Integer.MAX_VALUE);
                System.out.println(INPUT_MAXIMUM);
                int maximumCost = controller.inputNumber(0, Integer.MAX_VALUE);
                knight.searchAmmunitionByCost(minimumCost, maximumCost);
                break;
            case 2:
                System.out.println(INPUT_MINIMUM);
                int minimumWeight = controller.inputNumber(0, Integer.MAX_VALUE);
                System.out.println(INPUT_MAXIMUM);
                int maximumWeight = controller.inputNumber(0, Integer.MAX_VALUE);
                knight.searchAmmunitionByWeight(minimumWeight, maximumWeight);
                break;
        }
    }
}
