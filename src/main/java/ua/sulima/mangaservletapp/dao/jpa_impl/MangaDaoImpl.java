package ua.sulima.mangaservletapp.dao.jpa_impl;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ua.sulima.mangaservletapp.dao.MangaDao;
import ua.sulima.mangaservletapp.entity.Manga;

import javax.persistence.EntityManager;
import java.util.Optional;
@RequiredArgsConstructor
@Getter @Slf4j
public class MangaDaoImpl implements MangaDao {
    private final EntityManager em;
    @Override
    public Optional<Manga> findById(Integer integer) {
        Optional<Manga> manga = Optional.ofNullable(em.find(Manga.class, integer));
        return manga;
    }

    @Override
    public Integer save(Manga entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        return entity.getId();
    }
}
