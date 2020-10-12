package models.items;

import java.util.HashMap;
import java.util.Map;

import models.StatType;

public class Armour extends Item {
  public final ArmourType TYPE;
  private final ItemSlot.ArmourSlot ARMOUR_SLOT;
  private Map<StatType, Integer> mStats = new HashMap<>();

  public Armour(ArmourType type, ItemSlot.ArmourSlot armourSlot, int itemLevel, String name) {
    checkItemLevel(itemLevel, name);

    TYPE = type;
    ARMOUR_SLOT = armourSlot;
    mItemLevel = itemLevel;

    // (base stats + (iLvl * statgain)) * slot weight
    var baseStats = type.getBaseStats();
    var statGains = type.getStatGains();
    for(StatType stat : StatType.values()) {
      int value = (int) ((baseStats.get(stat) + (statGains.get(stat) * itemLevel)) * armourSlot.getSlotWeight());
      mStats.put(stat, value);
    }
    
    mName = name;
  }

  @Override
  public ItemSlot getItemSlot() {
    return ARMOUR_SLOT;
  }

  @Override
  public Map<StatType, Integer> getStats() {
    return Map.copyOf(mStats); // returns a copy to prevent user modifying original
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Item stats for: " + mName);
    builder.append("\nArmour Type: " + TYPE.DISPLAY_NAME);
    builder.append("\nSlot: " + ARMOUR_SLOT.getDisplayName());
    builder.append("\nItem level: " + mItemLevel);
    for(StatType stat : StatType.values()) {
      builder.append("\nBonus " + stat.DISPLAY_NAME + ": " + mStats.get(stat));
    }
    
    return builder.toString();
  }
}
