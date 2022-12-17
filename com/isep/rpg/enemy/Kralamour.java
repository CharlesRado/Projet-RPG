package com.isep.rpg.enemy;

import com.isep.rpg.Combatant;

public class Kralamour extends Enemy {
    public Kralamour(String name, int hp){
        super(name, hp);
        this.name = name;
        this.healthPoint = hp;
        this.damagePoints = 30;
    }

    // Implémentation de la méthode abstraite "fight" pour le dragon
    @Override

    public void fight(Combatant combatant)
    {
        combatant.looseHp(this.damagePoints);
        System.out.println("Le Kralamour " + this.name + " utilse sa tentacule primaire et enlève " + this.damagePoints + " a " + combatant.getName());
    }

    public int getDamagePoints(){
        return this.damagePoints;
    }

    private String name;
    private int healthPoint;
    private int damagePoints;
}

