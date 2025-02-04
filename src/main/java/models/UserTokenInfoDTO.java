package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class UserTokenInfoDTO extends DTO {
  public String id;
  public String email;
}
