package com.isep.rpg.items;

/*--------------------------*/
/*--------Class Armor-------*/
/*--------------------------*/

public class Armor extends Item {
    public Armor(String name, String holder, int defensePoints) {
        super(name);
        this.armorHolder = holder;
        this.defensePoints = defensePoints;
    }

    //Get
    public int getDefensePoints() { return defensePoints; }
    public String getArmorHolder(){ return armorHolder;}

    //Set
    public void setDefensePoints(int defensePoints) { this.defensePoints = defensePoints; }
    private int defensePoints;
    private String armorHolder;
}
