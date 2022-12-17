package com.isep.rpg.items;

/*--------------------------*/
/*--------Class Item--------*/
/*--------------------------*/

public abstract class Item {

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    private String name;
}
