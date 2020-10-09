package models;

public enum ItemSlot {
  HEAD("Head", .8), BODY("Body", 1.0), LEGS("Legs", .6), WEAPON("Weapon", null);

  public final Double EFFECT;
  public final String NAME;

  private ItemSlot(String name, Double effect) {
    NAME = name;
    EFFECT = effect;
  }
}
