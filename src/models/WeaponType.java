package models;

import functions.Formatter;

public enum WeaponType {
  MELEE(15, 2, StatType.STRENGTH), RANGED(5, 3, StatType.DEXTERITY);

  public final int BASE_DMG, SCALING_DMG;
  public final StatType AFFECTED_BY_STAT;
  public final String DISPLAY_NAME;

  private WeaponType(int baseDamage, int scalingDamage, StatType affectedByStat) {   
    DISPLAY_NAME = Formatter.formatName(name());
    BASE_DMG = baseDamage;
    SCALING_DMG = scalingDamage;
    AFFECTED_BY_STAT = affectedByStat;
  }
}