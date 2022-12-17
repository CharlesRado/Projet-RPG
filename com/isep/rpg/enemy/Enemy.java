package com.isep.rpg.enemy;

/*-----Class Enemy-----*/

import com.isep.rpg.Combatant;

public abstract class Enemy extends Combatant {
    public Enemy(String name, int hp){
        super(name, hp, 0, 0);
        this.name = name;
        this.healthPoint = hp;
    }

    public abstract void fight(Combatant combatant);//abstract car on ne sait pas comment il attaque
    public abstract int getDamagePoints();


    // Les points de dégats sont intégrés aux ennemis (ils n'ont pas d'arme)
    private String name;
    private int healthPoint;
}
