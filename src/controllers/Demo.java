package controllers;

import models.*;
import models.exceptions.EquipItemErrorException;

public class Demo implements IGameController {
  private Hero warrior, ranger, mage;
  private Item greatAxe, woodenSword, bow, plateHelmet, clothRobe, leatherLeggings, leatherCap;

  public Demo() {
    createHeroes();
    createItems();
  }

  public void run() {
    var someItem = new Armour(ArmourType.CLOTH, ItemSlot.Armour.BODY, 1, "bad item");
    warrior.equipItem(someItem);
    warrior.dealDamage();
    
    // demoLevelUp();
    // demoItems();
    // demoEquipItems();
    demoChangeEquipment();
    // demoDealDamage();
  }

  private void createHeroes() {
    warrior = new Hero(HeroClass.WARRIOR);
    ranger = new Hero(HeroClass.RANGER);
    mage = new Hero(HeroClass.MAGE);
  }

  private void createItems() {
    greatAxe = new Weapon(WeaponType.MELEE, 60, "Great Axe of the Gladiator");
    woodenSword = new Weapon(WeaponType.MELEE, 1, "Wooden Sword of the Apprentice");
    bow = new Weapon(WeaponType.RANGED, 17, "Long Bow of the Huntard");

    plateHelmet = new Armour(ArmourType.PLATE, ItemSlot.Armour.HEAD, 1, "Plate Helmet of the Apprentice");
    leatherCap = new Armour(ArmourType.LEATHER, ItemSlot.Armour.HEAD, 1, "Leather Cap of the Apprentice");
    clothRobe = new Armour(ArmourType.CLOTH, ItemSlot.Armour.BODY, 45, "Cloth Robe of the Acolyte");
    leatherLeggings = new Armour(ArmourType.LEATHER, ItemSlot.Armour.LEGS, 27, "Leather Leggings of the Beast");
  }
 
  private void demoLevelUp() {
    createHeroes();
    
    int xp1 = 567, xp2 = 9001;
    System.out.println(mage);
    System.out.println("------");
    System.out.println("mage gained " + mage.gainXP(xp1) + " levels from " + xp1 + " xp");
    System.out.println("------");
    System.out.println(mage);
    
    System.out.println("------");
    System.out.println("mage gained " + mage.gainXP(xp2) + " levels from " + xp2 + " xp");    
    System.out.println("------");
    System.out.println(mage);
    
    System.out.println("\n------\n");

    System.out.println(ranger);
    System.out.println("------");
    System.out.println("mage gained " + mage.gainXP(xp1) + " levels from " + xp1 + " xp");
    System.out.println("------");
    System.out.println(ranger);
    
  }

  private void demoItems() {  
    System.out.println(clothRobe);
    System.out.println("------");
    System.out.println(leatherLeggings);
    System.out.println("------");
    System.out.println(plateHelmet);
  }
  
  private void demoEquipItems() {
    createHeroes();
    
    try {
      System.out.println(warrior);
      warrior.equipItem(plateHelmet);
      System.out.println("------");
      System.out.println(plateHelmet);
      System.out.println("------");
      System.out.println(warrior);
      
      System.out.println("\n------\n");
      
      ranger.gainXP(20000);
      System.out.println(ranger);
      ranger.equipItem(leatherLeggings);
      System.out.println("------");
      System.out.println(ranger);
      ranger.equipItem(clothRobe);
    } catch(EquipItemErrorException e) {
      System.out.println(e.getMessage());
    }
  }

  private void demoChangeEquipment() {
    createHeroes();

    System.out.println(warrior);   
    warrior.equipItem(plateHelmet);
    System.out.println("\n-- Equipped --");
    System.out.println(plateHelmet);
    
    System.out.println("------");
    System.out.println(warrior);

    warrior.equipItem(leatherCap);
    System.out.println("\n-- Equipped --");
    System.out.println(leatherCap);
    System.out.println("------");
    
    System.out.println(warrior);    
  }
  
  private void demoDealDamage() {
    createHeroes();

    System.out.println("Attacking for " + warrior.dealDamage());
    warrior.equipItem(woodenSword);
    System.out.println("------");
    System.out.println("Attacking for " + warrior.dealDamage());
    warrior.gainXP(500000);
    warrior.equipItem(greatAxe);
    System.out.println("------");
    System.out.println("Attacking for " + warrior.dealDamage());
  }
}
