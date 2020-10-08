package models;

import java.util.Map;

import models.exceptions.ItemCreationErrorException;

public abstract class Item {
  public final int MAX_LEVEL = 100;

  protected String mName;
  protected int mItemLevel;

  public abstract ItemSlot getItemSlot();
  public abstract Map<StatType, Integer> getStats();

  public int getItemLevel() {
    return mItemLevel;
  }

  protected void checkItemLevel(int itemLevel) {
    if(itemLevel <= 0 || itemLevel > MAX_LEVEL) {
      throw new ItemCreationErrorException("Item cannot be created. Item level must be between 1 and " + MAX_LEVEL);
    }
  }
}
