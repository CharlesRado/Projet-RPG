package com.isep.rpg.enemy;

import com.isep.rpg.Combatant;

public class Bouftou extends Enemy {
    public Bouftou(String name, int hp){
        super(name, hp);
        this.name = name;
        this.healthPoint = hp;
        this.damagePoints = 5;
    }

    // Implémentation de la méthode abstraite "fight" pour le dragon
    @Override

    public void fight(Combatant combatant)
    {
        combatant.looseHp(this.damagePoints);
        System.out.println("Le bouftou " + this.name + " mord et enlève " + this.damagePoints + " a " + combatant.getName());
    }

    public int getDamagePoints(){
        return this.damagePoints;
    }

    private String name;
    private int healthPoint;
    private int damagePoints;
}