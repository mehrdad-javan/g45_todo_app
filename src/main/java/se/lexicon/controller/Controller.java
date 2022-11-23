package se.lexicon.controller;

import se.lexicon.view.ConsoleUI;
import se.lexicon.view.MainMenuAction;
import se.lexicon.dao.AppUserDao;
import se.lexicon.dao.PersonDao;
import se.lexicon.dao.impl.AppUserDaoImpl;
import se.lexicon.dao.impl.PersonDaoImpl;
import se.lexicon.model.AppUser;
import se.lexicon.model.Person;

public class Controller {
  ConsoleUI ui;
  PersonDao personDao;
  AppUserDao appUserDao;

  public Controller(){
    ui = new ConsoleUI();
    personDao = PersonDaoImpl.getInstance();
    appUserDao = AppUserDaoImpl.getInstance();
  }

  public void doMainMenu() {

    while (true) {
      MainMenuAction action = ui.displayMenu();
      switch (action) {
        case REGISTER:
          doRegister();
          break;
        case CREATE_TASK:
          doCreateTodoItem();
          break;
        case DISPLAY_TASKS:
          doDisplayTodoItems();
          break;
        case EXIT:
          System.exit(0);
      }
    }
  }

  public void doRegister() {
    Person personData = ui.getPersonData();

    AppUser appUserData = personData.getAppUser();
    AppUser createdAppUser = appUserDao.create(appUserData);

    personData.setAppUser(createdAppUser);
    Person createdPerson = personDao.create(personData);



    ui.displayPersonInformation(createdPerson);

  }

  public void doCreateTodoItem() {
    System.out.println("doCreateTodoItem method has been executed!");
  }

  public void doDisplayTodoItems() {
    System.out.println("doDisplayTodoItems method has been executed!");

  }

}
