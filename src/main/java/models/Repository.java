package models;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface Repository<E extends DomainEntity> {
  E add(final E entity);

  List<E> addMany(final List<E> entityList);

  E update(final E entity);

  List<E> updateMany(final List<E> entityList);

  Optional<E> findById(final UUID id);

  List<E> findAll();
}
