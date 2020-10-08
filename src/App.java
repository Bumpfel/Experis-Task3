import models.Armour;
import models.ArmourType;
import models.Hero;
import models.HeroClass;
import models.ItemSlot;
import models.Weapon;
import models.WeaponType;

public class App {
    public static void main( String[] args ){
        var mage = new Hero(HeroClass.MAGE);
        var warrior = new Hero(HeroClass.WARRIOR);
        
        var axe = new Weapon(WeaponType.MELEE, 1, "Some axe");
        var clothRobe = new Armour(ArmourType.CLOTH, ItemSlot.BODY, 1, "Cloth Robe of the Whale");
        var plateLeggings = new Armour(ArmourType.PLATE, ItemSlot.LEGS, -1, "Plate Leggings of the Gladiator");

        warrior.gainXP(500);
        // System.out.println(warrior);
        // System.out.println("------");
        System.out.println(plateLeggings);
        // System.out.println("------");
        warrior.equipItem(clothRobe);
        // System.out.println(warrior);
        
    }
}
