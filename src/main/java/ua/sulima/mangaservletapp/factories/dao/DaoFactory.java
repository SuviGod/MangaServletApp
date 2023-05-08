package ua.sulima.mangaservletapp.factories.dao;

import ua.sulima.mangaservletapp.dao.CreatorDao;
import ua.sulima.mangaservletapp.dao.MangaDao;
import ua.sulima.mangaservletapp.dao.UserDao;
import ua.sulima.mangaservletapp.factories.connection.ConnectionFactory;

import javax.persistence.Persistence;

public abstract class DaoFactory {

    private static volatile DaoFactory daoFactory;

    public static DaoFactory getJdbcInstance() {
        if (daoFactory == null) {
            synchronized (DaoFactory.class) {
                if (daoFactory == null) {
                    DaoFactory daoFact = new JdbcDaoFactory(ConnectionFactory.getHikariInstance());
                    daoFactory = daoFact;
                }
            }
        }
        return daoFactory;
    }

    public static DaoFactory getJPAInstance() {
        if (daoFactory == null) {
            synchronized (DaoFactory.class) {
                if (daoFactory == null) {
                    DaoFactory df = new JpaDaoFactory(Persistence.createEntityManagerFactory(
                            "MangaServletAppPersistenceUnit"));
                    daoFactory = df;
                }
            }
        }
        return daoFactory;
    }

    public abstract UserDao getUserDao();

    public abstract MangaDao getMangaDao();

    public abstract CreatorDao getCreatorDao();
}
