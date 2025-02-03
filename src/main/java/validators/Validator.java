package validators;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Getter;
import models.Result;

public class Validator {

  private final List<ValidatorItem> items = new ArrayList<>();
  private final List<String> itemsFalhos = new ArrayList<>();


  public Validator addItem(String nome, Object object, ValidatorParameters... parametros) {
    this.items.add(new ValidatorItem(nome, object, List.of(parametros)));
    return this;
  }

  public Result<Void> validar() {
    for (ValidatorItem item : items) {
      ValidatorResult resultado = item.validar();
      if (!resultado.isSucesso()) {
        itemsFalhos.add(resultado.getMensagem());
      }
    }
    if (!itemsFalhos.isEmpty()) {
      return Result.falha(String.join(";\n", itemsFalhos), 400);
    }

    return Result.sucesso();
  }

  private record ValidatorItem(String nome, Object object, List<ValidatorParameters> parametros) {

    public ValidatorResult validar() {
      for (ValidatorParameters parametro : parametros) {
        switch (parametro) {
          case NOT_NULL:
            if (Objects.isNull(object)) {
              return new ValidatorResult(false, nome + " não pode ser nulo");
            }
            break;
          case NOT_EMPTY:
            if (!TypeValidator.isString(object)) {
              throw new UnsupportedOperationException("Tipo de dado não suportado");
            }
            if (((String) object).isEmpty()) {
              return new ValidatorResult(false, nome + " não pode ser vazio");
            }
            break;
          case EMAIL:
            if (!TypeValidator.isString(object)) {
              throw new UnsupportedOperationException("Tipo de dado não suportado");
            }
            if (!DataValidator.isEmail((String) object)) {
              return new ValidatorResult(false, nome + " não é um email válido");
            }
            break;
          case CPF:
            if (!TypeValidator.isString(object)) {
              throw new UnsupportedOperationException("Tipo de dado não suportado");
            }
            if (DataValidator.isCpf((String) object)) {
              return new ValidatorResult(false, nome + " não é um CPF válido");
            }
            break;
          case CNPJ:
            if (!TypeValidator.isString(object)) {
              throw new UnsupportedOperationException("Tipo de dado não suportado");
            }
            if (!DataValidator.isCnpj((String) object)) {
              return new ValidatorResult(false, nome + " não é um CNPJ válido");
            }
            break;
          case PHONE:
            if (!TypeValidator.isString(object)) {
              return new ValidatorResult(false, nome + " não é um CNPJ válido");
            }
            if (!DataValidator.isTelefone((String) object)) {
              return new ValidatorResult(false, nome + " não é um telefone válido");
            }
            break;
          default:
            break;
        }
      }

      return new ValidatorResult(true);
    }
  }

  @Getter
  private static class ValidatorResult {

    private final boolean sucesso;
    private String mensagem;

    public ValidatorResult(boolean sucesso, String mensagem) {
      this.sucesso = sucesso;
      this.mensagem = mensagem;
    }

    public ValidatorResult(boolean sucesso) {
      this.sucesso = sucesso;
    }
  }

}
