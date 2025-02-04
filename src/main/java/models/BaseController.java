package models;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BaseController {

  @Autowired
  private HttpServletRequest request;

  public BaseController() {
    super();
  }

  public UserTokenInfoDTO getUsuario() {
    String id = request.getAttribute("UserId")
        .toString();
    String email = request.getAttribute("UserEmail")
        .toString();

    return UserTokenInfoDTO.builder()
        .id(id)
        .email(email)
        .build();
  }

}
