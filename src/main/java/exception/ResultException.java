package exception;

import models.ResultError;

public class ResultException extends RuntimeException {
  public ResultException(ResultError error) {
    super(error.message() +  "-StatusCode-" + error.code());
  }

  public ResultException(String message, Integer code ) {
    super(message + "-StatusCode-" + code);
  }

}
