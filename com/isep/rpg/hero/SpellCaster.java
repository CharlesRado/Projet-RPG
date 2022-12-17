package com.isep.rpg.hero;

import com.isep.rpg.Combatant;
import com.isep.rpg.hero.Hero;
import com.isep.rpg.items.*;

/*--------------------------*/
/*-----Class SpellCaster----*/
/*--------------------------*/

public abstract class SpellCaster extends Hero {

    public SpellCaster(String n, int hp, int armor, int mana) {
        super(n, hp,armor,mana);
        this.mana = mana;
    }

    public int getMana(){
        return this.mana;
    }

    public void setMana(int mana){
        this.mana = mana;
    }

    public void addMana(int mana){
        this.mana += mana;
    }

    public void increaseMana(int amount) {
        setMana(getMana()+ amount);
    }

    //arme : healer

    public void Gourds(Combatant combatant) {
        // check if the mage has enough mana to cast a fireball
        combatant.looseHp(10);
        System.out.println(getName() + " frappe avec sa gourde !");
    }


    //armes : mage
    public void castFireball(Combatant combatant) {
        // check if the mage has enough mana to cast a fireball
        if (getMana() >= 3) {
            setMana(getMana()-3); // decrease the mage's mana by 50
            combatant.looseHp(25);
            System.out.println(getName() + " lance une boule de feu!");
        } else {
            System.out.println(getName() + " n'a pas assez de mana pour lancer une boule de feu!");
        }
    }
    public void PetrolBomb(Combatant combatant) {
        // check if the mage has enough mana to cast a fireball
        if (getMana() >= 5) {
            setMana(getMana()-5); // decrease the mage's mana by 50
            combatant.looseHp(40);
            System.out.println(getName() + " lance une boule de feu!");
        } else {
            System.out.println(getName() + " n'a pas assez de mana pour lancer une boule de feu!");
        }
    }

    protected int mana;
}
