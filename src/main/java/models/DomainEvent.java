package models;

import java.util.Date;
import java.util.UUID;

public interface DomainEvent {

  public UUID getId();
  public Date getDataCriacao();

  public DTO getDados();
}
