package com.isep.rpg.items.consumables;

import com.isep.rpg.hero.Hero;
import com.isep.rpg.hero.SpellCaster;

import static com.isep.rpg.Game.displayMessage;

/*--------------------------*/
/*-------Class Potion-------*/
/*--------------------------*/

public class Potion extends Consumable {
    public Potion (String name, int mana){
        super(name, mana);
        this.manaPotion = mana;
    }

    public void grailMana(Hero hero){
        if (this.manaPotion > 0){
            hero.winHp(manaPotion);
            portion -= 1;
            displayMessage(hero.getName() + " consomme " + name + " et regagne " + manaPotion + " MANA !");
        } else {
            displayMessage("Vous n'avez plus de assez de "+ name + " pour en consommer !");
        }
    }

    public void addPortion(int addition){
        this.manaPotion += addition;
    }
    public int getPotionPower() { return this.manaPotion; }

    /*public void littlePotion(SpellCaster mage){
        System.out.println(mage.getName() + "prends une petite potion qui permet de récupérer 10 mana");
        mage.addMana(manaLowPotion);
    }

    public void middlePotion(SpellCaster mage){
        System.out.println(mage.getName() + "prends une potion moyenne qui permet de récupérer 15 mana");
        mage.addMana(manaMiddlePotion);
    }

    public void bigPotion(SpellCaster mage){
        System.out.println(mage.getName() + "prends une petite potion qui permet de récupérer 20 mana");
        mage.addMana(manaBigPotion);
    }*/


    /*if (!heroes.containsKey(hero)) {
        System.out.println("Le héros sélectionné n'existe pas.");
        return;
    }

    // On récupère le héros à partir de la liste de héros
    Hero h = heroes.get(hero);

    // On augmente ses points de mana de 20
    h.setMana(h.getMana() + 20);

    // On affiche un message pour indiquer que l'opération a réussi
    System.out.println("Le héros " + hero + " a maintenant " + h.getMana() + " points de mana.");*/
    private String name;
    private int manaPotion;

    /*public String manaHolder;
    private int manaLowPotion= 10;
    private int manaMiddlePotion= 15;
    private int manaBigPotion= 20;*/
    private int portion;
}
