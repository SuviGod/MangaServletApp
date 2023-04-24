package ua.sulima.mangaservletapp.dao.jpa_impl;

import lombok.RequiredArgsConstructor;
import ua.sulima.mangaservletapp.dao.CreatorDao;
import ua.sulima.mangaservletapp.entity.Creator;

import javax.persistence.EntityManager;
import java.util.Optional;

@RequiredArgsConstructor
public class CreatorDaoImpl implements CreatorDao {
    private final EntityManager em;
    @Override
    public Optional<Creator> findById(Integer integer) {

        return Optional.ofNullable(em.find(Creator.class, integer));
    }

    @Override
    public Integer save(Creator entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        return entity.getId();
    }
}
