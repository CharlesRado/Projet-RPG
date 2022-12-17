package com.isep.rpg.enemy;

import com.isep.rpg.Combatant;

public class Boss extends Enemy {
    public Boss(String name, int hp){
        super(name, hp);
        this.name = name;
        this.healthPoint = hp;
        this.damagePoints = 50;
    }

    // Implémentation de la méthode abstraite "fight" pour le dragon
    @Override

    public void fight(Combatant combatant)
    {
        combatant.looseHp(this.damagePoints);
        System.out.println("Le boss " + this.name + " s'énerve, se transforme et pulvérise " + combatant.getName() + "avec son attaque surdimensionnelle et lui inflige " + this.damagePoints);
    }

    public int getDamagePoints(){
        return this.damagePoints;
    }

    private String name;
    private int healthPoint;
    private int damagePoints;
}

