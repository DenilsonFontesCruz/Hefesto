package models;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Objects;
import javax.management.OperationsException;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
public class Result<T> {

  private final boolean isSucesso;
  private final boolean isFalha;
  private final T valor;
  private final ResultError error;

  protected Result(boolean isSucesso, T valor, ResultError error) throws OperationsException {
    if (isSucesso && Objects.nonNull(error)) {
      throw new OperationsException();
    }
    if (!isSucesso && Objects.isNull(error)) {
      throw new OperationsException();
    }

    this.isSucesso = isSucesso;
    this.isFalha = !isSucesso;
    this.error = error;
    this.valor = valor;
  }

  public T getValor() throws OperationsException {
    if (this.isFalha && Objects.isNull(this.valor)) {
      throw new OperationsException();
    }
    return this.valor;
  }

  public static <K> Result<K> falha(String erroMensagem, Integer erroCodigo) {
    try {
      return new Result<>(false, null, new ResultError(erroMensagem, erroCodigo));
    } catch (OperationsException e) {
      throw new RuntimeException(e);
    }
  }

  public static <K> Result<K> falha(ResultError error) {
    try {
      return new Result<>(false, null, error);
    } catch (OperationsException e) {
      throw new RuntimeException(e);
    }
  }

  public static <K> Result<K> sucesso() {
    try {
      return new Result<>(true, null, null);
    } catch (OperationsException e) {
      throw new RuntimeException(e);
    }
  }

  public static <K> Result<K> sucesso(K valor) {
    try {
      return new Result<>(true, valor, null);
    } catch (OperationsException e) {
      throw new RuntimeException(e);
    }
  }

  public String toString() {
    if (this.isSucesso) {
      return "Result(sucesso=" + this.isSucesso + ", valor=" + this.valor + ")";
    }
    return "Result(falha=" + this.isFalha + ", error=" + this.error.toString() + ")";
  }

  @EqualsAndHashCode
  public abstract static class ValueObject {

  }
}

