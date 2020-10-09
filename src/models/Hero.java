package models;

import java.util.HashMap;
import java.util.Map;
import models.exceptions.EquipItemErrorException;

public class Hero {
  private static final int BASE_XP_TO_LEVEL = 100;
  private static final double XP_LEVELUP_FACTOR = 1.1;

  public final HeroClass HERO_CLASS;
  
  private int mLevel = 1, mOverlappingXP, mXPRequiredForNextLevel = BASE_XP_TO_LEVEL;
  private Map<StatType, Integer> mHeroStats = new HashMap<>();
  private Map<StatType, Integer> mStatsFromItems = new HashMap<>(); // this is technically not needed since all the stats are available in the equipped items. this is however a summary for quicker access, and also preventing a calculation be made every single time these values is accessed
  private Map<ItemSlot, Item> mEquippedItems = new HashMap<>();

  public Hero(HeroClass heroClass) {
    HERO_CLASS = heroClass;
    var baseStats = HERO_CLASS.getBaseStats();

    // set base stats
    for (StatType stat : StatType.values()) {
      mHeroStats.put(stat, baseStats.get(stat));
    }
    
    // init equipped stats
    for (StatType type : StatType.values()) {
      mStatsFromItems.put(type, 0);
    }

    // init equipped items
    for(ItemSlot slot : ItemSlot.Armour.values()) {
      mEquippedItems.put(slot, null);
    }
    for(ItemSlot slot : ItemSlot.Weapon.values()) {
      mEquippedItems.put(slot, null);
    }
  }

  public int getXP() {
    return mOverlappingXP;
  }

  public int getLevel() {
    return mLevel;
  }

  /**
   * 
   * @param xp
   * @return levels gained
   */
  public int gainXP(int xp) {
    mOverlappingXP += xp;
    int levelsGained = 0;
    
    // one level gained per iteration
    while(mOverlappingXP >= mXPRequiredForNextLevel) {
      mOverlappingXP -= mXPRequiredForNextLevel;
      mXPRequiredForNextLevel *= XP_LEVELUP_FACTOR;
      mLevel ++;
      levelsGained ++;
    }

    // update hero stats
    var classGains = HERO_CLASS.getStatGains();
    for(StatType stat : StatType.values()) {
      int currentValue = mHeroStats.get(stat);
      int gain = classGains.get(stat);
      mHeroStats.put(stat, currentValue + gain * levelsGained);
    }
    return levelsGained;
  }


  public boolean equipItem(Item item) throws EquipItemErrorException {
    if(item.getItemLevel() > mLevel) {
      throw new EquipItemErrorException(item.getName() + " could not be equipped. Item level is too high.");
    }

    unequipItem(item.getItemSlot());

    var itemStats = item.getStats();
    if(itemStats != null) {
      for(StatType stat : itemStats.keySet()) {
        int currentValue = mStatsFromItems.get(stat);
        int itemValue = (int) (itemStats.get(stat) * item.getItemSlot().getEffect());
        mStatsFromItems.put(stat, currentValue + itemValue);
      }
    }
    
    mEquippedItems.put(item.getItemSlot(), item);
    return true;
  }

  private void unequipItem(ItemSlot itemSlot) {
    var oldItem = mEquippedItems.get(itemSlot);
    if(oldItem != null) {
      var oldItemStats = oldItem.getStats();
      if(oldItemStats != null) {
        // subtract stats from old item
        for (StatType stat : oldItemStats.keySet()) {
          int currentValue = mStatsFromItems.get(stat);
          int itemValue = (int) (oldItemStats.get(stat) * oldItem.getItemSlot().getEffect());
          mStatsFromItems.put(stat, currentValue - itemValue);
        }
      }
      mEquippedItems.remove(itemSlot);
    }
 }

  public int dealDamage() {
    Weapon weapon = ((Weapon) mEquippedItems.get(ItemSlot.Weapon.MAIN_HAND));
    if(weapon != null) {
      int weaponDmg = weapon.DAMAGE;
      StatType affectedByStat = weapon.TYPE.AFFECTED_BY_STAT;
      int dmgFromStats = (int) ((mHeroStats.get(affectedByStat) + mStatsFromItems.get(affectedByStat)) * affectedByStat.DMG_MULTIPLIER);    
      return weaponDmg + dmgFromStats;
    }
    return 0;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append(HERO_CLASS.DISPLAY_NAME + " details:");
    for(StatType stat : StatType.values()) {
      builder.append("\n" + stat.NAME + ": " + (mHeroStats.get(stat) + mStatsFromItems.get(stat)));
    }
    builder.append("\nLevel: " + mLevel);
    builder.append("\nXP to next: " + mOverlappingXP);
    return builder.toString();
  }
}

