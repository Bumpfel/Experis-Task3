package models;

import java.util.HashMap;
import java.util.Map;

public enum ArmourType implements ScalingStats {
  CLOTH("Cloth", 10, 0, 1, 3, 5, 0, 1, 2),
  LEATHER("Leather", 20, 1, 3, 0, 8, 1, 2, 0),
  PLATE("Plate", 30, 3, 1, 0, 12, 2, 1, 0);

  public final String NAME;

  private Map<StatType, Integer> mBaseStats = new HashMap<>();
  private Map<StatType, Integer> mStatGains = new HashMap<>();

  private ArmourType(String name, int baseHP, int baseStr, int baseDex, int baseInt, int hpGain, int strGain, int dexGain, int intGain) {
    NAME = name;
    mBaseStats.put(StatType.HEALTH, baseHP);
    mBaseStats.put(StatType.STRENGTH, baseStr);
    mBaseStats.put(StatType.DEXTERITY, baseDex);
    mBaseStats.put(StatType.INTELLIGENCE, baseInt);
    
    mStatGains.put(StatType.HEALTH, hpGain);
    mStatGains.put(StatType.STRENGTH, strGain);
    mStatGains.put(StatType.DEXTERITY, dexGain);
    mStatGains.put(StatType.INTELLIGENCE, intGain);
  }

  public Map<StatType, Integer> getBaseStats() {
    return Map.copyOf(mBaseStats);
  }

  public Map<StatType, Integer> getStatGains() {
    return Map.copyOf(mStatGains);
  }
}
