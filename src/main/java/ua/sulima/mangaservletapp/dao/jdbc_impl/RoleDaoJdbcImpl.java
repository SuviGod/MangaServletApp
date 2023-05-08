package ua.sulima.mangaservletapp.dao.jdbc_impl;

import ua.sulima.mangaservletapp.dao.RoleDao;
import ua.sulima.mangaservletapp.entity.Role;

import java.sql.Connection;
import java.util.Optional;

public class RoleDaoJdbcImpl extends ConnectionDaoJdbcImpl implements RoleDao {
    public RoleDaoJdbcImpl(Connection connection) {
        super(connection);
    }

    @Override
    public Optional<Role> findById(Short id) {
        return Optional.empty();
    }

    @Override
    public Short save(Role entity) {
        return (short)0;
    }

    @Override
    public Optional<Role> findByName(String name) {
        return Optional.empty();
    }
}
