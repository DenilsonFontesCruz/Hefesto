package models;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Data;
import lombok.Setter;


@MappedSuperclass
@Data
public abstract class Model {

  @Id
  private UUID id;
  private LocalDateTime dataCriacao = LocalDateTime.now();
  @Setter
  private LocalDateTime dataAtualizacao;
  @Setter
  private LocalDateTime dataExclusao;

  public void Atualizar() {
    this.dataAtualizacao = LocalDateTime.now();
  }

  public void Excluir() {
    this.dataExclusao = LocalDateTime.now();
  }
}
