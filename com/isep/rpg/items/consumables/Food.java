package com.isep.rpg.items.consumables;

import com.isep.rpg.hero.Hero;

import static com.isep.rpg.Game.displayMessage;


/*--------------------------*/
/*--------Class Food--------*/
/*--------------------------*/


public class Food extends Consumable {
    public Food(String name, int hp) {
        super(name, hp);
        this.hpFood = hp;
    }

    public void grailFood(Hero hero){
        if (this.hpFood > 0){
            hero.winHp(hpFood);
            portion -= 1;
            displayMessage(hero.getName() + " consomme " + name + " et regagne " + hpFood + " HP !");
        } else {
            displayMessage("Vous n'avez plus de assez de "+ name + " pour en consommer !");
        }
    }

    public void addQuantity(int addition){
        this.hpFood += addition;
    }
    public int getFoodPower() { return this.hpFood; }

    /*public void Poundou(Hero combatant){
        System.out.println(combatant.getName() + " mange du Poundou et récupère donc " + hpPoundou + " PV !");
        combatant.winHp(hpPoundou);
        System.out.println(combatant.getName() + " a mangé du Poundou !");
    }

    public void Dombre(Hero combatant){
        System.out.println(combatant.getName() + " mange du Dombre et récupère donc " + hpDombre + " PV !");
        combatant.winHp(hpDombre);
        System.out.println(combatant.getName() + " a mangé du Dombre !");
    }

    public void Aloco(Hero combatant){
        System.out.println(combatant.getName() + " mange du Aloco et récupère donc " + hpAloco + " PV !");
        combatant.winHp(hpAloco);
        System.out.println(combatant.getName() + " a mangé du Aloco !");
    }*/
    private String name;
    private int hpFood;
    /*private String foodHolder;
    private int hpPoundou = 20;
    private int hpDombre = 25;
    private int hpAloco = 30;*/
    private int portion;

}
