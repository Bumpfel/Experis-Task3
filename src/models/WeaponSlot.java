package models;

import functions.Formatter;

public enum WeaponSlot implements ItemSlot {
  MAIN_HAND;

  @Override
  public double getEffect() {
    return 1;
  }

  @Override
  public String getDisplayName() {
    return Formatter.formatName(name());
  }
}
