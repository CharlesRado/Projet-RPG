package com.isep.rpg.hero;

import com.isep.rpg.Combatant;
import com.isep.rpg.Game;
import com.isep.rpg.items.Item;
import com.isep.rpg.items.Weapon;
import com.isep.rpg.items.consumables.Consumable;
import com.isep.rpg.items.consumables.Food;
import com.isep.rpg.items.consumables.Potion;

import java.util.Scanner;

import static com.isep.rpg.Game.displayMessage;
import static java.lang.System.out;

/*--------------------------*/
/*--------Class Mage--------*/
/*--------------------------*/

public class Mage extends SpellCaster {

    public Mage(String name) {
        super(name,100,10, 12);
    }

    @Override
    public void fight(Combatant combatant) {
        combatant.looseHp(this.weapon.getDamagePoints());
        System.out.println(this.getName() + " attaque " + combatant.getName() + " et il perd " + this.weapon.getDamagePoints() + " points de vie !");
    }

    @Override
    public void take(Item item) {
        if (item instanceof Weapon)
        {
            if(((Weapon) item).getWeaponHolder() == "Mage")
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

    //permet de renvoyer le choix de l'action
    public int actionChoice() {
        Scanner scan = new Scanner (System.in);
        int choice;
        //condition permettant de connaitre le choix de l'action à faire
        do{
            displayMessage(
                    """
                    Quelles type d'actions voulez vous faire ? :\s
                    [1]- Attaquer \s
                    [2]- Se défendre \s
                    [3]- Soigner un allié \s
                    [4]- Utiliser un consommable \n """);

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
                return "Attack";
            case 2:
                return "Defend";
            case 3:
                return "Heal";
            case 4:
                return "Consume";
            default:
                displayMessage("Problème de fonctionnement !");
        }
        return "";
    }

    public void castFireball(Combatant combatant) {
        if (getMana() >= 10) {
            setMana(getMana()-10); // decrease the healer's mana by 50
            combatant.winHp(10);
            out.println(getName() + " lance la boule de feu!");
        } else {
            out.println(getName() + " n'a pas assez de mana pour lancer sa boule de feu !");
        }
    }

    public void castLightning(Combatant combatant) {
        if (getMana() >= 15) {
            setMana(getMana()-15); // decrease the healer's mana by 50
            combatant.winHp(16);
            out.println(getName() + " lance l'éclair !");
        } else {
            out.println(getName() + " n'a pas assez de mana pour lancer son éclair !");
        }
    }
    public void focus(){
        addMana(10);
        displayMessage(getName() + " se focus et regagne 10 MANA !");
    }
    public String getMageWeaponName(){
        return this.weapon.getName();
    }
    public int getWeaponDamage(){
        return this.weapon.getDamagePoints();
    }

    private Weapon weapon;
}
