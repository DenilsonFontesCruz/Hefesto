package constantes;

public class ConstantesRegex {
  public static final String REGEX_EMAIL = "^[\\w.-]+@([\\w-]+\\.)+[\\w-]{2,63}$";
  public static final String REGEX_CPF = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$";
  public static final String REGEX_CNPJ = "^\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}$";
  public static final String REGEX_TELEFONE = "^\\(\\d{2}\\)\\d{4,5}-\\d{4}$";
  public static final String REGEX_CEP = "^\\d{5}-\\d{3}$";
  public static final String REGEX_PLACA = "^([A-Z]{3}-\\d{4}|[A-Z]{3}\\d[A-Z]\\d{2})$";
  public static final String REGEX_DATA = "^\\d{2}/\\d{2}/\\d{4}$";
  public static final String REGEX_HORARIO = "^(?:[01]\\d|2[0-3]):[0-5]\\d$";
  public static final String REGEX_NUMERO = "^\\d+$";
  public static final String REGEX_DECIMAL = "^\\d*[,.]?\\d+$";
  public static final String REGEX_TEXTO = "^[\\p{L}\\s]+$";
  public static final String REGEX_ALFANUMERICO = "^[\\p{L}\\d\\s]+$";
  public static final String REGEX_SENHA = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
  public static final String REGEX_NOME = "^[\\p{L}\\s]{3,}$";
  public static final String REGEX_URL = "^(https?://)?([\\w-]+\\.)+[\\w-]{2,63}(/[\\w-./?%&=]*)?$";
  public static final String REGEX_IP = "^(?:(?:25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\.){3}(?:25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)$";
}
