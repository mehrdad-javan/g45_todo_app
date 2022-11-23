package se.lexicon;


import se.lexicon.dao.AppUserDao;
import se.lexicon.dao.PersonDao;
import se.lexicon.dao.TodoItemDao;
import se.lexicon.dao.impl.AppUserDaoImpl;
import se.lexicon.dao.impl.PersonDaoImpl;
import se.lexicon.dao.impl.TodoItemDaoImpl;
import se.lexicon.model.AppUser;
import se.lexicon.model.Person;
import se.lexicon.model.Role;
import se.lexicon.model.TodoItem;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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


    // person data
    Person personData1 = new Person("Test", "Test", appUserData1);

    PersonDao personDao = PersonDaoImpl.getInstance();

    Person createdPerson1 = personDao.create(personData1);
    System.out.println(createdPerson1.getAppUser());

    Optional<Person> optionalPerson = personDao.findByUsername("appuser");
    if (optionalPerson.isPresent()) System.out.println(optionalPerson.get());
    else System.out.println("Person not found");


    System.out.println("------------------------");

    TodoItem task1 = new TodoItem("task1", "test description", LocalDate.parse("2022-12-10"));
    task1.setAssignee(createdPerson1);

    TodoItemDao todoItemDao = TodoItemDaoImpl.getInstance();
    TodoItem createdTask1 = todoItemDao.create(task1);

    System.out.println(todoItemDao.findAll());
  }

}
