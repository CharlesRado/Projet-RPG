package com.isep.rpg.hero;

import com.isep.rpg.Combatant;
import com.isep.rpg.items.Item;
import com.isep.rpg.items.Weapon;
import com.isep.rpg.items.Armor;
import com.isep.rpg.items.consumables.Consumable;
import com.isep.rpg.items.consumables.Food;
import com.isep.rpg.items.consumables.Potion;

import java.util.Scanner;

import static com.isep.rpg.Game.displayMessage;

/*--------------------------*/
/*-------Class Hunter-------*/
/*--------------------------*/

public class Hunter extends Hero {

    public Hunter(String n) {
        //Hunter has 100 hp, 20 armor and 10 arrows
        super(n, 100, 50, 0);
        this.arrows = 10;
    }

    @Override
    public void fight(Combatant combatant)
    {
        if (this.arrows > 0){
            combatant.looseHp(this.weapon.getDamagePoints());
            System.out.println(this.getName() + " utilise une flèche et fait perdre "+ this.weapon.getDamagePoints() + "hp a" + combatant.getName() + " avec son " + weapon.getName());
            this.arrows -= 1;
        }
        else
        {
            combatant.looseHp(2);
            System.out.println(this.getName() + " n'a plus de flèches");
            System.out.println(this.getName() + " a fait tout de même perdre 2hp a " + combatant.getName() + " avec un coup d'arc !");
        }
    }

    @Override
    public void take(Item item)
    {
        if (item instanceof Weapon)
        {
            if(((Weapon) item).getWeaponHolder() == "Hunter")
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


    public void Status(){
        System.out.println(this.getName() + " : " + this.getHealthPoint() + " HP  ,  " + this.weapon.getDamagePoints() + " DMG  ,  " + (this.getPointArmor()) + " ARMOR");
    }

    public int getArrows() {
        return this.arrows;
    }
    public void setArrows(int arrows) {
        this.arrows += arrows;
    }
    public String getHunterWeaponName(){
        return this.weapon.getName();
    }
    public int getWeaponDamage() { return weapon.getDamagePoints(); }
    public String getArmorName() {
        return armorItem.getName();
    }
    public float getArmorDefensePoints() { return armorItem.getDefensePoints(); }


    private Weapon weapon;
    private Armor armorItem;
    private int arrows;
}
