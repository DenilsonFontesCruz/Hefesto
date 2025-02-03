package validators;

import lombok.Getter;

@Getter
public enum ValidatorParameters {
  NOT_NULL("notNull"),
  NOT_EMPTY("notEmpty"),
  EMAIL("email"),
  CPF("cpf"),
  CNPJ("cnpj"),
  PHONE("phone");

  private final String value;

  ValidatorParameters(String value) {
    this.value = value;
  }

}
