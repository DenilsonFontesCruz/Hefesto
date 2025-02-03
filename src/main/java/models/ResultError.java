package models;

import java.util.Objects;

public record ResultError(String message, Integer code) {
  public ResultError(String message, Integer code) {
    this.message = Objects.requireNonNullElse(message, "Erro desconhecido");
    this.code = Objects.requireNonNullElse(code, 500);
  }
}
