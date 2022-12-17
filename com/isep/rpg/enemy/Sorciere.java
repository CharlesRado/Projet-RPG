package com.isep.rpg.enemy;

/*-----Class Sorciere-----*/

import com.isep.rpg.Combatant;
import com.isep.rpg.enemy.Enemy;

public class Sorciere extends Enemy {
    public Sorciere(String name, int hp){
        super(name, hp);
        this.name = name;
        this.healthPoint = hp;
        this.damagePoints = 10;
    }

    // Implémentation de la méthode abstraite "fight" pour le dragon
    @Override

    public void fight(Combatant combatant)
    {
        combatant.looseHp(this.damagePoints);
        System.out.println("La sorcière " + this.name + " jette un sort et enlève " + this.damagePoints + " a " + combatant.getName());
    }

    public int getDamagePoints(){
        return this.damagePoints;
    }

    private String name;
    private int healthPoint;
    private int damagePoints;
}
