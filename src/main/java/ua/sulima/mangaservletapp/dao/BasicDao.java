package ua.sulima.mangaservletapp.dao;

import lombok.Getter;

import java.util.Optional;

public interface BasicDao <EntityType, ID> {

    Optional<EntityType> findById(ID id);

    ID save(EntityType entity);
}
