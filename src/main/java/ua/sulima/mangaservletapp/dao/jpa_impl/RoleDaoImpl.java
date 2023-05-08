package ua.sulima.mangaservletapp.dao.jpa_impl;

import lombok.RequiredArgsConstructor;
import ua.sulima.mangaservletapp.dao.RoleDao;
import ua.sulima.mangaservletapp.entity.Role;

import javax.persistence.EntityManager;
import java.util.Optional;
@RequiredArgsConstructor
public class RoleDaoImpl implements RoleDao {
    private final EntityManager em;
    @Override
    public Optional<Role> findById(Short aShort) {
        return Optional.empty();
    }

    @Override
    public Short save(Role entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        return entity.getId();
    }

    @Override
    public Optional<Role> findByName(String roleName) {
        Optional<Role> maybeRole = Optional.ofNullable((Role)em.createQuery(
                "SELECT role FROM Role role WHERE role.name = ?1")
                .setParameter(1, roleName)
                .getSingleResult());
        return maybeRole;
    }
}
