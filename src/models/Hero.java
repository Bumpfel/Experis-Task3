package models;
import java.util.HashMap;
import java.util.Map;

public class Hero {
  private static final int BASE_XP_TO_LEVEL = 100;
  private static final double XP_LEVELUP_FACTOR = 1.1;

  public final HeroClass HERO_CLASS;
  private int mLevel = 1, mOverlappingXP, mXPRequiredForNextLevel = BASE_XP_TO_LEVEL;

  private Map<StatType, Integer> mHeroStats = new HashMap<>();
  private Map<StatType, Integer> mEquippedStatsTotal = new HashMap<>(); // this is technically not needed since all the stats are available in the equipped items. this is however a summary for quicker access, and also preventing a calculation be made every single time these values is accessed
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
      mEquippedStatsTotal.put(type, 0);
    }

    // init equipped items
    for(ItemSlot slot : ItemSlot.values()) {
      mEquippedItems.put(slot, null);
    }
  }

  public void gainXP(int xp) {
    mOverlappingXP += xp;
    int levelsGained = 0;
    
    // one level gained per iteration
    while(mOverlappingXP >= mXPRequiredForNextLevel) {
      mOverlappingXP -= mXPRequiredForNextLevel;
      mXPRequiredForNextLevel *= XP_LEVELUP_FACTOR;
      mLevel ++;
    }

    // update hero stats
    var classGains = HERO_CLASS.getStatGains();
    for(StatType stat : StatType.values()) {
      int currentValue = mHeroStats.get(stat);
      int gain = classGains.get(stat);
      mHeroStats.put(stat, currentValue + gain * levelsGained);
    }
  }


  public boolean equipItem(Item item) {
    if(item.getItemLevel() > mLevel) {
      return false;
    }

    unequipItem(item.getItemSlot());

    var itemStats = item.getStats();
    if(itemStats != null) {
      for(StatType stat : itemStats.keySet()) {
        int current = mEquippedStatsTotal.get(stat);
        mEquippedStatsTotal.put(stat, current + itemStats.get(stat));
      }
    }
    return true;
  }

  private void unequipItem(ItemSlot itemSlot) {
    var oldItem = mEquippedItems.get(itemSlot);
    if(oldItem != null) {
      var oldItemStats = oldItem.getStats();
      if(oldItemStats != null) {
        // subtract stats from old item
        for (StatType stat : oldItemStats.keySet()) {
          int current = mEquippedStatsTotal.get(stat);
          int itemStat = oldItemStats.get(stat);
          mEquippedStatsTotal.put(stat, current - itemStat);
        } 
      }
      mEquippedItems.remove(itemSlot);
    }
 }

  public void dealDamage() {
    // TODO implement
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append(HERO_CLASS.className + " details:\n");
    for(StatType stat : StatType.values()) {
      builder.append(stat.NAME + ": " + (mHeroStats.get(stat) + mEquippedStatsTotal.get(stat)) + "\n");
    }
    builder.append("Level: " + mLevel + "\n");
    builder.append("XP to next: " + mOverlappingXP);
    return builder.toString();
  }
}

