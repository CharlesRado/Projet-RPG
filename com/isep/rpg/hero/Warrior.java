package com.isep.rpg.hero;

import com.isep.rpg.Combatant;
import com.isep.rpg.items.Item;
import com.isep.rpg.items.Weapon;
import com.isep.rpg.items.Armor;
import com.isep.rpg.items.consumables.Consumable;
import com.isep.rpg.items.consumables.Food;
import com.isep.rpg.items.consumables.Potion;

import java.sql.SQLOutput;
import java.util.Scanner;

import static com.isep.rpg.Game.displayMessage;

/*--------------------------*/
/*-------Class Warrior------*/
/*--------------------------*/

public class Warrior extends Hero {
    public Warrior(String name){
        //Warrior has 100 hp and 20 armor
        super(name, 100, 100, 0);
    }

    //Implémentation de la méthode abstraite "fight" par le guerrier
    @Override
    public void fight(Combatant combatant)
    {
        combatant.looseHp(this.weapon.getDamagePoints());
        System.out.println(this.getName() + " attaque " + combatant.getName() + "et il perd " + this.weapon.getDamagePoints() + " points de vie !");
    }

    //Implémentation de la méthode abstraite "take" pour le warrior :
    @Override
    public void take(Item item)
    {
        if (item instanceof Weapon)
        {
            if(((Weapon) item).getWeaponHolder() == "Warrior")
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
        Scanner scan = new Scanner(System.in);
        int choice;
        do{
            displayMessage(
                    """
                    Quelles type d'actions voulez vous faire ? :\s
                    [1]- Attaquer\s
                    [2]- Se défendre\s
                    [3]- Utiliser un consommable\n """);

            choice = scan.nextInt(); // On lit la réponse de l'utilisateur
            if (choice < 1 || choice > 4) {
                displayMessage("Le numéro d'action rentré n'est pas bon... Réessayer !");
            }
        }while(choice < 1 || choice > 4);
        return choice;
    }


    public String actionChoiceSwitch(int choice) {
        switch (choice) {
            case 1:
                return "Attack";
            case 2:
                return "Defend";
            case 3:
                return "Consume";
            default:
                displayMessage("Problème de fonctionnement !");
        }
        return "";
    }

    public String getWarriorWeaponName(){
        return this.weapon.getName();
    }
    public int getWeaponDamage(){
        return this.weapon.getDamagePoints();
    }

    private Weapon weapon;
    //private Armor armorItem;
    //ajouter les potions et la nourriture si besoin à verifier
}
