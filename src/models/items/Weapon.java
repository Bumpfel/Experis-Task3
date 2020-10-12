package models.items;

import java.util.Map;
import models.StatType;

public class Weapon extends Item {
  public final int DAMAGE;
  public final WeaponType TYPE;
  private final ItemSlot.WeaponSlot WEAPON_SLOT;

  public Weapon(WeaponType type, int itemLevel, String name) {
    checkItemLevel(itemLevel, name);

    DAMAGE = type.BASE_DMG + (itemLevel * type.SCALING_DMG);
    TYPE = type;
    mItemLevel = itemLevel;
    mName = name;
    WEAPON_SLOT = ItemSlot.WeaponSlot.MAIN_HAND;
  }

  @Override
  public Map<StatType, Integer> getStats() {
    return null;
  }
  
  @Override
  public ItemSlot.WeaponSlot getItemSlot() {
    return WEAPON_SLOT;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Item stats for: " + mName);
    builder.append("\nWeapon Type: " + TYPE.DISPLAY_NAME);
    builder.append("\nWeapon Level: " + mItemLevel);
    builder.append("\nDamage: " + DAMAGE);
    return builder.toString();
  }
}

