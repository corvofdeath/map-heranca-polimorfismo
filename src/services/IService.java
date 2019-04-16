package services;

import entities.Entity;

import java.util.List;
import java.util.UUID;

public interface IService<T extends Entity> {

    T save(T entity);
    List<T> getAll();
    T getById(UUID id);
}
