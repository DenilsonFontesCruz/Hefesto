package models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.Getter;

@Getter
public class AggregateRoot extends DomainEntity {

  private final List<DomainEvent> domainEvents = new ArrayList<DomainEvent>();

  protected AggregateRoot(UUID id) {
    super(id);
  }

  public void adicionarDomainEvent(DomainEvent event) {
    this.domainEvents.add(event);
  }

  public void removerDomainEvent(DomainEvent event) {
    this.domainEvents.remove(event);
  }

  public void limparDomainEvents() {
    this.domainEvents.clear();
  }

}
