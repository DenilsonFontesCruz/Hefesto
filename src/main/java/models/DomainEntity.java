package models;

import java.util.UUID;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Getter
@Setter
public abstract class DomainEntity {

  private UUID id;

  protected DomainEntity(UUID id) {
    this.id = id;
  }

  protected DomainEntity() {
    this.id = UUID.randomUUID();
  }

}
