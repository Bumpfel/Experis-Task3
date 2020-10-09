package models;

public enum WeaponType {
  MELEE(15, 2, StatType.STRENGTH), RANGED(5, 3, StatType.DEXTERITY);

  public final int BASE_DMG, SCALING_DMG;
  public final StatType AFFECTED_BY_STAT;

  private WeaponType(int baseDamage, int scalingDamage, StatType affectedByStat) {
    BASE_DMG = baseDamage;
    SCALING_DMG = scalingDamage;
    AFFECTED_BY_STAT = affectedByStat;
  }
}