package models;

public enum StatType {
  HEALTH("HP", 0, null), STRENGTH("Str", 1.5, DamageType.MELEE), DEXTERITY("Dex", 2, DamageType.RANGED), INTELLIGENCE("Int", 5, DamageType.SPELL);

  public final double DMG_MULTIPLIER;
  public final DamageType AFFECTS_DMG_TYPE;
  public final String NAME;
  
  private StatType(String name, double damageMultiplier, DamageType affectsDamageType) {
    NAME = name;
    DMG_MULTIPLIER = damageMultiplier;
    AFFECTS_DMG_TYPE = affectsDamageType;
  }
}