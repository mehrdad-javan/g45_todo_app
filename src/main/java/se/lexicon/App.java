package se.lexicon;


import se.lexicon.dao.AppUserDao;
import se.lexicon.dao.impl.AppUserDaoImpl;
import se.lexicon.model.AppUser;
import se.lexicon.model.Role;

public class App {

  public static void main(String[] args) {
    // user data
    AppUser appUserData1 = new AppUser("test", "password", Role.ROLE_USER);
    AppUser appUserData2 = new AppUser("user2", "password", Role.ROLE_USER);
    AppUser appUserData3 = new AppUser("user3", "password", Role.ROLE_USER);

    AppUserDao appUserDao = AppUserDaoImpl.getInstance();
    AppUser createdAppUser1 = appUserDao.create(appUserData1);
    AppUser createdAppUser2 = appUserDao.create(appUserData2);
    AppUser createdAppUser3 = appUserDao.create(appUserData3);

    System.out.println("-------------------");
    System.out.println(appUserDao.findAll());
    System.out.println("-------------------");

    AppUser updateAppUser101 = new AppUser(101, "appuser", "password", false, Role.ROLE_USER);
    appUserDao.update(updateAppUser101);
    AppUser findById101 = appUserDao.findById(101);
    System.out.println(findById101);


    AppUserDao appUserDao2 = AppUserDaoImpl.getInstance();
    System.out.println(appUserDao2.findAll());


  }

}
