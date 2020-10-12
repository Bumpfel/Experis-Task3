package models.items;

import java.util.Map;

import models.StatType;
import models.exceptions.ItemCreationErrorException;

public abstract class Item {
  public final int MAX_LEVEL = 100; // should probably be decided by the game controller
  
  protected String mName;
  protected int mItemLevel;
  
  public abstract Map<StatType, Integer> getStats();
  public abstract ItemSlot getItemSlot();
    
  public int getItemLevel() {
    return mItemLevel;
  }

  public String getName() {
    return mName;
  }

  protected void checkItemLevel(int itemLevel, String name) throws ItemCreationErrorException {
    if(itemLevel <= 0 || itemLevel > MAX_LEVEL) {
      throw new ItemCreationErrorException("\"" + name + "\" cannot be created. Item level must be between 1 and " + MAX_LEVEL);
    }
  }
}
