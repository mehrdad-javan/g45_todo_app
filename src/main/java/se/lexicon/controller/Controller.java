package se.lexicon.controller;

import se.lexicon.dao.TodoItemDao;
import se.lexicon.dao.impl.TodoItemDaoImpl;
import se.lexicon.model.TodoItem;
import se.lexicon.view.ConsoleUI;
import se.lexicon.view.MainMenuAction;
import se.lexicon.dao.AppUserDao;
import se.lexicon.dao.PersonDao;
import se.lexicon.dao.impl.AppUserDaoImpl;
import se.lexicon.dao.impl.PersonDaoImpl;
import se.lexicon.model.AppUser;
import se.lexicon.model.Person;

import java.util.List;

public class Controller {
  ConsoleUI ui;
  PersonDao personDao;
  AppUserDao appUserDao;
  TodoItemDao todoItemDao;

  public Controller() {
    ui = new ConsoleUI();
    personDao = PersonDaoImpl.getInstance();
    appUserDao = AppUserDaoImpl.getInstance();
    todoItemDao = TodoItemDaoImpl.getInstance();
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
    TodoItem todoItemData = ui.getTodoItemData();
    Person personData = todoItemData.getAssignee();

    Person foundPerson = personDao.findById(personData.getId());

    todoItemData.setAssignee(foundPerson);
    TodoItem createdTodoItem = todoItemDao.create(todoItemData);

    ui.displayTodoItemInformation(createdTodoItem);

  }

  public void doDisplayTodoItems() {
    List<TodoItem> todoItemList = todoItemDao.findAll();
    ui.displayTodoItemInformation(todoItemList);
  }


  //...

}
