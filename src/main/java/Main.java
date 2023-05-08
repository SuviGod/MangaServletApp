import lombok.extern.slf4j.Slf4j;
import ua.sulima.mangaservletapp.dao.CreatorDao;
import ua.sulima.mangaservletapp.dao.MangaDao;
import ua.sulima.mangaservletapp.dao.UserDao;
import ua.sulima.mangaservletapp.factories.dao.DaoFactory;
import ua.sulima.mangaservletapp.entity.Creator;
import ua.sulima.mangaservletapp.entity.Manga;
import ua.sulima.mangaservletapp.entity.Role;
import ua.sulima.mangaservletapp.entity.User;

import javax.persistence.EntityManager;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
public class Main {
    public static void main(String[] args){

//        DaoFactory daoFactory = DaoFactory.getJdbcInstance();
//        UserDao userDao = daoFactory.getUserDao();
//
//        List<Role> userRoles = new ArrayList<>();
//        userRoles.add(Role.builder()
//                .id((short)1)
//                .name("ROLE_USER")
//                .build());
//        User newUser = User.builder()
//                .nickname("newUser")
//                .email("newUserEmail")
//                .password("userPassword")
//                .image(null)
//                .updated(new Timestamp(System.currentTimeMillis()))
//                .roles(userRoles)
//                .build();
//        Long newUserId = userDao.save(newUser);
//
//        Optional<User> user = userDao.findById(newUserId);
//        if(user.isPresent()){
//            System.out.println(user.get());
//        }else{
//            System.out.println("not present");
//        }
//
//        CreatorDao creatorDao = daoFactory.getCreatorDao();
//        Creator newCreator = Creator.builder()
//                .description("")
//                .name("Ishida Sui")
//                .build();
//        Integer newCreatorId = creatorDao.save(newCreator);
//
//        Optional<Creator> creator = creatorDao.findById(newCreatorId);
//        if(creator.isPresent()){
//            System.out.println(creator.get());
//        }else{
//            System.out.println("not present");
//        }
//
//        MangaDao mangaDao = daoFactory.getMangaDao();
//        Manga newManga = Manga.builder()
//                .mangaName("Tokyo ghoul")
//                .authorId(newCreatorId)
//                .artistId(newCreatorId)
//                .releaseYear((short)2012)
//                .translatorId(newUserId)
//                .previewImagePath("path")
//                .build();
//        Integer newMangaId = mangaDao.save(newManga);
//
//        Optional<Manga> maybeManga = mangaDao.findById(newMangaId);
//        if(maybeManga.isPresent()){
//            System.out.println(maybeManga.get());
//        }else{
//            System.out.println("new manga 1 is not present");
//        }
//
//        Manga newManga1 = Manga.builder()
//                .mangaName("Pandora Hearts")
//                .authorId(newCreatorId)
//                .artistId(newCreatorId)
//                .releaseYear((short)2008)
//                .translatorId(newUserId)
//                .previewImagePath("pandora path")
//                .build();
//        newMangaId = mangaDao.save(newManga);
//
//        maybeManga = mangaDao.findById(newMangaId);
//        if(maybeManga.isPresent()){
//            System.out.println(maybeManga.get());
//        }else{
//            System.out.println("new manga 2 is not present");
//        }
//
//        List<Manga> mangas = mangaDao.findAll(10, 0);
//        System.out.println("present mangas: ");
//        System.out.println(mangas);

        DaoFactory daoFactory = DaoFactory.getJPAInstance();
        MangaDao mangaDao = daoFactory.getMangaDao();
        CreatorDao creatorDao = daoFactory.getCreatorDao();
        UserDao userDao = daoFactory.getUserDao();

        Creator newCreator = Creator.builder()
                .description("")
                .name("Ishida Sui")
                .build();
        Integer newCreatorId = creatorDao.save(newCreator);

        Optional<Creator> creator = creatorDao.findById(newCreatorId);
        if(creator.isPresent()){
            System.out.println(creator.get());
        }else{
            System.out.println("not present");
        }

        List<Role> userRoles = new ArrayList<>();
        userRoles.add(Role.builder()
                .id((short)1)
                .name("ROLE_USER")
                .build());
        User newUser = User.builder()
                .nickname("newUser hiber2")
                .email("newUserEmail hiber13255543")
                .password("userPassword")
                .image(null)
                .updated(new Timestamp(System.currentTimeMillis()))
                .roles(userRoles)
                .build();
        Long newUserId = userDao.save(newUser);

        Optional<User> user = userDao.findById(newUserId);
        if(user.isPresent()){
            System.out.println(user.get());
        }else{
            System.out.println("user is not present");
        }

        log.info("creating manga");
        Manga newManga = Manga.builder()
                .mangaName("Pandora Hearts hiber")
                .authorId(1)
                .artistId(1)
                .releaseYear((short)2008)
                .translatorId(1L)
                .previewImagePath("pandora path")
                .build();
        Integer newMangaId = mangaDao.save(newManga);


        Optional<Manga> maybeManga = mangaDao.findById(newMangaId);
        if(maybeManga.isPresent()){
            System.out.println(maybeManga.get());
        }else{
            System.out.println("manga is not present");
        }


//        Optional<User> user = userDao.findByEmail("newUserEmail hiber13255543");
//        if(user.isPresent()){
//            System.out.println(user.get());
//        }else{
//            System.out.println("not present");
//        }



    }
}
