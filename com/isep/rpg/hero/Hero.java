package com.isep.rpg.hero;

import com.isep.rpg.Combatant;
import com.isep.rpg.items.*;

/*--------------------------*/
/*--------Class Hero--------*/
/*--------------------------*/

public abstract class Hero extends Combatant {
    public Hero(String n, int hp,int armor, int mana) {
        super(n, hp, armor, mana);
    }

    // Abstract car n'importe quel hero peut prendre un objet mais son
    // utilisation dépend du type du héro (une arme n'est pas utile à un mage)
    public abstract void take(Item item);

    /*public void defense(){
    }*/
}
