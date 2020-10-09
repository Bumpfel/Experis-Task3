import models.Armour;
import models.*;

public class App {
  private static Hero warrior, ranger, mage;
  private static Item axe, bow, clothRobe, plateLeggings;

  public static void main(String[] args) {
    warrior = new Hero(HeroClass.WARRIOR);
    ranger = new Hero(HeroClass.RANGER);
    mage = new Hero(HeroClass.MAGE);

    axe = new Weapon(WeaponType.MELEE, 60, "Great Axe of the Gladiator");
    bow = new Weapon(WeaponType.RANGED, 17, "Long Bow of the Huntard");

    plateLeggings = new Armour(ArmourType.PLATE, ItemSlot.LEGS, 1, "Plate Leggings of the Apprentice");
    
    demoLevelUp();
    // demoEquipItems();
    // demoItems();
  }
  
  static void demoItems() {
    System.out.println(new Armour(ArmourType.CLOTH, ItemSlot.BODY, 1, "Cloth Robe of the Acolyte"));
    System.out.println("------");
    System.out.println(new Armour(ArmourType.CLOTH, ItemSlot.BODY, 20, "Cloth Robe of the Fire Wielder"));
    // System.out.println(plateLeggings);
  }
    
  static void demoEquipItems() {
    System.out.println(warrior);
    System.out.println("------");
    System.out.println((warrior.equipItem(plateLeggings) ? "--Equipped" : "--Did not equip") + "\n" + plateLeggings);
    System.out.println("------");
    System.out.println(warrior);
    
  }
  
  static void demoLevelUp() {
    int xp = 567;
    System.out.println(mage);
    System.out.println("------");
    System.out.println("mage gained " + mage.gainXP(xp) + " levels from " + xp + " xp");
    System.out.println("------");
    System.out.println(mage);
    
    System.out.println("\n------\n");

    System.out.println(ranger);
    System.out.println("------");
    System.out.println("ranger gained " + ranger.gainXP(8792) + " levels");
    System.out.println("------");
    System.out.println(ranger);

  }

}
