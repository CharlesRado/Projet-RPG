package com.isep.rpg.items.consumables;

import com.isep.rpg.items.Item;


/*--------------------------*/
/*-----Class Consumable-----*/
/*--------------------------*/


public abstract class Consumable extends Item {
    public Consumable(String name, int upPower){
        super(name);
        this.consumablePower = upPower;
    }
    public abstract String so();
    private int consumablePower;
}
