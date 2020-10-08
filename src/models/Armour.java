package models;

import java.util.HashMap;
import java.util.Map;

public class Armour extends Item {
  public final ArmourType TYPE;
  public final ItemSlot ITEM_SLOT;
  private Map<StatType, Integer> mStats = new HashMap<>();

  public Armour(ArmourType type, ItemSlot itemSlot, int itemLevel, String name) {
    TYPE = type;
    ITEM_SLOT = itemSlot;
    mItemLevel = itemLevel;
    var baseStats = type.getBaseStats();
    var statGains = type.getStatGains();
    for(StatType stat : StatType.values()) {
      mStats.put(stat, baseStats.get(stat) + (statGains.get(stat) * itemLevel));
    }
      
    mName = name;
  }

  @Override
  public Map<StatType, Integer> getStats() {
    return Map.copyOf(mStats);
  }

  @Override
  public ItemSlot getItemSlot() {
    return ITEM_SLOT;
  }

  @Override
  public String toString() {
    var baseStats = TYPE.getBaseStats();
    var statGains = TYPE.getStatGains();
    StringBuilder builder = new StringBuilder();
    builder.append("Item stats for: " + mName + "\n");
    builder.append("Armour Type: " + TYPE.NAME + "\n");
    builder.append("Slot: " + ITEM_SLOT.NAME + "\n");
    builder.append("Item level: " + mItemLevel + "\n");
    for(StatType stat : StatType.values()) {
      builder.append("Bonus " + stat.NAME + ": " + (baseStats.get(stat) + statGains.get(stat) * mItemLevel) + "\n");
    }
    
    return builder.toString();
  }
}
