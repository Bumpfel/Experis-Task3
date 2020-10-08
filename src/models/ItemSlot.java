package models;

public enum ItemSlot {
  HEAD("Head", .8), BODY("Body", 1), LEGS("Legs", .6), WEAPON("Weapon", 0);

  public final double EFFECT;
  public final String NAME;

  private ItemSlot(String name, double effect) {
    NAME = name;
    EFFECT = effect;
  }
}
