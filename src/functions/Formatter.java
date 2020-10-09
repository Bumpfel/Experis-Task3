package functions;

public class Formatter {
  public static String formatName(String name) {
    return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
  }
}
