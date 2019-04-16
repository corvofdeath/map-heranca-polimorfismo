package services;

import entities.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BaseService<T extends Entity> implements IService<T> {

    private final List<T> repository;

    public BaseService() {
        this.repository = new ArrayList<>();
    }

    @Override
    public T save(T entity) {

        entity.setId(UUID.randomUUID());
        this.repository.add(entity);

        return entity;
    }

    @Override
    public List<T> getAll() {
        return this.repository;
    }

    @Override
    public T getById(UUID id) {

        for (T entity : this.repository) {
            if (entity.getId().equals(id))
                return entity;
        }

        return null;
    }
}
