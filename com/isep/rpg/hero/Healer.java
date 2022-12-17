package com.isep.rpg.hero;

import com.isep.rpg.Combatant;
import com.isep.rpg.Game;
import com.isep.rpg.items.*;// .* = importe tout du dossier items
import com.isep.rpg.items.consumables.Consumable;
import com.isep.rpg.items.consumables.Food;
import com.isep.rpg.items.consumables.Potion;

import java.util.List;
import java.util.Scanner;

import static com.isep.rpg.Game.displayMessage;
import static java.lang.System.out;

/*--------------------------*/
/*-------Class Healer-------*/
/*--------------------------*/

public class Healer extends SpellCaster {

    public Healer(String name) {
        super(name,100,30,16);
    }

    @Override
    public void fight(Combatant combatant) {
        combatant.looseHp(this.weapon.getDamagePoints());
        System.out.println(this.getName() + " attaque " + combatant.getName() + "et il perd " + this.weapon.getDamagePoints() + " points de vie !");
    }
    @Override
    public void take(Item item) {
        if (item instanceof Weapon)
        {
            if(((Weapon) item).getWeaponHolder() == "Healer")
            {
                this.weapon = (Weapon) item;
            }
            else
            {
                System.out.println("Cette arme n'est pas faite pour " + this.getName());
            }
        }
        else if (item instanceof Potion)
        {
            this.eatConsumable((Consumable) item);
        }
        else if (item instanceof Food)
        {
            this.eatConsumable((Consumable) item);
        }
    }


    public int actionChoice() {
        Scanner scan = new Scanner (System.in);
        int choice;
        //condition permettant de connaitre le choix de l'action à faire
        do{
            displayMessage(
                    """
                    Quelles type d'actions voulez vous faire ? :\s
                    [1]- Se défendre \s
                    [2]- Soigner un allié \s
                    [3]- Utiliser un consommable \n """);

            choice = scan.nextInt(); // On lit la réponse de l'utilisateur
            if (choice < 1 || choice > 4) {
                displayMessage("Le numéro d'action rentré n'est pas bon... Réessayer !");
            }
        }while(choice < 1 || choice > 4);
        return choice;//renvoie du choix prit par l'utilisateur
    }

    public String actionChoiceSwitch(int choice) {
        switch (choice) {
            case 1:
                return "Defend";
            case 2:
                return "Heal";
            case 3:
                return "Consume";
            default:
                displayMessage("Problème de fonctionnement !");
        }
        return "";
    }

    public String getNameArmor(){
        return armorItem.getName();
    }

    public void castHeal(Combatant combatant) {
        // check if the healer has enough mana to cast a heal spell
        if (getMana() >= 5) {
            setMana(getMana()-5); // decrease the healer's mana by 50
            combatant.winHp(20);
            out.println(getName() + " lance un sort de soins!");
        } else {
            out.println(getName() + " n'a pas assez de mana pour lancer un sort de soins!");
        }
    }

    public void Status(){
        System.out.println(this.getName() + " : " + this.getHealthPoint() + " HP  ,  " + this.weapon.getDamagePoints() + " DMG  ,  " + (this.getPointArmor()) + " ARMOR");
    }
    public String getHealerWeaponName(){
        return weapon.getName();
    }
    public int getWeaponDamage(){
        return weapon.getDamagePoints();
    }
    private Weapon weapon;
    private Armor armorItem;
    private int calcDamage;
    private boolean defense;
    private int hp = 20;
}
