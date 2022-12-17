package com.isep.rpg.enemy;

/*-----Class Dragon-----*/

import com.isep.rpg.Combatant;
import com.isep.rpg.enemy.Enemy;

public class Dragon extends Enemy {
    public Dragon(String name, int hp){
        super(name, hp);
        this.name = name;
        this.healthPoint = hp;
        this.damagePoints = 15;
    }

    // Implémentation de la méthode abstraite "fight" pour le dragon
    @Override

    public void fight(Combatant combatant)
    {
        combatant.looseHp(this.damagePoints);
        System.out.println("Le dragon " + this.name + " crache du feu et enlève " + this.damagePoints + " a " + combatant.getName());
    }

    public int getDamagePoints(){
        return this.damagePoints;
    }

    private String name;
    private int healthPoint;
    private int damagePoints;
}
