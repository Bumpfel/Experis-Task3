package models;

import java.util.Map;

import models.exceptions.ItemCreationErrorException;

public abstract class Item {
  public final int MAX_LEVEL = 100;

  protected ItemSlot itemSlot;
  protected String mName;
  protected int mItemLevel;

  public abstract Map<StatType, Integer> getStats();
  
  public int getItemLevel() {
    return mItemLevel;
  }
  
  public ItemSlot getItemSlot() {
    return itemSlot;
  }

  protected void checkItemLevel(int itemLevel, String name) {
    if(itemLevel <= 0 || itemLevel > MAX_LEVEL) {
      throw new ItemCreationErrorException("\"" + name + "\" cannot be created. Item level must be between 1 and " + MAX_LEVEL);
    }
  }

  public String getName() {
    return mName;
  }
}
