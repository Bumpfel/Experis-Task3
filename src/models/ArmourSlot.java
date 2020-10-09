package models;

import functions.Formatter;

public enum ArmourSlot implements ItemSlot {
  HEAD(.8), BODY(1), LEGS(.6);

  private double effect;

  private ArmourSlot(double effect) {
    this.effect = effect;
  }
  
  @Override
  public double getEffect() {
    return effect;
  }
  
  @Override
  public String getDisplayName() {
    return Formatter.formatName(name());
  }
}
