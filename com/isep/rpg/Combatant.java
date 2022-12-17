package com.isep.rpg;

import javax.lang.model.element.NestingKind;

import com.isep.rpg.items.Weapon;
import com.isep.rpg.items.consumables.*;

/*--------------------------*/
/*-----Class Combatant------*/
/*--------------------------*/

public abstract class Combatant {

    public Combatant(String n, int hp, int arm, int mana) {
        this.name = n;
        this.healthPoint = hp;
        this.baseHealthPoint = hp;
        this.armor = arm;
        this.baseArmor = arm;
        this.manaPoint = mana;
    }

    //Get

    /*Variable qui est un type attribute*/
    public String getName() {//méthode permettant de récupérer le nom du combattant
        return this.name;
    }

    public int getHealthPoint() {//méthode permettant de récupérer la valeur de la vie
        return this.healthPoint;
    }

    public int getPointArmor() {//méthode permettant de récupérer la valeur de l'armure
        return this.armor;
    }

    public int getPointMana() {//méthode permettant de récupérer la valeur de mana
        return this.manaPoint;
    }

    public int getWeaponDamage() {//méthode permettant de récupérer la valeur des dommages de l'arme
        return this.weapon.getDamagePoints();
    }


    /*PAS ICI
    public abstract String getNameWeapon();
    public abstract String getNameArmor();*/

    //Set
    public void looseHp(int hp){
        this.armor -= hp;
        if (this.armor <= 0)
        {
            this.healthPoint -= this.armor;
            this.armor = 0;
            if (this.healthPoint <= 0)
            {
                this.healthPoint = 0;
                //System.out.println(this.name + " is dead");
            }
        }
    }

    public void winHp(int hp){
        this.armor += hp;
        if (this.armor <= 0)
        {
            this.healthPoint += this.armor;
            this.armor = 0;
            if (this.healthPoint >= 100)
            {
                this.healthPoint = 100;
                //System.out.println(this.name + " is dead");
            }
        }
    }


    public void eatConsumable(Consumable item){
        if(item instanceof Food)
        {
            this.healthPoint += ((Food) item).getFoodPower(); //J'ajoute la puissance de la food
            if(this.healthPoint > this.baseHealthPoint) // je vérifie que je ne dépasse ma vie de base
            {
                this.armor = this.healthPoint - this.baseHealthPoint;
                if(this.armor > this.baseArmor)
                {
                    this.armor = this.baseArmor;
                }
                this.healthPoint = this.baseHealthPoint; //si c'est le cas je met ma vie à celle de base que je ne peux pas dépasser
            }
        }
        else if(item instanceof Potion)
        {
            this.armor += ((Potion) item).getPotionPower(); //J'ajoute la puissance de la potion
            if(this.armor > this.baseArmor) // je vérifie que je ne dépasse ma limite d'armure de base
            {
                this.armor = this.baseArmor; //si c'est le cas je met mon armure à celle de base que je ne peux pas dépasser
            }
        }
    }

    public void winMana(int mana){
        this.manaPoint += mana; //manaPoint = manaPoint += mana;
    }

    /*Méthode qui est un attribut*/
    // Chaque "vrai" combatant (non "abstract") implémente un code différent
    // pour la méthode "fight"
    public abstract void fight(Combatant combatant);//abstract car on ne sait pas comment il attaque
    public abstract int actionChoice();
    public abstract String actionChoiceSwitch(int choice);
    public abstract boolean defense ();
    public abstract void setDefense (boolean defense);
    //pour chaque attribut rajouter private (règles d'encapsulation en POO)
    private String name;
    private int healthPoint;//ne pas mettre static car sinon tous les points de vie seront partagés avec tous les combattants
    private int baseHealthPoint;
    private int weaponDamage;
    private int manaPoint;
    private int armor;
    private int baseArmor;
    private Weapon weapon;
    private boolean defense;


}