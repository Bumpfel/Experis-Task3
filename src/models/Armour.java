package models;

import java.util.HashMap;
import java.util.Map;

public class Armour extends Item {
  public final ArmourType TYPE;
  private Map<StatType, Integer> mStats = new HashMap<>();

  public Armour(ArmourType type, ItemSlot itemSlot, int itemLevel, String name) {
    checkItemLevel(itemLevel, name);

    TYPE = type;
    this.itemSlot = itemSlot;
    mItemLevel = itemLevel;
    var baseStats = type.getBaseStats();
    var statGains = type.getStatGains();
    for(StatType stat : StatType.values()) {
      int nr = (int) ((baseStats.get(stat) + (statGains.get(stat) * itemLevel)) * itemSlot.EFFECT);
      mStats.put(stat, nr);
    }
    
    mName = name;
  }

  @Override
  public Map<StatType, Integer> getStats() {
    return Map.copyOf(mStats);
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Item stats for: " + mName);
    builder.append("\nArmour Type: " + TYPE.NAME);
    builder.append("\nSlot: " + itemSlot.NAME);
    builder.append("\nItem level: " + mItemLevel);
    for(StatType stat : StatType.values()) {
      builder.append("\nBonus " + stat.NAME + ": " + mStats.get(stat));
    }
    
    return builder.toString();
  }
}
