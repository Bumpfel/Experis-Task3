package models;

import java.util.Map;

import models.exceptions.ItemCreationErrorException;

public abstract class Item {
  public final int MAX_LEVEL = 100;
  
  protected String mName;
  protected int mItemLevel;
  
  public abstract Map<StatType, Integer> getStats();
  public abstract ItemSlot getItemSlot();
  
  private String[] intervalNames = new String[] { "Apprentice", "Acolyte", "Beast", "Gladiator" };
  
  public int getItemLevel() {
    return mItemLevel;
  }

  protected void checkItemLevel(int itemLevel, String name) throws ItemCreationErrorException {
    if(itemLevel <= 0 || itemLevel > MAX_LEVEL) {
      throw new ItemCreationErrorException("\"" + name + "\" cannot be created. Item level must be between 1 and " + MAX_LEVEL);
    }
  }

  public String getName() {
    return mName;
  }

  public String getGeneratedName() {
    String str = "";

    return str;
  }
}
