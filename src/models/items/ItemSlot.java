package models.items;

import functions.Formatter;

public interface ItemSlot {
  public double getSlotWeight();
  public String getDisplayName();

  public enum ArmourSlot implements ItemSlot {
    HEAD(.8), BODY(1), LEGS(.6);
  
    private final double SLOT_WEIGHT; // the multiplicative impact this item will have on the character stats
  
    private ArmourSlot(double effect) {
      this.SLOT_WEIGHT = effect;
    }
    
    @Override
    public double getSlotWeight() {
      return SLOT_WEIGHT;
    }
    
    @Override
    public String getDisplayName() {
      return Formatter.formatName(name());
    }
  }

  public enum WeaponSlot implements ItemSlot {
    MAIN_HAND;
  
    @Override
    public double getSlotWeight() {
      return 1;
    }
  
    @Override
    public String getDisplayName() {
      return Formatter.formatName(name());
    }
  }

}
