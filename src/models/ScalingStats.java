package models;

import java.util.Map;

public interface ScalingStats { // TODO inte jättestor mening med denna
  public Map<StatType, Integer> getBaseStats();
  public Map<StatType, Integer> getStatGains();
}
