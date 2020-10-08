package models;

public enum WeaponType {
  MELEE(15, 2, DamageType.MELEE), RANGED(5, 3, DamageType.RANGED);

  public final int BASE_DMG, SCALING_DMG;
  public final DamageType DAMAGE_TYPE;

  private WeaponType(int baseDamage, int scalingDamage, DamageType damageType) {
    BASE_DMG = baseDamage;
    SCALING_DMG = scalingDamage;
    DAMAGE_TYPE = damageType;
  }
}