package models.exceptions;

public class EquipItemErrorException extends RuntimeException {
  private static final long serialVersionUID = 2L;

  public EquipItemErrorException(String msg) {
    super(msg);
  }
}
