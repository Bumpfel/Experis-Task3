package models.items;

import functions.Formatter;

public interface ItemSlot {
  public double getEffect();
  public String getDisplayName();

  public enum Armour implements ItemSlot {
    HEAD(.8), BODY(1), LEGS(.6);
  
    private double effect;
  
    private Armour(double effect) {
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

  public enum Weapon implements ItemSlot {
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

}
