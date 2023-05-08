package ua.sulima.mangaservletapp.dao;

import ua.sulima.mangaservletapp.entity.Role;

import java.util.Optional;

public interface RoleDao extends BasicDao<Role, Short> {
    Optional<Role> findByName(String name);
}
