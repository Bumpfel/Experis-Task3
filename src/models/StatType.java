package models;

public enum StatType {
  HEALTH("HP", 0), STRENGTH("Str", 1.5), DEXTERITY("Dex", 2), INTELLIGENCE("Int", 5);

  public final double DMG_MULTIPLIER;
  public final String NAME;
  
  private StatType(String name, double damageMultiplier) {
    NAME = name;
    DMG_MULTIPLIER = damageMultiplier;
  }
}