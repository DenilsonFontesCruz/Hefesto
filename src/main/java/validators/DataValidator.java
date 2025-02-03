package validators;

import constantes.ConstantesRegex;

public class DataValidator {
  public static boolean isEmail(String email) {
    return email.matches(ConstantesRegex.REGEX_EMAIL);
  }

  public static boolean isTelefone(String telefone) {
    return telefone.matches(ConstantesRegex.REGEX_TELEFONE);
  }

  public static boolean isCpf(String cpf) {
    if(!cpf.matches(ConstantesRegex.REGEX_CPF)) {
      return false;
    }

    String cpfNumerico = cpf.replaceAll("[^0-9]", "");

    if(cpfNumerico.length() != 11) {
      return false;
    }

    try {
      int digito1 = calcularDigitoVerificador(cpfNumerico.substring(0, 9), 10);
      int digito2 = calcularDigitoVerificador(cpfNumerico.substring(0, 9) + digito1, 11);

      return cpfNumerico.equals(cpfNumerico.substring(0, 9) + digito1 + digito2);
    } catch (Exception e) {
      return false;
    }
  }

  public static boolean isCnpj(String cnpj) {
    if(!cnpj.matches(ConstantesRegex.REGEX_CNPJ)) {
      return false;
    }

    String cnpjNumerico = cnpj.replaceAll("[^0-9]", "");

    if(cnpjNumerico.length() != 14) {
      return false;
    }

    try {
      int digito1 = calcularDigitoVerificador(cnpjNumerico.substring(0, 12), 5);
      int digito2 = calcularDigitoVerificador(cnpjNumerico.substring(0, 12) + digito1, 6);

      return cnpjNumerico.equals(cnpjNumerico.substring(0, 12) + digito1 + digito2);
    } catch (Exception e) {
      return false;
    }
  }

  private static int calcularDigitoVerificador(String parte, int pesoInicial) {
    int soma = 0;
    int peso = pesoInicial;

    boolean isCnpj = parte.length() > 11;

    for (int i = 0; i < parte.length(); i++) {
      int digito = Character.getNumericValue(parte.charAt(i));
      soma += digito * peso;

      if (isCnpj) {
        peso = (peso == 2) ? 9 : peso - 1; // CNPJ: Reseta para 9 após chegar em 2
      } else {
        peso--;
      }
    }

    int resto = soma % 11;
    return (resto < 2) ? 0 : (11 - resto);
  }
}
