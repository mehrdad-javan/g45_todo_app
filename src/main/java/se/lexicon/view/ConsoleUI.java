package se.lexicon.view;

import se.lexicon.model.AppUser;
import se.lexicon.model.Person;
import se.lexicon.model.Role;

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

  public void displayPersonInformation(Person person){
    System.out.println(person.toString());
  }

  // get todo_item data

  // print todo_item information

  // display all tasks


}
