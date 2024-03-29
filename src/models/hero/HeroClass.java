package models.hero;

import java.util.HashMap;
import java.util.Map;

import functions.Formatter;
import models.StatType;

public enum HeroClass {
  WARRIOR(150, 10, 3, 1, 30, 5, 2, 1),
  RANGER(120, 5, 10, 2, 30, 5, 2, 1),
  MAGE(100, 2, 3, 10, 15, 1, 2, 5);

  public final String DISPLAY_NAME;
  private Map<StatType, Integer> mBaseStats = new HashMap<>();
  private Map<StatType, Integer> mStatGains = new HashMap<>();

  private HeroClass(int baseHP, int baseStr, int baseDex, int baseInt, int hpGain, int strGain, int dexGain, int intGain) {
    DISPLAY_NAME = Formatter.formatName(name());

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
