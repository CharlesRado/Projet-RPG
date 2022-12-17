package com.isep.rpg;

import com.isep.rpg.enemy.*;
import com.isep.rpg.hero.*;
import com.isep.rpg.items.Weapon;
import com.isep.rpg.items.consumables.Food;
import com.isep.rpg.items.consumables.Potion;
import com.isep.utils.InputParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.util.concurrent.ThreadLocalRandom;

import javax.sound.sampled.*;

import java.io.File;

/*--------------------------*/
/*--------Class Game--------*/
/*--------------------------*/

public class Game {

    public Game(InputParser inputParser){

        System.out.println("Bienvenue dans mon Mini RPG Lite 3000 ! Bon jeu et bonne chance");
        //Liste des armes pour chaque type de héros
        warriorWeaponList = new ArrayList<>();
        hunterWeaponList = new ArrayList<>();
        mageWeaponList = new ArrayList<>();
        healerWeaponList = new ArrayList<>();

        //On ajoute les armes à la liste pour le warrior
        warriorWeaponList.add(new Weapon("Epée Valeryenne", "Warrior", 90));
        warriorWeaponList.add(new Weapon("Gourdin maléfique", "Warrior", 50));
        warriorWeaponList.add(new Weapon("Couteau paralysant", "Warrior", 40));
        warriorWeaponList.add(new Weapon("Kolibris doloris", "Warrior", 30));

        ///On ajoute les armes à la liste pour le hunter
        hunterWeaponList.add(new Weapon("Arc de Sureau", "Hunter", 100));
        hunterWeaponList.add(new Weapon("Arbalète Diamantique", "Hunter", 70));
        hunterWeaponList.add(new Weapon("Fronde glacée", "Hunter", 50));
        hunterWeaponList.add(new Weapon("Magnum Zana-Tsipìka", "Hunter", 35));

        //On ajoute les armes à la liste pour le mage
        mageWeaponList.add(new Weapon("Felo'Melorn", "Mage", 90));
        mageWeaponList.add(new Weapon("Aluneth", "Mage", 50));

        //On ajoute les armes à la liste pour le warrior
        healerWeaponList.add(new Weapon("Acide Chloridrique", "Healer", 90));
        healerWeaponList.add(new Weapon("Venin Eclésiastique", "Healer", 50));

        // On créé les listes pour les consomables
        epicerie = new ArrayList<>();
        pub = new ArrayList<>();

        // On ajoute les food
        epicerie.add(new Food("Fruits", 30));
        epicerie.add(new Food("Steak", 40));
        epicerie.add(new Food("Poulet", 100));

        // On ajoute les potions
        pub.add(new Potion("Diabolo", 20));
        pub.add(new Potion("Pilsner", 40));
        pub.add(new Potion("Ricard", 100));

        this.inputParser = inputParser;

        // Liste des héros
        heros = new ArrayList<>();
        // On créé le scanner pour le nombre de héros choisit par l'utilisateur
        Scanner scan1 = new Scanner (System.in);

        do {
            // On demande à l'utilisateur de choisir un nombre entre 1 et 4
            System.out.println("Avec combien de héros voulez vous partir a l'aventure? (max = 4): ");
            nbHero = scan1.nextInt();
            // On limite à 4 heros pour le moment et on boucle tant que le nomnbre d'héros choisit n'est pas bon
            if (nbHero < 1 || nbHero > 4)
            {
                System.out.println("Vous ne pouvez avoir qu'1 a 4 héros maximum !");
            }
        } while (nbHero < 1 || nbHero > 4);

        // On créé le scanner pour créer notre héros
        Scanner scan2 = new Scanner (System.in);

        ///
        // Pour tous les héros on demande à l'user de donner son nom et on lui ajoute une arme
        // On lui ajoute une arme
        // On affiche ses caractéristiques d'armure
        // On affiche les caractéristiques de son arme
        for (int i = 0; i<nbHero; i++)
        {
            System.out.println("Quel Héros souhaitez vous ajouter a votre équipe? :\nWarrior\nHunter\nMage\nHealer");
            typeHero = scan2.nextLine();
            switch (typeHero.toLowerCase())
            {
                case "warrior":
                    System.out.println("Quel est son nom? : ");
                    name = scan2.nextLine();
                    tempWarrior = new Warrior(name);
                    tempWarrior.take(warriorWeaponList.get(i));
                    System.out.println(tempWarrior.getName() + " rejoint l'aventure\nIl possède une " +
                            tempWarrior.getWarriorWeaponName() + " qui tape : " + tempWarrior.getWeaponDamage() + " DMG" +
                            "\nEt il a une armure de : " + tempWarrior.getPointArmor() + " DEF\n");
                    heros.add(tempWarrior);
                    break;
                case "hunter":
                    System.out.println("Quel est son nom? : ");
                    name = scan2.nextLine();
                    tempHunter = new Hunter(name);
                    tempHunter.take(hunterWeaponList.get(i));
                    System.out.println(tempHunter.getName() + " rejoint l'aventure\nIl possède une " +
                            tempHunter.getHunterWeaponName() + " qui tape : " + tempHunter.getWeaponDamage() + " DMG" +
                            "\nEt il a une armure de : " + tempHunter.getPointArmor() + " DEF\n");
                    heros.add(tempHunter);
                    break;
                case "mage":
                    name = scan2.nextLine();
                    tempMage = new Mage(name);
                    tempMage.take(mageWeaponList.get(i));
                    System.out.println(tempMage.getName() + " rejoint l'aventure\nIl possède une " +
                            tempMage.getMageWeaponName() + " qui tape : " + tempMage.getWeaponDamage() + " DMG" +
                            "\nEt il a une armure de : " + tempMage.getPointArmor() + " DEF\n");
                    heros.add(tempMage);
                    break;
                case "healer":
                    name = scan2.nextLine();
                    tempHealer = new Healer(name);
                    tempHealer.take(healerWeaponList.get(i));
                    System.out.println(tempHealer.getName() + " rejoint l'aventure\nIl possède une " +
                            tempHealer.getHealerWeaponName() + " qui tape : " + tempHealer.getWeaponDamage() + " DMG" +
                            "\nEt il a une armure de : " + tempHealer.getPointArmor() + " DEF\n");
                    heros.add(tempHealer);
                    break;
                default:
                    System.out.println("C'est pas un type de héros ça, recommence");
                    i -= 1;//on recommence l'itérarion de la boucle.
            }
        }

        //On affiche la liste de tous les héros avec leur caracactéristique
        for (int i = 0; i < heros.size(); i++)
        {
            System.out.println(heros.get(i).getName() + " : " + heros.get(i).getHealthPoint() + " HP  ,  " + heros.get(i).getWeaponDamage() + " DMG  ,  " + (heros.get(i).getPointArmor()) + " ARMOR");
        }

        //Liste de tous les niveaux
        allEnemies = new ArrayList<>();

        //Niveau 1
        Level1 = new ArrayList<>();
        Level1.add(new Bouftou("noir", 50));
        Level1.add(new Bouftou("royal", 80));

        //Niveau 2
        Level2 = new ArrayList<>();
        Level2.add(new Sorciere("Mafalda", 60));
        Level2.add(new Sorciere("Malcombeix", 60));
        Level2.add(new Sorciere("Ursula", 80));

        //Niveau 3
        Level3 = new ArrayList<>();
        Level3.add(new Dragon("Vaghar", (100)));

        //Niveau 4
        Level4 = new ArrayList<>();
        Level4.add(new Dragon("Reghar", 150));
        Level4.add(new Dragon("Thomhar", 250));
        Level4.add(new Bouftou("royal", 110));
        Level4.add(new Sorciere("Karaba", 90));

        //Niveau du boss
        LevelBoss = new ArrayList<>();
        LevelBoss.add(new Boss("Darkseid", 300));

        //On ajoute tous les niveaux dans la liste
        allEnemies.add(Level1);
        allEnemies.add(Level2);
        allEnemies.add(Level3);
        allEnemies.add(Level4);
        allEnemies.add(LevelBoss);
    }

