package models.exceptions;

public class ItemCreationErrorException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  public ItemCreationErrorException(String msg) {
    super(msg);
  }
}
