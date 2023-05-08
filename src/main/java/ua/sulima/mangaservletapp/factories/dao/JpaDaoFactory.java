package ua.sulima.mangaservletapp.factories.dao;

import lombok.RequiredArgsConstructor;
import ua.sulima.mangaservletapp.dao.CreatorDao;
import ua.sulima.mangaservletapp.dao.MangaDao;
import ua.sulima.mangaservletapp.dao.UserDao;
import ua.sulima.mangaservletapp.dao.jpa_impl.CreatorDaoImpl;
import ua.sulima.mangaservletapp.dao.jpa_impl.MangaDaoImpl;
import ua.sulima.mangaservletapp.dao.jpa_impl.UserDaoImpl;

import javax.persistence.EntityManagerFactory;

@RequiredArgsConstructor
public class JpaDaoFactory extends DaoFactory{
    private final EntityManagerFactory emf;
    @Override
    public UserDao getUserDao() {
        return new UserDaoImpl(emf.createEntityManager());
    }

    @Override
    public MangaDao getMangaDao() {
        return new MangaDaoImpl(emf.createEntityManager());
    }

    @Override
    public CreatorDao getCreatorDao() {
        return new CreatorDaoImpl(emf.createEntityManager());
    }
}