    public void start() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        /*
        // Musique au début du jeu
        File mp3File = new File(File mp3File = new File("Opening-Credits-Game-of-Thrones-Season-8-HBO.wav");
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(mp3File);

        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
        clip.loop(Clip.LOOP_CONTINUOUSLY);");
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(mp3File);

        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
        clip.loop(Clip.LOOP_CONTINUOUSLY);*/

        int ixHero = 0;
        for (int i =0; i < allEnemies.size(); i++)
        {
            enemies = allEnemies.get(i);
            displayMessage(
                    "\\\\\\\\-----------------------------------------------////////\n" +
                    "                Nouveau niveau ! Préparez vous !                \n" +
                    "\\\\\\\\-----------------------------------------------////////");
            for (Enemy enemy : enemies)
            {
                System.out.println(enemy.getName() + " : " + enemy.getHealthPoint() + " HP ,  " + enemy.getDamagePoints() + " DMG");
            }

            // Boucle de jeu
            while (true)
            {
                displayStatus(heros, enemies);
                displayMessage(
                        "\\\\\\\\-----------------------------------------------////////\n" +
                        "                 Héros, Quel est votre métier?                 \n" +
                        "\\\\\\\\-----------------------------------------------////////");
                for (int a = 0; a < heros.size(); a++)
                {
                    if (enemies.size() == 0) //On checke si il y a encore des ennemis
                    {
                        break;
                    }
                    displayStatus(heros, enemies);
                    displayMessage("A toi de jouer " + heros.get(a).getName() + " \n ///////////////////");
                    actionChoice(heros.get(a));

                    if (enemies.size() == 0) // On check si il y a encore des ennemis
                    {
                        break;
                    }

                    for(int b = 0; b < enemies.size(); b++) // On parcourt la liste des ennemis pour voir leur statut
                    {
                        if (enemies.get(b).getHealthPoint() <= 0) // Si un ennemi meurt on l'indique
                        {
                            displayMessage(enemies.get(b).getName()+ " est mort !");
                            enemies.remove(b);
                            waitUser();
                        }
                    }

                }
                displayMessage(
                        "\\\\\\\\-----------------------------------------------////////\n" +
                        "        La noirceure arrive, les ennemis se regroupent         \n" +
                        "\\\\\\\\-----------------------------------------------////////");
                if (enemies.size() != 0)
                {
                    for (Enemy lemal: enemies)
                    {
                        displayStatus(heros, enemies);
                        displayMessage("Attention, " + lemal.getName() + " va attaquer \n ///////////////");
                        int randomTarget = ThreadLocalRandom.current().nextInt(0, heros.size());
                        lemal.fight(heros.get(randomTarget));
                        if (heros.get(randomTarget).getHealthPoint() <= 0) // Si un héros meurt on l'indique
                        {
                            displayMessage
                                    ("Le pauvre " + heros.get(randomTarget).getName() + " a été vaincu...");
                            heros.remove(randomTarget);
                            waitUser();
                        }
                        waitUser();
                    }

                    // A chaque fin de tour on soigne un peu les héros pour leur laisser une chance de gagner
                    for (int h = 0; h < heros.size(); h++)
                    {
                        Food soin = new Food("soin", 20);
                        heros.get(h).eatConsumable(soin);
                        //heros.get(h).setIfInDefense(false);
                    }
                    displayMessage(
                            "\\\\\\\\-----------------------------------------------////////\n" +
                            "          Fin du tour, un peu de soin ça fait pas de mal       \n" +
                            "            Tous les héros gagnent 20 points de vie            \n" +
                            "\\\\\\\\-----------------------------------------------////////");
                }

                // Check si il y a encore des héros
                if (heros.size() == 0)
                {
                    displayMessage("Aucun survivant ... Le mal l'emporte !\n");
                    break;
                }
                if (enemies.size() == 0)
                {
                    displayMessage("Les héros ont vaincus ce niveau !!!\n");
                    break;
                }
            }
            if (heros.size() == 0)
            {
                break;
            }

            for (int h = 0; h < heros.size();h++){
                Food soin = new Food("soin", 100);
                heros.get(h).eatConsumable(soin);
            }
            displayMessage(
                    "\\\\\\\\-----------------------------------------------////////\n" +
                    "                    Level " + i + " fini !!                    \n" +
                    "                 Les héros ont repris 100 hp                   \n" +
                    "\\\\\\\\-----------------------------------------------////////");
        }
        displayMessage(
                "\\\\\\\\-----------------------------------------------////////\n" +
                "              Merci d'avoir jouer ! A bientôt !                \n" +
                "\\\\\\\\-----------------------------------------------////////");
    }

    //méthode choix des actions : type d'action en fonction du héro
    public void actionChoice(Hero hero){//cette methode va permettre en bref de traduire le choix de l'utilisateur
        int choice = hero.actionChoice();
        String returnedChoice = hero.actionChoiceSwitch(choice);

        actionMakerChoice(returnedChoice, hero);//l'action va être effectuée dans cette methode
    }

    //méthode qui permet de récupérer le action de choix des actions et de les exécuter
    public Combatant actionMakerChoice(String choice, Hero combatant){
        //déclarations de variables pour provoquer une action
        String enemiesMenu;
        String heroMenu;
        String menuConsumables;
        int nbEnemy = enemies.size();
        int nbHero = heros.size();
        int attackChoice;
        int allyChoice;
        int consumableChoice;

        //Debut du switch  permettant d'effectuer les actions
        switch(choice){
            // attaque du héro
            case "Attack":
                Scanner scan2 = new Scanner (System.in);
                do{
                    enemiesMenu = "";
                    displayMessage("Qui souhaitez vous attaquer ? :");
                    for (int i = 0; i < nbEnemy;i++){
                        enemiesMenu += "["+(i+1)+"] - "+enemies.get(i).getName()+"\n";
                    }
                    displayMessage(enemiesMenu);
                    attackChoice = scan2.nextInt();
                    if (attackChoice < 1 || attackChoice > nbEnemy) {
                        displayMessage("Ennemis selectionnés non existant. Veuillez recommmencer");
                    }
                }while(attackChoice < 1 || attackChoice > nbEnemy);

                tempEnemy = enemies.get((attackChoice-1));//Je prend l'ennemi, je le met dans une variable
                combatant.fight(tempEnemy);//je le frappe
                enemies.set((attackChoice-1), tempEnemy);//puis je le remet dans sa liste.
                break;
            // Défense du héro
            case "Defend":
                combatant.setDefense(true);
                displayMessage(combatant.getName()+" se met en garde!\n");
                break;
            // Jet de sort du Mage
            case "spell":
                int spellChoice;
                Scanner scan3 = new Scanner (System.in);
                do{
                    displayMessage("Quel sort souhaitez vous lancer ? :\n" +
                            "[1] - FireBall \n" +
                            "[2] - Lightning \n" +
                            "[3] - Focus \n" );

                    spellChoice = scan3.nextInt();
                    if (spellChoice < 1 || spellChoice > 4) {
                        displayMessage("Sort selectionné non existant. Veuillez Recommmencez");
                    }
                }while(spellChoice < 1 || spellChoice > 4);

                switch (spellChoice) {
                    case 1:
                        do{
                            enemiesMenu = "";
                            displayMessage("Sur qui souhaitez vous lancer ce sort ? :");
                            for (int i = 0; i < nbEnemy;i++){
                                enemiesMenu += "["+(i+1)+"] - "+enemies.get(i).getName()+"\n";
                            }
                            displayMessage(enemiesMenu);
                            attackChoice = scan3.nextInt();
                            if (attackChoice < 1 || attackChoice > nbEnemy) {
                                displayMessage("Ennemis selectionné non existant. Veuillez Recommmencez");
                            }
                        }while(attackChoice < 1 || attackChoice > nbEnemy);

                        tempEnemy = enemies.get((attackChoice-1));//Je prend l'ennemi, je le met dans une variable
                        ((Mage)combatant).castFireball(tempEnemy);//je lui lance mon sort
                        enemies.set((attackChoice-1), tempEnemy);//puis je le remet dans sa liste.

                        break;
                    case 2:
                        do{
                            enemiesMenu = "";
                            displayMessage("Sur qui souhaitez vous lancer ce sort ? :");
                            for (int i = 0; i < nbEnemy;i++){
                                enemiesMenu += "["+(i+1)+"] - "+enemies.get(i).getName()+"\n";
                            }
                            displayMessage(enemiesMenu);
                            attackChoice = scan3.nextInt();
                            if (attackChoice < 1 || attackChoice > nbEnemy) {
                                displayMessage("Ennemis selectionné non existant. Veuillez Recommmencez");
                            }
                        }while(attackChoice < 1 || attackChoice > nbEnemy);

                        tempEnemy = enemies.get((attackChoice-1));//Je prend l'ennemi, je le met dans une variable
                        ((Mage)combatant).castLightning(tempEnemy);//je lui lance mon sort
                        enemies.set((attackChoice-1), tempEnemy);//puis je le remet dans sa liste.
                        break;
                    case 3:
                        ((Mage)combatant).focus();
                        break;
                    default:
                        displayMessage("Le code a un problème de fonctionnement !");
                }
                break;
            // Jet de sort du Healer
            case "Heal":
                Scanner scan4 = new Scanner (System.in);
                do{
                    heroMenu = "";
                    displayMessage("Qui souhaitez vous soigner ? :");
                    for (int i = 0; i < nbHero;i++){
                        heroMenu += "["+(i+1)+"] - "+heros.get(i).getName()+"\n";
                    }
                    displayMessage(heroMenu);
                    allyChoice = scan4.nextInt();
                    if (allyChoice < 1 || allyChoice > nbHero) {
                        displayMessage("Allie selectionné non existant. Veuillez Recommmencez");
                    }
                }while(allyChoice < 1 || allyChoice > nbHero);
                tempHero = heros.get((allyChoice-1));//Allié dans une variable
                ((Healer)combatant).winHp(tempHero);//Soin de l'allié
                heros.set((allyChoice-1), tempHero);//Allié dans sa liste
                break;
                // Consommation du héro
            case "Consume":
                Scanner sc5 = new Scanner (System.in);
                menuConsumables ="";
                do{
                    displayMessage("Que souhaitez vous consommer ? :");
                    for (int i = 0; i < epicerie.size();i++){
                        menuConsumables += "["+(i+1)+"] - "+epicerie.get(i).so()+"\n";
                    }
                    if (combatant instanceof SpellCaster){
                        for (int i = epicerie.size(); i < (epicerie.size() + pub.size());i++){
                            menuConsumables += "[" + (i+1) + "] - " + pub.get(i-epicerie.size()).so()+"\n";
                        }
                    }
                    displayMessage(menuConsumables);
                    consumableChoice = sc5.nextInt();
                    if (consumableChoice < 1 || consumableChoice > (epicerie.size() + ((combatant instanceof SpellCaster)?pub.size():0))) {
                        displayMessage("Allie selectionné non existant. Veuillez Recommmencez");
                    }
                }while(consumableChoice < 1 || consumableChoice > (epicerie.size() + ((combatant instanceof SpellCaster)?pub.size():0)));

                if (consumableChoice > epicerie.size()){//=On a choisi une potion
                    pub.get(consumableChoice- epicerie.size() -1).grailMana((SpellCaster) combatant);
                }else{
                    epicerie.get(consumableChoice-1).grailFood((Hero) combatant);
                }

                break;

            default:
                displayMessage("Il y'a un problème dans le actionMaker");
        }
        return combatant;//on retourne le combatant pour le remettre ensuite dans sa liste.
    }

    private InputParser inputParser;

    private ArrayList<Weapon> warriorWeaponList;
    private ArrayList<Weapon> hunterWeaponList;
    private ArrayList<Weapon> mageWeaponList;
    private ArrayList<Weapon> healerWeaponList;

    private ArrayList<Food> epicerie;
    private ArrayList<Potion> pub;

    private List<Combatant> heros;
    private List<ArrayList> allEnemies;
    private ArrayList<Enemy> enemies;

    private ArrayList<Enemy> Level1;
    private ArrayList<Enemy> Level2;
    private ArrayList<Enemy> Level3;
    private ArrayList<Enemy> Level4;
    private ArrayList<Enemy> LevelBoss;

    private Hero tempHero;
    private Warrior tempWarrior;
    private Hunter tempHunter;
    private Mage tempMage;
    private Healer tempHealer;

    private Enemy tempEnemy;

    private static void displayStatus(List<Combatant> h, ArrayList<Enemy> e) {
        System.out.println("#########################");
        for (Combatant c: h) {
            System.out.print(c.getName() + "(" + c.getHealthPoint() + ") ");
        }
        System.out.println();
        for (Combatant c: e) {
            System.out.print(c.getName() + "(" + c.getHealthPoint() + ") ");
        }
        System.out.println();
    }

    public static void displayMessage(String message) {
            System.out.println(message);
    }

    private static void waitUser() { // REFAIRE CETTE FONCTION
        System.out.println("PRESS ENTER TO SKIP");
        Scanner scan = new Scanner(System.in);
        String delay = scan.nextLine();
    }
    private int nbHero;
    private String typeHero;
    private String name;
}
