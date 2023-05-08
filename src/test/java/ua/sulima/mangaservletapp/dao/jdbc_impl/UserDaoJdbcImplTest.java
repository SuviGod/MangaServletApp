package ua.sulima.mangaservletapp.dao.jdbc_impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ua.sulima.mangaservletapp.dao.UserDao;
import ua.sulima.mangaservletapp.entity.Role;
import ua.sulima.mangaservletapp.entity.User;
import ua.sulima.mangaservletapp.factories.connection.ConnectionFactory;
import ua.sulima.mangaservletapp.factories.dao.DaoFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class UserDaoJdbcImplTest {

    private ConnectionFactory connectionFactory = ConnectionFactory.getHikariInstance();

    private DaoFactory daoFactory = DaoFactory.getJdbcInstance();

    @Test
    public void testSave1(){
        try(Connection connection = connectionFactory.getConnection()){
            connection.setAutoCommit(false);
            UserDao userDao = daoFactory.getUserDao();

            List<Role> userRoles = new ArrayList<>();
            userRoles.add(Role.builder()
                    .id((short)1)
                    .name("ROLE_USER")
                    .build());
            User newUser = User.builder()
                    .nickname("newUser")
                    .email("newUserEmail")
                    .password("userPassword")
                    .image(null)
                    .updated(new Timestamp(System.currentTimeMillis()))
                    .roles(userRoles)
                    .build();
            Long newUserId = userDao.save(newUser);
            newUser.setId(newUserId);

            Optional<User> foundUser = userDao.findById(newUserId);
            if(foundUser.isPresent()){
                Assertions.assertEquals(newUser.getEmail(), foundUser.get().getEmail());
                Assertions.assertEquals(newUser.getNickname(), foundUser.get().getNickname());
                Assertions.assertEquals(newUser, foundUser.get());
            }else{
                Assertions.assertTrue(false);
            }
            connection.rollback();
            connection.setAutoCommit(true);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
