package validators;

public class TypeValidator {
  public static <T> boolean checarTipo(Object objeto, Class<T> tipo) {
    return tipo.isInstance(objeto);
  }

  public static boolean isString(Object objeto) {
    return checarTipo(objeto, String.class);
  }

  public static boolean isInteger(Object objeto) {
    return checarTipo(objeto, Integer.class);
  }

  public static boolean isLong(Object objeto) {
    return checarTipo(objeto, Long.class);
  }

  public static boolean isFloat(Object objeto) {
    return checarTipo(objeto, Float.class);
  }

  public static boolean isDouble(Object objeto) {
    return checarTipo(objeto, Double.class);
  }

  public static boolean isBoolean(Object objeto) {
    return checarTipo(objeto, Boolean.class);
  }

  public static boolean isChar(Object objeto) {
    return checarTipo(objeto, Character.class);
  }

  public static boolean isByte(Object objeto) {
    return checarTipo(objeto, Byte.class);
  }
}
