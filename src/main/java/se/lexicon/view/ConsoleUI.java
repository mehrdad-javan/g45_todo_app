package se.lexicon.view;

import se.lexicon.model.AppUser;
import se.lexicon.model.Person;
import se.lexicon.model.Role;
import se.lexicon.model.TodoItem;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI {

  public MainMenuAction displayMenu() {
    System.out.println("1.Register");
    System.out.println("2.Create Task");
    System.out.println("3.Display All Tasks");
    System.out.println("4.Exit");

    System.out.println("Enter a number: ");
    int operationCode = getNumber();

    switch (operationCode) {
      case 1:
        return MainMenuAction.REGISTER;
      case 2:
        return MainMenuAction.CREATE_TASK;
      case 3:
        return MainMenuAction.DISPLAY_TASKS;
      default:
        return MainMenuAction.EXIT;
    }

  }

  public int getNumber() {
    Scanner scanner = new Scanner(System.in);
    return scanner.nextInt();
  }

  public String getString() {
    Scanner scanner = new Scanner(System.in);
    return scanner.nextLine();
  }

  public Person getPersonData() {
    System.out.println("Username:");
    String username = getString();

    System.out.println("Password:");
    String pwd = getString();

    AppUser appUserData = new AppUser(username, pwd, Role.ROLE_USER);

    System.out.println("FirstName:");
    String fn = getString();

    System.out.println("LastName:");
    String ln = getString();
    Person personData = new Person(fn, ln, appUserData);

    return personData;

  }

  public void displayPersonInformation(Person person) {
    System.out.println(person.toString());
  }

  public TodoItem getTodoItemData() {
    System.out.println("Title:");
    String title = getString();
    System.out.println("Description:");
    String description = getString();
    System.out.println("Deadline (YYYY-MM-DD):");
    String deadline = getString();

    System.out.println("PersonId:");
    Integer personId = getNumber();

    TodoItem todoItemData = new TodoItem(title, description, LocalDate.parse(deadline));

    Person personData = new Person();
    personData.setId(personId);

    todoItemData.setAssignee(personData);

    return todoItemData;

  }

  public void displayTodoItemInformation(TodoItem todoItem) {
    System.out.println(todoItem.toString());
  }

  public void displayTodoItemInformation(List<TodoItem> todoItemList) {
    for (TodoItem todoItem : todoItemList) {
      displayTodoItemInformation(todoItem);
    }
  }

  //...
}
