package com.isep.rpg.items;

import com.isep.rpg.Combatant;
import com.isep.rpg.items.*;

import static java.lang.System.out;

/*--------------------------*/
/*-------Class Weapon-------*/
/*--------------------------*/


public class Weapon extends Item {

    public Weapon(String weapon_name, String holder, int damagePoints) {
        super(weapon_name);
        this.holder = holder;
        this.damagePoints = damagePoints;
    }

    public int getDamagePoints() {
        return this.damagePoints;
    }
    public String getWeaponHolder(){return this.holder;}

    private int damagePoints;
    private String holder;
    // Une arme inflige des points de dégats
    // Elle peut être porter que par certains combattants

}
