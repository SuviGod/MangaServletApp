package ua.sulima.mangaservletapp.dao.jpa_impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ua.sulima.mangaservletapp.dao.UserDao;
import ua.sulima.mangaservletapp.entity.User;

import javax.persistence.EntityManager;
import java.util.Optional;

@Slf4j @RequiredArgsConstructor
public class UserDaoImpl implements UserDao {
    private final EntityManager em;
    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(em.find(User.class, id));
    }

    @Override
    public Long save(User entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        return entity.getId();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.ofNullable((User)em.createQuery("SELECT user FROM User user WHERE user.email = ?1")
                .setParameter(1, email)
                .getSingleResult());
    }

}
